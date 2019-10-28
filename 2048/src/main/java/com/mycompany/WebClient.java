import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebClient {
     public static void main(String[] args) throws Exception {
	String url = "http://localhost:443/safe/xd.html";

		URL UrlObj = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) UrlObj.openConnection();
		connection.setRequestMethod("POST");
                 System.setProperty("http.agent", "");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                
		connection.setDoOutput(true);

         try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
             String urlPostParameters = "userID=250&amp;userName=Mike";
             outputStream.writeBytes(urlPostParameters);
             
             outputStream.flush();
         }

		System.out.println("Send 'HTTP POST' request to : " + url);
		
		int responseCode = connection.getResponseCode();
		System.out.println("Response Code : " + responseCode);

		if(responseCode==HttpURLConnection.HTTP_OK) {
                    StringBuffer response;
            try (BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = inputReader.readLine()) != null) {
                    response.append(inputLine);
                }
            }

		System.out.println(response.toString());
        }
    }
}
   