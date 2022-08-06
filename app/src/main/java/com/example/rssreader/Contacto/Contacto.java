package com.example.rssreader.Contacto;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.rssreader.R;

public class Contacto extends AppCompatActivity implements View.OnClickListener  {

    Toolbar mActionBarToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contacto);

        //Button btnredaccion = (Button) findViewById(R.id.redaccion);
        //btnredaccion.setOnClickListener(this);

        Button btnSuscripciones = (Button) findViewById(R.id.suscripciones);
        btnSuscripciones.setOnClickListener(this);

        Button btnConmutador = (Button) findViewById(R.id.conmutador);
        btnSuscripciones.setOnClickListener(this);

        Button btnVentas = (Button) findViewById(R.id.ventas);
        btnSuscripciones.setOnClickListener(this);


        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Contacto");

        mActionBarToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

          }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contacto, menu);
        return true;
   }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

     if(v.getId() == R.id.suscripciones) {

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:4422919903"));
            startActivity(intent);

        }else if(v.getId() == R.id.conmutador) {

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:4422919900"));
            startActivity(intent);

        }else if(v.getId() == R.id.ventas){

         Intent intent = new Intent(Intent.ACTION_CALL);
         intent.setData(Uri.parse("tel:4422919902"));
         startActivity(intent);

     }

    }
}
