package com.example.theidlegame.database;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mining")
public class Mining {

    @PrimaryKey
    @NonNull
    public String key1;

    public String stone;

    public String copper;

    public String iron;

    public String diamond;

    public String titanium;
}
