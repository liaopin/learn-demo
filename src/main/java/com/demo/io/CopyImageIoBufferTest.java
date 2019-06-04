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
 * @DESCRIPTION :
 * @AUTHOR : liaopin
 * @DATE : 2019年5月20日
 ************************************************************
 */
public class CopyImageIoBufferTest {
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
            int length = 0;
            while ((length = bis.read()) != -1) {
                bos.write(length);
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
            // 复制操作时间为:72838
        }
    }
}
