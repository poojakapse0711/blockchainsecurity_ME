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
public class UploadHelper
{
       
//private static final String ACCESS_TOKEN = "HruxJey6TwMAAAAAAAAAAT8msC1oj5maYH3rr0tTPo5kWTcqDIsNnNVTNO7LsMiT";
private static final String ACCESS_TOKEN = "sl.BWHS54_caWLIFhnwuL-yad2H2ogJR0LqXFd93XNAYnKqGAZFofM3rWw2nQwMT7jQeR3Gz8BdXJ6bUkQQKwlwU_1fvJQOYVKc2tMdm01jPjS4H-deCcnRjCqu_uV0rzB7vtWSS8U";
public void intiateUpload(String path) throws DbxException, UploadErrorException, IOException
{
    
   // dropboxaccount name=projectbe234@gmail.com;
  //  password=Project@123
       // DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
    DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/ME_Project").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        FullAccount account = client.users().getCurrentAccount();
        System.out.println(account.getName().getDisplayName());
        
        
        UploadFile uf=new UploadFile();
         uf.uploaddropboxFile(client,path);
}
}
