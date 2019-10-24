package org.tensorflow.lite.examples.detection;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    Socket soc;
    String host;
    int port;

    public Server(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void initServer(){
        try {
            soc = new Socket(host, port);

        } catch (
                UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (
                IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void Write(String msg){

        try {
            PrintWriter writer = new PrintWriter(soc.getOutputStream());
            writer.write(msg);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}
