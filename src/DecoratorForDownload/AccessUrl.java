package DecoratorForDownload;
import java.net.URL;
import java.net.URLConnection;

public interface AccessUrl {
    void operation(URLConnection connection, String url) throws Exception;
}
