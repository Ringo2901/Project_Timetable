import java.io.IOException;
import java.util.Scanner;

public class Teachers {
    private static String filePath = "src\\main\\resources\\teachers.txt";
    public static void addTeacher() throws IOException {
        Scanner input = new Scanner (System.in); // Сканнер для ввода в консоль
        System.out.println("Enter the teacher's name");
        String name = input.nextLine();
        System.out.println("Enter the subject");
        String subject = input.nextLine();
        System.out.println("Enter the contact information");
        String contactInf = input.nextLine();

        int num = Teachers.getNum();

        String newTeacher = Integer.toString(num) + "|" + name + "|" + subject + "|" + contactInf;

        Rewriter.rewrite(filePath, num, newTeacher); // перезапись файла

        input.close();
    }
    private static int getNum() throws IOException {
        return 1;
    }
    public static void output() throws IOException {
    }
}
