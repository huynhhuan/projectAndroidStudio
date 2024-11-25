package com.example.bahuankt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FragmentHome extends Fragment {
    private RecyclerView.Adapter adapterBook;
    private RecyclerView listview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        listview = rootView.findViewById(R.id.listView);
        listview.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Book> items = new ArrayList<>();
        items.add(new Book("", "Sach hay 1"));
        items.add(new Book("", "Sach hay 12"));
        items.add(new Book("", "Sach hay 3."));
        items.add(new Book("", "BSach hay 4."));
        items.add(new Book("", "Sach hay 5"));
        items.add(new Book("", "Sach hay 6"));
        items.add(new Book("", "Sach hay 7"));
        items.add(new Book("", "Sach hay 8."));

        adapterBook = new BookAdapter(items);
        listview.setAdapter(adapterBook);

        return rootView;
    }
}