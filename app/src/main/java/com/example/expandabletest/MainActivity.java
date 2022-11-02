package com.example.expandabletest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> sectionList = new ArrayList<>();
    HashMap<String, ArrayList<String>> itemList = new HashMap<>();
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recycler_view);

        //section values//

        sectionList.add("Morning");
        sectionList.add("AfterNoon");
        sectionList.add("Evening");
        sectionList.add("Night");

        //arraylist
        ArrayList<String> arrayList = new ArrayList<>();

        //add morning values
        arrayList.add("05:00 AM");
        arrayList.add("06:00 AM");
        arrayList.add("07:00 AM");
        arrayList.add("08:00 AM");
        arrayList.add("09:00 AM");
        arrayList.add("10:00 AM");
        arrayList.add("11:00 AM");

        //put morning values in itemlist
        itemList.put(sectionList.get(0), arrayList);

        //add afternoon values
        arrayList = new ArrayList<>();
        arrayList.add("12:00 PM");
        arrayList.add("01:00 PM");
        arrayList.add("02:00 PM");
        arrayList.add("03:00 PM");
        arrayList.add("04:00 PM");

        //put afternoon values in itemlist
        itemList.put(sectionList.get(1), arrayList);

        //add evening values
        arrayList = new ArrayList<>();
        arrayList.add("05:00 PM");
        arrayList.add("06:00 PM");
        arrayList.add("07:00 PM");
        arrayList.add("08:00 PM");

        //put evening values in itemlist
        itemList.put(sectionList.get(2), arrayList);

        //add night values
        arrayList = new ArrayList<>();
        arrayList.add("09:00 PM");
        arrayList.add("10:00 PM");
        arrayList.add("11:00 PM");
        arrayList.add("12:00 PM");
        arrayList.add("01:00 AM");
        arrayList.add("02:00 AM");
        arrayList.add("03:00 AM");
        arrayList.add("04:00 AM");

        //put night values in itemlist
        itemList.put(sectionList.get(3), arrayList);

        adapter= new MainAdapter(this, sectionList, itemList);
        GridLayoutManager manager= new GridLayoutManager(this, 3);
        //set layout manager to recycler view
        recyclerView.setLayoutManager(manager);
        //set layout manager to adapter
        adapter.setLayoutManager(manager);
        adapter.shouldShowHeadersForEmptySections(false);
        recyclerView.setAdapter(adapter);

    }
}