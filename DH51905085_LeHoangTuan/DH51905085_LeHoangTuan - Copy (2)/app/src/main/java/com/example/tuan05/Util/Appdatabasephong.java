package com.example.tuan05.Util;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.tuan05.Dao.DaoPhong;


import Entity.Phong;

@Database(entities = {Phong.class},version = 1,exportSchema = false)
public abstract class Appdatabasephong extends RoomDatabase {
    private static Appdatabasephong INSTANCE;
    public abstract DaoPhong daoPhong();


    public static Appdatabasephong getAppDatabase(Context context){
        if(INSTANCE==null){
            INSTANCE=
                    Room.databaseBuilder(context.getApplicationContext(),
                                    Appdatabasephong.class,DBUtil.DATABASE_NAME)
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }
    public static void destroyInstance(){
        INSTANCE=null;
    }
}
