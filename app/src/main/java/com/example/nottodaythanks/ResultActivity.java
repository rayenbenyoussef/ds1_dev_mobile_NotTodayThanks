package com.example.nottodaythanks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    TextView result;
    View mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        this.mainLayout = findViewById(R.id.main);
        this.result= (TextView) findViewById(R.id.tv_res_rby);
        Bundle b= getIntent().getExtras();
        boolean aprv= b.getBoolean(Utils.RAYEN_NUMBER+"_approved");
        String nom=b.getString(Utils.RAYEN_NUMBER+"_nom");

        if(aprv){
            this.result.setText(getString(R.string.approved,nom));
            this.result.setTextColor(getResources().getColor(R.color.green));
            mainLayout.setBackgroundResource(R.drawable.bg_res_aprv);

        }else{
            this.result.setText(getString(R.string.refuser,nom));
            this.result.setTextColor(getResources().getColor(R.color.red));
            mainLayout.setBackgroundResource(R.drawable.bg_res_ref);

        }

    }

    public void goback(View view){
        Intent i= new Intent(this, MainActivity.class);
        startActivity(i);
    }
}