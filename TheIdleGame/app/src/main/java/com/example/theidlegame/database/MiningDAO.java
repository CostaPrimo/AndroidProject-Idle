package com.example.theidlegame.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MiningDAO {
    @Insert
    void insert(Mining mining);

    @Update
    void update(Mining mining);

    @Query("Select stone FROM mining WHERE key1 = 1")
    String getStone();

    @Query("Select copper FROM mining WHERE key1 = 1")
    String getcopper();

    @Query("Select iron FROM mining WHERE key1 = 1")
    String getIron();

    @Query("Select diamond FROM mining WHERE key1 = 1")
    String getDiamond();

    @Query("Select titanium FROM mining WHERE key1 = 1")
    String getTitanium();


    @Query("SELECT COUNT(key1) from mining")
    int countMiners();

    @Query("Select * FROM mining WHERE key1 = 1")
    Mining getMiner();
}
