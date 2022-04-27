package dataAccess.webDataAccess;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class SingletonHttpConnection {
    private static HttpURLConnection connection;


    public static HttpURLConnection getConnection(){
        String characterName = "Khnor";
        String accessToken = "CB0274D5-E8E5-0340-AB96-12CB0AFA2345BF90ECFC-A46A-4B0D-8420-BEEF7E47EF17";
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
