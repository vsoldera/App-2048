/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


 /*
 * @author luizviniciusruoso
 */
public class WebClient {
    
public  void Get(String[] args) throws Exception {

		String url = "http://www.google.com/search?q=techndeck";
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




public  void SendPost() throws IOException  {

	String url = "http://localhost:8006/SpringBootServiceProject/Users";

		URL UrlObj = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) UrlObj.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0");
		connection.setDoOutput(true);

		DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());

		String urlPostParameters = "userID=250&amp;userName=Mike";
		outputStream.writeBytes(urlPostParameters);
		
		outputStream.flush();
		outputStream.close();

		System.out.println("Send 'HTTP POST' request to : " + url);
		
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
}



