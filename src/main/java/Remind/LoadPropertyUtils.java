package Remind;/*
作者Crying711
日期:10/19/2020
时间:10:19 AM
*/

import Arch.Config;

import java.io.File;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LoadPropertyUtils {
    static
    {
        String url =null;

       if (Config.Osname.startsWith("Windows"))
       {
           url ="Remind_Windows-x86-64";
           System.loadLibrary(url);
       }else if (Config.Osname.startsWith("Linux"))
      {
         url =new File("Remind_Linux-x86-64.so").getAbsolutePath();
            System.load(url);
      }

    }
    public  native static  String WordArt();
public  static  String Getemail(String key){
    String value = "";
    Locale locale = Locale.getDefault();
    try {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("mail", locale);
        value =resourceBundle.getString(key);
    }catch (MissingResourceException mre)
    {
        value ="";

    }
    return  value;



}



    public  static Object Getconfig(String key){
        String value = "";
        Locale locale = Locale.getDefault();
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("config", locale);
            value =resourceBundle.getString(key);
        }catch (MissingResourceException mre)
        {
            value ="";

        }
        return  value;
        }

}
