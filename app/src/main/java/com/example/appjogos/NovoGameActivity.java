package com.example.appjogos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.example.appjogos.data.GameRepository;
import com.example.appjogos.data.Repository;
import com.example.appjogos.model.Game;


public class NovoGameActivity extends Activity {

    private EditText editGame, editAno, editPreco, editQtd;
    private Repository repository;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_game);

        editGame = findViewById(R.id.editGame);
        editAno = findViewById(R.id.editAno);
        editPreco = findViewById(R.id.editPreco);
        editQtd = findViewById(R.id.editQtd);
        repository = new Repository(getApplicationContext());
        game = new Game();
    }


    public void salvarGame(View view){
        game.setNome(editGame.getText().toString());
        game.setAno_lancamento(Integer.parseInt(editAno.getText().toString()));
        game.setPreco(Integer.parseInt(editPreco.getText().toString()));
        game.setQtd(Integer.parseInt(editQtd.getText().toString()));
        repository.getGameRepository().insert(game);
        callHomeActivity();
    }

    private void callHomeActivity() {
        Intent homeActivity = new Intent(NovoGameActivity.this,HomeActivity.class);
        startActivity(homeActivity);
        finish();
    }
}
