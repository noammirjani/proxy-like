package DecoratorForDownload;

import java.net.URLConnection;

/**
 * This class is a decorator for accessing URLs that only allows access to image files.
 */
public class ImageAccess extends Decorator{

    /**
     * Constructs an ImageAccess object with the given AccessUrl object.
     *
     * @param accessUrl the AccessUrl object to decorate.
     */
    public ImageAccess(AccessUrl accessUrl) {

        super(accessUrl);
    }

    /**
     * Overrides the operation method of the AccessUrl interface to only allow access to URLs that
     * point to image files.
     *
     * @param connection the URLConnection object representing the connection to the URL.
     * @param url the URL string to access.
     * @throws Exception if the URL does not point to an image file, or if an error occurs during
     *                   the operation of the decorated AccessUrl object.
     */
    @Override
    public void operation(URLConnection connection, String url) throws Exception {

        String contentType = connection.getContentType();
        if (contentType != null && contentType.contains("application/image")) {
            throw new Exception("denied");
        }

        super.operation(connection, url);
    }
}