package dataAccess.webDataAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Model.Inventory;
import Model.Item;
import org.json.JSONArray;
import org.json.JSONObject;

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
        ArrayList<Item> items = new ArrayList<Item>();

        try {
            InputStream inputStream = connection.getInputStream();
            BufferedReader bR = new BufferedReader(  new InputStreamReader(inputStream));
            String line = "";

            StringBuilder responseStrBuilder = new StringBuilder();
            while((line =  bR.readLine()) != null){

                responseStrBuilder.append(line);
            }
            inputStream.close();

            JSONObject result= new JSONObject(responseStrBuilder.toString());

            System.out.println(result.getJSONArray("bags"));

            JSONArray jsonArray = result.getJSONArray("bags");
            System.out.println(jsonArray.get(0));
            JSONObject firstInventory = (JSONObject) jsonArray.get(0);
            System.out.println(firstInventory);
//            // Pour tous les objets on récupère les infos
//            for (int i = 0; i < array.length(); i++) {
//                // On récupère un objet JSON du tableau
//                JSONObject obj = new JSONObject(array.getString(i));
//                // On fait le lien Personne - Objet JSON
//                Personne personne = new Personne();
//                personne.setNom(obj.getString("nom"));
//                personne.setPrenom(obj.getString("prenom"));
//                // On ajoute la personne à la liste
//                personnes.add(personne);
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // On retourne la liste des personnes
//        return personnes;
        return "null";
    }
}
