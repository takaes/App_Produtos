package com.example.appjogos.data;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import com.example.appjogos.model.Game;

public class GameRepository {

    private GameDAO mGameDAO;
    private List<Game> mGames;
    private List<Game> mGamesJoin;

    public GameRepository(Context context){
        GameRoomDatabase db = GameRoomDatabase.getDatabase(context);
        mGameDAO = db.gameDAO();
    }

    public List<Game> getAllGames(){
        mGames = mGameDAO.loadGames();
        return mGames;
    }

    public List<Game> getAllGamesJoin(){
        mGamesJoin = mGameDAO.loadGames();
        return mGamesJoin;
    }

    public Game loadGameByID(long ID) {
        return mGameDAO.loadGameByID(ID);
    }

    public void insert(Game game){
        new insertAsyncTask(mGameDAO).execute(game);
    }
    public void delete(long id){mGameDAO.delete(id);}
    public void update(Game game) {mGameDAO.update(game);}

    private static class insertAsyncTask extends AsyncTask<Game,Void,Void>{

        private GameDAO mAsyncTaskDAO;

        insertAsyncTask(GameDAO dao){
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Game... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }

}
