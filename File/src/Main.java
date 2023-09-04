import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Класс, представляющий файл
class File {
    private String fileName;
    private String fileExtension;
    private String fileContent;

    public File(String fileName, String fileExtension, String fileContent) {
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.fileContent = fileContent;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public String getFileContent() {
        return fileContent;
    }

    @Override
    public String toString() {
        return fileName + "." + fileExtension;
    }
}

// Класс, представляющий папку
class Folder implements Iterable<File> {
    private String folderName;
    private String ownerName;
    private List<File> files = new ArrayList<>();

    public Folder(String folderName, String ownerName) {
        this.folderName = folderName;
        this.ownerName = ownerName;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public String getFolderName() {
        return folderName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public Iterator<File> iterator() {
        return files.iterator();
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем файлы
        File file1 = new File("document1", "txt", "Содержимое документа 1");
        File file2 = new File("image1", "jpg", "Содержимое изображения 1");
        File file3 = new File("document2", "doc", "Содержимое документа 2");

        // Создаем папку и добавляем файлы в нее
        Folder folder = new Folder("Моя папка", "John Doe");
        folder.addFile(file1);
        folder.addFile(file2);
        folder.addFile(file3);

        // Итерируемся по файлам в папке и выводим их имена
        System.out.println("Файлы в папке \"" + folder.getFolderName() + "\":");
        for (File file : folder) {
            System.out.println(file);
        }
    }
}
