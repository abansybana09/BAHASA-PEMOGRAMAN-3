package com.example.project_bp3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PanduanWudhuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan_wudhu);

        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);

        ImageButton pengertianButton = findViewById(R.id.pengertian_button);
        pengertianButton.setOnClickListener(this);

        ImageButton kapanButton = findViewById(R.id.kapan_button);
        kapanButton.setOnClickListener(this);

        ImageButton amalanButton = findViewById(R.id.amalan_button);
        amalanButton.setOnClickListener(this);

        ImageButton airButton = findViewById(R.id.air_button);
        airButton.setOnClickListener(this);

        ImageButton batalButton = findViewById(R.id.batal_button);
        batalButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back_button) {
            finish();
        } else if (v.getId() == R.id.pengertian_button) {
            startActivity(new Intent(this, PengertianActivity.class));
        } else if (v.getId() == R.id.kapan_button) {
            startActivity(new Intent(this, KapanActivity.class));
        } else if (v.getId() == R.id.amalan_button) {
            startActivity(new Intent(this, AmalanActivity.class));
        } else if (v.getId() == R.id.air_button) {
            startActivity(new Intent(this, AirActivity.class));
        } else if (v.getId() == R.id.batal_button) {
            startActivity(new Intent(this, BatalActivity.class));
        }
    }
}
