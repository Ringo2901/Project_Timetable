package com.example.project_timetable;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Teachers {
    private static String filePath = "src\\main\\resources\\teachers.txt";
    private static String NAME,INF, SUBJECT;
    private static int NUM;

    public static void setName(String s){
        NAME = s;
    }
    public static void setInf(String s){
        INF = s;
    }
    public static void setSubject(String s){
        SUBJECT = s;
    }
    public static void setNum(String s){
        NUM = Integer.parseInt(s);
    }
    public static void addTeacher() throws IOException {

        String newTeacher = Integer.toString(NUM) + "|" + NAME + "|" + SUBJECT + "|" + INF;

        SecondaryFunctions.rewrite(filePath, NUM, newTeacher); // перезапись файла

        //input.close();
    }
    private static int getNum() throws IOException {
        Scanner sc = new Scanner(new File(filePath));
        int idx = 1;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.length() == 0) return idx;
            idx++;
        }
        sc.close();
        return idx;
    }
    public static String StringOutput() throws IOException {
        Scanner output = new Scanner (new File(filePath));
        String res = "";
        while(output.hasNextLine()){
            String s = output.nextLine();
            int idx;
            String itemNum ="", Name = "", subject = "", contactInf = "";
            for(idx = 0; idx < s.length() && s.charAt(idx) != '|'; idx++) itemNum += s.charAt(idx);
            idx++;
            for( ; idx < s.length() && s.charAt(idx) != '|'; idx++) Name += s.charAt(idx);
            idx++;
            for( ; idx < s.length() && s.charAt(idx) != '|'; idx++) subject += s.charAt(idx);
            idx++;
            for( ; idx < s.length(); idx++) contactInf += s.charAt(idx);


            int  NumLen = 3, NameLen = 30, subjectLen = 15;
            res += itemNum + ".";
            for(int i = 0; i < NumLen - itemNum.length(); i++) res+=" ";
            res += Name;
            for(int i = 0; i < NameLen - Name.length(); i++) res+=" ";
            res += subject;
            for(int i = 0; i < subjectLen - subject.length(); i++)res+=" ";
            res += contactInf;


            res += "\n";
        }
        output.close();
        return res;
    }


}