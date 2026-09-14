// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/richie-rich/problem?isFullScreen=true
// Problem     Highest Value Palindrome
// Difficulty  Medium
// Subdomain   Strings
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-09-14, 07:40 p.m.
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
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */

    public static String highestValuePalindrome(String s, int n, int k) {
        //can we make it palindrome check
        int min=0;
        int max_val=9;
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)){
                min++;
            }
            
        }  
        if(min>k){
            return "-1";
        }
        //make it palindrome
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)==s.charAt(n-i-1)){
                continue;
            }
            int max=Math.max(s.charAt(i)-'0',s.charAt(n-i-1)-'0');
            sb.setCharAt(i, (char)(max+'0'));
            sb.setCharAt(n-i-1,(char)(max+'0'));
            k--;
        }
        //maximize it
        int i=0;
        
        while(i<n/2&&k>0){
            if(sb.charAt(i)=='9'){
                i++;
                continue;
            }
            if(s.charAt(i)!=s.charAt(n-i-1)){
                if(k>=1){
                    sb.setCharAt(i,'9');
                    sb.setCharAt(n-i-1,'9');
                    k--;
                }
            }else{
                if(k>=2){
                    sb.setCharAt(i,'9');
                    sb.setCharAt(n-i-1,'9');
                    k-=2;
                }
            }
            i++;
        }

        // if(k==1){
        //     for(int j=0;j<n/2;j++){
        //         if(sb.charAt(j)-'0'==9){
        //             continue;
        //         }
        //         else if((s.charAt(j)!=sb.charAt(j) && s.charAt(n-j-1)==sb.charAt(n-j-1)) || (s.charAt(j)==sb.charAt(j) && s.charAt(n-j-1)!=sb.charAt(n-j-1))){
        //             sb.setCharAt(j, (char)(max_val+'0'));
        //             sb.setCharAt(n-j-1,(char)(max_val+'0'));
        //             k--;
        //             break;
        //         }
        //     }
        // }
        if(n%2==1 && k>0){
            sb.setCharAt(n/2,'9');
            k--;
        }

        return sb.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
