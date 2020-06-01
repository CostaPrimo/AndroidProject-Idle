package com.example.theidlegame.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface GatheringDAO {

    @Insert
    void insert(Gathering gathering);

    @Update
    void update(Gathering gathering);

    @Query("Select grass FROM gathering WHERE key1 = 1")
    String getGrass();

    @Query("Select wood FROM gathering WHERE key1 = 1")
    String getWood();

    @Query("Select water FROM gathering WHERE key1 = 1")
    String getWater();

    @Query("SELECT COUNT(key1) from gathering")
    int counGathers();

    @Query("Select * FROM gathering WHERE key1 = 1")
    Gathering getGatherer();
}
