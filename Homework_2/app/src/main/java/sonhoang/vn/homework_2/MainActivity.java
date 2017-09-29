package sonhoang.vn.homework_2;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.toString();
    private FloatingActionButton fbAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
        addListeners();
    }

    private void addListeners() {
        fbAddButton.setOnClickListener(this);
    }

    private void setupUI() {
        fbAddButton = (FloatingActionButton) findViewById(R.id.fb_add_button);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fb_add_button:{
                addImage();
                break;
            }
        }
    }

    private void addImage() {
        LinearLayout llImageView = (LinearLayout) findViewById(R.id.ll_image_view);
        ViewImage viewImage = new ViewImage(this);
        llImageView.addView(viewImage);
    }

}
