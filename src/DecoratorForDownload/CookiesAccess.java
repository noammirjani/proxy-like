package DecoratorForDownload;

import java.net.URL;
import java.net.URLConnection;

public class CookiesAccess extends Decorator{

    public CookiesAccess(AccessUrl accessUrl) {

        super(accessUrl);
    }

    public void operation(URLConnection connection, String url) throws Exception {

        if(connection.getHeaderField("Set-Cookie") != null)
            throw new Exception("denied");

        super.operation(connection, url);
    }
}
