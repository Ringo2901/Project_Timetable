import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Timetable {
    private static File fileTimetable = new File("src\\main\\resources\\timetable.txt");
    public static void changeTimetableItem() throws IOException {

        Scanner input = new Scanner (System.in); // Сканнер для ввода в консоль
        /*System.out.println("Enter number of day");
        int dayNum = input.nextInt();*/

        System.out.println("Enter number of item");
        int itemNum = input.nextInt();

        String lessonName = "";
        String teacherName = "";
        System.out.println("Enter lesson name");
        while(lessonName.isEmpty()) lessonName = input.nextLine(); //ожидание ввода названия предмета
        System.out.println("Enter teacher surname");
        while(teacherName.isEmpty()) teacherName = input.nextLine(); //ожидание ввода фамилии преподаватель



        String newItem = Integer.toString(itemNum) + "|" + lessonName + "|" + teacherName;
        Rewriter.rewrite(fileTimetable.getPath(), itemNum, newItem); // перезапись файла

        input.close();
    }
    public static void output() throws IOException {
    }

}