package DecoratorForDownload;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ConcreteAccessUrl implements AccessUrl{
    private URLConnection urlConnect;

    public ConcreteAccessUrl(String url) throws Exception {
        this.urlConnect =  (new URL(url)).openConnection();

//        HttpURLConnection.setFollowRedirects(false);
//        HttpURLConnection httpURLConnection = (HttpURLConnection)urlConnect;
//        httpURLConnection.setRequestMethod("HEAD");
//
//        int responseCode = httpURLConnection.getResponseCode();
//        if (responseCode != HttpURLConnection.HTTP_OK) {
//            throw new Exception(Integer.toString(responseCode));
//        }
    }

    public URLConnection getUrlConnection(){
        return urlConnect;
    }

    @Override
    public void operation(URLConnection connection, String url) {}
}
