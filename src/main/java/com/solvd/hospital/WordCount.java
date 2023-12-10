package com.solvd.hospital;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCount {
    private static final Logger logger = LogManager.getLogger(Hospital.class);

    public static void main(String[] args) throws IOException {
        WordCount wordCount = new WordCount();
        String outputLine;
        String option;
        Scanner in = new Scanner(System.in);
        ArrayList<String> listOfWords = new ArrayList<>();
        File input = new File("src/main/resources/input.txt");
        File output = new File("src/main/resources/output.txt");
        String str = FileUtils.readFileToString(input, "UTF-8");

        str = str.replaceAll("[\\r\\n]+", " ");
        for (String wordSplitWithLine : StringUtils.split(str, "\n")) {
            for (String wordSplitWithSpace : wordSplitWithLine.split(" ")) {
                StringUtils.replace(wordSplitWithSpace.trim(), ".", " ");
                StringUtils.replace(wordSplitWithSpace.trim(), ",", " ");
                listOfWords.add(wordSplitWithSpace.trim());
            }
            do {
                outputLine = wordCount.findTheCountOfTheWord(in, listOfWords);
                FileUtils.writeStringToFile(output, outputLine + "\n", "UTF-8", true);
                logger.info("Do want to continue again ?  Y / N ");
                option = in.next();
            } while (option.equalsIgnoreCase("y"));
            logger.info("The end");
            FileUtils.writeStringToFile(output, "THE END" + "\n", "UTF-8", true);
            in.close();
        }
    }

    public String findTheCountOfTheWord(Scanner in, ArrayList<String> listOfWords) {
        String word;
        int count = 0;
        logger.info("Enter the word find the occurrences:");
        word = in.next();
        for (String output : listOfWords) {
            if (StringUtils.compareIgnoreCase(output.trim(), word) == 0) {
                count++;
            }
        }
        return word + " = " + count;
    }
}
