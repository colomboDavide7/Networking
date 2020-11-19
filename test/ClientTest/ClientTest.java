package ClientTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void shouldCreateUnboundedClientSocket(){
        System.out.println("* Client Socket test: shouldCreateUnboundedClientSocket()\n");
        Socket clientSocket = new Socket();
        assertFalse(clientSocket.isConnected());
        // This method return false because this socket is not associated with any address
        assertFalse(clientSocket.isBound());
        // The remote port is 0 because the Socket is not yet connected
        assertEquals(0, clientSocket.getPort());

    }

    @Test
    public void shouldCreateBoundedClientSocket(){
        System.out.println("* Client Socket test: shouldCreateBoundedClientSocket()\n");
        try {
            Socket s = new Socket("whois.internic.net", 43);
            assertEquals(43, s.getPort());
            assertTrue(s.isBound());
            assertTrue(s.isConnected());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldCreateURL(){
        System.out.println("* URL test: shouldCreateURL()\n");
        try {
            URL url = new URL("http", "www.HerbSchildt.com", "index.html");
            assertEquals(-1, url.getPort());
            assertEquals("http", url.getProtocol());
            assertEquals("www.HerbSchildt.com", url.getHost());
            assertEquals("index.html", url.getFile());
        } catch(MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldEstablishURLConnection(){
        System.out.println("* URLConnection test: shouldEstablishURLConnection()\n");
        try {
            URL url = new URL("http://www.internic.net");
            URLConnection conn = url.openConnection();

            System.out.println("response date in millisecond from 1 January 1970: " + conn.getDate());
            System.out.println("content-type: " + conn.getContentType());
            System.out.println("last modified date: " + conn.getLastModified());

            long len = conn.getContentLengthLong();
            int c;
            if(len != 0){
                System.out.println("============= CONTENT =============");
                InputStream in = conn.getInputStream();
                while((c = in.read()) != -1)
                    System.out.print((char) c);
            }
        } catch(MalformedURLException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


}
