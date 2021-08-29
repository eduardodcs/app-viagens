package br.com.appviagens.ui.activity;

import static br.com.appviagens.ui.activity.PacoteActivityConstants.CHAVE_PACOTE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.appviagens.R;
import br.com.appviagens.dao.PacoteDAO;
import br.com.appviagens.model.Pacote;
import br.com.appviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APPBAR);
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
        listaDePacotes.setOnItemClickListener((adapterView, view, posicao, id) -> {
            Pacote pacoteClicado = pacotes.get(posicao);
            vaiParaResumoPacote(pacoteClicado);
        });
    }

    private void vaiParaResumoPacote(Pacote pacoteClicado) {
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteClicado);
        startActivity(intent);
    }
}