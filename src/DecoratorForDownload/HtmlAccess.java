package DecoratorForDownload;

import java.net.URLConnection;

/**
 * A concrete decorator that blocks the download if the URL refers to an HTML document.
 */
public class HtmlAccess extends Decorator {

    /**
     * Creates an instance of HtmlAccess with the given AccessUrl.
     *
     * @param accessUrl the AccessUrl to decorate.
     */
    public HtmlAccess(AccessUrl accessUrl) {
        super(accessUrl);
    }

    /**
     * Checks if the content type of the URL connection is HTML, and throws an exception if it is.
     *
     * @param connection the URL connection to the remote resource.
     * @param url        the URL of the remote resource.
     * @throws Exception if the content type of the URL connection is HTML.
     */
    public void operation(URLConnection connection, String url) throws Exception {
        String contentType = connection.getContentType();
        if (contentType != null && contentType.startsWith("text/html")) {
            throw new Exception("denied");
        }
        super.operation(connection, url);
    }
}
