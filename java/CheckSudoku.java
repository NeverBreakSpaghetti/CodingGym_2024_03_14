package java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckSudoku {
    public static void main(String[] args) throws IOException {
        List<Integer[]> input = parseInput(); //entry : [row, column, value]
        CheckSudoku checkSudoku = new CheckSudoku();

        System.out.println(checkSudoku.evaluateInsertions(input));
    }

    private static List<Integer[]> parseInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int insertionsNumber = Integer.parseInt(br.readLine());
        List<Integer[]> insertions = new ArrayList<>(insertionsNumber);
        for (int i = 0; i < insertionsNumber; i++) {
            String insertionString = br.readLine();
            Integer[] insertion = Arrays.stream(insertionString.split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            insertions.add(insertion);
        }
        return insertions;
    }

    public String evaluateInsertions(List<Integer[]> insertions) {
        // write your code here
    }
}
