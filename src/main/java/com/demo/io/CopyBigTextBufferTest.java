package com.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CopyBigTextBufferTest {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        File from = new File("src/main/resources/bigtext.log");
        File to = new File("src/main/resources/bigtext_copy.log");
        Reader fr = null;
        BufferedReader br = null;
        Writer fw = null;
        BufferedWriter bw = null;
        try {
            fr = new FileReader(from);
            br = new BufferedReader(fr);
            fw = new FileWriter(to);
            bw = new BufferedWriter(fw);
            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.flush();
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
