package DecoratorForDownload;
import java.net.URL;
import java.net.URLConnection;


public class HtmlAccess extends Decorator{

    public HtmlAccess(AccessUrl accessUrl) {

        super(accessUrl);
    }

    public void operation(URLConnection connection, String url) throws Exception {

        if(connection.getContentType().equals("text/html"))
            throw new Exception("denied");

        super.operation(connection, url);
    }
}
