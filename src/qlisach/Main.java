package qlisach;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> ds = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Xóa sách");
            System.out.println("3. Sửa sách");
            System.out.println("4. Xuất danh sách");
            System.out.println("5. Tìm sách chứa 'Lập trình'");
            System.out.println("6. Lấy tối đa K sách có giá <= P");
            System.out.println("7. Tìm sách theo tác giả");
            System.out.println("0. Thoát");

            int chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1: themSach(); break;
                case 2: xoaSach(); break;
                case 3: suaSach(); break;
                case 4: xuatSach(); break;
                case 5: timLapTrinh(); break;
                case 6: timTheoGia(); break;
                case 7: timTheoTacGia(); break;
                case 0: return;
            }
        }
    }

    static void themSach() {
        System.out.print("Mã sách: ");
        int ma = sc.nextInt(); sc.nextLine();

        System.out.print("Tên sách: ");
        String ten = sc.nextLine();

        System.out.print("Tác giả: ");
        String tg = sc.nextLine();

        System.out.print("Đơn giá: ");
        double gia = sc.nextDouble();

        ds.add(new Book(ma, ten, tg, gia));
    }

    static void xoaSach() {
        System.out.print("Nhập mã sách cần xóa: ");
        int ma = sc.nextInt();

        ds.removeIf(s -> s.maSach == ma);
    }

    static void suaSach() {
        System.out.print("Nhập mã sách cần sửa: ");
        int ma = sc.nextInt();
        sc.nextLine();

        for (Book b : ds) {
            if (b.maSach == ma) {
                System.out.print("Tên mới: ");
                b.tenSach = sc.nextLine();

                System.out.print("Tác giả mới: ");
                b.tacGia = sc.nextLine();

                System.out.print("Giá mới: ");
                b.donGia = sc.nextDouble();
            }
        }
    }

    static void xuatSach() {
        for (Book b : ds) {
            b.hienThi();
        }
    }

    static void timLapTrinh() {
        for (Book b : ds) {
            if (b.tenSach.toLowerCase().contains("lap trinh")) {
                b.hienThi();
            }
        }
    }

    static void timTheoGia() {
        System.out.print("Nhập K: ");
        int k = sc.nextInt();

        System.out.print("Nhập giá P: ");
        double p = sc.nextDouble();

        int count = 0;

        for (Book b : ds) {
            if (b.donGia <= p && count < k) {
                b.hienThi();
                count++;
            }
        }
    }

    static void timTheoTacGia() {
        sc.nextLine();
        System.out.print("Nhập tên tác giả: ");
        String tg = sc.nextLine();

        for (Book b : ds) {
            if (b.tacGia.equalsIgnoreCase(tg)) {
                b.hienThi();
            }
        }
    }
}