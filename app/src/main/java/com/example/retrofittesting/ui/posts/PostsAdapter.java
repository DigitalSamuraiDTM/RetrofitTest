package com.example.retrofittesting.ui.posts;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittesting.MainActivity;
import com.example.retrofittesting.MainApplication;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)  {
        PojoPostData state = data.get(position);
        holder.pojoPostData = state;
        holder.id = state.getId();
        holder.userId = state.getUserId();
        holder.textTitle.setText(state.getTitle());
        holder.textTitle.setTransitionName(String.valueOf(R.string.trans_post_title)+position);
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
        PojoPostData pojoPostData;
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

            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.getActivity(),textTitle, (ViewCompat.getTransitionName(textTitle)+getAdapterPosition()));
            ActivityNavigator.Extras extras = new ActivityNavigator.Extras.Builder().setActivityOptions(optionsCompat).build();
            NavController navigation = Navigation.findNavController(view);
            Bundle bundle = new Bundle();

            bundle.putParcelable("post", pojoPostData);

            navigation.navigate(R.id.action_navigation_posts_to_selectedPostFragment,bundle,null,extras);

        }
    }
}