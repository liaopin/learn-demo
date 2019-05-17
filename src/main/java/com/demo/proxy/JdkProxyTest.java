package com.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyTest {

    public static void main(String[] args) {

        User user = new User();
        user.setName("lina");
        user.setAge(17);
        final UserService target = new UserServiceImpl();

        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
            new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("jdkProxy invoke befor");
                    Object respnse = method.invoke(target, args);
                    System.out.println("jdkProxy invoke after");
                    return respnse;
                }

            });

        userServiceProxy.save(user);

        System.out.println(System.lineSeparator());

        /*
         * UserService userService = new UserServiceImpl(); ProxyFactory factory = new ProxyFactory(); UserService proxy
         * = (UserService) factory.getProxy(userService); proxy.save(user);
         */

    }
}
