package selectedpost;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.retrofittesting.R;

import retrofitPojoClasses.PojoPostData;

public class SelectedPostFragment extends Fragment {

    TextView title;
    TextView body;
    TextView date;
    TextView author;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_selected_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();

        PojoPostData data = getArguments().getParcelable("post");
        title.setText(data.getTitle());
        body.setText(data.getBody());
        
    }

    private void initView(){
        title = (TextView) getView().findViewById(R.id.selPost_view_title);
        body = (TextView) getView().findViewById(R.id.selPost_view_body);
        author = (TextView) getView().findViewById(R.id.selPost_view_author);
        date = (TextView) getView().findViewById(R.id.selPost_view_date);
    }
}