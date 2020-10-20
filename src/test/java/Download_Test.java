import Download_Save.Download;
import Download_Save.Download_Core;
import org.junit.Test;

import java.io.IOException;

public class Download_Test {


    @Test
    public  void Dwonload() throws IOException {

        Download.Download("https://www.xiurenji.com/XiaoYu/4326.html");
    }


    @Test
    public  void Dwonloadlist()
    {


    }


    @Test
    public  void  Download_Core() throws IOException {

        Download_Core.Download("https://www.xiurenji.com/Uploadfile/202002/6/58115233841.jpg","ll","2");
    }
}
