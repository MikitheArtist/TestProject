package logic;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import static logic.ExpressionAnalyze.*;

public class Main {
    public static final String FILE_PATH_FOR_RESULT = "src/main/resources/textResult.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String expressionText = scanner.nextLine();

        List<Lexeme> lexemes = lexAnalyze(expressionText);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        String result = String.valueOf(expr(lexemeBuffer));
        String countOfNumberText = "Number of digits in expression: " + String.valueOf(counterOfNumber);

        File file = new File(FILE_PATH_FOR_RESULT);

        try {
            PrintWriter printWriter =
                    new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            printWriter.println(expressionText);
            printWriter.println(countOfNumberText);
            printWriter.println(result);
            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
