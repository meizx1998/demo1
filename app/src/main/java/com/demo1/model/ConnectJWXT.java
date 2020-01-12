package com.demo1.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ConnectJWXT {


private String stuNum;//学号

    public String get__VIEWSTATE() {
        return __VIEWSTATE;
    }
    private String stuName;//学生姓名
private String __VIEWSTATE;
private Map<String,String>cookies =new HashMap<>();
private Connection connection;//实现网络请求工具
private Connection.Response response;

    public Map<String, String> getCookies() {
        return cookies;
    }

    private Document document;

//第一次打开网页并保存cookie和VIewstate
public void openlogin()
{
    connection= Jsoup.connect("http://xuanke1.ujs.edu.cn/1.aspx");
    connection.header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
    try {
        response=connection.timeout(3000).execute();
        cookies=response.cookies();
        document=Jsoup.parse(response.body());
        //提取其中的__Viewstate
        for(Element element:document.getElementsByTag("input"))
        {
            if(element.attr("name").equals("__VIEWSTATE"))
            {
                __VIEWSTATE=element.val();
                break;
            }
        }
       // __VIEWSTATE="abc";

    } catch (IOException e) {
        e.printStackTrace();
    }


}

}
