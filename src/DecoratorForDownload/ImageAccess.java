package DecoratorForDownload;

import java.net.URL;
import java.net.URLConnection;

public class ImageAccess extends Decorator{

    public ImageAccess(AccessUrl accessUrl) {

        super(accessUrl);
    }

    public void operation(URLConnection connection, String url) throws Exception {

        if(!connection.getContentType().contains("image/"))
            throw new Exception("denied");

        super.operation(connection, url);
    }
}
