package com.example.applistaplanetas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MostrarPlanetas_Activity extends AppCompatActivity {

    TextView txtTitulo,txtAutor,txtTipo;
    ImageView imgCapa;
    RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_planetas_layout);

        txtTitulo = findViewById(R.id.mtxtTitulo);
        imgCapa = findViewById(R.id.mimgCapa);
        txtAutor = findViewById(R.id.mtxtAutor);
        txtTipo = findViewById(R.id.mtxtTipo);
        rating = findViewById(R.id.mratClass);

        Intent intent = getIntent();

        String TituloLivro = intent.getStringExtra("tituloLivro");
        int capaLivro = intent.getIntExtra("capaLivro",0);
        String autorLivro = intent.getStringExtra("autorLivro");
        String tipoLivro = intent.getStringExtra("tipoLivro");
        Float pontuacao = intent.getFloatExtra("ratingLivro",0);

        txtTitulo.setText(TituloLivro);
        imgCapa.setImageResource(capaLivro);
        txtAutor.setText(autorLivro);
        txtTipo.setText(tipoLivro);
        rating.setRating(pontuacao);
    }
}
