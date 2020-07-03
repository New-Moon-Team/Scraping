package com.example.demo.getDataNoJson;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GetHandleHaveClass {
    public static void main(String[] args) throws IOException {

             for (int i =1; i<=61;i++){
                 System.out.println(i);
                 Document docAll = Jsoup.connect("https://www.mrpuzzlehead.com/collections/500-piece-jigsaw-puzzles?page="+i).get();
//        Elements handle = docAll.select(".grid-view-item__link grid-view-item__image-container")  ;
                 Elements handle = docAll.getElementsByClass("wk-app-btn tt-btn-wishlist wlbutton-js");
                 System.out.println(handle.size());
                 for(int t =0;t<handle.size();t++){
                     System.out.println(  "https://www.mrpuzzlehead.com" + handle.get(t).attr("href"));
                     SaveFile(  "https://www.mrpuzzlehead.com" +  handle.get(t).attr("href"));
                 }
             }

    }
    public static void SaveFile(String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\TheNewMoonST\\file\\json\\mrpuzzlehead.txt", true));
        writer.write(data + "\n");
        writer.close();
    }
}

