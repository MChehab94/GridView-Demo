package mchehab.com.gridviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by muhammadchehab on 12/6/17.
 */

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private List<String> listImageURLs;

    private int imageDimension;

    public GridViewAdapter(Context context, List<String> listImageURLs, int imageDimension){
        this.context = context;
        this.listImageURLs = listImageURLs;
        this.imageDimension = imageDimension;
    }

    @Override
    public int getCount() {
        return listImageURLs.size();
    }

    @Override
    public Object getItem(int position) {
        return listImageURLs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.gridview_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        final float scale = context.getResources().getDisplayMetrics().density;
        int pixels = (int) (imageDimension* scale + 0.5f);

        viewHolder.imageView.setLayoutParams(new LinearLayout.LayoutParams(pixels, pixels));

        Picasso.with(context)
                .load(listImageURLs.get(position))
                .transform(new CropCircleTransformation())
                .into(viewHolder.imageView);

        return convertView;
    }

    public void setImageDimen(int imageDimension) {
        this.imageDimension = imageDimension;
    }

    class ViewHolder{
        ImageView imageView;
    }
}