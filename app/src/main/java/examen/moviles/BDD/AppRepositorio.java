package examen.moviles.BDD;

import android.app.Application;

import examen.moviles.Datoss;

public class AppRepositorio {
    private DatosDAO platoDao;

    public AppRepositorio(Application application) {
        AppBaseDato db = AppBaseDato.getInstance(application);
        platoDao = db.datosDAO();
    }

    public void insertar(final Datoss datoss) {
        AppBaseDato.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                platoDao.insertar(datoss);
            }
        });
    }

    ;

    public void buscarTodos(Callback<String> callback) {
        new BuscarDato(this.platoDao, callback).execute();
    }

    ;
}

