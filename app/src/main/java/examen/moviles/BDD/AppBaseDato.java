package examen.moviles.BDD;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;

import examen.moviles.Datoss;

@Database(entities = {Datoss.class}, version = 1)
public abstract class AppBaseDato extends RoomDatabase {
    public static Executor databaseWriteExecutor;

    public abstract DatosDAO datosDAO();


    public static AppBaseDato getInstance(final Context context) {
        return Room.databaseBuilder(context, AppBaseDato.class, "database-name").build();
    }
}
