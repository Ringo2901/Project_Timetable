import java.io.IOException;
import java.util.Scanner;

public class TaskList {
    private static String filePath = "src\\main\\resources\\tasks.txt";
    public static void addTask() throws IOException {
        Scanner input = new Scanner (System.in); // Сканнер для ввода в консоль
        System.out.println("Enter your task");
        String task = input.nextLine();
        System.out.println("Enter the deadline");
        String deadline = input.nextLine();
        int num = TaskList.getNum();

        String newTask = Integer.toString(num) + "|" + deadline + "|" + task;

        Rewriter.rewrite(filePath, num, newTask); // перезапись файла

        input.close();
    }
    private static int getNum() throws IOException {
        return 1;
    }
    public static void deleteTask() throws IOException {
        Scanner input = new Scanner (System.in); // Сканнер для ввода в консоль
        System.out.println("Enter number of the completed task");
        int num = input.nextInt();
        Rewriter.rewrite(filePath, num, "");
        System.out.println("Task deleted");
    }
    public static void output() throws IOException {

    }

}

