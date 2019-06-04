package com.demo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 ************************************************************
 * @类名 : CopyImageTest.java
 *
 * @DESCRIPTION :效率最高复制
 * @AUTHOR : liaopin
 * @DATE : 2019年5月20日
 ************************************************************
 */
public class CopyImageIoByteBufferTest {
    // 所有文件都可以用字节流读取(ByteArrayInputStream或FileInputStream)，字符可以选择字符流更方便
    // 图片使用字节流读取
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        File file = new File("src/main/resources/1.mp4");
        File outFile = new File("src/main/resources/test.mp4");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream(outFile);
            bos = new BufferedOutputStream(fos);
            byte[] bytes = new byte[8192];// 1024复制操作时间为:112 | 8192复制操作时间为:42
            while (bis.read(bytes) != -1) {
                bos.write(bytes);
                bos.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("复制操作时间为:" + (endTime - startTime));
            System.out.println("是最差效率的" + 122144 / (endTime - startTime) + "倍");
            // 复制操作时间为:112
        }
    }
}
