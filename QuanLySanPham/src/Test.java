import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        while (number != 0) {
            menu();
            number = scanner.nextInt();
            File file = new File("D:\\Module 2\\Day 17\\QuanLySanPham\\ProductList");
            OutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            switch (number) {
                case 1:
                    ArrayList<SanPham> list = new ArrayList<>();
                    SanPham sanPham = new SanPham();
                    System.out.println("Nhập ID");
                    int ID = scanner.nextInt();
                    scanner.nextLine();
                    sanPham.setID(ID);

                    System.out.println("Nhập tên sản phẩm");
                    String name = scanner.nextLine();
                    sanPham.setName(name);

                    System.out.println("Nhập tên hãng");
                    String brandName = scanner.nextLine();
                    sanPham.setBrandName(brandName);

                    System.out.println("Nhập giá tiền");
                    Long price = Long.parseLong(scanner.nextLine());
                    sanPham.setPrice(price);

                    list.add(sanPham);

                    for (SanPham sanPham1: list) {
                        objectOutputStream.writeObject(sanPham1);
                    }
                    objectOutputStream.flush();
                    break;
                case 2:
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream
                            ("D:\\Module 2\\Day 17\\QuanLySanPham\\ProductList"));
                    SanPham sanPhamRead = (SanPham) objectInputStream.readObject();
                    objectInputStream.close();
                    System.out.println("ID: " + sanPhamRead.getID());
                    System.out.println("Tên sản phẩm: " + sanPhamRead.getName());
                    System.out.println("Tên hãng sản phẩm: " + sanPhamRead.getBrandName());
                    System.out.println("Giá sản phẩm: " + sanPhamRead.getPrice());
                    break;
                case 4:
                    System.exit(4);
                    objectOutputStream.close();
            }
        }
    }
    public static void menu(){
        System.out.println("Menu");
        System.out.println("1.Thêm sản phẩm");
        System.out.println("2.Hiển thị sản phẩm");
        System.out.println("3.Tìm sản phẩm theo tên");
        System.out.println("4.Thoát");
    }
}
