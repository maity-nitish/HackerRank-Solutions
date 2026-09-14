// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/queens-attack-2/problem?isFullScreen=true
// Problem     Queen's Attack II
// Difficulty  Medium
// Subdomain   Implementation
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
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
    // Write your code here
        int up=n-r_q;
        int down=r_q-1;
        int right=n-c_q;
        int left=c_q-1;
        int upRight=Math.min(up,right);
        int upLeft=Math.min(up,left);
        int downRight=Math.min(down,right);
        int downLeft=Math.min(down,left);
        for(List<Integer> obs:obstacles){
            int r_o=obs.get(0);
            int c_o=obs.get(1);
            if(c_o==c_q){
                if(r_o>r_q) up=Math.min(up,r_o-r_q-1);
                else down=Math.min(down,r_q-r_o-1);
            } else if(r_o==r_q){
                if(c_o>c_q) right=Math.min(right,c_o-c_q-1);
                else left=Math.min(left,c_q-c_o-1);
            } else if(Math.abs(r_o-r_q)==Math.abs(c_o-c_q)){
                if(r_o>r_q&&c_o>c_q) upRight=Math.min(upRight,r_o-r_q-1);
                else if(r_o>r_q&&c_o<c_q) upLeft=Math.min(upLeft,r_o-r_q-1);
                else if(r_o<r_q&&c_o>c_q) downRight=Math.min(downRight,r_q-r_o-1);
                else if(r_o<r_q&&c_o<c_q) downLeft=Math.min(downLeft,r_q-r_o-1);
            }
        }
        return up+down+left+right+upRight+upLeft+downRight+downLeft;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
