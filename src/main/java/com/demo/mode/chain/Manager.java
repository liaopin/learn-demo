package com.demo.mode.chain;

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
