package com.example.appjogos.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.appjogos.data.GameDAO;
import com.example.appjogos.model.Game;

@Database(entities = {Game.class}, version = 1)
public abstract class GameRoomDatabase extends RoomDatabase {

    private static volatile GameRoomDatabase INSTANCE;

    public static GameRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (GameRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),GameRoomDatabase.class,"game_database").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract GameDAO gameDAO();
}
