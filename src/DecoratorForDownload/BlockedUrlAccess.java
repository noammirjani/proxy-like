package DecoratorForDownload;

import FileManager.FileManage;
import java.net.URLConnection;

/**
 * A concrete decorator class that blocks access to URLs listed in a file.
 * It extends the Decorator abstract class and implements the AccessUrl interface.
 */
public class BlockedUrlAccess extends Decorator {

    /**
     * Constructor that initializes a BlockedUrlAccess object with an AccessUrl object.
     *
     * @param accessUrl The AccessUrl object to be decorated.
     */
    public BlockedUrlAccess(AccessUrl accessUrl) {
        super(accessUrl);
    }

    /**
     * Overrides the operation method of the AccessUrl interface.
     * It blocks access to the URL if it is listed in the "blocked.txt" file.
     * Otherwise, it passes the connection and URL to the decorated object.
     *
     * @param connection The URLConnection object to be accessed.
     * @param url        The URL to be accessed.
     * @throws Exception if the URL is listed in the "blocked.txt" file.
     */
    @Override
    public void operation(URLConnection connection, String url) throws Exception {
        if (FileManage.getInstance().searchInFile("blocked.txt", url).contains("blocked")) {
            throw new Exception("Access denied. URL is blocked.");
        }
        super.operation(connection, url);
    }
}