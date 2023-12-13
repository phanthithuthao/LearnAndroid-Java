package com.example.tuan05.Util;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tuan05.Dao.DaoPhong;
import com.example.tuan05.Dao.DaoNhanVien;

import Entity.NhanVien;
import Entity.Phong;

@Database(entities = {NhanVien.class},version = 1,exportSchema = false)
public abstract class Appdatabase extends RoomDatabase {
    private static Appdatabase INSTANCE;
    public abstract DaoNhanVien daoNhanVien();
    //public abstract DaoPhong daoPhong();

    public static Appdatabase getAppDatabase(Context context){
        if(INSTANCE==null){
            INSTANCE=
                    Room.databaseBuilder(context.getApplicationContext(),
                                    Appdatabase.class,DBUtil.DATABASE_NAME)
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }
    public static void destroyInstance(){
        INSTANCE=null;
    }
}
