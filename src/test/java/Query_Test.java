import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Query_Test {

@Test
public    void Query() throws IOException {
//    https://www.sogou.com/web?query=ip

    Document document = Jsoup.parse(new URL("https://www.so.com/s?ie=utf-8&fr=none&src=360sou_newhome&nlpv=basesc&q=ip"),5000);


    URL url;


    Elements element = document.getElementsByClass("mh-detail");
    for (Element e:element
         ) {
        System.out.println(e.getElementsByTag("span").text());
    }
    System.out.println(element);




}





}



