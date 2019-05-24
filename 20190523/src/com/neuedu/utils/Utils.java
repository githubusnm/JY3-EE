package com.neuedu.utils;

import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;

public class Utils {
    public static String getRandomId(){
        Random random = new Random();
        int i = random.nextInt(100);
        String str = null;
        str = String.valueOf(System.currentTimeMillis());
        if (i<10){
            str += "0"+i;
        }
        return str += i;
    }

    public static String getFilename(Part part){
        String submittedFileName = part.getSubmittedFileName();
        UUID uuid = UUID.randomUUID();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String filename = uuid+submittedFileName;
        try {
            inputStream = part.getInputStream();
        outputStream = new FileOutputStream("C:\\img\\" + filename);
        int buffer = 0;
        byte[] bs = new byte[1024];
        while((buffer = inputStream.read(bs)) != -1){
            outputStream.write(bs,0,buffer);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filename;
    }

    public static Date getDate(String string){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            java.util.Date parse = simpleDateFormat.parse(string);
            date = new Date(parse.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
