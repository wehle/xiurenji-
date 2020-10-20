package xiurenji.Reptiles;

import Arch.Config;
import Choice.Chioce;
import Download_Save.Download;
import Remind.Abnormal;
import Remind.LoadPropertyUtils;
import Remind.Send;
import Remind.SendFIle_size;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{



    public static void main( String[] args )
    {

            boolean Remind = Boolean.valueOf(String.valueOf(LoadPropertyUtils.Getconfig("Remind")));

            boolean  SocksProxy = Boolean.valueOf(String.valueOf(LoadPropertyUtils.Getconfig("socksProxy")));

            String Folderpath  = String.valueOf(LoadPropertyUtils.Getconfig("Folderpath"));
            System.out.println(LoadPropertyUtils.WordArt());

    /*
    *
    * 使用代理
    * */
            if (SocksProxy)
            {
             System.setProperty("socksProxyHost", String.valueOf(LoadPropertyUtils.Getconfig("socksProxyHost")));

             System.setProperty("socksProxyPort",  String.valueOf(LoadPropertyUtils.Getconfig("socksProxyPort")));
            }

        /*
         *
         * 使用邮箱提醒
         * */
            if (Remind)
                {
                Thread Start = new SendFIle_size();

                Start.start();
                }


        if (args.length != 0)
        {
            if (args[0].equals("help"))
            {
                System.out.println("INFO: 1==One group,2==Ten groups,3==All groups");
            }else{


                try
                {
                    List<String> list=  Chioce.initialization();
                    System.out.println("INFO: Start successfully"+new Date());
                    Chioce.Selector(list, Byte.parseByte(args[0]));
                }catch (Exception ex)
                {
                    Send.SendEmail("爬虫信息","<br>"+"文件数量: "+new File(Folderpath).listFiles().length +"<br>"+ Abnormal.getExceptionDetail(ex));
                }catch (Error er)
                {
                    Send.SendEmail("爬虫信息","<br>"+"文件数量: "+new File(Folderpath).listFiles().length +"<br>"+ Abnormal.getExceptionDetail(er));
                }
                }

        }else
            {   try
                {
                    List<String> list=  Chioce.initialization();
                    System.out.println("INFO: Start successfully"+new Date());
                    Chioce.Selector(list);
                }
                catch (Exception e)
                {
                    Send.SendEmail("爬虫信息","<br>"+"文件数量: "+new File(Folderpath).listFiles().length +"<br>"+ Abnormal.getExceptionDetail(e));
                }catch (Error e)
                {
                Send.SendEmail("爬虫信息","<br>"+"文件数量: "+new File(Folderpath).listFiles().length +"<br>"+ Abnormal.getExceptionDetail(e));
                }
                }
    }
}
