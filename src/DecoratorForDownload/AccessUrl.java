/**
 *
 * The AccessUrl interface represents a component of the Decorator pattern.
 * It declares a single method, operation, which must be implemented by all decorators.
 * The operation method modifies the behavior of the URLConnection object passed as an argument,
 * according to the specific decorator's functionality.
 */
package DecoratorForDownload;
import java.net.URLConnection;

public interface AccessUrl {

    /**
     * Modifies the behavior of the URLConnection object passed as an argument.
     * The specific decorator's functionality is implemented in this method.
     *
     * @param connection the URLConnection object to be modified.
     * @param url the URL associated with the connection.
     * @throws Exception if an error occurs while performing the operation.
     */
    void operation(URLConnection connection, String url) throws Exception;
}