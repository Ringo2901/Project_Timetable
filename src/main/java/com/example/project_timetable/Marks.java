package com.example.project_timetable;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Marks {
    private static String filePath = "src\\main\\resources\\marks.txt";
    public static void addMark() throws IOException {
        Scanner input = new Scanner (System.in); // Сканнер для ввода в консоль
        System.out.println("Enter the subject");
        String subject = input.nextLine();
        System.out.println("Enter your marks");
        String marksLine = input.nextLine();
        int num = Marks.getNum();

        // String newMark = Integer.toString(num) + "|" + deadline +  + task;

        SecondaryFunctions.rewrite(filePath, num, ""); // перезапись файла

        input.close();
    }
    private static int getNum() throws IOException {
        return 1;
    }
    /*private static ArrayList<Integer> getMarks(){
        Scanner input = new Scanner (filePath);
        String marksLine = input.nextLine();
        ArrayList<Integer> marksList = new ArrayList<>();
        int n = 0;
        for(int i = 0, j = 0; i < marksLine.length();i++) {
            if(marksLine.charAt(i) != ' ') n = n * 10 + Character.getNumericValue(marksLine.charAt(i));
            else marksList.add(n);
        }
        marksList.add(n);
        input.close();
        return marksList;
    }*/
    /*public static float averageScore() throws IOException {

    }*/
    public static void output() throws IOException {
    }
}
