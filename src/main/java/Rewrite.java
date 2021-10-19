import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Rewrite
{
    private void Rwrite(String filePath, String oldLine, String newLine) throws IOException {
        // замена определенной строки в текстовом файле на новую
        // пока в общем виде
        Scanner sc = new Scanner(new File(filePath));
        StringBuilder builder = new StringBuilder(); //переменная хранит весь текст
        while (sc.hasNextLine()) {  //запись текста
            builder.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = builder.toString();
        System.out.println("Contents of the file: "+ fileContents); //иллюстративный вывод старого содержания
        sc.close();
        fileContents = fileContents.replaceAll(oldLine, newLine); // замена старой строки на новую
        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("new data: "+ fileContents);//иллюстративный вывод нового содержания
        writer.append(fileContents);//запись в файл нового текста
        writer.flush();
        writer.close();

    }
}
