package example.toong.testuservisiblehint;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragment1 extends Fragment {
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("Linh", "Tab1 oncreate"+ getUserVisibleHint());
        return inflater.inflate(R.layout.tab_fragment_1, container, false);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i("Linh","Tab1 isVisible "+isVisibleToUser+ ""+isResumed());
    }
}