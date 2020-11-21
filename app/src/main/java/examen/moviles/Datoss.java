package examen.moviles;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Datoss {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo
    private String texto ;


    public Datoss(){
    }

    public Datoss(Long id, String texto){
        this.id = id;
        this.texto = texto;
    }

    public Long getId() {return id; }

    public void setId(Long id) {this.id = id; }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }


}
