import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.*;

public class main {

    public static void main(String[] args) throws IOException {
        //boolean firstRun = false;
        FileReader in = null;   //классы, хранящие инфу о том в какие файлы осуществляется ввод/вывод
        FileReader out = null;

        File fileTimetable = new File("src\\main\\resources\\timetable.txt"), // файлы в которых хранятся данные
                fileMarks = new File("src\\main\\resources\\marks.txt"),
                fileTeachers = new File("src\\main\\resources\\teachers.txt");

        int functionNumber;    // номер выбранной команды
        Scanner input = new Scanner (System.in); // Сканнер для ввода в консоль
        System.out.println("Enter text");// вывод начального текста(можно также сделать из файла)

        functionNumber = input.nextInt(); // ввод номера функции

        Choosing choosing = new Choosing();
        String r = choosing.cin (functionNumber);

        System.out.println(r);



    }


}