package com.pokidin.a.demostore;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SearchTabFragment extends Fragment {

    RecyclerView mRecyclerView;

    String[] cater = {"Lask", "Mask", "Task", "Empir", "Bigbag", "Tongo", "HrukHru", "Sima Karamba",
            "Dumba Dumba", "Harabumba", "Chock Bock", "Belanock", "Duda Puda", "Hryda Juda", "Dzga",
            "Bambo", "Bigebia", "Sub ba Ba", "Sika Kaka", "Massakakigha", "Durabanga", "Subbue"};

    public SearchTabFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_tab, container, false);

        final Spinner spinner = view.findViewById(R.id.spinCategories);

        mRecyclerView = view.findViewById(R.id.rvItems);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(layoutManager);

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(
                getActivity(), R.layout.support_simple_spinner_dropdown_item, cater);
        spinner.setAdapter(categoryAdapter);

        return view;
    }

}
