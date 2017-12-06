package mchehab.com.gridviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> listImageURLs = new ArrayList<>();

    private GridView gridView;
    private GridViewAdapter gridViewAdapter;

    private float width;

    private int imageDimen = 100;
    int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addImageURLs();

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        width = displayMetrics.widthPixels / displayMetrics.density;
        count = (int) width/imageDimen;
        if(savedInstanceState != null){
            count = savedInstanceState.getInt("count");
        }

        imageDimen = (int)(width/count);

        gridView = findViewById(R.id.gridView);
        gridView.setNumColumns(count);
        gridViewAdapter = new GridViewAdapter(this, listImageURLs, imageDimen);
        gridView.setAdapter(gridViewAdapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.one:count = 1;break;
            case R.id.two:count = 2;break;
            case R.id.three:count = 3;break;
            case R.id.four:count = 4;break;
            case R.id.five:count = 5;break;
            case R.id.six:count = 6;break;
            case R.id.seven:count = 7;break;
            case R.id.eight:count = 8;break;
        }

        imageDimen = (int)(width/count);
        gridViewAdapter.setImageDimen(imageDimen);
        gridView.setNumColumns(count);

        return true;
    }

    private void addImageURLs(){
        listImageURLs.add("http://i.dailymail.co.uk/i/pix/2016/04/12/23/3319F89C00000578-3536787-image-m-19_1460498410943.jpg");
        listImageURLs.add("https://www.w3schools.com/css/img_forest.jpg");
        listImageURLs.add("https://www.w3schools.com/css/trolltunga.jpg");
        listImageURLs.add("https://www.w3schools.com/css/pineapple.jpg");
        listImageURLs.add("https://cdn.arstechnica.net/wp-content/uploads/2016/02/5718897981_10faa45ac3_b-640x624.jpg");
        listImageURLs.add("https://www.w3schools.com/css/paris.jpg");
        listImageURLs.add("https://www.w3schools.com/css/paris.jpg");
        listImageURLs.add("https://www.w3schools.com/css/trolltunga.jpg");
        listImageURLs.add("https://www.w3schools.com/css/lights600x400.jpg");
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-11.jpg");
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-15.jpg");
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-19.jpg");
        listImageURLs.add("https://cdn.spacetelescope.org/archives/images/thumb700x/heic1509a.jpg");
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-12.jpg");
        listImageURLs.addAll(listImageURLs);
    }
}