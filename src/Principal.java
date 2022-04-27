import dataAccess.webDataAccess.HttpConnection;

import javax.net.ssl.HttpsURLConnection;

public class Principal {
    public static void main(String[] args) {
        HttpConnection connection = new HttpConnection();
        System.out.println(connection.connectionStatus());
        System.out.println(connection.showInfos());
    }
}
