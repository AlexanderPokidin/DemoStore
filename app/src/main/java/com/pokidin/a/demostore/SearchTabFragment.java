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
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchTabFragment extends Fragment {
    private static final String TAG = "SearchTabFragment";

    RecyclerView mRecyclerView;
    private List<Category> mCategories;

    String[] cater = {"Lask", "Mask", "Task", "Empir", "Bigbag", "Tongo", "HrukHru", "Sima Karamba",
            "Dumba Dumba", "Harabumba", "Chock Bock", "Belanock", "Duda Puda", "Hryda Juda", "Dzga",
            "Bambo", "Bigebia", "Sub ba Ba", "Sika Kaka", "Massakakigha", "Durabanga", "Subbue"};

    public SearchTabFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RestClient.getCategoryStoreApi().getCategories(
                RestClient.KEY).enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                Log.d(TAG, "onResponse checked");
                Log.d(TAG, "response: " + response.code());
                if (response.isSuccessful()) {
                    mCategories.add(response.body());
                    Log.d(TAG, "Size: " + mCategories.size());
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
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_tab, container, false);

        final Spinner spinner = view.findViewById(R.id.spinCategories);
        mCategories = new ArrayList<>();

        mRecyclerView = view.findViewById(R.id.rvItems);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(layoutManager);

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(
                getActivity(), R.layout.support_simple_spinner_dropdown_item, getCategoriesName(mCategories));
        spinner.setAdapter(categoryAdapter);

        return view;
    }

    // TODO Check Exception: java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
    private String[] getCategoriesName(List<Category> categories) {

        ArrayList<Category.Result> resultList = new ArrayList<>(categories.get(0).getResults());
        String[] categoriesName = new String[resultList.size()];


        for (int i = 0; i < resultList.size(); i++) {
            categoriesName[i] = resultList.get(i).getName();

            Log.d(TAG, "Size: " + resultList.size());
            Log.d(TAG, categories.get(0).getResults().get(i).getCategoryName());
        }
        return categoriesName;
    }

}
