package com.demo.mode.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 ************************************************************
 * @类名 : Handler.java
 *
 * @DESCRIPTION : 责任链模式
 * @AUTHOR : liaopin
 * @DATE : 2019年5月16日
 ************************************************************
 */
public abstract class Handler<T extends Message> {
    protected Handler<T> nextHandler; // 下一个责任链成员

    public Handler<T> nextHandler(Handler<T> nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    };

    // 处理传递过来的时间
    public abstract HandlerResult handleMessage(final T message);

    // 什么条件下当前handle可以处理msg
    public abstract boolean canHandlerMessage(final T message);

    public List<HandlerResult> chainDoMessage(Handler<T> handler, List<T> messages) {
        List<HandlerResult> results = new ArrayList<HandlerResult>();
        for (T message : messages) {
            if (canHandlerMessage(message)) {
                HandlerResult result = handleMessage(message);
                results.add(result);
            } else {
                HandlerResult result = nextHandlerMessage(handler, message);
                results.add(result);
            }
        }

        return results;
    }

    protected HandlerResult nextHandlerMessage(Handler<T> handler, T message) {
        HandlerResult result = null;
        if (handler.nextHandler != null && handler.nextHandler.canHandlerMessage(message)) {
            result = handler.nextHandler.handleMessage(message);
        } else if (handler.nextHandler != null) {
            result = nextHandlerMessage(handler.nextHandler, message);
        } else {
            System.out.println("warnning ! nobody can do with it");
            result = new HandlerResult("nobody", "nobody can do with it");
        }
        return result;
    }
}
