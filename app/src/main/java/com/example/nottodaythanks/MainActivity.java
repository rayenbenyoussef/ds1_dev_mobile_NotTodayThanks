package com.example.nottodaythanks;

import static android.widget.Toast.LENGTH_LONG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText nom;
    EditText daten;
    EditText dated;
    RadioButton tourisme;
    RadioButton modpasse;
    RadioButton fuite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        this.nom=(EditText) findViewById(R.id.et_nom_ma);
        this.daten=(EditText) findViewById(R.id.et_an_ma);
        this.dated=(EditText) findViewById(R.id.et_ad_ma);
        this.tourisme=(RadioButton) findViewById(R.id.rbtn_tour_ma);
        this.modpasse=(RadioButton) findViewById(R.id.rbtn_modpas_ma);
        this.fuite=(RadioButton) findViewById(R.id.rbtn_fuite_ma);


    }

    public void toVerif(View view){
        String nom_str=this.nom.getText().toString();


        if(nom_str.isEmpty()){
            Toast.makeText(this,"Saisissez votre nom!",LENGTH_LONG).show();
            return;
        }

        if(this.daten.getText().toString().isEmpty()){
            Toast.makeText(this,"Saisissez votre date de naissance!",LENGTH_LONG).show();
            return;
        }

        if(this.dated.getText().toString().isEmpty()){
            Toast.makeText(this,"Saisissez votre date de destination!",LENGTH_LONG).show();
            return;
        }

        int dated_int=Integer.parseInt(this.dated.getText().toString());
        int daten_int=Integer.parseInt(this.daten.getText().toString());

        if(dated_int==2026){
            Toast.makeText(this,"Ça va ? Tu es déjà là!",LENGTH_LONG).show();
            return;
        }

        if(!this.tourisme.isChecked() && !this.modpasse.isChecked() && !this.fuite.isChecked()){
            Toast.makeText(this,"Choisissez une option!",LENGTH_LONG).show();
            return;
        }

        if(this.modpasse.isChecked() &&
                dated_int >2026){
            Toast.makeText(this,"Tu ne peux pas changer l'avenir.!",LENGTH_LONG).show();
            return;
        }

        Intent i= new Intent(MainActivity.this,VerificationActivity.class);
        i.putExtra(Utils.MARAM_NUMBER+"_nom",nom_str);

        i.putExtra(Utils.MARAM_NUMBER+"_age",2026 - daten_int);

        if(this.tourisme.isChecked()){
            i.putExtra(Utils.MARAM_NUMBER+"_motif",this.tourisme.getText().toString());
        } else if (this.modpasse.isChecked()) {
            i.putExtra(Utils.MARAM_NUMBER+"_motif",this.modpasse.getText().toString());
        }else {
            i.putExtra(Utils.MARAM_NUMBER+"_motif",this.fuite.getText().toString());
        }

        i.putExtra(Utils.MARAM_NUMBER+"_dated",this.dated.getText().toString());

        if (this.modpasse.isChecked()){
            i.putExtra(Utils.MARAM_NUMBER+"_risk",Utils.isPrime(Math.abs(daten_int - dated_int)));
        }else{
            i.putExtra(Utils.MARAM_NUMBER+"_risk",false);
        }

        startActivity(i);
    }
}