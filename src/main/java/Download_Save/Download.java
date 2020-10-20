package Download_Save;/*
作者Crying711
日期:9/10/2020
时间:7:23 PM
*/

import Query.QueryUtils;

import java.io.IOException;
import java.util.List;

public class Download {



    /*
    *
    * 下载一组    使用 线程延时
    *
    * */
    @Deprecated
    public  static  void Download(final String url, final long delayed) throws IOException, InterruptedException {






        new Thread(){
                    @Override
                    public void run() {
                        List<String> list = null;
                        try {
                            list = QueryUtils.Getimglinks(url);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        String name = null;
                        name = QueryUtils.GetTitle(url);

                        System.out.println("INFO: "+name+"Start downloading  Number of files "+list.size());
                        long start = System.currentTimeMillis();
                        for (int i = 0; i <=list.size()-1 ; i++) {

                            try {
                                if ( Download_Core.Download(list.get(i), name, String.valueOf(i))){
                                        if (i==list.size()-1)
                                        {
                                            System.out.println("INFO: "+"\033[32;4m" + name+ " "+list.size()+"Thread started successfully" + "\033[0m");

                                        }
                                }
                                else {
                                    System.out.println("INFO: "+"\033[33;4m" + name+"Already exists" + "\033[0m");
                                    return;
                                }

                                } catch (IOException e) {
                                e.printStackTrace();
                                }
                                try {
                                Thread.sleep(delayed);
                                } catch (InterruptedException e) {
                                e.printStackTrace();
                                }

                        }


                        System.out.println();
                        System.out.println("INFO: "+name+"Download successful");


                    }
                }.start();


    }


    /*
     *
     * 下载一组
     *
     * */
    public  static  void Download(String url) throws IOException {

                 List<String>   list = QueryUtils.Getimglinks(url);

                if (list.size() ==0){
                    return;
                }

                String name = QueryUtils.GetTitle(url);
                System.out.println("INFO: "+name+"Start downloading  Number of files "+list.size());

                for (int i = 0; i <=list.size()-1 ; i++)
                {
                    if ( Download_Core.Download(list.get(i), name, String.valueOf(i)))
                    {

                        if (i==list.size()-1)
                        {

                            System.out.println("INFO: "+"\033[32;4m" + name+ " "+list.size()+"Thread started successfully" + "\033[0m");


                        }
                    }else
                        {
                            System.out.println("INFO: "+"\033[33;4m" + name+"Already exists" + "\033[0m");
                        System.out.println();
                        return;
                        }

                }

                System.out.println();
                System.out.println("INFO: "+name+"Download successful");


    }

    /*
     *
     * 下载全部
     *
     * */
    public  static  void Download(List<String> list) throws IOException, InterruptedException {

        for (int i = 0; i <=list.size()-1 ; i++)
        {
                        Download(list.get(i));
        }

    }




}
