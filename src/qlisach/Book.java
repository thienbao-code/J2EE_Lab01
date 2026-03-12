package qlisach;



public class Book {
    int maSach;
    String tenSach;
    String tacGia;
    double donGia;

    public Book(int maSach, String tenSach, String tacGia, double donGia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.donGia = donGia;
    }

    public void hienThi() {
        System.out.println(maSach + " | " + tenSach + " | " + tacGia + " | " + donGia);
    }
}