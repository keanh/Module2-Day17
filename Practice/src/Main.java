import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    static void copyFileUsingJava7Files(File source,File dest) throws Exception{
        Files.copy(source.toPath(),dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    static void copyFileUsingStream(File source, File dest) throws Exception{
        InputStream is = new FileInputStream(source);
        OutputStream os = new FileOutputStream(dest);
        try{
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0){
                os.write(buffer,0,length);
            }
        }finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter source file");
        String sourcePath = scanner.nextLine();
        System.out.println("Enter destination file");
        String destinationPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);

        try{
            copyFileUsingJava7Files(sourceFile,destinationFile);
            System.out.println("Copy completed");
        }catch (Exception e){
            System.out.println("Can't copy that file");
            System.out.println(e.getMessage());
        }
    }
}
