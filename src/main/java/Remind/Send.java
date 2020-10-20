package Remind;/*
作者Crying711
日期:10/19/2020
时间:10:14 AM
*/

import org.apache.commons.mail.HtmlEmail;

import java.io.File;
import java.util.Date;

public class Send  {

    public  static  void SendEmail(String subject,String message)
    {

        HtmlEmail email = new HtmlEmail();
        try {
            email.setHostName(LoadPropertyUtils.Getemail("mail.host"));
            email.setCharset(LoadPropertyUtils.Getemail("mail.encoding"));
            email.addTo(LoadPropertyUtils.Getemail("mail.to"));
            email.setSSLOnConnect(false);

            email.setSmtpPort(Integer.parseInt(LoadPropertyUtils.Getemail("mail.smtp.port")));
            email.setFrom(LoadPropertyUtils.Getemail("mail.from"),LoadPropertyUtils.Getemail("mail.nickname"));
            email.setAuthentication(LoadPropertyUtils.Getemail("mail.username"),LoadPropertyUtils.Getemail("mail.password"));
            email.setSubject(subject);

            email.setMsg("爬虫信息来了！"+new Date()+"<br>"+message);
            email.send();

        }catch (Exception e){


        }


    }
    public static  long getTotalSizeOfFilesInDir(File file) {
        if (file.isFile())
            return file.length();
        final File[] children = file.listFiles();
        long total = 0;
        if (children != null)
            for (final File child : children)
                total += getTotalSizeOfFilesInDir(child);
        return total;
    }



}
