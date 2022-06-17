package com.example.demoweb1706;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {
    private Connection conn;

    public ArtistDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Artist> findAll() {
        List<Artist> artists = new ArrayList<>();
        try (Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from artist");
            while (resultSet.next()) {
                artists.add(new Artist(resultSet.getInt(1), resultSet.getString(2)));
            }
            return artists;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
