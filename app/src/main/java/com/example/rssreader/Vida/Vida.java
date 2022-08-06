package com.example.rssreader.Vida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.rssreader.Contacto.Contacto;
import com.example.rssreader.Opinion.ReadRssOpinion;
import com.example.rssreader.R;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

public class Vida extends AppCompatActivity {

    Toolbar mActionBarToolbar;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinion);

        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Vida y Salúd");

        PublisherAdView adView = (PublisherAdView)findViewById(R.id.banner_300x250);
        PublisherAdRequest request = new PublisherAdRequest.Builder().build();
        adView.loadAd(request);

        mActionBarToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        ReadRssVida readRssvida = new ReadRssVida(this,recyclerView);
        readRssvida.execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vida, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refrescar) {

            Intent refresh = getIntent();
            finish();
            startActivity(refresh);
        }else if (id == R.id.action_contacto){

            Intent contacto = new Intent( this, Contacto.class);
            startActivity(contacto);
        }

        return super.onOptionsItemSelected(item);
    }
}
