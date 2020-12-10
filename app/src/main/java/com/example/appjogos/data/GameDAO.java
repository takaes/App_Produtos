package com.example.appjogos.data;

import androidx.room.Dao;
import androidx.room.Embedded;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

import com.example.appjogos.model.Game;

@Dao
public interface GameDAO {

    @Insert
    void insert(Game game);

    @Update
    void update(Game game);

    @Query("SELECT * FROM games_table WHERE games_table.ID == :id")
    Game loadGameByID(Long id);

    @Query("DELETE FROM games_table where games_table.ID == :id")
    void delete(long id);

    @Query("SELECT * from games_table ORDER BY preco DESC")
    List<Game> loadGames();

    @Query("SELECT nome from games_table")
    List<String> loadGamesNames();

    class GameJoin {
        @Embedded
        public static Game game;
    }
}
