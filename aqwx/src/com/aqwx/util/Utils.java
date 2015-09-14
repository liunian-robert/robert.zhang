 package com.aqwx.util;

 import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;


 public class Utils
 {
   public static Date string2Date(String date)
   {
       SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
       Date ss = null;
     try {
         ss = formate.parse(date);
     } catch (ParseException e) {
          e.printStackTrace();
          throw new RuntimeException(e.getMessage(), e);
     }
        return ss;
   }

   public static String Date2String(Date date) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        String month = null;
        if (c.get(2) + 1 < 10)
          month = "0" + (c.get(2) + 1);
     else {
          month =""+ c.get(2) + 1;
     }
        String ss = c.get(1) + "-" + month + "-" +
          c.get(5);
        return ss;
   }
   public static String getDate() {
        Date date = new Date();
        String time = date.getHours() + " :" + date.getMinutes() + " :" + date.getSeconds();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        return ft.format(date) + "  " + time;
   }
   public static String getCurrentDate() {
        Calendar c = new GregorianCalendar();
        String year = c.get(1) + "年";
        String month = c.get(2) + 1 + "月";
        String day = c.get(5) + "日";
        String date = year + month + day;
        return date;
   }
   public static String getWeek() {
        Calendar c = new GregorianCalendar();
        int m = c.get(7);
        String st = "";
        switch (m) {
     case 1:
          return "星期日";
     case 2:
          return "星期一";
     case 3:
          return "星期二";
     case 4:
          return "星期三";
     case 5:
          return "星期四";
     case 6:
          return "星期五";
     case 7:
          return "星期六";
     }
        return st;
   }
   public static String getMonthString() {
        Calendar c = new GregorianCalendar();
        String month = null;
        if (c.get(2) + 1 < 10)
          month = "0" + (c.get(2) + 1);
     else {
          month = ""+c.get(2) + 1;
     }
        String ss = c.get(1) + "-" + month;
        return ss;
   }
   public static void write2Image(File Image, String fileName) {
        OutputStream out = null;
        InputStream in = null;
     try
     {
         out = new FileOutputStream(fileName);
         in = new FileInputStream(Image);
         IOUtils.copy(in, out);
         out.close();
         in.close();
     }
     catch (Exception e)
     {
         e.printStackTrace();
         throw new RuntimeException(e.getMessage(), e);
     }
   }

   public static String getRandomString() {
       Calendar c = new GregorianCalendar();
       StringBuffer sb = new StringBuffer();
       sb.append(c.get(1));
       int k = c.get(2) + 1;
       if (k < 10)
         sb.append("0" + k);
     else {
         sb.append(k);
     }
       if (c.get(5) < 10)
         sb.append("0" + c.get(5));
     else {
         sb.append(c.get(5));
     }
       UUID m = UUID.randomUUID();
       sb.append(m.toString().substring(0, m.toString().indexOf("-")));
       return sb.toString();
   }
   public static String getImageString(String rname) {
       String m = UUID.randomUUID().toString();
       String last = rname.substring(rname.indexOf("."), rname.length()).trim();
       String name = m.substring(0, m.indexOf("-"));
       return name.trim() + last;
   }
   public static int getYear(Date date) {
       Calendar c = new GregorianCalendar();
       c.setTime(date);
       return c.get(1);
   }

   public static int getMonth(Date date) {
       Calendar c = new GregorianCalendar();
       c.setTime(date);
       return c.get(2) + 1;
   }

   public static int getDay(Date date) {
       Calendar c = new GregorianCalendar();
       c.setTime(date);
       return c.get(5);
   }

   public static boolean saveDatabase() {
       String path = ServletActionContext.getServletContext()
         .getRealPath("/database") +
         "/";
       String str = "cmd /c mysqldump -u root -proot --database   db_aqwx >  " + path + "db_aqwx.sql";
     try {
         Runtime rt = Runtime.getRuntime();
         rt.exec(str);
         return true;
     }
     catch (IOException e)
     {
         e.printStackTrace();
     }
       return false;
   }
   public static String getContent(String ss) {
       String content = "";
       if ((ss != null) && (!ss.equals(""))) {
         if (ss.length() > 20)
           content = ss.substring(0, 20) + "....";
       else {
           content = ss + "....";
       }
     }
       return content;
   }
   public static void deleteFile(String path, String filename) {
       File folder = new File(path);
       File[] files = folder.listFiles();
       for (File file : files)
         if (file.getName().equals(filename.trim()))
           file.delete();
   }
   
   /*public static String  getProperty(){
       String property = "/home/vcap/file/199c089a-5022-4cfd-affb-b4fd00f5b2f6";
       return property;
   }*/
 }
