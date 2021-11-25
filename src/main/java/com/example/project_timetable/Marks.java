package com.example.project_timetable;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Marks {
    private static String filePath = "src\\main\\resources\\marks.txt";
    private static String SUBJECT, MARKS;
    public static void setSubject(String s){
        SUBJECT = s;
    }
    public static void setMarks(String s){
        MARKS = s;
    }

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
        if(newLine) newMarks = Integer.toString(num) + "|" + SUBJECT + "|" + Float.toString(averageMark(num)) + "|" + MARKS;
        else newMarks = s + " " + MARKS;


        SecondaryFunctions.rewrite(filePath, num, newMarks); // перезапись файла

    }

    public static float averageMark(int numOfSubject) throws IOException {
        float res = 10;
        return res;
    }
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
            res += itemNum + ".";
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
}

