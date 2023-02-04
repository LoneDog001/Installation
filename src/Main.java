import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        addDirectories("D://Games//src//main", sb);
        addDirectories("D://Games//src//test", sb);
        addDirectories("D://Games//res//drawable", sb);
        addDirectories("D://Games//res//vectors", sb);
        addDirectories("D://Games//res//icons", sb);
        addDirectories("D://Games//savegames", sb);
        addDirectories("D://Games//temp", sb);
        addFile("D://Games//src//main//Main.java", sb);
        addFile("D://Games//src//main//Utils.java", sb);
        addFile("D://Games//temp//temp.txt", sb);
        infoWrite("D://Games//temp//temp.txt", sb);
    }

    public static void addDirectories(String path, StringBuilder info) {
        File newDir = new File(path);
        if (newDir.mkdirs()) {
            System.out.println("Папка создана");
            info.append("Папка " + newDir.getName() + " создана в папке D://Games. ");
        } else {
            System.out.println("Папка не создана");
            info.append("Папка " + newDir.getName() + " не создана в папке D://Games. ");
        }

    }

    public static void addFile(String path, StringBuilder info) {
        File newFile = new File(path);
        try {
            if (newFile.createNewFile()) {
                System.out.println("Файл создан");
                info.append("Файл " + newFile.getName() + " создан в папке D://Games. ");
            } else {
                System.out.println("Файл не создан");
                info.append("Файл " + newFile.getName() + " не создан в папке D://Games. ");
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void infoWrite(String path, StringBuilder info) {
        try (FileWriter writer = new FileWriter(path, false)) {
            writer.write(String.valueOf(info));
            writer.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}


