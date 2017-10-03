package sonhoang.vn.gridview;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView gvGridView;
    private ArrayList<Image> images = new ArrayList<>();
    private ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void setupUI() {
        gvGridView = (GridView) findViewById(R.id.gv_grid_view);
        images.add(new Image("Cupcake", R.drawable.cupcake));
        images.add(new Image("Jellybean", R.drawable.jellybean));
        images.add(new Image("Kitkat", R.drawable.kitkat));
        images.add(new Image("Lollipop", R.drawable.lollipop));
        images.add(new Image("Marshmallow", R.drawable.marshmallow));
        images.add(new Image("Nougat", R.drawable.nougat));
        images.add(new Image("Oreo", R.drawable.oreo));

        imageAdapter = new ImageAdapter(this, images, R.layout.image_element);
        gvGridView.setAdapter(imageAdapter);
    }
}
