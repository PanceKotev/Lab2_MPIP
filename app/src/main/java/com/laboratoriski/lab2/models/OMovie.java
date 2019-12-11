package com.laboratoriski.lab2.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="Movies")
public class OMovie {
    @PrimaryKey
    @NonNull
    public String imdbID;
    public OMovie(@NonNull String imdbID, String title, String year, String poster, String released, String plot, Double imdbRating, Double metascore) {
        this.imdbID = imdbID;
        Title = title;
        Year = year;
        Poster = poster;
        Released = released;
        Plot = plot;
        this.imdbRating = imdbRating;
        Metascore = metascore;
    }

    public String Title;

    public String Year;

    public String Poster;

    public String Released;

    public String Plot;

    public Double imdbRating;

    public Double Metascore;

}
