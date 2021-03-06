package com.example.retrofittesting.ui.posts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittesting.R;

import java.util.List;

import mechanics.RandomDate;
import retrofitPojoClasses.PojoPostData;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {
    private List<PojoPostData> data;
    private final LayoutInflater inflater;
    PostsAdapter(Context context, List<PojoPostData> data){
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }
    // возвращает холдер, который будет хранить данные по одному объекту
    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.post_list_item,parent,false);
        return new ViewHolder(view);
    }

    //выполняет привязку объекта холдер к объекту
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PojoPostData state = data.get(position);
        holder.textTitle.setText(state.getTitle());
        holder.textBody.setText(state.getBody());
        holder.textDate.setText(RandomDate.getRandomDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle;
        TextView textBody;
        TextView textDate;
        ViewHolder(View view) {
            super(view);
            textTitle =(TextView) view.findViewById(R.id.post_text_title);
            textBody =(TextView) view.findViewById(R.id.post_text_body);
            textDate = (TextView) view.findViewById(R.id.post_text_date);

        }
    }
}