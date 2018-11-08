package com.pokidin.a.demostore;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.pokidin.a.demostore.api.RestClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchTabFragment extends Fragment {
    private static final String TAG = "SearchTabFragment";

    RecyclerView mRecyclerView;
    private Category mCategory;
    private Spinner spinner;

    String[] cater = {"Lask", "Mask", "Task", "Empir", "Bigbag", "Tongo", "HrukHru", "Sima Karamba",
            "Dumba Dumba", "Harabumba", "Chock Bock", "Belanock", "Duda Puda", "Hryda Juda", "Dzga",
            "Bambo", "Bigebia", "Sub ba Ba", "Sika Kaka", "Massakakigha", "Durabanga", "Subbue"};

    public SearchTabFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate checked: Start");

        RestClient.getCategoryStoreApi().getCategories(
                RestClient.KEY).enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                Log.d(TAG, "onResponse checked");
                Log.d(TAG, "response: " + response.code());
                if (response.isSuccessful()) {
                    mCategory = response.body();
                    addSpinnerData(getCategoriesName(mCategory));
                    Log.d(TAG, "Response is Successful: " + response.body() );
                    Log.d(TAG, "Category contains: " + mCategory.getResults() );

                } else {
                    Log.d(TAG, "Request failed: " + response.code() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Log.d(TAG, "getCategories onFailure: " + t.getMessage() + " " + t.toString());
                Toast.makeText(getActivity(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
        Log.d(TAG, "onCreate checked: Finish");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_tab, container, false);
        Log.d(TAG, "onCreateView checked");

        spinner = view.findViewById(R.id.spinCategories);

        mRecyclerView = view.findViewById(R.id.rvItems);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(layoutManager);

        return view;
    }

    private String[] getCategoriesName(Category category) {
        Log.d(TAG, "getCategoriesName checked: Start");


        ArrayList<Category.Result> resultList = new ArrayList<>(category.getResults());
        String[] categoriesName = new String[resultList.size()];


        for (int i = 0; i < resultList.size(); i++) {
            categoriesName[i] = resultList.get(i).getName();

            Log.d(TAG, "Size: " + resultList.size());
            Log.d(TAG, category.getResults().get(i).getCategoryName());
        }
        Log.d(TAG, "getCategoriesName checked: Finish");

        return categoriesName;
    }

    private void addSpinnerData(String[] strings){
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(
                getActivity(), R.layout.support_simple_spinner_dropdown_item, strings);
        spinner.setAdapter(categoryAdapter);
        Log.d(TAG, "categoryAdapter checked");
    }
}
