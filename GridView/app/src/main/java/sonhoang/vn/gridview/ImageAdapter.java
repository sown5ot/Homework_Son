package sonhoang.vn.gridview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Son Hoang on 9/30/2017.
 */

public class ImageAdapter extends BaseAdapter {
    private List<Image> images = new ArrayList<>();
    private int layout;
    private Context context;

    public ImageAdapter(Context context, List<Image> images, int layout) {
        this.context = context;
        this.images = images;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_image);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.tv_image_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Image image = images.get(position);
        viewHolder.imageView.setBackgroundResource(image.getImage());
        viewHolder.imageView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                500
        ));
        viewHolder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.imageView.setPadding(5, 5, 5, 5);
        viewHolder.imageView.setCropToPadding(true);
        viewHolder.textView.setText(image.getImageName());


        return convertView;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView textView;
    }

}
