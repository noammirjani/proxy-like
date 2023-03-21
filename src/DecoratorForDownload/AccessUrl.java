package DecoratorForDownload;

import java.net.URLConnection;

public interface AccessUrl {

    void operation(URLConnection connection, String url) throws Exception;
}
