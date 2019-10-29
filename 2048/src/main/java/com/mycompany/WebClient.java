 import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class WebClient {
    



	public static void main(String[] args) throws Exception {

		String url = "http://localhost:3000/getPos";
		URL urlObj = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();

		connection.setRequestMethod("GET");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0");

		System.out.println("Send 'HTTP GET' request to : " + url);

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
		}
	}

}


     
   