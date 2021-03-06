package com.demo.mode.chain;

/**
 * 
 ************************************************************
 * @类名 : President.java
 *
 * @DESCRIPTION :
 * @AUTHOR : liaopin
 * @DATE : 2019年5月17日
 * @param <T>
 ************************************************************
 */
public class President<T extends Message> extends Handler<T> {

    @Override
    public HandlerResult handleMessage(T message) {
        System.out.println("I'm President,I can do with message!");
        return new HandlerResult("President", "I have do it!");
    }

    @Override
    public boolean canHandlerMessage(T message) {
        return MessageType.THREE.equals(message.getMessageType());
    }

}
