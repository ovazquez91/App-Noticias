package com.example.rssreader;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ParseException;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.format.DateFormat;
import android.text.format.Formatter;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;


import com.example.rssreader.Cine.Cine;
import com.example.rssreader.Contacto.Contacto;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;

public class NewsDetails extends AppCompatActivity implements View.OnClickListener {

    WebView webView;
    TextView fecha;
    TextView title;
    TextView descripcion;
    ImageView Thumbnail;
    Toolbar mActionBarToolbar;
    String liga = "";
    String pubDate = "";
    SimpleDateFormat format;
    //Button btnCompartir;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        Button btnCompartir = (Button) findViewById(R.id.btnCompartir);
        btnCompartir.setOnClickListener(this);
        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);


        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Noticias");

        PublisherAdView adView = (PublisherAdView)findViewById(R.id.banner_ad);
        PublisherAdRequest request = new PublisherAdRequest.Builder().build();
        adView.loadAd(request);

        mActionBarToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //webView = (WebView) findViewById(R.id.webview);
        fecha = (TextView) findViewById(R.id.fecha);
        title = (TextView) findViewById(R.id.tittle);
        descripcion = (TextView) findViewById(R.id.description);
        Bundle bundle = getIntent().getExtras();
        // webView.loadUrl(bundle.getString("link"));
        title.setText(bundle.getString("title"));
        //CharSequence textoInterpretado = Html.fromHtml(bundle.getString("content:encoded"));

        descripcion.setText(Html.fromHtml(bundle.getString("content:encoded")));
        //descripcion.setMovementMethod(new ScrollingMovementMethod());

        liga = bundle.getString("link");
        pubDate = bundle.getString("pubDate");

        fecha.setText(pubDate);
        Thumbnail= (ImageView) findViewById(R.id.imageDetail);
        Picasso.with(this).load(bundle.getString("thumb")).into(Thumbnail);



    }

    public void onClick (View v)
    {

        if (v.getId() == R.id.btnCompartir) {
            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "asunto");//se usará por ejemplo para email
            intent.putExtra(Intent.EXTRA_TEXT, liga);
            startActivity(Intent.createChooser(intent, "Compartir usando"));
        }

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*
        if (id == R.id.action_compartir) {


            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "asunto");//se usará por ejemplo para email
            intent.putExtra(Intent.EXTRA_TEXT, liga);
            intent.setPackage("com.whatsapp");

            try {
                startActivity(intent);

            } catch (Exception e) {
                AlertDialog.Builder alert  = new AlertDialog.Builder(this);
                alert.setTitle("Tienes un pequeño problema");
                alert.setMessage("No tienes instalada la aplicación de Whatsapp");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which)
                    {
                        dialog.dismiss();

                    }
                });
                alert.show();
            }


        }else if(id == R.id.action_facebook){

            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "asunto");//se usará por ejemplo para email
            intent.putExtra(Intent.EXTRA_TEXT, liga);
            intent.setPackage("com.facebook.katana");
            try {
                startActivity(intent);

            } catch (Exception e) {
                AlertDialog.Builder alert  = new AlertDialog.Builder(this);
                alert.setTitle("Tienes un pequeño problema");
                alert.setMessage("No tienes instalada la aplicación de Facebook");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which)
                    {
                        dialog.dismiss();

                    }
                });
                alert.show();
            }

        }else if(id == R.id.action_twitter){

            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "asunto");//se usará por ejemplo para email
            intent.putExtra(Intent.EXTRA_TEXT, liga);
            intent.setPackage("com.twitter.android");

            try {
                startActivity(intent);

            } catch (Exception e) {
                AlertDialog.Builder alert  = new AlertDialog.Builder(this);
                alert.setTitle("Tienes un pequeño problema");
                alert.setMessage("No tienes instalada la aplicación de twitter");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which)
                    {
                        dialog.dismiss();

                    }
                });
                alert.show();
            }


        }else
        */if(id == R.id.action_CambioT){

            descripcion.setTextSize(20);

        }else if(id == R.id.action_Refrescar){

            Intent refresh = getIntent();
            finish();
            startActivity(refresh);

        }else if(id == R.id.action_share){

            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "asunto");//se usará por ejemplo para email
            intent.putExtra(Intent.EXTRA_TEXT, liga);
            startActivity(Intent.createChooser(intent, "Compartir usando"));

        }else if(id == R.id.action_contacto){

            Intent contacto = new Intent(this, Contacto.class);
            startActivity(contacto);

            /*   llamada
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:4422499308"));
            startActivity(intent);*/
        }

        return super.onOptionsItemSelected(item);
    }
}
