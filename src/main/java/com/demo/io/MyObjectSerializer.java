package com.demo.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 ************************************************************
 * @类名 : MyObjectSerializer.java
 *
 * @DESCRIPTION :
 * @AUTHOR : liaopin
 * @DATE : 2019年5月20日
 ************************************************************
 */
public class MyObjectSerializer {
    public byte[] serialize(Object object) throws Exception {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            System.out.println("object is not serializable");
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                System.out.println("object fail to unserialize");
            }
            try {
                baos.close();
            } catch (IOException e) {
                System.out.println("object fail to unserialize");
            }
        }
    }

    public Object deserialize(byte[] bytes) throws Exception {
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            System.out.println("object fail to unserialize");
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                System.out.println("object fail to unserialize");
            }
            try {
                bais.close();
            } catch (IOException e) {
                System.out.println("object fail to unserialize");
            }
        }
    }

}
