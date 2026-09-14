// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/the-power-sum/problem?isFullScreen=true
// Problem     The Power Sum
// Difficulty  Medium
// Subdomain   Recursion
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-09-14, 07:39 p.m.
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
     * Complete the 'powerSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER X
     *  2. INTEGER N
     */
    public static int rec(int X,int N,int num){
        if(X==0){
            return 1;
        }
        int power=(int)Math.pow(num,N);
        if(X<0 || power>X){
            return 0;
        }
        return rec(X-power,N,num+1)+rec(X,N,num+1);
        
    }

    public static int powerSum(int X, int N) {
    // Write your code here
        return rec(X,N,1);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = Integer.parseInt(bufferedReader.readLine().trim());

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
