package se.edtek.y2015.d4;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {

    public int task(String secretKey, String prefix) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        int l = 0;

        while (true) {

            String hash = md5(md, secretKey + l);

            if (hash.startsWith(prefix)) {
                return l;
            }

            l++;
        }
    }

    private String md5(MessageDigest md, String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        md.update(s.getBytes("UTF-8"));
        byte[] digest = md.digest();
        // return DatatypeConverter.printHexBinary(digest).toUpperCase();
        return "";
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Solution solution = new Solution();

        int result1 = solution.task("ckczppom", "00000");
        System.out.println("Uppgift 1: " + result1);

        int result2 = solution.task("ckczppom", "000000");
        System.out.println("Uppgift 2: " + result2);
    }
}
