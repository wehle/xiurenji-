package Remind;/*
作者Crying711
日期:10/19/2020
时间:5:26 PM
*/



import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import java.util.Calendar;

import java.util.GregorianCalendar;

public class SendFIle_size extends  Thread
    {
    @Override
    public void run() {


        while (true)
        {
        GregorianCalendar gcalendar = new GregorianCalendar();

        int Second = gcalendar.get(Calendar.SECOND);

        int Minute = gcalendar.get(Calendar.MINUTE);

        int Deliverytime = Integer.parseInt(String.valueOf(LoadPropertyUtils.Getconfig("Deliverytime")));

        RuntimeMXBean mxb = ManagementFactory.getRuntimeMXBean();
        if (Second == 0)
        {
            if (Minute % Deliverytime == 0)
            {
                String url = String.valueOf(LoadPropertyUtils.Getconfig("Folderpath"));
                Send.SendEmail("爬虫提示","<br>"+"文件数量: "+new File(url).listFiles().length +"<br>"+"文件大小:"+ Send.getTotalSizeOfFilesInDir(new File(url)) / (1024 * 1024 * 1024)+"Gb" +"<br>"+"进程id:"+mxb.getName());
            }
        }

        }
                    }
    }
