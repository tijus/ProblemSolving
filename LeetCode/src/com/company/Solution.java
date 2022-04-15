package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static void calculateSumOfDigits(int num) {
        int sumOfDigits = 0;
        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            sumOfDigits += digit;
        }

        System.out.println(sumOfDigits);
    }

    public static void main(String[] args) {
        // System.in and System.out are input and output streams, respectively.
        InputStream inputStream = System.in;

        InputReader in = new InputReader(inputStream);

        // Read the number of test casese.
        int T = in.nextInt();
        while (T-- > 0) {
            // Read the numbers a and b.
            int num = in.nextInt();
            calculateSumOfDigits(num);
            // Compute the sum of a and b.
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}