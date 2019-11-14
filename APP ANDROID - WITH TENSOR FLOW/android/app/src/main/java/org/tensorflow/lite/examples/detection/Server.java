package org.tensorflow.lite.examples.detection;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.DataOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;


public class Server {
    String urlPost;
    String urlGet;
    String posicao,aux;
    String situacaoUso;
    JSONObject jsonObject;



    public void PostInfo(JSONObject dado) throws IOException, JSONException {

        String url = "http://localhost:3000/postInfo";

        URL UrlObj = new URL(this.urlPost);

        HttpURLConnection connection = (HttpURLConnection) UrlObj.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setDoOutput(true);

        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());

        String urlPostParameters = "dado="+dado;
        outputStream.writeBytes(urlPostParameters);

        outputStream.flush();
        outputStream.close();

        System.out.println("Send 'HTTP POST' request to : " + this.urlPost);

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = inputReader.readLine()) != null) {
                response.append(inputLine);
            }
            inputReader.close();
            System.out.println(response.toString());
            aux = response.toString();
            jsonObject = new JSONObject(aux);
            situacaoUso = (String) jsonObject.get("situacaoUso");
            posicao = (String) jsonObject.get("posicao");
        }
    }

    public void GetInfo() throws IOException {
        String url = "localhost:3000/getInfo";
        URL urlObj = new URL(this.urlGet);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        System.out.println("Send 'HTTP GET' request to : " + this.urlGet);

        Integer responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = inputReader.readLine()) != null) {
                response.append(inputLine);
            }

            inputReader.close();

            System.out.println(response.toString());
        }
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

    public void sendUpdatePost(String posicao) throws JSONException {
        JSONObject j = new JSONObject() ;

        j.put("situacaoUso", "used");
        j.put("posicao", posicao);

        try {
            this.PostInfo(j);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}




