package com.example.appjogos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appjogos.data.GameAdapter;
import com.example.appjogos.data.GameDAO;
import com.example.appjogos.data.GameRepository;
import com.example.appjogos.model.Game;
import com.example.appjogos.model.User;

import java.util.List;

public class HomeActivity extends Activity implements AdapterView.OnItemClickListener{

    private ListView listaGames;
    private GameRepository repository;
    ArrayAdapter<Game> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listaGames = findViewById(R.id.listaGames);
        repository = new GameRepository(getApplicationContext());
        atualizarGames();
        listaGames.setOnItemClickListener(this);
    }

    public void novoGame(View view){
        Intent novoGame = new Intent(HomeActivity.this,NovoGameActivity.class);
        startActivity(novoGame);
    }

    private void atualizarGames(){
        List<Game> games = repository.getAllGames();
        adapter = new GameAdapter(getApplicationContext(), R.layout.game_item, games);
        listaGames.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final Game game = (Game) adapterView.getItemAtPosition(i);
        AlertDialog.Builder dialog = new AlertDialog.Builder(HomeActivity.this);
        dialog.setTitle("O que fazer com " + game.getNome()).setItems(R.array.opcoes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if(which == 0) {
                    repository.delete(game.getId());
                    atualizarGames();
                }
                else if(which == 1){
                    callActivity(game.getId());
                }

            }
        }).create().show();
    }

    private void callActivity(Long id) {
        Intent atualizar = new Intent(HomeActivity.this,AtualizarGameActivity.class);
        atualizar.putExtra("ID",id);
        startActivity(atualizar);
    }
    
}
