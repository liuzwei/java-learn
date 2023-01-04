package com.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.SimpleBookmark;

import lombok.Data;

public class PdfDictionaryUtil {

    private static String title = "Title";

    private static String goTo = "GoTo";

    private static String action = "Action";

    private static String pageTag = "Page";

    public static  List<PdfDirectory> getDirs(File file) throws IOException {
        PdfReader reader = new PdfReader(Files.newInputStream(file.toPath()));

        List list = SimpleBookmark.getBookmark(reader);
        List<PdfDirectory> dirs = new ArrayList<>();
        if(list.isEmpty()){
            return dirs;
        }
        for (Iterator i = list.iterator(); i.hasNext(); ) {
            PdfDirectory dir = new PdfDirectory();
            showBookmark((Map) i.next(), dir);
            dirs.add(dir);
        }
        return dirs;
    }

    private static void showBookmark(Map bookmark, PdfDirectory dir) {
        dir.setTitle(String.valueOf(bookmark.get(title)));
        if (goTo.equals(bookmark.get(action))) {
            String page = (String) bookmark.get(pageTag);
            if (page != null) {
                page = page.trim();
                int idx = page.indexOf(' ');
                int pageNum;
                if (idx < 0) {
                    pageNum = Integer.parseInt(page);
                } else {
                    pageNum = Integer.parseInt(page.substring(0, idx));
                }
                dir.setPageNum(pageNum);
            }
        }
        ArrayList kids = (ArrayList) bookmark.get("Kids");
        if (kids == null) {
            return;
        }
        List<PdfDirectory> childs = new ArrayList<>();
        for (Iterator i = kids.iterator(); i.hasNext(); ) {
            PdfDirectory child = new PdfDirectory();
            showBookmark((Map) i.next(), child);
            childs.add(child);
        }
        dir.setChilds(childs);
    }

    @Data
    public static class PdfDirectory {

        /**
         * 目录名字
         */
        private String title;

        /**
         * 页码
         */
        private Integer pageNum;

        /**
         * 子目录
         */
        private List<PdfDirectory> childs;
    }

    public static void main(String[] args) throws Exception{
        List<PdfDirectory> dirs = getDirs(new File("C:/Users/liuzh/Downloads/TCP-IP详解(卷一).pdf"));
        System.out.println(JSONObject.toJSONString(dirs));
    }
}
