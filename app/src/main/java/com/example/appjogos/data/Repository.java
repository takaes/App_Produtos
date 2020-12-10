package com.example.appjogos.data;

import android.content.Context;

public class Repository {
    private GameRepository gameRepository;

    public Repository(Context context){
        gameRepository = new GameRepository(context);
    }

    public GameRepository getGameRepository() {
        return gameRepository;
    }

}
