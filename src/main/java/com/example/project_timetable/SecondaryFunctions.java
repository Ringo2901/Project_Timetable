package com.example.project_timetable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * SecondaryFunctions class of secondary functions (rewriting)
 */
public class SecondaryFunctions
{
    /**
     * rewrite the method of rewriting information in a file
     * @param filePath - path to the file where the input data is written
     * @param idx the number of rewrited line
     * @param newLine the new line
     */
    public static void rewrite(String filePath, int idx, String newLine) throws IOException {
        Scanner sc = new Scanner(new File(filePath));
        StringBuilder builder = new StringBuilder(); //переменная хранящая весь текст
        String oldLine = "";
        int i = 0;
        while (sc.hasNextLine()) {  //запись текста
            i++;
            String s = sc.nextLine();
            if(idx == i)  builder.append(newLine + System.lineSeparator()); // замена необходимой строки
            else builder.append(s + System.lineSeparator());
        }
        sc.close();
        if(idx > i){
            for(int j = i; j < idx - 1; j++) {builder.append(System.lineSeparator());} // добавление пустых срок
            builder.append(newLine + System.lineSeparator());// добавление нового пункта
        }
        String fileContents = builder.toString();

        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
        }
        finally {
            // блок кода, который должен быть выполнен после завершения блока try
        }
        //System.out.println("new data: "+ fileContents);//иллюстративный вывод нового содержания
        writer.append(fileContents);//запись в файл нового текста
        writer.flush();
        writer.close();

    }
}