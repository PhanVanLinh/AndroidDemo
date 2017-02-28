package example.toong.testuservisiblehint;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragment3 extends Fragment {
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("Linh", "Tab3 oncreate" + getUserVisibleHint());
        return inflater.inflate(R.layout.tab_fragment_3, container, false);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i("Linh","Tab3 isVisible "+isVisibleToUser+""+isResumed());
    }
}