// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/gridland-metro/problem?isFullScreen=true
// Problem     Gridland Metro
// Difficulty  Medium
// Subdomain   Search
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
     * Complete the 'gridlandMetro' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER k
     *  4. 2D_INTEGER_ARRAY track
     */
    

    public static long gridlandMetro(int n, int m, int k, List<List<Integer>> track) {
    // Write your code here
        if(track.isEmpty()) return n * m;

        track.sort((a,b) -> {
            if(!a.get(0).equals(b.get(0))) return a.get(0) - b.get(0);
            return a.get(1) - b.get(1);
        });

        List<List<Integer>> merged= new ArrayList<>();
        List<Integer> prev = track.get(0);

        for(int i=1; i<track.size(); i++){
            List<Integer> curr = track.get(i);
            if(prev.get(0).equals(curr.get(0)) && curr.get(1) <= prev.get(2)){
                prev.set(2, Math.max(prev.get(2), curr.get(2)));
            } else {
                merged.add(prev);
                prev = curr;
            }
        }
        merged.add(prev);

        long count = (long)n * m;
        for(List<Integer> t : merged){
            count -= (long)(t.get(2) - t.get(1) + 1);
        }

        return count;
    }

    

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> track = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                track.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.gridlandMetro(n, m, k, track);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
