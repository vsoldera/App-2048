package com.example.control_for_2048;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpConnection{


    private void writeStream(OutputStream out) throws IOException {
        String output = jsonSend();

        out.write(output.getBytes());
        out.flush();
    }
    private String readStream(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);
        for (String line = r.readLine(); line != null; line =r.readLine()){
            sb.append(line);
        }
        is.close();
        return sb.toString();
    }



    public void connect() throws IOException {
        URL url = new URL("http://localhost:3000/");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoOutput(true); // Triggers POST.
        try {
            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);
            System.out.println(1);

//            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
  //          writeStream(out);
    //        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
      //      readStream(in);
        } finally {
            urlConnection.disconnect();
        }

    }

    public String jsonSend() {

        JSONObject jsonObject = new JSONObject();

        FileWriter writeFile = null;


        //Armazena dados em um Objeto JSON
        try {
            jsonObject.put("movimentacao", "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try{
            writeFile = new FileWriter("saida.json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toString());
            writeFile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        //Imprimne na Tela o Objeto JSON para vizualização
       // System.out.println(jsonObject);
        return jsonObject.toString();

    }
}
