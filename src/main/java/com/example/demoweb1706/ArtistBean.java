package com.example.demoweb1706;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ArtistBean {
    private List<Artist> artists;

    private Artist current = new Artist(0,"");

    public ArtistBean() {
        artists = new ArrayList<>(List.of(
            new Artist(1, "Ivan"),
            new Artist(2, "Oksana"),
            new Artist(3, "Ostap"),
            new Artist(4, "Petro"),
            new Artist(5, "Maria"),
            new Artist(6, "Ivanka")
        ));
    }
}
