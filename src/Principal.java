import business.HttpManager;
import dataAccess.webDataAccess.HttpConnection;

import javax.net.ssl.HttpsURLConnection;

public class Principal {
    public static void main(String[] args) {
//        HttpConnection connection = new HttpConnection();
//        System.out.println(connection.connectionStatus());
//        System.out.println(connection.showInfos());

        HttpManager manager = new HttpManager();
        if(!manager.extractingData()){
            System.out.println("Données extraites de l'API");
        }
        else{
            System.out.println("Erreur dans la récupération de l'inventaire");
        }

    }
}
