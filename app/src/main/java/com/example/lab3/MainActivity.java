package com.example.lab3;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.lab3.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    GridView grid;
    String[] flowers = {"Jordan", "Palestine", "Syria"};
    TextView tv;
    int[] flowerImages = {R.drawable.jordan, R.drawable.palestine, R.drawable.syria};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        CustomAdapter flowerCA = new CustomAdapter();
        lv.setAdapter(flowerCA);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, flowers[position], Toast.LENGTH_SHORT).show();
            }
        });
        grid = findViewById(R.id.grid);
        ArrayAdapter gridAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, flowers);
        grid.setAdapter(gridAdapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this, flowers[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, flowers[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, flowers[position], Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        tv = findViewById(R.id.tv2);
        RatingBar rb;
        rb = findViewById(R.id.rb);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tv.setText(String.valueOf(rb.getRating()));
//                tv.setText("Your rating "+String.valueOf(rb.getRating()));
            }
        });

    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return flowers.length;
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
            View view = getLayoutInflater().inflate(R.layout.row, null);
            TextView text = view.findViewById(R.id.flowers);
            ImageView images = view.findViewById(R.id.images);
            text.setText(flowers[position]);
            images.setImageResource(flowerImages[position]);
            return view;
        }
    }
}