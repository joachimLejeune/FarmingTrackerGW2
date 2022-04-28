package dataAccess.webDataAccess;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class SingletonHttpConnection {
    private static HttpURLConnection connection;


    public static HttpURLConnection getConnection(String characterName, String accessToken){
        String urlString =  "https://api.guildwars2.com/v2/characters/"+characterName+"/inventory?access_token="+accessToken;
        URL url = null;
        try {
            url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
