package com.example.my_project.Fragments;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_project.Lists.FirstList;
import com.example.my_project.Lists.SecondList;
import com.example.my_project.R;

public class SecondListAdapter extends RecyclerView.Adapter {
    Context mContext;
    public SecondListAdapter(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_list_layout,parent,false);
        return new RecyclerViewHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ( (RecyclerViewHolder) holder).BindView(position);
    }

    @Override
    public int getItemCount() {
        return SecondList.second_name.length;
    }
    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name,creator,size,star;
        ImageView image;
        int position;

        public RecyclerViewHolder(View view, Context context){
            super(view);
            name = view.findViewById(R.id.second_name);
            creator =view.findViewById(R.id.second_creator);
            size = view.findViewById(R.id.second_weight);
            star =view.findViewById(R.id.second_star);
            image = view.findViewById(R.id.second_image);

            view.setOnClickListener((View.OnClickListener) this);
        }
        public void BindView(int position){
            this.position = position;
            name.setText(SecondList.second_name[position]);
            creator.setText(SecondList.second_creater[position]);
            size.setText(SecondList.second_weight[position]);
            star.setText(SecondList.second_star[position]);
            image.setImageResource(SecondList.second_img[position]);
        }

        @Override
        public void onClick(View v) {
            Log.e("Second RecyclerView", "onClick: OK");
        }
    }
}
