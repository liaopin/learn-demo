package com.demo.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CopyBigTextByteTest {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        File from = new File("src/main/resources/bigtext.log");
        File to = new File("src/main/resources/bigtext_copy.log");
        Reader fr = null;
        Writer fw = null;
        try {
            fr = new FileReader(from);
            fw = new FileWriter(to);
            char[] bytes = new char[8192];
            while (fr.read(bytes) != -1) {
                fw.write(bytes);
                fw.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("复制操作耗时:" + (endTime - startTime) + "毫秒");
        }

    }

}
