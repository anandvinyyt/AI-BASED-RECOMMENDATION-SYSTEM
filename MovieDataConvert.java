package com.predictionmarketing.convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MovieDataConvert {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("F:\\Internship2025java\\workspace\\ItemRecommend\\src\\main\\resources\\u.data"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\Internship2025java\\workspace\\ItemRecommend\\src\\main\\resources\\movies.csv"));

        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split("\\t", -1);
            bw.write(values[0] + "," + values[1] + "," + values[2] + "\n");
        }

        br.close();
        bw.close();

    }
}
