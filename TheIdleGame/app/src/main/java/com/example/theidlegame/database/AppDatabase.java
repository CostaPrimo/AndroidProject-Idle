package com.example.theidlegame.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Gathering.class, Mining.class, Research.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    public abstract GatheringDAO gatheringDAO();
    public abstract MiningDAO miningDAO();
    public abstract ResearchDAO researchDAO();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "gathering-database").build();
        }
        return INSTANCE;
    }

}
