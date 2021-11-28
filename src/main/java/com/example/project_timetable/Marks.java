package com.example.project_timetable;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class works with Marks
 * @author Igor Baran
 * @version 3.0
 *
 */
public class Marks {
    /**
     * filePath - path to the file where the input data is written
     */
    private static String filePath = "src\\main\\resources\\marks.txt";
    /**
     * SUBJECT - the line where the subject is written,
     * MARKS - the line where the marks are written
     */
    private static String SUBJECT, MARKS;

    /**
     * The method assigns the entered subject to the string
     * @param s a string that accepts the entered value
     */
    public static void setSubject(String s){
        SUBJECT = s;
    }

    /**
     * The method assigns the entered marks to the string
     * @param s a string that accepts the entered value
     */
    public static void setMarks(String s){
        MARKS = s;
    }

    /**
     * The method reads information from a file, calculates a newline number, writes a newline in the format "num|subject|AverajeMark|marks"
     */
    public static void addMarks() throws IOException {
        int idx, num = 1;
        String itemNum = "", sub = "";
        Scanner sc = new Scanner(new File(filePath));
        boolean newLine = true;
        String s = "";
        while (sc.hasNextLine() && newLine) {
            s = sc.nextLine();
            for(idx = 0; idx < s.length() && s.charAt(idx) != '|'; idx++) itemNum += s.charAt(idx);
            idx++;
            for( ; idx < s.length() && s.charAt(idx) != '|'; idx++) sub += s.charAt(idx);
            if (sub.equals(SUBJECT)) {System.out.println("equal"); newLine = false;}
            else num++;
            sub = "";
        }
        sc.close();

        String newMarks = "";
        if(newLine) newMarks = num + "|" + SUBJECT + "|" + Float.toString(averageMark(num)) + "|" + MARKS;
        else newMarks = s + " " + MARKS;

        SecondaryFunctions.rewrite(filePath, num, newMarks); // перезапись файла
    }

    /**
     * The method calculates the average score for the selected subject
     * @param numOfSubject the number of the subject, the average mark for which you want to calculate
     * @return res an average mark
     */
    public static float averageMark(int numOfSubject) throws IOException {
        /*Scanner Marks = new Scanner(new File(filePath));
        float average = 0;
        while (Marks.hasNextLine()) {

            String s = Marks.nextLine();
            int idx;
            String itemNum = "", subject = "", marksLine = "";
            for (idx = 0; idx < s.length() && s.charAt(idx) != '|'; idx++) itemNum += s.charAt(idx);
            idx++;
            for (; idx < s.length() && s.charAt(idx) != '|'; idx++) subject += s.charAt(idx);
            idx++;
            for (; idx < s.length(); idx++) marksLine += s.charAt(idx);
            /*int Sum = 0;
            int N = 0;
            String[] marks = marksLine.split(" ");
            for (String mark : marks) {
                Sum += Integer.valueOf(mark);
                N++;
                res = (float) Sum / N;
            }*/
            /*if (Integer.valueOf(itemNum) == numOfSubject) {
                int Sum = 0;
                int N = 0;
                String[] marks = marksLine.split(" ");
                for (String mark : marks) {
                    Sum += Integer.valueOf(mark);
                    N++;
                    average = (float) Sum / N;
                }
            }
        }*/
        float res = 10;
        return res;
        //return average;
    }


    /**
     * The method reads information from a file, generates lines for output, outputs lines in format "Num.Subject Average Marks"
     * @return res marks output string
     */
    public static String StringOutput() throws IOException {
        Scanner output = new Scanner (new File(filePath));
        String res = "";
        while(output.hasNextLine()){
            String s = output.nextLine();
            int idx;
            String itemNum ="", subject = "", average = "", marks = "";
            for(idx = 0; idx < s.length() && s.charAt(idx) != '|'; idx++) itemNum += s.charAt(idx);
            idx++;
            for( ; idx < s.length() && s.charAt(idx) != '|'; idx++) subject += s.charAt(idx);
            idx++;
            for( ; idx < s.length() && s.charAt(idx) != '|'; idx++) average += s.charAt(idx);
            idx++;
            for( ; idx < s.length(); idx++) marks += s.charAt(idx);

            int  NumLen = 3, subjectLen = 15, averageLen = 10;
            String point = "";
            if(idx > 3) point = ".";
            res += itemNum + point;
            for(int i = 0; i < NumLen - itemNum.length(); i++) res+=" ";
            res += subject + ":";
            for(int i = 0; i < subjectLen - subject.length(); i++) res+=" ";
            res += average;
            for(int i = 0; i < averageLen - average.length(); i++) res+=" ";
            res += marks;
            res += "\n";
        }
        output.close();
        return res;
    }
    /**
     * The method delete selected line
     * @param num the number of deleted line
     */
    public static void deleteMarks(int num) throws IOException {
        SecondaryFunctions.rewrite(filePath, num, "");
    }

}

