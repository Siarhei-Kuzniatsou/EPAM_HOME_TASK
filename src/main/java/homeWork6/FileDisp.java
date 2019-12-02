package homeWork6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileDisp {
    private static FileDisp fileDisp;
    private File file;
    private static final String nameFile = "Employers.txt";
    TableDisp tableDisp = TableDisp.getInstance();

    public FileDisp() {
        file = new File(nameFile);
//        this.tableDisp = tableDisp;
    }

    public boolean isEmpty() {
        return file.length() == 0;
    }

    public void readFile() {
        List<String> table = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(nameFile))) {
            table = lines.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : table) {
            String[] array = s.split(" ");
            Employer employer = new Employer(Integer.parseInt(array[0]), array[1], array[2]);
            tableDisp.addInTable(employer);
        }
    }

    public void saveFile(List<Employer> table) throws IOException {
        FileWriter file = new FileWriter(nameFile);
        for(int i = 0; i != table.size(); i++) {
            file.write(String.valueOf(table.get(i)));
            file.write("\n");
            }
        file.close();
    }

    public static FileDisp getInstance(){
        if (fileDisp == null) return new FileDisp();
        else return fileDisp;
    }
}
