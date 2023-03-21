package DecoratorForDownload;

import FileManager.FileManage;
import java.net.URLConnection;


public class BlockedUrlAccess extends Decorator{

    public BlockedUrlAccess(AccessUrl accessUrl) {

        super(accessUrl);
    }

    public void operation(URLConnection connection, String url) throws Exception {

        if(FileManage.getInstance().searchInFile("blocked.txt", url).contains("blocked"))
            throw new Exception("denied");

        super.operation(connection, url);
    }
}