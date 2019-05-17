package com.demo.proxy;

public class StaticProxyTest {

    public static void main(String[] args) {
        User user = new User();
        user.setName("liaopin");
        user.setAge(18);

        UserService userService = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy(userService);
        proxy.save(user);

    }

}
