package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.rmi.server.ExportException;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(System.getProperty("user.dir"));
        System.out.println("--------------------------");
        //doTryCatchFinally();
         //doTryWithResources();
        //doTryWithResourcesMulti();
        doCloseThing();
        depecratedFileWrite();
    }

    public static void doTryCatchFinally() {
        char[] buff = new char[8];
        int length;
        Reader reader = null;
        System.out.println("doTryCatchFinally");

        try {
            reader = Helper.openReader("file1.txt");
            while ((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength: " + length);
                for (int i = 0; i < length; i++)
                    System.out.print(buff[i]);
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e2) {
                System.out.println(e2.getClass().getSimpleName() + " - " + e2.getMessage());
            }
        }
    }

    public static void doTryWithResources() {
        char[] buff = new char[8];
        int length;
        System.out.println("doTryWithResources");

        try (Reader reader = Helper.openReader("file1.txt")) {

            while ((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength: " + length);
                for (int i = 0; i < length; i++)
                    System.out.print(buff[i]);
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

    }

    public static void doTryWithResourcesMulti() {
        System.out.println("doTryWithResourcesMulti");
        char[] buff = new char[8];
        int length;
        try (Reader reader = Helper.openReader("file1.txt");
             Writer writer = Helper.openWriter("file2.txt")) {

            while ((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength: " + length);
                writer.write(buff,0,length);;
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }


    }

    private static void doCloseThing() {
        System.out.println("doCloseThing");
        try (MyAutoCloseable ac = new MyAutoCloseable()) {
            ac.saySomething();
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
            for(Throwable t:e.getSuppressed()) {
                System.out.println("Suppressed: " + t.getMessage());
            }
        }
    }

    private static void depecratedFileWrite(){

        String[] data =  {
            "Line 1",
            "Line 1 2",
            "Line 1 2 3",
            "Line Last"
        };

        try(BufferedWriter bw =
                new BufferedWriter((new FileWriter("data.txt")))) {

            for(String d:data) {
                bw.write(d);
                bw.newLine();
            }
        } catch (Exception ex) {
            System.out.println("Exceptoin: " + ex.getMessage());
        }
    }

}
