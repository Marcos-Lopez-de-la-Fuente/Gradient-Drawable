package com.example.gradientdrawable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;

import java.util.Map;

import static java.util.Map.entry;


public class SeekBackgroundActivity extends AppCompatActivity {

    private SeekBar seekBarMain;
    private ConstraintLayout constraintMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_background);

        this.seekBarMain = findViewById(R.id.seekBarMain);
        this.constraintMain = findViewById(R.id.constraintMain);


        ///////////////////////////////////////////////////////////////////////////


        this.seekBarMain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                setNewColor(progressValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }


    public void setNewColor(int progressValue) {
        Map<Integer, Integer> colors = Map.ofEntries(
                entry(0, Color.RED),
                entry(1, Color.YELLOW),
                entry(2, Color.GREEN),
                entry(3, Color.MAGENTA),
                entry(4, Color.BLACK),
                entry(5, Color.BLUE),
                entry(6, Color.CYAN),
                entry(7, Color.DKGRAY),
                entry(8, Color.GRAY),
                entry(9, Color.LTGRAY),
                entry(10, Color.WHITE)
        );


        String progressStr = Integer.toString(progressValue);

        int newProgressValue = 0;
        switch (progressStr.length()) {
            case 1:
                newProgressValue = progressValue;
                break;
            case 2:
                newProgressValue = Integer.parseInt(progressStr.substring(1));
                break;
            case 3:
                newProgressValue = Integer.parseInt(progressStr.substring(2));
                break;
        }
        this.constraintMain.setBackgroundColor(colors.get(newProgressValue));
    }

}