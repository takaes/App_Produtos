package com.example.appjogos.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;


import java.util.List;

import com.example.appjogos.model.Game;
import com.example.appjogos.R;
import com.example.appjogos.data.GameDAO;

public class GameAdapter extends ArrayAdapter<Game> {
    private int rId;

    public GameAdapter(@NonNull Context context, int resource, @NonNull List<Game> objects) {
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent) {
        View mView = currentView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }

        Game game = getItem(position);

        TextView textNome = mView.findViewById(R.id.textNomeGame);
        TextView textAno = mView.findViewById(R.id.textAnoGame);
        TextView textPreco = mView.findViewById(R.id.textPrecoGame);
        TextView textQtd = mView.findViewById(R.id.textQtdGame);

        textNome.setText(game.getNome().toUpperCase());
        textAno.setText("Ano: " + String.valueOf(game.getAno_lancamento()));
        textPreco.setText("R$: " + String.valueOf(game.getPreco()));
        textQtd.setText("Quantidade disponível: " + String.valueOf(game.getQtd()));

        return mView;

    }

}
