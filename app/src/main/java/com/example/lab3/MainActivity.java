package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView conf = null;
    private int orientation = new Configuration().orientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conf = findViewById(R.id.screenOrientation);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        orientation = newConfig.orientation;
        defineScreenOrientation();
    }

    private void defineScreenOrientation() {
        int stringResource;
        switch (orientation) {
            case (Configuration.ORIENTATION_LANDSCAPE):
                stringResource = R.string.landscape_orientation;
                break;
            case (Configuration.ORIENTATION_PORTRAIT):
                stringResource = R.string.portrait_orientation;
                break;
            default:
                stringResource = R.string.unknown;
                break;
        }
        conf.setText(getString(stringResource));
    }
}