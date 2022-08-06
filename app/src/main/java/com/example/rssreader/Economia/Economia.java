package com.example.rssreader.Economia;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.rssreader.Contacto.Contacto;
import com.example.rssreader.R;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

public class Economia extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar mActionBarToolbar;

    public static boolean verificaConexion(Context ctx) {
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // No sólo wifi, también GPRS
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        // este bucle debería no ser tan ñapa
        for (int i = 0; i < 2; i++) {
            // ¿Tenemos conexión? ponemos a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economia);

        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Economia");

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
        ReadRssEco readRssqro=new ReadRssEco(this,recyclerView);
        if (!verificaConexion(this)) {

            AlertDialog.Builder alert  = new AlertDialog.Builder(this);
            alert.setTitle("Tienes un pequeño problema");
            alert.setMessage("Tu conexion a Internet esta fallando");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,int which)
                {
                    dialog.dismiss();
                }
            });
            alert.show();

        }else {
            readRssqro.execute();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_economia, menu);
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
