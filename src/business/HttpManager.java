package business;

import dataAccess.webDataAccess.HttpConnection;

public class HttpManager {
    private HttpConnection httpManager;

    public HttpManager(){
        this.httpManager = new HttpConnection();
    }

    public String extractData(){
        String data = httpManager.showInfos();

        return data;
    }


}
