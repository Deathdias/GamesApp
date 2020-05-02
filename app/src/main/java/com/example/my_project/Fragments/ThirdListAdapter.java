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
import com.example.my_project.Lists.ThirdList;
import com.example.my_project.R;

public class ThirdListAdapter extends RecyclerView.Adapter {
    Context nContext;
    public ThirdListAdapter(Context context){
        nContext = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.third_list_layout,parent,false);
        return new RecyclerViewHolder(view, nContext);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ( (RecyclerViewHolder) holder).BindView(position);
    }

    @Override
    public int getItemCount() {
        return ThirdList.genre.length;
    }
    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView genre;
        int position;

        public RecyclerViewHolder(View view, Context context){
            super(view);
            genre = view.findViewById(R.id.third_text);
            view.setOnClickListener((View.OnClickListener) this);
        }
        public void BindView(int position){
            this.position = position;
            genre.setText(ThirdList.genre[position]);
        }

        @Override
        public void onClick(View v) {
            Log.e("Third RecyclerView", "onClick: OK");

            if(ThirdList.genre[position] == "Категорий"){
                Bundle bundle = new Bundle();
                SecondFragment secondFragment = new SecondFragment();
                FragmentManager fragmentManager =((AppCompatActivity)nContext).getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout_second, secondFragment);
            }
        }
    }
}
