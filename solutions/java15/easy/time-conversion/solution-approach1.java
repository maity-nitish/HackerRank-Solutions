// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/time-conversion/problem?isFullScreen=true
// Problem     Time Conversion
// Difficulty  Easy
// Subdomain   Warmup
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-09-14, 07:42 p.m.
// ──────────────────────────────────────────────────

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        String str="";
        if(s.charAt(s.length()-2)=='P'){
            int a=Integer.parseInt(s.substring(0,2));
            if(a==12){
                str+=s.substring(0,s.length()-2);
                return str;
            }
            a+=12;
            str+=a;
            str+=s.substring(2,s.length()-2);
            return str;
        }
        int a=Integer.parseInt(s.substring(0,2));
        if(a==12){
            str+="00";
        }
        else if(a<=9){
            str+="0";
            str+=a;
        }
        else{
            str+=a;
        }
        str+=s.substring(2,s.length()-2);
        return str;
    }
        
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
