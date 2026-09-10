// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/java-1d-array-introduction/problem?isFullScreen=true
// Problem     Java 1D Array
// Difficulty  Easy
// Subdomain   Data Structures
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-09-10, 11:13 p.m.
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



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int[] a=new int[n];
        for(int i=0;i<n;i++){
            int val=Integer.parseInt(bufferedReader.readLine().trim());
            a[i]=val;
        }
        for(int i=0;i<n;i++){
            System.out.println(a[i]);
        }
        bufferedReader.close();
    }
}
