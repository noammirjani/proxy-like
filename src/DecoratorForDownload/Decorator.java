package DecoratorForDownload;

import java.net.URLConnection;

public class Decorator implements  AccessUrl{
    protected AccessUrl accessUrl;

    public Decorator(AccessUrl accessUrl) {
        this.accessUrl = accessUrl;
    }

    @Override
    public void operation(URLConnection connection, String url) throws Exception {

        accessUrl.operation(connection, url);
    }
}