package com.laboratoriski.lab2.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="Movies")
public class OMovie {
    @PrimaryKey
    public String imdbID;

    public String Title;

    public String Year;

    public String Poster;

    public String Released;

    public String Plot;

    public Double imdbRating;

    public Double Metascore;

}
