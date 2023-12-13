package Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "phong"  )
public class Phong implements Serializable {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="ma")
    private String ma;

    @ColumnInfo(name = "ten")
    private String ten;

    public Phong(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public Phong() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
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
        return "Phong{" +
                ", ten='" + ten + '\'' +
                '}';
    }
}
