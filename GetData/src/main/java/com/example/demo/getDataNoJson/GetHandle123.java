package com.example.demo.getDataNoJson;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GetHandle123 {
    public static void main(String[] args) throws IOException {

        for (int i =1 ; i<=106;i++){
            System.out.println(i);
            Document docAll = Jsoup.connect("https://mellouise.com/collections/tumblers?page="+i).get();
//        Elements handle = docAll.select(".grid-view-item__link grid-view-item__image-container")  ;
            Elements handle = docAll.getElementsByClass("product__image-wrapper") ;
            System.out.println(handle.size());
            for(int t =0;t<handle.size();t++){
                System.out.println(  "https://mellouise.com" + handle.get(t).attr("href"));
                SaveFile(  "https://mellouise.com" +  handle.get(t).attr("href"));
            }
        }

    }
    public static void SaveFile(String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\TheNewMoonST\\file\\json\\tumbler.txt", true));
        writer.write(data + "\n");
        writer.close();
    }
}

