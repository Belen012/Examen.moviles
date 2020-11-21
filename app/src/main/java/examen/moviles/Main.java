package examen.moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;

import examen.moviles.BDD.AppRepositorio;

public class Main extends AppCompatActivity {
    Context contexto = this;
    TextView textView;
    EditText edit_text;
    Datoss datoss;
    Button button;
    Switch aSwitch;
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



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edit_text.getText().toString().isEmpty())
                    datoss.setTexto(edit_text.getText().toString());

                startActivity(new Intent(contexto, Mostrar.class));

            }
            });
      //  }


    }
}