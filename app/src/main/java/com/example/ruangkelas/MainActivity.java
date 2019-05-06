package com.example.ruangkelas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String title = "Mode List";
    final String STATE_TITLE = "state_string";
    final String STATE_MODE = "state_mode";
    int mode;

    private ArrayList<String> NamaPemain = new ArrayList<>();
    private ArrayList<String> PosisiPemain = new ArrayList<>();
    private ArrayList<String> LinkGambar = new ArrayList<>();
    private ArrayList<String> NoPemain = new ArrayList<>();
    private ArrayList<String> UmurPemain = new ArrayList<>();
    private ArrayList<String> WargaNegaraPemain = new ArrayList<>();
    private ArrayList<String> DetailPemain = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate:started.");
        initImageBitmaps();

        if (savedInstanceState == null) {
            setActionBarTitle("RuangKelas");
            showListActivity();
            mode = R.id.action_list;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            setMode(stateMode);
        }
    }

    private void initImageBitmaps() {
        LinkGambar.add("https://www.pinclipart.com/picdir/middle/40-402207_clip-arts-related-to-iron-man-face-vector.png");
        NamaPemain.add("Bilal Suryananda");
        PosisiPemain.add("Taman Griya");
        UmurPemain.add("36 Tahun");
        WargaNegaraPemain.add("Chile");
        NoPemain.add("1");
        DetailPemain.add("Kiper Manchester City, dengan nomor punggung 1. Lahir pada 13 April 1983, di Viluco, Chile. Bergabung dengan Manchester City sejak 25 August 2016");

        LinkGambar.add("https://www.pinclipart.com/picdir/middle/40-402207_clip-arts-related-to-iron-man-face-vector.png");
        NamaPemain.add("Ari Wiradana");
        PosisiPemain.add("Kerobokan");
        UmurPemain.add("36 Tahun");
        WargaNegaraPemain.add("Chile");
        NoPemain.add("1");
        DetailPemain.add("Kiper Manchester City, dengan nomor punggung 1. Lahir pada 13 April 1983, di Viluco, Chile. Bergabung dengan Manchester City sejak 25 August 2016");

        LinkGambar.add("https://www.pinclipart.com/picdir/middle/40-402207_clip-arts-related-to-iron-man-face-vector.png");
        NamaPemain.add("Aditya Mahendra");
        PosisiPemain.add("Denpasar");
        UmurPemain.add("36 Tahun");
        WargaNegaraPemain.add("Chile");
        NoPemain.add("1");
        DetailPemain.add("Kiper Manchester City, dengan nomor punggung 1. Lahir pada 13 April 1983, di Viluco, Chile. Bergabung dengan Manchester City sejak 25 August 2016");

        LinkGambar.add("https://www.pinclipart.com/picdir/middle/40-402207_clip-arts-related-to-iron-man-face-vector.png");
        NamaPemain.add("Dwiki Krisnanda");
        PosisiPemain.add("Denpasar");
        UmurPemain.add("36 Tahun");
        WargaNegaraPemain.add("Chile");
        NoPemain.add("1");
        DetailPemain.add("Kiper Manchester City, dengan nomor punggung 1. Lahir pada 13 April 1983, di Viluco, Chile. Bergabung dengan Manchester City sejak 25 August 2016");

        LinkGambar.add("https://www.pinclipart.com/picdir/middle/40-402207_clip-arts-related-to-iron-man-face-vector.png");
        NamaPemain.add("Dimas Aresta");
        PosisiPemain.add("Kelungkung");
        UmurPemain.add("36 Tahun");
        WargaNegaraPemain.add("Chile");
        NoPemain.add("1");
        DetailPemain.add("Kiper Manchester City, dengan nomor punggung 1. Lahir pada 13 April 1983, di Viluco, Chile. Bergabung dengan Manchester City sejak 25 August 2016");

        showListActivity();

    }

    private void showHome(){
        setContentView(R.layout.home_layout);
    }

    private void showListActivity() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AssigmentActivity adapter = new AssigmentActivity(this, NamaPemain, LinkGambar, PosisiPemain, DetailPemain, NoPemain, UmurPemain, WargaNegaraPemain);
        recyclerView.setAdapter(adapter);

    }

    /*private void showCardViewActivity() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CardViewActivity adapter = new CardViewActivity(this, NamaPemain, LinkGambar, PosisiPemain, DetailPemain, NoPemain, UmurPemain, WargaNegaraPemain);
        recyclerView.setAdapter(adapter);
    }

    private void showGridActivity() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        GridActivity adapter = new GridActivity(this, NamaPemain, LinkGambar, PosisiPemain, DetailPemain, NoPemain, UmurPemain, WargaNegaraPemain);
        recyclerView.setAdapter(adapter);

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showListActivity();
                break;

            /*case R.id.action_grid:
                title = "Mode Grid";
                showGridActivity();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showCardViewActivity();
                break;*/
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putInt(STATE_MODE, mode);
    }
}