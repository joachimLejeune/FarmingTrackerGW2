import business.HttpManager;
import dataAccess.webDataAccess.HttpConnection;

import javax.net.ssl.HttpsURLConnection;

public class Principal {
    public static void main(String[] args) {
//        HttpConnection connection = new HttpConnection();
//        System.out.println(connection.connectionStatus());
//        System.out.println(connection.showInfos());

        HttpManager manager = new HttpManager();
        System.out.println(manager.extractData());
    }
}
