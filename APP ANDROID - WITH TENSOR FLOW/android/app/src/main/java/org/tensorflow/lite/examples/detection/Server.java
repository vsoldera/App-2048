package org.tensorflow.lite.examples.detection;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import static java.util.logging.Level.SEVERE;


public class Server {
    String urlPost;
    String urlGet;
    String posicao, aux;
    String situacaoUso;
    JSONObject jsonObject;


    public String getUrlPost() {
        return urlPost;
    }

    public void setUrlPost(String urlPost) {
        this.urlPost = urlPost;
    }

    public String getUrlGet() {
        return urlGet;
    }

    public void setUrlGet(String urlGet) {
        this.urlGet = urlGet;
    }

    /* public void controleGeral() throws InterruptedException{
            while(true){

                    TimeUnit.SECONDS.sleep(1);
                try {
                    this.GetInfo();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }*/
    //Ja existe a funcao post info e get info, eh mandar um JSON pra funcao postInfo
    public void PostInfo(JSONObject dado) throws IOException, JSONException {
        try {
            TimeUnit.SECONDS.sleep((long) 0.2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String url = getUrlPost() + "/postInfo";

        URL UrlObj = new URL(url);

        HttpURLConnection connection = (HttpURLConnection) UrlObj.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setDoOutput(true);

        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());

        String urlPostParameters = "dado=" + dado;
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
           /* aux = response.toString();
            jsonObject = new JSONObject(aux);
            situacaoUso = (String) jsonObject.get("situacaoUso");
            posicao = (String) jsonObject.get("posicao");*/
        }
    }

    public void GetInfo() throws IOException {
        String url = getUrlGet() + "/getPos";
        URL urlObj = new URL(url);
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

    public int getValidationServer() throws IOException {
        String url = getUrlGet() + "/confExistence";
        URL urlObj = new URL(url);
        JSONObject j = new JSONObject();//making global to the function
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        System.out.println("Send 'HTTP GET' request to : " + this.urlGet);

        Integer responseCode = null;
        connection.setConnectTimeout(3000);

            try {
                responseCode = connection.getResponseCode();

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
                    try {
                        j.put("retorno", response.toString());
                        return 1;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException i) {
                i.printStackTrace();
                return -1;

            }
        return -1;


    }


/*
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
    */


    public void sendUpdatePost(String posicao) throws JSONException {
        JSONObject j = new JSONObject() ;

        j.put("situacaoUso", "toUse");
        j.put("posicao", posicao);
        j.put("Origem", "Controle");

        try {
            this.PostInfo(j);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(SEVERE, null, ex);
        }

    }
    public void sendUpdatePostIA(String objeto, float confianca) throws JSONException {
        JSONObject j = new JSONObject() ;
        int ctrl=0;
        System.out.println(confianca);
        if(objeto.equals("mouse") && confianca >= 0.070){
            ctrl =1;
            j.put("posicao", "Up");
        }
        if(objeto.equals("person") && confianca >= 0.070) {
                j.put("posicao", "Down");
            ctrl =1;
        }
        if(objeto.equals("backpack") && confianca >= 0.070) {
            ctrl =1;
           j.put("posicao", "Left");
        }
        if(objeto.equals("cell phone") && confianca >= 0.070){
            ctrl =1;
            j.put("posicao", "Right");
        }
      if(ctrl ==1) {


          j.put("situacaoUso", "toUse");
          j.put("Origem", "Controle");


          try {
              this.PostInfo(j);
          } catch (IOException ex) {
              Logger.getLogger(Server.class.getName()).log(SEVERE, null, ex);
          }
      }else {
          System.out.println("nenhum match");
          ctrl=0;
      }
      }
    }






