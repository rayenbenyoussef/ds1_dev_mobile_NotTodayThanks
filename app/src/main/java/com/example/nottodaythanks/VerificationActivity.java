package com.example.nottodaythanks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VerificationActivity extends AppCompatActivity {

    TextView nom;
    TextView age;
    TextView dated;
    TextView motif;
    ImageView img;
    Button approve;
    Button refuse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verification);

        this.nom=(TextView) findViewById(R.id.tv_nom_rby);
        this.age=(TextView) findViewById(R.id.tv_age_rby);
        this.dated=(TextView) findViewById(R.id.tv_ad_rby);
        this.motif=(TextView) findViewById(R.id.tv_moif_rby);

        this.img=(ImageView) findViewById(R.id.imgv_ver_rby);
        this.approve=(Button) findViewById(R.id.btn_aprv_rby);
        this.refuse=(Button) findViewById(R.id.btn_ref_rby);


        Bundle b=getIntent().getExtras();
        this.nom.setText(b.getString(Utils.MARAM_NUMBER+"_nom"));
        this.age.setText(Integer.toString(b.getInt(Utils.MARAM_NUMBER+"_age")));
        this.dated.setText("to "+b.getString(Utils.MARAM_NUMBER+"_dated"));
        this.motif.setText(b.getString(Utils.MARAM_NUMBER+"_motif"));

        if(b.getBoolean(Utils.MARAM_NUMBER+"_risk")){
            this.approve.setEnabled(false);
            this.approve.setText("paradoxe détecté!");
            this.approve.setBackgroundResource(R.drawable.disabaled_approve);
            this.approve.setBackgroundTintList(null);
            this.approve.setTextColor(getResources().getColor(R.color.red));
        }

        if(this.motif.getText().toString().equals("Tourisme")){
            this.img.setImageResource(R.drawable.tourisme);
        } else if (this.motif.getText().toString().equals("Modification du passé")) {
            this.img.setImageResource(R.drawable.pastmod);
        }else{
            this.img.setImageResource(R.drawable.fuite);
        }

    }
    public void refuse(View view){
        Intent i = new Intent(this,ResultActivity.class);
        i.putExtra(Utils.RAYEN_NUMBER+"_nom",this.nom.getText().toString());
        i.putExtra(Utils.RAYEN_NUMBER+"_approved",false);
        startActivity(i);
    }

    public void approve(View view){
        Intent i = new Intent(this,ResultActivity.class);
        i.putExtra(Utils.RAYEN_NUMBER+"_nom",this.nom.getText().toString());
        i.putExtra(Utils.RAYEN_NUMBER+"_approved",true);
        startActivity(i);
    }
}