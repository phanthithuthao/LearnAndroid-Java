package model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class SinhVien implements Serializable {
    public int ma;
    public String ten;
    public  String lop;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
    public SinhVien() {
    }

    public SinhVien(int ma, String ten, String lop) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
    }

    public SinhVien(String ten, String lop) {
        this.ten = ten;
        this.lop = lop;
    }

    @NonNull
    @Override
    public String toString() {
        return ma + " - " + ten + " - " + lop;
    }
}
