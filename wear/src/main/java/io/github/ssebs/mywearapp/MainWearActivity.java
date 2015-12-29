package io.github.ssebs.mywearapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;

public class MainWearActivity extends WearableActivity {
    private Bundle bun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_wear);
        setAmbientEnabled();

        bun = savedInstanceState;
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {

    }

    /**
     * Button click
     *
     * @param view
     */
    public void buttClick(View view) {
        Intent i = new Intent(MainWearActivity.this, SecondActivity.class);
        MainWearActivity.this.startActivity(i);
        //   Toast.makeText(MainWearActivity.this, "a toast", Toast.LENGTH_SHORT).show();
    }
}
