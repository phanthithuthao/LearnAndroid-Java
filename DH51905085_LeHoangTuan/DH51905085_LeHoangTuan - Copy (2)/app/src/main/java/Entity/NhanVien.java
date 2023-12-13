package Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;
@Entity(tableName = "nhanvien")
public class NhanVien implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ma")
    private int ma;
    @ColumnInfo(name = "ten")
    private String ten;
    @ColumnInfo(name = "phai")
    private int phai;
    @ColumnInfo(name = "maphong")
    private String MaPhong;

    public NhanVien(int ma, String ten, int phai, String maPhong) {
        this.ma = ma;
        this.ten = ten;
        this.phai = phai;
        MaPhong = maPhong;
    }

    public NhanVien() {
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

    public int getPhai() {
        return phai;
    }

    public void setPhai(int phai) {
        this.phai = phai;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String maPhong) {
        MaPhong = maPhong;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "ma=" + ma +
                ", ten='" + ten + '\'' +
                ", phai=" + phai +
                ", MaPhong='" + MaPhong + '\'' +
                '}';
    }
}
