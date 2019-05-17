package com.demo.mode.chain;

/**
 * 
 ************************************************************
 * @类名 : Manager.java
 *
 * @DESCRIPTION :
 * @AUTHOR : liaopin
 * @DATE : 2019年5月17日
 * @param <T>
 ************************************************************
 */
public class Manager<T extends Message> extends Handler<T> {

    @Override
    public HandlerResult handleMessage(T message) {
        System.out.println("I'm manager,I can do with message!");
        return new HandlerResult("manager", "I have do it!");
    }

    @Override
    public boolean canHandlerMessage(T message) {
        return MessageType.TWO.equals(message.getMessageType());
    }

}
