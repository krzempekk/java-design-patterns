package decorator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDataSource implements DataSource {
    private String filename;

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    public void writeData(String data) {
        try {
            File file = new File(this.filename);
            file.createNewFile();

            FileWriter writer = new FileWriter(this.filename);
            writer.write(data);
            writer.close();
        } catch (IOException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
    }

    public String readData() {
        String data = new String();
        try {
            File file = new File(this.filename);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                data = data + reader.nextLine();
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            ex.printStackTrace();
        }

        return data;
    }
}
