/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dropbox;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.UploadErrorException;
import com.dropbox.core.v2.users.FullAccount;
import java.io.IOException;

/**
 *
 * @author Lenovo
 */
public class OverwriteHelper
{
       
private static final String ACCESS_TOKEN = "HruxJey6TwMAAAAAAAAAAT8msC1oj5maYH3rr0tTPo5kWTcqDIsNnNVTNO7LsMiT";

public void intiateOverwrite(String path) throws DbxException, UploadErrorException, IOException
{
     DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        FullAccount account = client.users().getCurrentAccount();
        System.out.println(account.getName().getDisplayName());
        
        
         new FileOverwrite().overwriteFile(client, path);
}
}
