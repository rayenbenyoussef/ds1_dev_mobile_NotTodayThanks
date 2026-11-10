package com.example.nottodaythanks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        this.result= (TextView) findViewById(R.id.tv_res_rby);
        Bundle b= getIntent().getExtras();
        boolean aprv= b.getBoolean(Utils.RAYEN_NUMBER+"_approved");
        String nom=b.getString(Utils.RAYEN_NUMBER+"_nom");

        if(aprv){
            this.result.setText(getString(R.string.approved,nom));
        }else{
            this.result.setText(getString(R.string.refuser,nom));
        }

    }

    public void goback(View view){
        Intent i= new Intent(this, MainActivity.class);
        startActivity(i);
    }
}