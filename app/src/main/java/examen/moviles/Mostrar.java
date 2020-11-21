package examen.moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import examen.moviles.BDD.AppBaseDato;

public class Mostrar extends AppCompatActivity {

    ListView list_view;
    ArrayAdapter<String> adapter;
    AppBaseDato db;
    Mostrar mostrar = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list_view = findViewById(R.id.list_view);
        list_view.setAdapter(adapter);
        db = AppBaseDato.getInstance(this);
        new guardarDatoss().execute();

    }


    public class guardarDatoss extends AsyncTask<Void, Void, Void> {
        ArrayList<String> listaDatosString = new ArrayList<>();
        List<Datoss> listaDatosDatos = new ArrayList<>();
        protected Void doInBackground(Void... voids){
            Datoss datoss = new Datoss();
            listaDatosDatos = mostrar.db.datosDAO().buscarTodos();
            for(Datoss dato : listaDatosDatos){
                listaDatosString.add(dato.toString());
            }
            System.out.println("ACAAAAAAA "+listaDatosString);
            return null;
        }

        protected void onPostExecute(Void voids){
            mostrar.adapter.addAll(listaDatosString);
            //mostrar.adapter

        }


    }


}