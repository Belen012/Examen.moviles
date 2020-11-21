package examen.moviles.BDD;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import examen.moviles.Datoss;

@Dao
public interface DatosDAO {
    @Insert
    void insertar(Datoss datoss);

    @Delete
    void borrar(Datoss datoss);

    @Update
    void actualizar(Datoss datoss);

    @Query("SELECT * FROM Datoss WHERE id = :id LIMIT 1")
    Datoss buscar(String id);

    @Query("SELECT * FROM Datoss")
    List<Datoss> buscarTodos();
}

