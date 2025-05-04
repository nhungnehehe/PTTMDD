package com.phamtuyetnhung.k22411cfirstdegree;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

import java.util.Locale;
import android.os.Handler;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Khai báo các biến để quản lý các ô nhớ của các view:
    EditText  edtCoefficientA;
    EditText  edtCoefficientB;
    TextView txtResult;
    Spinner spinnerLanguage;
    String[] languageCodes;

    ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences prefs = getSharedPreferences("app_settings", MODE_PRIVATE);
        String langCode = prefs.getString("language", "en"); // mặc định là English
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addViews();

        spinnerLanguage = findViewById(R.id.spinner_language);
        languageCodes = getResources().getStringArray(R.array.language_codes);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.language_names,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLanguage.setAdapter(adapter);

// Set lại đúng vị trí nếu cần (dựa vào locale hiện tại)
        String currentLang = Locale.getDefault().getLanguage();
        for (int i = 0; i < languageCodes.length; i++) {
            if (languageCodes[i].equals(currentLang)) {
                spinnerLanguage.setSelection(i);
                break;
            }
        }

        spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean isFirstLoad = true;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isFirstLoad) {
                    isFirstLoad = false;
                    return;
                }
                changeAppLanguage(languageCodes[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        edtCoefficientA = findViewById(R.id.edtCoefficientA);
        edtCoefficientB = findViewById(R.id.edtCoefficientB);
        txtResult = findViewById(R.id.txtResult);
        progressBar = findViewById(R.id.progress_bar);

    }

    public void do_solution(View view) {
        //Lấy hsa trên giao diện
        String hsa = edtCoefficientA.getText().toString();
        double a = Double.parseDouble(hsa);
        double b = Double.parseDouble(edtCoefficientB.getText().toString());

        if (a==0 && b ==0)
        {
//            txtResult.setText("Infinity!");
            txtResult.setText(getResources().getText(R.string.title_infinity));
        }
        else if (a==0 && b!=0)
        {
//            txtResult.setText("No solution!");
            txtResult.setText(getResources().getText(R.string.title_no_solution));
        }
        else
        {
            double x = - b/a;
            txtResult.setText("x="+x);
        }
    }

    public void do_next(View view) {
        edtCoefficientA.setText("");
        edtCoefficientB.setText("");
        txtResult.setText("");
        edtCoefficientA.requestFocus();
    }

    public void do_exit(View view) {
        finish();
    }

    private void changeAppLanguage(String langCode) {

        SharedPreferences prefs = getSharedPreferences("app_settings", MODE_PRIVATE);
        prefs.edit().putString("language", langCode).apply();

        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(() -> {
            Locale locale = new Locale(langCode);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.setLocale(locale);
            getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        // Reload activity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 500);
    }

}