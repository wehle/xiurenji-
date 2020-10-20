package Query;/*
作者Crying711
日期:9/10/2020
时间:6:14 PM
*/

import Arch.Config;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryUtils {
/*
* 查询一组
*
*
* */
    public  static List Getgroup(String url) throws IOException {
        Document document = Jsoup.parse(new URL(url),5000);
        Elements element = document.getElementsByClass("dan");
        List<String> list = new ArrayList<>();
        for (Element e:element
             ) {

        list.add("https://www.xiurenji.com"+e.getElementsByTag("a").attr("href"));

        }

        return  list;

    }
    /*
     * 查询页面大小
     *
     *
     * */
    public  static int Getpagesize(String url) throws IOException {
        Document document = Jsoup.parse(new URL(url),5000);
        Elements element = document.getElementsByClass("page");
        Document Document_1 = Jsoup.parse(String.valueOf(element));
        Elements Element_1 = Document_1.getElementsByTag("a");
        List<String> list = new ArrayList<>();
        for (Element e:Element_1
        ) {
            list.add(e.getElementsByTag("a").attr("href"));
        }
        String number = list.get(list.size()-1);
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(number);
        int size = Integer.parseInt(m.replaceAll("").trim());

        return  size;

    }
    /*
     * 查询图片地址
     *
     *
     * */
    public  static List Getimglink(String url) throws IOException {
        Document document = null;
        try {
            document = Jsoup.parse(new URL(url),50000);
        } catch (Exception e){

            System.out.println("INFO "+"\033[31;4m" + new Date()+":  "+"Connection timeout, retrying:"+url + "\033[0m");

            return         Getimglink(url);

        }

        Elements element = document.getElementsByAttribute("onload");
        List<String> list = new ArrayList<>();
        for (Element e:element
        ) {

            list.add("https://www.xiurenji.com"+e.getElementsByTag("img").attr("src"));

        }

        return  list;

    }
    /*
     * 查询图片数量
     *
     *
     * */
    public  static int Getimgsize(String url) throws IOException
    {  Document document =null;
        try {
            document = Jsoup.parse(new URL(url),5000*10);
        }catch (Exception e){


            System.out.println("INFO "+"\033[31;4m" + new Date()+":  "+"Connection timeout, retrying:"+url + "\033[0m");
            return  Getimgsize(url);
        }


        Elements element = document.getElementsByClass("page");

        Document Docment_1 = Jsoup.parse(String.valueOf(element));

        Elements elements = Docment_1.getElementsByTag("a");

        List<String> list = new ArrayList<>();

        for (Element e:elements
        )
        {
            list.add(e.getElementsByTag("a").text());
        }
        list = Removeduplication(list);

        int  size = 0;
        try {
           size = Integer.parseInt(list.get(list.size()-2));
        }catch (ArrayIndexOutOfBoundsException e){

            System.out.println();
            System.out.println("INFO :"+"\033[34;4m" + new Date()+":  "+"由于本套图官方已经下架。故只有3张预览图可供欣赏。望理解:"+url + "\033[0m");
            return  0;
        }

         return size;

    }
    /*
     * 查询一组的所有图片
     *
     *
     * */
        public  static List Getimglinks(String url) throws IOException
        {


         String Url_intercept=url.substring(0, url.length()-5);

        int size = Getimgsize(url);
        if (size ==0){

            return  Getimglink(url);
        }
        List list = new ArrayList();
        String urls;
        for (int i = 0; i <size ; i++)
        {


            if (i!=0)
            {
                urls = Url_intercept+"_"+i+".html";
            }
            else
                {
                    urls = Url_intercept+".html";
                }
           list.addAll(QueryUtils.Getimglink(urls)) ;
        }


    return list;

}

/*
*
* 获得所有的组 连接
*
* */

        public  static  List GetALL(String url) throws IOException
        {
        int size = QueryUtils.Getpagesize(url);
         String Url_intercept=url.substring(0, url.length()-5);
         String urls;
         List<String> list = new ArrayList<>();
         for (int i = 0; i <size ; i++)
            {
                if (i!=0)
                {
                    urls = Url_intercept+(i+1)+".html";
                }
                else
                    {
                        urls = Url_intercept+".html";
                    }
                list.addAll(QueryUtils.Getgroup(urls));

            }

    return  list;
    }


    /*
     *
     * 获得所有的组 连接 并写入到文件中
     *
     * */
    public  static List<String> GetALLS() throws IOException
    {
        System.out.println("INFO: initialization Please wait ");
        System.out.println("INFO: Operating system  "+ Config.Osname);
        System.out.println("INFO: User home directory  "+ Config.Home);

        List<String> list = new ArrayList();
        List<String>  Link= new ArrayList();
        Link.add("https://www.xiurenji.com/XiuRen/index.html");
        Link.add("https://www.xiurenji.com/MFStar/index.html");
        Link.add("https://www.xiurenji.com/MiStar/index.html");
        Link.add("https://www.xiurenji.com/MyGirl/index.html");
        Link.add("https://www.xiurenji.com/IMiss/index.html");
        Link.add("https://www.xiurenji.com/YouWu/index.html");
        Link.add("https://www.xiurenji.com/FeiLin/index.html");
        Link.add("https://www.xiurenji.com/MiiTao/index.html");
        Link.add("https://www.xiurenji.com/YouMi/index.html");
        Link.add("https://www.xiurenji.com/XiaoYu/index.html");
        Link.add("https://www.xiurenji.com/HuaYang/index.html");
        Link.add("https://www.xiurenji.com/XingYan/index.html");
        BufferedWriter Writer = new BufferedWriter(new FileWriter("xiurenji.config"));
        long Start = System.currentTimeMillis();
        for (int i = 0; i <=Link.size()-1 ; i++)
        {
                   list.addAll(GetALL(Link.get(i)));
        }
        for (int i = 0; i <=list.size()-1 ; i++) {
            Writer.write(list.get(i));
            Writer.newLine();
        }
        long End = System.currentTimeMillis();
        System.out.println("INFO: "+"It took "+(End-Start)/(1000)+" seconds");
        return list;
    }

    public  static  String GetTitle(String url) {
        Document document = null;
        try {
            document = Jsoup.parse(new URL(url),5000);
        } catch (IOException e) {
                System.out.println(url);
                return  GetTitle(url);
        }
        Elements elements = document.getElementsByClass("title");
        return  elements.text();
}




        public  static  List Removeduplication(List list)
        {
            for (int i = 0; i <=list.size() ; i++)
            {
                for (int j = list.size()-1; j >i ; j--)
                {
                    if (list.get(j).equals(list.get(i)))
                    {
                        list.remove(j);
                    }
                }
            }

            return  list;


        }
}
