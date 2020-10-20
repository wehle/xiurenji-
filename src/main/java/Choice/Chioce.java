package Choice;/*
作者Crying711
日期:9/10/2020
时间:8:35 PM
*/

import Arch.Config;
import Download_Save.Download;
import Query.QueryUtils;
import Remind.LoadPropertyUtils;


import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Chioce{

    /*
     *
     * 初始化 链接组 以list的方式返回 并洗牌
     *
     * */
    public  static  List<String> initialization() throws IOException {

        File folder = new File(String.valueOf(LoadPropertyUtils.Getconfig("Folderpath")));
        if (!folder.exists())
        {
            folder.mkdirs();
        }
        File file = new File("xiurenji.config");
        if (!file.exists())
        {

            return     QueryUtils.GetALLS();

        }

        BufferedReader bufferedReader  = new BufferedReader(new FileReader(file));
        String line;
        List<String> list = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null){
            list.add(line);
        }
        if (list.size()==0){

            return  QueryUtils.GetALLS();

        }
       Collections.shuffle(list);
        return list;
    }

    public static  List<String> Randoms(List<String> list)
    {

        List<String> lists = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            lists.add(list.get(new Random().nextInt(list.size())));
        }
        return  lists;
    }

    public static  String Random(List<String> list)
    {

        return list.get(new Random().nextInt(list.size()));

    }

    /*
     *
     * 通过Main方法 args 的方式选择
     *
     * */
    public  static  void Selector(List list,byte Controller ) throws IOException, InterruptedException {





        switch (Controller){
            case  1:{

                Download.Download(Chioce.Random(list),0);

                break;
            }

            case  2:{


                Download.Download(Chioce.Randoms(list));

                break;
            }

            case  3:{
                Download.Download(list);

                break;
            }


        }


    }
    /*
    *
    * 通过input 的方式选择
    *
    * */
    public  static  void Selector(List list) throws IOException, InterruptedException {

        Scanner Input  = new Scanner(System.in);
        byte Controller;
        System.out.println("INFO: 1==One group,2==Ten groups,3==All groups");
        Controller = Input.nextByte();

        switch (Controller){
            case  1:
                {

                Download.Download(Chioce.Random(list),0);
                Chioce.Selector(list);
                break;
                }

            case  2:
                {
                    Download.Download(Chioce.Randoms(list));
                    Chioce.Selector(list);
                    break;
                 }

            case  3:
                {
                    Download.Download(list);
                    Chioce.Selector(list);
                    break;
                }


        }


    }

}
