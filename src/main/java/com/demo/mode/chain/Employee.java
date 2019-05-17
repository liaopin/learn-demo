package com.demo.mode.chain;

/**
 * 
 ************************************************************
 * @类名 : Employee.java
 *
 * @DESCRIPTION :
 * @AUTHOR : liaopin
 * @DATE : 2019年5月17日
 * @param <T>
 ************************************************************
 */
public class Employee<T extends Message> extends Handler<T> {

    @Override
    public HandlerResult handleMessage(T message) {
        System.out.println("I'm employee,I can do with message!");
        return new HandlerResult("employee", "I have do it!");
    }

    @Override
    public boolean canHandlerMessage(T message) {
        return MessageType.ONE.equals(message.getMessageType());
    }

}
