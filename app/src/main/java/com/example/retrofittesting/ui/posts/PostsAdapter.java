package com.example.retrofittesting.ui.posts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittesting.MainActivity;
import com.example.retrofittesting.R;

import java.util.List;

import mechanics.RandomDate;
import retrofitPojoClasses.PojoPostData;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {
    private List<PojoPostData> data;
    private final LayoutInflater inflater;
    private NavController controller;
    PostsAdapter(Context context, List<PojoPostData> data, NavController controller){
        this.data = data;
        this.controller = controller;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)  {
        PojoPostData state = data.get(position);
        holder.id = state.getId();
        holder.userId = state.getUserId();
        holder.textTitle.setText(state.getTitle());
        holder.textBody.setText(state.getBody());
        holder.textDate.setText(RandomDate.getRandomDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textTitle;
        TextView textBody;
        TextView textDate;
        int id;
        int userId;

        RelativeLayout layoutPost;
        ViewHolder(View view) {
            super(view);
            textTitle =(TextView) view.findViewById(R.id.post_text_title);
            textBody =(TextView) view.findViewById(R.id.post_text_body);
            textDate = (TextView) view.findViewById(R.id.post_text_date);
            layoutPost = (RelativeLayout) view.findViewById(R.id.post__main_lay);

            textBody.setOnClickListener(this);
            layoutPost.setOnClickListener(this);
            textDate.setOnClickListener(this);
        }

        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.post__main_lay:
                    Log.d("TAG","Clicked lay: "+String.valueOf(userId));
                    break;
                case R.id.post_text_body:
                    Log.d("TAG","Clicked textview: "+String.valueOf(userId));
                    break;
                case R.id.post_text_date:
                    Log.d("TAG","Clicked date view: "+String.valueOf(id));
                    break;
            }

            NavController navigation = Navigation.findNavController(view);
            navigation.navigate(R.id.action_navigation_posts_to_selectedPostFragment);
        }
    }
}