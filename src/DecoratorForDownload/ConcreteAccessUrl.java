package DecoratorForDownload;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ConcreteAccessUrl implements AccessUrl{
    private final URLConnection urlConnect;

    public ConcreteAccessUrl(URL url) throws Exception {

        this.urlConnect = url.openConnection();
        HttpURLConnection con = (HttpURLConnection)urlConnect;
        con.setRequestMethod("GET");

        con.connect();

        int responseCode = con.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new Exception(Integer.toString(responseCode));
        }
    }

    public URLConnection getUrlConnection(){
        return urlConnect;
    }

    @Override
    public void operation(URLConnection connection, String url) {}
}