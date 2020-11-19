package ClientTest;

import java.io.IOException;
import java.net.*;

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

    

}
