package com.githubcolomboDavide7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("whois.internic.net", 43);

            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            String toKnow = "OraclePressBooks.com";
            byte[] buffer = toKnow.getBytes();
            out.write(buffer);
            int c;
            while((c = in.read()) != -1)
                System.out.print((char) c);
            s.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
