package mechanics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.retrofittesting.MainApplication;

public class InternetAccess {
    public static boolean isConnected(){
        ConnectivityManager manager = (ConnectivityManager) MainApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return (manager.getActiveNetworkInfo() != null && manager.getActiveNetworkInfo().isConnected());
    }
}
