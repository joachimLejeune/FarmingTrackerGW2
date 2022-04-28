package business;

import dataAccess.webDataAccess.HttpConnection;

public class HttpManager {
    private HttpConnection httpManager;
    private static String characterName = "Khnor";
    private static String access_token = "CB0274D5-E8E5-0340-AB96-12CB0AFA2345BF90ECFC-A46A-4B0D-8420-BEEF7E47EF17";

    public HttpManager(){
        this.httpManager = new HttpConnection(characterName,access_token);
    }

    public String extractData(){
        String data = httpManager.showInfos();

        return data;
    }


}
