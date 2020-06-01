package com.example.theidlegame.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "research")
public class Research {
    @PrimaryKey
    @NonNull
    public String key1;

    public String research1;

    public String research2;

    public String research3;

    public String research4;

    public String research5;

    public String research6;
}

