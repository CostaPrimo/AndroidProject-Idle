package com.example.theidlegame.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "gathering")
public class Gathering {

    @PrimaryKey
    @NonNull
    public String key1;

    public String grass;

    public String wood;

    public String water;

}
