     package com.aqwx.util;

     import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

     public class BASE64
     {
       public static String encode(String password)
       {
       BASE64Encoder encoder = new BASE64Encoder();
       return encoder.encode(password.getBytes());
       }

       public static String decode(String ms) {
       BASE64Decoder decoder = new BASE64Decoder();
       String password = null;
         try {
         password = new String(decoder.decodeBuffer(ms));
         } catch (IOException e) {
         e.printStackTrace();
         throw new RuntimeException(e.getMessage(), e);
         }
       return password;
       }
     }
