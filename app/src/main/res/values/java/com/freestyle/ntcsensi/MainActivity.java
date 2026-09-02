package com.freestyle.ntcsensi;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    LinearLayout root;
    LinearLayout content;

    int BLACK = Color.rgb(8, 8, 8);
    int RED = Color.rgb(220, 20, 40);
    int WHITE = Color.WHITE;
    int GRAY = Color.rgb(35, 35, 35);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showHome();
    }

    private TextView text(String value, int size) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(WHITE);
        t.setPadding(20, 15, 20, 15);
        return t;
    }

    private Button button(String name) {
        Button b = new Button(this);
        b.setText(name);
        b.setTextColor(WHITE);
        b.setTextSize(15);
        b.setBackgroundColor(RED);
        return b;
    }

    private void setup(String title) {
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(BLACK);

        TextView header = text(title, 22);
        header.setTextColor(RED);
        header.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        header.setGravity(Gravity.CENTER);
        header.setPadding(10, 25, 10, 25);

        root.addView(header);

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(20, 10, 20, 30);

        scroll.addView(content);
        root.addView(scroll,
                new LinearLayout.LayoutParams(
                        -1, 0, 1));

        setContentView(root);
    }

    private void showHome() {
        setup("FREESTYLE N@TC SENSI");

        TextView welcome = text(
                "BLACK • RED GAMING SENSITIVITY",
                18);
        welcome.setTextColor(RED);
        welcome.setGravity(Gravity.CENTER);
        content.addView(welcome);

        TextView info = text(
                "\nChoose your device and generate a starting sensitivity preset.\n\n"
                + "These settings are starting points only. "
                + "No sensitivity can guarantee 100% headshots.",
                15);
        content.addView(info);

        Button generator = button("🎯 SENSITIVITY GENERATOR");
        content.addView(generator);

        generator.setOnClickListener(v -> showGenerator());

        Button drag = button("🖱 HOW TO DRAG");
        content.addView(drag);

        drag.setOnClickListener(v -> showDragGuide());

        Button profile = button("👤 PROFILE");
        content.addView(profile);

        profile.setOnClickListener(v -> showProfile());
    }

    private void showGenerator() {
        setup("SENSITIVITY GENERATOR");

        content.addView(text("SELECT DEVICE", 18));

        Spinner devices = new Spinner(this);

        String[] list = {
                "Samsung",
                "Tecno",
                "Infinix",
                "Xiaomi",
                "Redmi",
                "Oppo",
                "Vivo",
                "Realme",
                "Other Android"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_item,
                        list);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        devices.setAdapter(adapter);
        content.addView(devices);

        Button generate = button("GENERATE PRESET");
        content.addView(generate);

        TextView result = text(
                "\nYour sensitivity will appear here.",
                17);
        result.setTextColor(RED);
        content.addView(result);

        generate.setOnClickListener(v -> {

            String device =
                    devices.getSelectedItem().toString();

            String preset =
                    "DEVICE: " + device
                    + "\n\n"
                    + "General: 180"
                    + "\nRed Dot: 150"
                    + "\n2× Scope: 165"
                    + "\n4× Scope: 155"
                    + "\nSniper: 70"
                    + "\nFree Look: 100"
                    + "\n\nUse these as a starting point and "
                    + "adjust them to your own touch response.";

            result.setText(preset);

            Toast.makeText(
                    this,
                    "Preset generated",
                    Toast.LENGTH_SHORT).show();
        });

        Button back = button("← BACK");
        content.addView(back);

        back.setOnClickListener(v -> showHome());
    }

    private void showDragGuide() {
        setup("HOW TO DRAG");

        TextView guide = text(
                "🎯 SMOOTH DRAG GUIDE\n\n"
                + "1. Keep your finger on the fire button.\n\n"
                + "2. Start the drag smoothly instead of moving "
                + "your finger very fast.\n\n"
                + "3. Move upward in a controlled motion.\n\n"
                + "4. Practice at different distances.\n\n"
                + "5. If your aim moves too far upward, reduce "
                + "your sensitivity slightly.\n\n"
                + "6. If your aim feels too slow, increase it "
                + "a little.\n\n"
                + "There is no setting that guarantees 100% "
                + "headshots. Practice and device touch response "
                + "also matter.",
                16);

        content.addView(guide);

        Button back = button("← BACK");
        content.addView(back);

        back.setOnClickListener(v -> showHome());
    }

    private void showProfile() {
        setup("PROFILE");

        TextView icon = text("👤", 55);
        icon.setGravity(Gravity.CENTER);
        content.addView(icon);

        TextView name = text(
                "FREESTYLE N@TC SENSI",
                25);

        name.setTextColor(RED);
        name.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD);
        name.setGravity(Gravity.CENTER);

        content.addView(name);

        TextView description = text(
                "\nSensitivity Generator\n"
                + "Drag Guide\n"
                + "Black & Red Gaming Theme\n\n"
                + "Version 1.0",
                16);

        description.setGravity(Gravity.CENTER);
        content.addView(description);

        Button back = button("← BACK");
        content.addView(back);

        back.setOnClickListener(v -> showHome());
    }
}
