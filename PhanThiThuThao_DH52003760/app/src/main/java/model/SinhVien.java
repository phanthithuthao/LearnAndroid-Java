package model;

import java.util.Date;

public class SinhVien {
    private String ten;
    private Date ngaySinh;
    private boolean an;
    private boolean ngu;

    public SinhVien() {

    }

    public SinhVien(String ten, Date ngaySinh, boolean an, boolean ngu) {
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.an = an;
        this.ngu = ngu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isAn() {
        return an;
    }

    public void setAn(boolean an) {
        this.an = an;
    }

    public boolean isNgu() {
        return ngu;
    }

    public void setNgu(boolean ngu) {
        this.ngu = ngu;
    }

    @Override
    public String toString() {
        return ten + " - " + ngaySinh + " - "+an + " - " + ngu;
    }
}
