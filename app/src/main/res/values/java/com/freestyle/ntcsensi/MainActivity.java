package com.freestyle.ntcsensi;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Main background
    LinearLayout layout = new LinearLayout(this);
    layout.setOrientation(LinearLayout.VERTICAL);
    layout.setPadding(30, 40, 30, 30);
    layout.setGravity(Gravity.TOP);
    layout.setBackgroundColor(Color.rgb(18, 18, 18));

    // Title
    TextView title = new TextView(this);
    title.setText("FREE FIRE SENSI");
    title.setTextSize(28);
    title.setTextColor(Color.WHITE);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 20, 0, 20);
    layout.addView(title);

    // Profile card
    LinearLayout profile = new LinearLayout(this);
    profile.setOrientation(LinearLayout.VERTICAL);
    profile.setGravity(Gravity.CENTER);
    profile.setPadding(20, 25, 20, 25);

    GradientDrawable profileBackground = new GradientDrawable();
    profileBackground.setColor(Color.rgb(35, 35, 35));
    profileBackground.setCornerRadius(25);
    profile.setBackground(profileBackground);

    TextView avatar = new TextView(this);
    avatar.setText("👤");
    avatar.setTextSize(45);
    avatar.setGravity(Gravity.CENTER);

    TextView profileName = new TextView(this);
    profileName.setText("Player Profile");
    profileName.setTextSize(20);
    profileName.setTextColor(Color.WHITE);
    profileName.setGravity(Gravity.CENTER);

    TextView profileInfo = new TextView(this);
    profileInfo.setText("Sensi Generator");
    profileInfo.setTextSize(14);
    profileInfo.setTextColor(Color.LTGRAY);
    profileInfo.setGravity(Gravity.CENTER);

    profile.addView(avatar);
    profile.addView(profileName);
    profile.addView(profileInfo);

    layout.addView(profile);

    // Space
    TextView space = new TextView(this);
    space.setText("");
    space.setHeight(25);
    layout.addView(space);

    // Sensitivity section
    TextView sensiTitle = new TextView(this);
    sensiTitle.setText("SENSITIVITY SETTINGS");
    sensiTitle.setTextSize(20);
    sensiTitle.setTextColor(Color.WHITE);
    sensiTitle.setGravity(Gravity.CENTER);
    layout.addView(sensiTitle);

    // Sensitivity values
    TextView sensi = new TextView(this);
    sensi.setText(
            "General: 189\n" +
            "Red Dot: 125\n" +
            "2x Scope: 174\n" +
            "4x Scope: 184\n" +
            "Sniper Scope: 29\n" +
            "Free Look: 87"
    );
    sensi.setTextSize(17);
    sensi.setTextColor(Color.WHITE);
    sensi.setGravity(Gravity.CENTER);
    sensi.setPadding(20, 20, 20, 20);

    layout.addView(sensi);

    // Generate button
    Button generate = new Button(this);
    generate.setText("GENERATE SENSITIVITY");
    generate.setTextSize(16);

    generate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            sensi.setText(
                    "General: 190\n" +
                    "Red Dot: 130\n" +
                    "2x Scope: 175\n" +
                    "4x Scope: 180\n" +
                    "Sniper Scope: 30\n" +
                    "Free Look: 85"
            );
        }
    });

    layout.addView(generate);

    // About button
    Button about = new Button(this);
    about.setText("ABOUT APP");
    about.setTextSize(16);

    layout.addView(about);

    setContentView(layout);
}

}
