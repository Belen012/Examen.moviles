package examen.moviles.BDD;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import examen.moviles.Datoss;

public class BuscarDato extends AsyncTask<String, Void, List<Datoss>> {
    private DatosDAO dao;
    private Callback<String> callback;

    public BuscarDato(DatosDAO dao, Callback<String> callback) {
        this.dao = dao;
        this.callback = callback;
    }

    @Override
    protected List<Datoss> doInBackground(String... strings) {
        List<Datoss> datoss = dao.buscarTodos();
        Log.i("Info","Platos encontrados" + datoss.toString());
        return datoss;
    }

    protected void onPostExecute(List<Datoss> datoss) {
        super.onPostExecute(datoss);
        callback.onCallback(datoss.toString());
    }
}
