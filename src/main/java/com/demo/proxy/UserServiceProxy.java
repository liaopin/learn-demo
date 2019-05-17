package com.demo.proxy;

public class UserServiceProxy implements UserService {
    private UserService target;

    public UserServiceProxy(UserService target) {
        super();
        this.target = target;
    }

    public int save(User user) {
        System.out.println("this is proxy");
        System.out.println("save befor");
        target.save(user);
        System.out.println("save after");
        return 0;
    }

    public UserService getTarget() {
        return target;
    }

    public void setTarget(UserService target) {
        this.target = target;
    }

}
