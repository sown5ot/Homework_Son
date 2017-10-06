package sonhoang.vn.calling;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString();
    private String callNumber;
    private TextView tvCallNumber;
    private ImageView ivCallButton;
    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPermission();
        setupUI();
        addListeners();
    }

    private void addListeners() {
        ivCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri callNumberUri = Uri.parse("tel:" + callNumber);
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(callNumberUri);
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
                Log.d(TAG, "onClick: " + callNumber);
            }
        });
    }

    private void setupUI() {
        ivCallButton = (ImageView) findViewById(R.id.iv_call_button);
        tvCallNumber = (TextView) findViewById(R.id.tv_dial_numbers);

        callNumber = tvCallNumber.getText().toString();
    }

    private void initPermission() {
        if (Build.VERSION.SDK_INT >= 23){
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        PERMISSION_REQUEST_CODE);
            }
        }
    }
}
