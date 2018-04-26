package main.util;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {



    public static String encrypt(String s){
        String res = null;
        byte[] bytesOfMessage = new byte[0];
        try {
            bytesOfMessage = s.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytesOfDigest = md.digest(bytesOfMessage);
            return DatatypeConverter.printHexBinary(bytesOfDigest).toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }



}
