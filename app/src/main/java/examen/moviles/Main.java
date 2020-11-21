package examen.moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import examen.moviles.BDD.AppBaseDato;

public class Main extends AppCompatActivity {
    Context contexto = this;
    Main main = this;
    TextView textView;
    EditText edit_text;
    Datoss datoss = new Datoss();
    Button button;
    Switch aSwitch;
    AppBaseDato db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        textView = findViewById(R.id.textView);
        textView.setText("Integrese lo que desea guardar");
        edit_text = findViewById(R.id.edit_text);
        aSwitch = findViewById(R.id.switch1);

        button = findViewById(R.id.button);
        button.setVisibility(View.GONE);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(aSwitch.isChecked()){
                    button.setVisibility(View.VISIBLE);
                }else{
                    button.setVisibility(View.GONE);
                }
            }
        });


        /*db = Room.databaseBuilder(getApplicationContext(), AppBaseDato.class, "database-name")
                .allowMainThreadQueries()
                .build();*/

        db = AppBaseDato.getInstance(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edit_text.getText().toString().isEmpty()) {
                    datoss.setTexto(edit_text.getText().toString());
                    new guardarDatoss().execute();
                }

                startActivity(new Intent(contexto, Mostrar.class));

            }
            });
      //  }


    }

    public class guardarDatoss extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... voids){
            Datoss datoss = new Datoss();
            main.db.datosDAO().insertar(datoss);
            return null;
        }
    }



}