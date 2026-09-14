// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?isFullScreen=true
// Problem     Sherlock and the Valid String
// Difficulty  Medium
// Subdomain   Strings
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-09-14, 07:41 p.m.
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
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        Map<Character,Integer> dic=new HashMap<>();
        for(int i=0;i<s.length();i++){
            dic.put(s.charAt(i),dic.getOrDefault(s.charAt(i),0)+1);
        }
        List<Integer> freq=new ArrayList<>(dic.values());
        Map<Integer,Integer> freqCount=new HashMap<>();
        for(int f:freq){
            freqCount.put(f,freqCount.getOrDefault(f,0)+1);
        }
        if(freqCount.size()==1){
            return "YES";
        }
        if(freqCount.size()>2){
            return "NO";
        }
        List<Integer> keys=new ArrayList<>(freqCount.keySet());
        int f1=keys.get(0),f2=keys.get(1);
        if((freqCount.get(f1)==1&&f1==1)||(freqCount.get(f2)==1&&f2==1)){
            return "YES";
        }
        if((freqCount.get(f1)==1&&f1==f2+1)||(freqCount.get(f2)==1&&f2==f1+1)){
            return "YES";
        }
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
