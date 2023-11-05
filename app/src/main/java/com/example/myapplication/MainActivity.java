package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner_gender
                = (Spinner)findViewById(R.id.spinner_gender);
        final Spinner spinner_name
                = (Spinner)findViewById(R.id.spinner_name);

        // Create an ArrayAdapter using the string array and
        // a default spinner layout
        ArrayAdapter<CharSequence> ad_gender
                = ArrayAdapter.createFromResource(
                this, R.array.gender_type,
                android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of
        // choices appears
        ad_gender.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner_gender.setAdapter(ad_gender);

        spinner_gender.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> adapterView, View view,
                            int i, long l)
                    {

                        if (adapterView.getSelectedItem()
                                .toString()
                                .equals("Bhatgaon-05")) {
                            ArrayAdapter<CharSequence> ad_name
                                    = ArrayAdapter.createFromResource(
                                    getApplicationContext(),
                                    R.array.Bhatgaon05,
                                    android.R.layout
                                            .simple_spinner_item);
                            spinner_name.setAdapter(ad_name);
                        } else if (adapterView.getSelectedItem()
                                .toString()
                                .equals("Premnagar-04")) {
                            ArrayAdapter<CharSequence> ad_name
                                    = ArrayAdapter.createFromResource(
                                    getApplicationContext(),
                                    R.array.Premnagar04,
                                    android.R.layout
                                            .simple_spinner_item);
                            spinner_name.setAdapter(ad_name);
                        } else {
                            ArrayAdapter<CharSequence> ad_name
                                    = ArrayAdapter.createFromResource(
                                    getApplicationContext(),
                                    R.array.Pratappur06,
                                    android.R.layout
                                            .simple_spinner_item);
                            spinner_name.setAdapter(ad_name);
                        }
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> adapterView)
                    {
                    }
                });

        spinner_name.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> adapterView, View view,
                            int i, long l)
                    {
                        Snackbar
                                .make(findViewById(R.id.layout),
                                        adapterView.getSelectedItem()
                                                .toString()
                                                + " is a "
                                                + spinner_gender
                                                .getSelectedItem()
                                                .toString(),
                                        BaseTransientBottomBar
                                                .LENGTH_LONG)
                                .show();
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> adapterView)
                    {
                    }
                });
    }
}