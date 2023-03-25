package DecoratorForDownload;

import java.net.URLConnection;

/**
 * A decorator for URL connections that blocks access if the connection contains a "Set-Cookie" header.
 */
public class CookiesAccess extends Decorator {

    /**
     * Constructs a new CookiesAccess decorator with the given AccessUrl object.
     *
     * @param accessUrl the AccessUrl object to decorate.
     */
    public CookiesAccess(AccessUrl accessUrl) {
        super(accessUrl);
    }

    /**
     * Performs the cookies access operation on the URL connection, blocking access if a "Set-Cookie" header is present.
     *
     * @param connection the URLConnection object to perform the operation on.
     * @param url the URL string associated with the connection.
     * @throws Exception if access is denied due to the presence of a "Set-Cookie" header.
     */
    @Override
    public void operation(URLConnection connection, String url) throws Exception {
        if (connection.getHeaderField("Set-Cookie") != null) {
            throw new Exception("denied");
        }
        super.operation(connection, url);
    }
}