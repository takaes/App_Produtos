package com.example.appjogos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appjogos.data.Repository;
import com.example.appjogos.model.Game;

import java.util.List;

public class AtualizarGameActivity extends Activity {
    private EditText editGame, editAno, editPreco, editQtd;
    private Repository repository;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_game);

        long extra_id = getIntent().getLongExtra("ID",0);
        Toast.makeText(this, "ID = " + extra_id, Toast.LENGTH_SHORT).show();

        editGame = findViewById(R.id.editGame);
        editAno = findViewById(R.id.editAno);
        editPreco = findViewById(R.id.editPreco);
        editQtd = findViewById(R.id.editQtd);
        repository = new Repository(getApplicationContext());
        loadGame(extra_id);
    }

    private void loadGame(long extra_id) {
        game = repository.getGameRepository().loadGameByID(extra_id);
        editAno.setText(String.valueOf(game.getAno_lancamento()));
        editGame.setText(game.getNome());
        editPreco.setText(String.valueOf(game.getPreco()));
        editQtd.setText(String.valueOf(game.getQtd()));

    }

    public void atualizarFilme(View view){
        game.setNome(editGame.getText().toString());
        game.setAno_lancamento(Integer.parseInt(editAno.getText().toString()));
        game.setPreco(Integer.parseInt(editPreco.getText().toString()));
        game.setQtd(Integer.parseInt(editQtd.getText().toString()));
        repository.getGameRepository().update(game);
        callHomeActivity();
    }

    private void callHomeActivity() {
        Intent homeActivity = new Intent(AtualizarGameActivity.this,HomeActivity.class);
        startActivity(homeActivity);
        finish();
    }
}
