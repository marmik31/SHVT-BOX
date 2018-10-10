package info.androidhive.firebase;

import android.view.View;

/**
 * Created by Krunal on 6/16/2017.
 */

public interface ClickListener {
    void onClick(View view, int position);
    void onLongClick(View view, int position);
}
