package com.company;

import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable {
    @Override
    public void close() throws IOException {
        //System.out.println("close");
        throw new  IOException("Exception from close");

    }

    public void saySomething() throws IOException {
        throw new  IOException("Exception from saySomething");
        //System.out.println("Something");
    }

}
