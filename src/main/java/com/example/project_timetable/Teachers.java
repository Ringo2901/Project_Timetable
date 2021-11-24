package com.example.project_timetable;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Класс работы с информацией о преподавателях
 * @author Baran Igor
 * @version 1.0
 */
public class Teachers {
    /**
     * filePath - путь к файлу, в котором хранится информация о преподавателях
     */
    private static String filePath = "src\\main\\resources\\teachers.txt";

    /**
     * Метод добавления информации о преподавателе
     * @param input - введенные данные
     * @throws IOException
     */
    public static void addTeacher(Scanner input) throws IOException {
        // Scanner input = new Scanner (System.in); // Сканнер для ввода в консоль
        String name = "", subject = "", contactInf = "";
        System.out.println("Введите ФИО преподавателя.");
        while(name.isEmpty()) name = input.nextLine();
        System.out.println("Введите предмет.");
        while(subject.isEmpty())subject = input.nextLine();
        System.out.println("Введите информацию о преподавателе.");
        while(contactInf.isEmpty()) contactInf = input.nextLine();

        int num = Teachers.getNum();

        String newTeacher = Integer.toString(num) + "|" + name + "|" + subject + "|" + contactInf;

        SecondaryFunctions.rewrite(filePath, num, newTeacher); // перезапись файла

        //input.close();
    }
    /**
     * Метод вычисляет номер строки, в которую будут записываться данные
     * @return idx номер  следующей строки
     * @throws IOException
     */
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
    /**
     * Метод выводит данные о преподавателях
     * @throws IOException
     */
    public static void output() throws IOException {
        Scanner output = new Scanner (new File(filePath));
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


            int  NumLen = 3, NameLen = 10, subjectLen = 12;
            for(int i = 0; i < NumLen - itemNum.length(); i++) {System.out.print(" ");}
            System.out.print(itemNum + ".");
            for(int i = 0; i < NameLen - Name.length(); i++) {System.out.print(" ");}
            System.out.print(Name);
            for(int i = 0; i < NameLen - Name.length(); i++) {System.out.print(" ");}
            System.out.print(subject);
            for(int i = 0; i < subjectLen - subject.length(); i++) {System.out.print(" ");}
            System.out.print(contactInf);
            System.out.println();
        }
        output.close();
    }
}