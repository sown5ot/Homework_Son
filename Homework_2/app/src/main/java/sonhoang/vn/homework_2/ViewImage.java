package sonhoang.vn.homework_2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by Son Hoang on 9/30/2017.
 */

public class ViewImage extends View {
    private final int MARGINDEFAULT = 16;

    public ViewImage(Context context) {
        super(context);
        setRandomImage();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int viWidth = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(viWidth, viWidth / 2);

        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.setMargins(MARGINDEFAULT, MARGINDEFAULT, MARGINDEFAULT, MARGINDEFAULT);
        requestLayout();
    }

    private void setRandomImage() {
        Random random = new Random();
        int ivChoose = random.nextInt(5) + 1;

        switch (ivChoose){
            case 1:
                setBackgroundResource(R.drawable.food_1);
                break;
            case 2:
                setBackgroundResource(R.drawable.food_2);
                break;
            case 3:
                setBackgroundResource(R.drawable.food_3);
                break;
            case 4:
                setBackgroundResource(R.drawable.food_4);
                break;
            case 5:
                setBackgroundResource(R.drawable.food_5);
                break;
        }
    }
}
