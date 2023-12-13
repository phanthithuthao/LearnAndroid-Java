package com.example.tuan05.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Entity.NhanVien;
@Dao
public interface DaoNhanVien {
    @Query("SELECT * FROM nhanvien")
    List<NhanVien> getAll();

    @Delete
    int delete(NhanVien nhanVien);

    @Insert
    void insert(NhanVien nhanVien);

    @Update
    int Update(NhanVien nhanVien);


}
