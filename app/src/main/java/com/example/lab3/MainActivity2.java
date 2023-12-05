package com.example.lab3;

import android.content.Intent;
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

public class MainActivity2 extends AppCompatActivity {

    ListView lv;
    GridView grid;
    String[] countries = {"Jordan", "Palestine", "Syria", "Lebanon"};
    TextView tv;
    int[] countriesImages = {R.drawable.jordan, R.drawable.palestine, R.drawable.syria, R.drawable.lebanon};

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
                switch (position){
                    case 0:
                        Intent i = new Intent(MainActivity2.this, Jordan.class);
                        break;
                    case 1:
                         i = new Intent(MainActivity2.this, Palestine.class);
                        break;
                    case 2:
                         i = new Intent(MainActivity2.this, Syria.class);
                        break;
                    case 3:
                         i = new Intent(MainActivity2.this, Lebanon.class);
                        break;
                }
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return countries.length;
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
            TextView text = view.findViewById(R.id.tv1);
            ImageView images = view.findViewById(R.id.im1);
            text.setText(countries[position]);
            images.setImageResource(countriesImages[position]);
            return view;
        }
    }
}