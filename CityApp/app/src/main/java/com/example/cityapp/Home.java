//package com.example.cityapp;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.widget.SearchView;
//import androidx.fragment.app.Fragment;
//
//import java.util.ArrayList;
//
//public class Home extends Fragment {
//    SearchView mySearchView;
//    ListView listView;
//
//    ArrayList<String> list;
//    ArrayAdapter<String> adapterList;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        mySearchView = findViewById(R.id.searchView);
//        listView = findViewById(R.id.listView);
//
//        list = new ArrayList<String>();
//        list.add("Jaipur");
//        list.add("Abohar");
//        list.add("Jalandhar");
//        list.add("Mumbai");
//
//        adapterList = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
//        listView.setAdapter(adapterList);
//
//        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//
//                adapterList.getFilter().filter(newText);
//                return false;
//            }
//        });
//    }
//}
