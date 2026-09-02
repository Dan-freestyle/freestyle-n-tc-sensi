package com.freestyle.ntcsensi;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(30, 40, 30, 30);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView title = new TextView(this);
        title.setText("FREE FIRE SENSI");
        title.setTextSize(26);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);

        layout.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Sensitivity Generator");
        subtitle.setTextSize(18);
        subtitle.setGravity(Gravity.CENTER);
        layout.addView(subtitle);

        result = new TextView(this);
        result.setText("\nTap Generate Sensi");
        result.setTextSize(18);
        result.setTextColor(Color.BLACK);
        result.setGravity(Gravity.CENTER);
        layout.addView(result);

        Button generate = new Button(this);
        generate.setText("GENERATE SENSI");

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                result.setText(
                    "\nRecommended Sensitivity\n\n" +
                    "General: 190\n" +
                    "Red Dot: 180\n" +
                    "2X Scope: 170\n" +
                    "4X Scope: 160\n" +
                    "Sniper Scope: 90\n" +
                    "Free Look: 150\n"
                );
            }
        });

        layout.addView(generate);

        setContentView(layout);
    }
}
