package com.demo.mode.chain;

public class HandlerResult {
    private String handlerName;
    private String msg;

    public HandlerResult(String handlerName, String msg) {
        super();
        this.handlerName = handlerName;
        this.msg = msg;
    }

    public HandlerResult() {
        super();
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
