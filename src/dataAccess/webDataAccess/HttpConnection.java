package dataAccess.webDataAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


public class HttpConnection {
    public HttpURLConnection connection;

    public HttpConnection(String characterName, String accessToken){
        connection = SingletonHttpConnection.getConnection(characterName,accessToken);
    }

    public int connectionStatus(){
        Integer connectionCode = -1;
        try {
            connectionCode = connection.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return connectionCode;
    }

    public String showInfos(){
        BufferedReader in = null;
        String inputLine;
        StringBuilder content = new StringBuilder();
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((inputLine = in.readLine())!=null){
                content.append(inputLine);
//                content.append("\n");
            }
            in.close();



            return content.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
