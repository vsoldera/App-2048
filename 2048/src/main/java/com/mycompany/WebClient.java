package com.mycompany;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import java.util.concurrent.TimeUnit ;
public class WebClient extends Jogo {
    String urlPost;
    String urlGet;
    Jogo jogo;
    
    

    public WebClient(String urlPost, String urlGet, Jogo jogo) {
        this.urlPost = urlPost;
        this.urlGet = urlGet;
        this.jogo = jogo;
    }
    
    public void setJogo(Jogo j){
        this.jogo = jogo;
    }
    public Jogo getJogo(){
        return jogo;
    }

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
    
    
    public void controleGeral() throws InterruptedException{
        while(true){
            try {
                TimeUnit.SECONDS.sleep(1);
                getInfo();
            } catch (ProtocolException ex) {
                Logger.getLogger(WebClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(WebClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    
    
    public void postInfo(JSONObject dado) throws MalformedURLException, IOException{
        

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

		if(responseCode==HttpURLConnection.HTTP_OK) {
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

        
       
	public void getInfo() throws MalformedURLException, ProtocolException, IOException{
                String posicao,aux;
                String situacaoUso;
                JSONObject jsonObject;
                
         
          
		URL urlObj = new URL(this.urlGet);
		HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();

		connection.setRequestMethod("GET");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0");

		System.out.println("Send 'HTTP GET' request to : " + this.urlGet);
              
		Integer responseCode = connection.getResponseCode();
		System.out.println("Response Code : " + responseCode);

		if(responseCode==HttpURLConnection.HTTP_OK) {
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
                        //System.out.println(jsonObject.get("posicao"));
                        situacaoUso = (String) jsonObject.get("situacaoUso");
                        posicao = (String) jsonObject.get("posicao");
                        
                        this.controleJogo(posicao, situacaoUso  );
                       
		}
	}
        
        
        public void controleJogo(String posicao, String situacaoUso){
            
                    
                
                if(this.jogo.getSituacaoJogo() == 1 && situacaoUso.equals("toUse")){
                if(posicao.equals("up")) this.jogo.toUp();


                if(posicao.equals("down")) this.jogo.toDown();
                if(posicao.equals("left")) this.jogo.toLeft();
                if(posicao.equals("right")) this.jogo.toRight();

                    this.sendUpdatePost(posicao);
                }else System.out.println("not ready");
            
            
            
        }
        
        public void sendUpdatePost(String posicao){
            JSONObject j = new JSONObject() ;
            
             j.put("situacaoUso", "used");
             j.put("posicao", posicao);
                              
            try {
                this.postInfo(j);
            } catch (IOException ex) {
                Logger.getLogger(WebClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
}
        



     
   