package com.demo.mode.chain;

public class Message {
    private MessageType messageType;
    private String message;
    private int count;

    public Message(MessageType messageType, String message) {
        super();
        this.messageType = messageType;
        this.message = message;
    }

    public Message() {
        super();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
