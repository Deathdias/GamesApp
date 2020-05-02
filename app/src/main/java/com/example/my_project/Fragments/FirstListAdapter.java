package com.example.my_project.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_project.Lists.FirstList;
import com.example.my_project.R;

public class FirstListAdapter extends RecyclerView.Adapter {
    Context nContext;
    public FirstListAdapter(Context context){
        nContext = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_list_layout,parent,false);
        return new RecyclerViewHolder(view, nContext);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ( (RecyclerViewHolder) holder).BindView(position);
    }

    @Override
    public int getItemCount() {
        return FirstList.first.length;
    }
    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView filt;
        int position;

        public RecyclerViewHolder(View view, Context context){
            super(view);
            filt = view.findViewById(R.id.first_text);
            view.setOnClickListener((View.OnClickListener) this);
        }
        public void BindView(int position){
            this.position = position;
            filt.setText(FirstList.first[position]);
        }

        @Override
        public void onClick(View v) {
            Log.e("First RecyclerView", "onClick: OK");
            if(FirstList.first[position] == "Категорий") {
                Log.e("First RecyclerView", "Категорий: OK");
                Bundle bundle = new Bundle();
                ThirdFragment thirdFragment = new ThirdFragment();
                FragmentManager fragmentManager = ((AppCompatActivity) nContext).getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout_second, thirdFragment)
                        .commit();
            }
            if(FirstList.first[position] == "Рекомендуем"){
                Log.e("First RecyclerView", "Рекомендуем: OK");
                Bundle bundle = new Bundle();
                SecondFragment secondFragment = new SecondFragment();
                FragmentManager fragmentManager =((AppCompatActivity)nContext).getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout_second, secondFragment)
                        .commit();
            }
            if(FirstList.first[position] == "Лучшее"){
                Log.e("First RecyclerView", "Лучшее: OK");
                Bundle bundle = new Bundle();
                SecondFragment secondFragment = new SecondFragment();
                FragmentManager fragmentManager =((AppCompatActivity)nContext).getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout_second, secondFragment)
                        .commit();
            }
            if(FirstList.first[position] == "Платное"){
                Log.e("First RecyclerView", "Платное: OK");
                Bundle bundle = new Bundle();
                SecondFragment secondFragment = new SecondFragment();
                FragmentManager fragmentManager =((AppCompatActivity)nContext).getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout_second, secondFragment)
                        .commit();
            }
        }
    }
}
