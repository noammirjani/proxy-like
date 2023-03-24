package DecoratorForDownload;

import java.net.URLConnection;

/**
 * Decorator class to add functionality to the AccessUrl interface.
 */
public class Decorator implements AccessUrl {
    /**
     * The accessUrl instance variable to be decorated.
     */
    protected AccessUrl accessUrl;

    /**
     * Constructor to set the accessUrl instance variable.
     *
     * @param accessUrl the AccessUrl object to be decorated.
     */
    public Decorator(AccessUrl accessUrl) {
        this.accessUrl = accessUrl;
    }

    /**
     * Calls the operation method of the decorated AccessUrl object.
     *
     * @param connection the URLConnection object for the operation.
     * @param url the URL for the operation.
     * @throws Exception if an exception occurs in the decorated AccessUrl object's operation method.
     */
    @Override
    public void operation(URLConnection connection, String url) throws Exception {
        accessUrl.operation(connection, url);
    }
}