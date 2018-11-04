package com.pokidin.a.demostore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.pokidin.a.demostore.api.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Debug Run";

    private List<Category> mCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = findViewById(R.id.spinCategories);

        mCategories = new ArrayList<>();

        RestClient.getCategoryStoreApi().getCategories("taxonomy", "categories",
                "22w1n5abtj7tjj8y2f9kuqas").enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                mCategories.addAll(response.body());
                Log.d(TAG, "Size: " + mCategories.size());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(
                this, R.layout.support_simple_spinner_dropdown_item, getCategoriesName(mCategories));
        spinner.setAdapter(categoryAdapter);
    }

    private String[] getCategoriesName(List<Category> categories) {
        String[] categoriesName = new String[categories.size()];
        for (int i = 0; i < categories.size(); i++) {
            categoriesName[i] = categories.get(0).getResults().get(i).getCategoryName();
            Log.d(TAG, "Size: " + categories.size());
            Log.d(TAG, categories.get(0).getResults().get(i).getCategoryName().toString());
        }
        return categoriesName;
    }
}
