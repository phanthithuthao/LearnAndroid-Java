package model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    public int ma;
    public String ten;

    public SinhVien() {

    }

    public SinhVien(int ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

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

    @Override
    public String toString() {
        return ma + " - " + ten;
    }
}
