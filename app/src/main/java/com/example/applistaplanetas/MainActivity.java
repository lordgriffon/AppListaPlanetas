package com.example.applistaplanetas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import static com.example.applistaplanetas.R.layout.modelo_lista_planetas;

public class MainActivity extends AppCompatActivity {

    ListView ListarLivros;

    String[] nomeLivro = {"Olho do Mundo",
            "Anjos e Demonios",
            "O Cortiço",
            "Diario do Chaves",
            "Dracula","Duna",
            "Entrevista com Vampiro",
            "Um Estudo em Vermelho",
            "As Florestas do Silencio",
            "Fogo e Sangue",
            "Harry Potter",
            "Aprendizagem Baseada em Jogos Digitais",
            "As Mentiras de Locke Lamora",
            "Mau começo", "Pipeline da Liderança",
            "Prince of Thorns",
            "O Principe",
            "Principe de Westeros",
            "Silmarillion",
            "Transformando Suor em Ouro"};
    int[] capaLivro = {R.drawable.olhodomundo,
            R.drawable.anjos,R.drawable.cortico,R.drawable.diario,R.drawable.dracula,R.drawable.duna,R.drawable.entrevista,
            R.drawable.estudo,R.drawable.florestas,R.drawable.fogoesangue,R.drawable.harry,R.drawable.jogos,R.drawable.lamora,R.drawable.maucomeco,
            R.drawable.pipeline,R.drawable.prince,R.drawable.principe,R.drawable.rogue,R.drawable.silmarillion,R.drawable.transformando};
    String[] tipoLivro = {"Fantasia", "Policial","Romance","Comedia","Terror","Ficção Cientifica","Terror","Policial",
            "Fantasia","Fantasia","Aventura","Aprendizagem","Fantasia","Aventura","Liderança","Fantasia",
            "Administração","Fantasia","Fantasia","Liderança"};
    String[] autorLivro = {"Robert Jordan", "Dan Brown","Aluísio Azevedo","Roberto Gomes Bolaños","Bran Stoker","Frank Herbert","Anne Rice","Arthur Conan Doyle",
            "Emily Rodda","George R R Martin","J.K Rowling","Mark Prensky","Scott Lycnh","Lemony Snicket","Ram Charam","Mark Lawrence",
            "Nicolau Maquiavel","Gardner Dozois","JRR Tolkien","Bernardinho"};
    float[] ratingLivro = {4.5f, 4f,4f,4.5f,3.8f,3.5f,4f,4,5f,3f,4f,3.5f,3f,4f,2.5f,5f,3.5f,4f,3.5f,5f,4f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListarLivros = findViewById(R.id.listarPlanetas);

        CustomAdapter adapter = new CustomAdapter();

        ListarLivros.setAdapter(adapter);

        ListarLivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MostrarPlanetas_Activity.class);

                intent.putExtra("tituloLivro", nomeLivro[position]);
                intent.putExtra("capaLivro", capaLivro[position]);
                intent.putExtra("tipoLivro", tipoLivro[position]);
                intent.putExtra("autorLivro", autorLivro[position]);
                intent.putExtra("ratingLivro", ratingLivro[position]);


                startActivity(intent);

            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return capaLivro.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView txtNomeLivro, txtTipoLivro, txtAutoLivro;
            ImageView imgCapaLivro;
            RatingBar ratLivro;

            View carregaView = getLayoutInflater().inflate(modelo_lista_planetas, null);

            txtNomeLivro = carregaView.findViewById(R.id.txtListaTitulo);
            txtTipoLivro = carregaView.findViewById(R.id.txtListaCategoria);
            txtAutoLivro = carregaView.findViewById(R.id.txtListaAutor);

            imgCapaLivro = carregaView.findViewById(R.id.imgListaCapa);
            ratLivro = carregaView.findViewById(R.id.ratListaPontuacao);

            txtNomeLivro.setText(nomeLivro[position]);
            txtTipoLivro.setText(tipoLivro[position]);
            txtAutoLivro.setText(autorLivro[position]);
            imgCapaLivro.setImageResource(capaLivro[position]);
            ratLivro.setRating(ratingLivro[position]);


            return carregaView;
        }
    }
}
