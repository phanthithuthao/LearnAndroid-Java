package com.example.tuan05.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Entity.NhanVien;
import Entity.Phong;

@Dao
public interface DaoPhong {
    @Query("SELECT * FROM phong")
    List<Phong> getAllPhong();

    @Insert
    void insert(Phong phong);



}


