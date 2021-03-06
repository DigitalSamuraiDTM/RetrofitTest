package mechanics.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofitPojoClasses.PojoPostData;

public interface JSONPlaceHolderApi {
    @GET("/posts/{id}")
    public Call<PojoPostData> getPostWithId(@Path("id") int id);
    @GET("/posts")
    public Call<List<PojoPostData>> getPosts();
//    @GET("/comments/{userId}")
//    public Call<PojoCommentData> getCommentWithUserId(@Path("userId") int userId);
//    @GET("/comments")
//    public Call<List<PojoCommentData>> getCommentsOfPostId(@Query("postId") int postId);
}