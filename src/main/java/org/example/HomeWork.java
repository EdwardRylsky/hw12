package org.example;


import lombok.SneakyThrows;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import java.util.Scanner;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу https://codeforces.com/problemset/problem/1324/C
     */
    @SneakyThrows
    public void frogSteps(InputStream in, OutputStream out) {
        Objects.requireNonNull(in, "Parameter 'in' can't be null");
        Objects.requireNonNull(out, "Parameter 'out' can't be null");

        try (Scanner scanner = new Scanner(in)) {
            int N = new Scanner(scanner.nextLine()).nextInt();

            for (int i = 0; i < N; i++) {
                String line = scanner.nextLine();
                int result = countL(line);
                out.write(Integer.toString(result).getBytes());
                out.write("\r\n".getBytes());
            }
            out.flush();

        }
    }

    private int countL(String line) {
        int maxLSubstringLength = 0;

        String[] split = line.split("R");
        for (String s : split) {
            if (s.length() > maxLSubstringLength) {
                maxLSubstringLength = s.length();
            }
        }

        return maxLSubstringLength + 1;
    }
}