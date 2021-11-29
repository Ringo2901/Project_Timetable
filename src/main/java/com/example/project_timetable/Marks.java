package com.example.project_timetable;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

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

    private static boolean CORRECTNESS;
    private static int NUM;
    public static void setNum(String s) throws IOException {
        if(SecondaryFunctions.isDigit(s)){
            NUM = Integer.parseInt(s);
            if(NUM <= SecondaryFunctions.getNum(filePath)) CORRECTNESS = true;
            else CORRECTNESS = false;
        }
        else CORRECTNESS = false;

    }
    public static boolean isCorrect(){
        return CORRECTNESS;
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
            if (sub.equals(SUBJECT)) {; newLine = false;}
            else num++;
            sub = "";
        }
        sc.close();

        String newMarks = "";
        if(newLine) newMarks = NUM + "|" + SUBJECT + "|" + MARKS;
        else {
            newMarks = s + " " + MARKS;
        }

        SecondaryFunctions.rewrite(filePath, num, newMarks); // перезапись файла
    }

    /**
     * The method calculates the average score for the selected subject
     * @param numOfSubject the number of the subject, the average mark for which you want to calculate
     * @return res an average mark
     */
    private static float averageMark(int numOfSubject) throws IOException {
        Scanner Marks = new Scanner(new File(filePath));
        float res = 0;
        String s = "";
        int j = 0;
        while (Marks.hasNextLine() && j != numOfSubject) {

            s = Marks.nextLine();
            j++;

        }
        int idx;
        String itemNum = "", subject = "", marksLine = "", average = "";
        for (idx = 0; idx < s.length() && s.charAt(idx) != '|'; idx++) itemNum += s.charAt(idx);
        idx++;
        for (; idx < s.length() && s.charAt(idx) != '|'; idx++) subject += s.charAt(idx);
        idx++;
            /*for( ; idx < s.length() && s.charAt(idx) != '|'; idx++) average += s.charAt(idx);
            idx++;*/
        for (; idx < s.length(); idx++) marksLine += s.charAt(idx);
        int Sum = 0;
        int N = 0;
        int x = 0;
        for(int i = 0; i < marksLine.length(); i++){
            if(marksLine.charAt(i) >= '0' && marksLine.charAt(i) <= '9') x = x*10 + marksLine.charAt(i) - '0';
            else {
                Sum += x;
                N++;
                x = 0;
            }
        }
        Sum += x;
        N++;
        res = (float) Sum / N;
        return res;

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
            DecimalFormat df = new DecimalFormat("###.##");
            String avMark = df.format(averageMark(Integer.parseInt(itemNum)));
            average = avMark;
            idx++;
            for( ; idx < s.length(); idx++) marks += s.charAt(idx);

            int  NumLen = 3, subjectLen = 15, averageLen = 10;
            String point = "", d = "";
            if(idx > 3) {
                point = ".";
                d = ":";
            }
            res += itemNum + point;
            for(int i = 0; i < NumLen - itemNum.length(); i++) res+=" ";
            res += subject + d;
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

