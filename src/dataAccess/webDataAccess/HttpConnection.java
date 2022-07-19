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

    public HttpConnection(String characterName, String accessToken) {
        connection = SingletonHttpConnection.getConnection(characterName, accessToken);
    }

    public int connectionStatus() {
        Integer connectionCode = -1;
        try {
            connectionCode = connection.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return connectionCode;
    }

    public Inventory GetInventory() {
//        ArrayList<Item> items = new ArrayList<Item>();
        Inventory inventory = new Inventory();
        try {
            InputStream inputStream = connection.getInputStream();
            BufferedReader bR = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            StringBuilder responseStrBuilder = new StringBuilder();
            while ((line = bR.readLine()) != null) {

                responseStrBuilder.append(line);
            }
            inputStream.close();

            JSONObject result = new JSONObject(responseStrBuilder.toString());

//            System.out.println(result.getJSONArray("bags"));

            JSONArray jsonArray = result.getJSONArray("bags"); // l'ensemble de mes sacs
//            System.out.println(jsonArray.get(0));
            JSONObject firstInventory = (JSONObject) jsonArray.get(0); // le premier sac
//            System.out.println(firstInventory);

//            System.out.println(firstInventory.get("inventory")); // le contenu du premier sac
            JSONArray contenu = firstInventory.getJSONArray("inventory"); // on reconvertit en Array JSON
//            System.out.println(contenu);
            // Pour tous les objets on récupère les infos
            for (int i = 0; i < contenu.length(); i++) {
                System.out.println(contenu.get(i));
                // On récupère un objet JSON du tableau
                JSONObject obj = (JSONObject) contenu.get(i);
                // On fait le lien Item - Objet JSON
                Item item = new Item((Integer) obj.get("id"), (Integer) obj.get("count"));
                // On ajoute la personne à la liste
                inventory.AddItem(item);
                System.out.println(inventory.GetItem(i).ToString());
//                System.out.println(obj.get("id"));
            }
            // On retourne la liste des personnes
//        return personnes;
            return inventory;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
