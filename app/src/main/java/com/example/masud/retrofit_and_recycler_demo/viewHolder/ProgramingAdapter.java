package com.example.masud.retrofit_and_recycler_demo.viewHolder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.masud.retrofit_and_recycler_demo.R;
import com.example.masud.retrofit_and_recycler_demo.model.User;

public class ProgramingAdapter extends RecyclerView.Adapter<ProgramingAdapter.ProgrammingViewholder>{

    private Context context;
    private User[] data;
    public ProgramingAdapter(Context context,User[] user){
        this.context=context;
        this.data=user;

    }

    @NonNull
    @Override
    public ProgrammingViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.github_item_view, viewGroup,false);

        return new ProgrammingViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewholder holder, int i) {
    final User user=data[i];
    holder.textView.setText(user.getLogin());
        Glide.with(holder.imageView.getContext()).load(user.getAvatarUrl()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               // Toast.makeText(context, user.getLogin()+"was clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public  class ProgrammingViewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ProgrammingViewholder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.iv_image);
            textView=itemView.findViewById(R.id.tv_name);
        }
    }

}




//Another Example for code..............
/*extends RecyclerView.Adapter<ProgramingAdapter.ProgrammingViewholder>
    private String[] data;

    public ProgramingAdapter(String[] data)
    {
        this.data=data;
    }

    @NonNull
    @Override
    public ProgrammingViewholder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.programming_list_item, parent,false);
        return new ProgrammingViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewholder programmingViewholder, int i) {
        String title=data[i];
        programmingViewholder.textView.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ProgrammingViewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ProgrammingViewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_picture);
            textView=itemView.findViewById(R.id.tv_text);
        }
    }*/