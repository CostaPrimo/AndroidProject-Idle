package com.example.theidlegame.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ResearchDAO {
    @Insert
    void insert(Research research);

    @Update
    void update(Research research);

    @Query("Select research1 FROM research WHERE key1 = 1")
    String getResearch1();

    @Query("Select research2 FROM research WHERE key1 = 1")
    String getResearch2();

    @Query("Select research3 FROM research WHERE key1 = 1")
    String getResearch3();

    @Query("Select research4 FROM research WHERE key1 = 1")
    String getResearch4();

    @Query("Select research5 FROM research WHERE key1 = 1")
    String getResearch5();

    @Query("Select research6 FROM research WHERE key1 = 1")
    String getResearch6();

    @Query("SELECT COUNT(key1) from research")
    int countResearch();

    @Query("Select * FROM research WHERE key1 = 1")
    Research getResearcher();
}
