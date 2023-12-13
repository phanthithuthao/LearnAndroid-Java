package Model;

import androidx.annotation.NonNull;

public class AnhEm {
    public String ten;
    public int tuoi;

    public AnhEm() {
    }

    public AnhEm(String ten, int tuoi) {
        this.ten = ten;
        this.tuoi = tuoi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @NonNull
    @Override
    public String toString() {
        return ten + " - " + tuoi;
    }
}
