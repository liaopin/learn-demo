package com.demo.mode.chain;

import java.util.ArrayList;
import java.util.List;

public class ChainTest {

    public static void main(String[] args) {
        Employee<Message> employee = new Employee<Message>();
        Manager<Message> manager = new Manager<Message>();
        President<Message> president = new President<Message>();
        // msg --> employee --> manager --> president
        //            |           |             |
        //res  <--    |     <--   |     <--     |
        
        employee.nextHandler(manager).nextHandler(president);

        List<Message> messages = new ArrayList<Message>();
        messages.add(new Message(MessageType.ONE, "employee can do with this message"));
        messages.add(new Message(MessageType.ONE, "employee can do with this message2"));
        messages.add(new Message(MessageType.TWO, "manager can do with this message"));
        messages.add(new Message(MessageType.THREE, "president can do with this message"));
        messages.add(new Message(MessageType.OHTER, "nobody can do with this message"));
        List<HandlerResult> results = employee.chainDoMessage(employee, messages);
        System.out.println("======================================================");
        for (HandlerResult result : results) {
            System.out.println("handlerName:" + result.getHandlerName() + "|msg:" + result.getMsg());
        }
    }

}
