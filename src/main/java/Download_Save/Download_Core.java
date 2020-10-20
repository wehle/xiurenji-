package Download_Save;/*
作者Crying711
日期:9/10/2020
时间:7:07 PM
*/

import Arch.Config;

import java.io.*;
import java.net.*;

public class Download_Core {
/*
*
* 下载一个 判断文件是否存在 如果存在就下载 不存在则跳过
*
*
* */
    public  static boolean Download(String url,String foldername,String index) throws IOException {
        File file = new File("File"+Config.Fileseparator+foldername);

        if (!file.exists())
        {
            file.mkdirs();
        }

        File  picture  = new File(file.getAbsolutePath()+Config.Fileseparator+index+".png");
        if (picture.exists()){
            return false;
        }

        new Thread(){


           @Override
           public void run() {




               HttpURLConnection Connetion= null;
               try {
                   Connetion = (HttpURLConnection)new URL(url).openConnection();
               } catch (IOException e) {
                   e.printStackTrace();
               }
               try {
                   Connetion.setRequestMethod("GET");
               } catch (ProtocolException e) {
                   e.printStackTrace();
               }
               Connetion.setReadTimeout(5000);
               Connetion.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36");
               Connetion.setRequestProperty("Referer","https://www.xiurenji.com/");
               Connetion.setRequestProperty("Host","img1.xiurenji.com");
               InputStream In = null;
               try {
                   In = Connetion.getInputStream();
               } catch (IOException e) {
                return;
               }

               BufferedOutputStream Out = null;
               try {
                   Out = new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath()+Config.Fileseparator+index+".png"));
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               }
               try {
                   Savefile(In,Out);
               } catch (SocketTimeoutException e){
                   try {
                       Download(url, foldername, index);
                   } catch (IOException ioException) {
                       ioException.printStackTrace();
                   }
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }.start();


return  true;
    }
    private static  void Savefile(InputStream In, BufferedOutputStream out) throws IOException {
        int len = 0;
        byte size[]  = new byte[1024];

        while ((len = In.read(size)) !=-1)
        {

            out.write(size,0,len);
        }
        In.close();
        out.close();




    }








}
