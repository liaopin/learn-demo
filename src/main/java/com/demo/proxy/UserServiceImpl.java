package com.demo.proxy;

public class UserServiceImpl implements UserService {

    public int save(User user) {
        System.out.println("target save user:");
        return 1;
    }

}
