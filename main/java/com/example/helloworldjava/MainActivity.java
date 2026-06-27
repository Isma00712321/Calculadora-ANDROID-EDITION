package com.example.helloworldjava;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {


    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void onButtonClick(View v) {
        EditText e1 = (EditText)findViewById(R.id.insertanumero1);
        EditText e2 = (EditText)findViewById(R.id.insertnumero2);
        TextView t1 = findViewById(R.id.Resultado);

        if (e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty()) {
            Toast.makeText(this, "pon algo tonto", Toast.LENGTH_SHORT).show();
            return;
        }

        int resultado;


        RadioGroup grupo = (RadioGroup)findViewById(R.id.grupo);

        int seleccion = grupo.getCheckedRadioButtonId();

        if (seleccion == R.id.suma) {
            resultado = Integer.parseInt(e1.getText().toString()) + Integer.parseInt(e2.getText().toString());
        } else if (seleccion == R.id.resta) {
            resultado = Integer.parseInt(e1.getText().toString()) - Integer.parseInt(e2.getText().toString());
        } else if (seleccion == R.id.multiplica) {
            resultado = Integer.parseInt(e1.getText().toString()) * Integer.parseInt(e2.getText().toString());
        } else {
            Toast.makeText(this, "selecciona algo bobolon", Toast.LENGTH_SHORT).show();
            return;
        }

        t1.setText("El resultado es: " + resultado);




        if (mp == null || !mp.isPlaying()) {
            mp  = MediaPlayer.create(this, R.raw.pl);
            mp.start();
        } else {
            mp.stop();
        }

    }
}