package com.example.rssreader;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.Toast;


import com.example.rssreader.Opinion.Opinion;
import com.example.rssreader.Opinion.ReadRssOpinion;

import java.util.zip.Inflater;


public class FragmentAM extends Fragment implements View.OnClickListener {

      RecyclerView recyclerView;
      ImageButton phoy, excelsior, vsd, cinefila, mujer, faro;

      public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          View view = inflater.inflate(R.layout.fragment_first, container, false);

          phoy = (ImageButton) view.findViewById(R.id.btnPeriodicohoy);
          phoy.setOnClickListener(this);

          excelsior = (ImageButton) view.findViewById(R.id.btnExcelsior);
          excelsior.setOnClickListener(this);

          vsd = (ImageButton) view.findViewById(R.id.btnVsd);
          vsd.setOnClickListener(this);

          cinefila = (ImageButton) view.findViewById(R.id.btnCinefila);
          cinefila.setOnClickListener(this);

          mujer = (ImageButton) view.findViewById(R.id.btnMujer);
          mujer.setOnClickListener(this);

          faro = (ImageButton) view.findViewById(R.id.btnFaro);
          faro.setOnClickListener(this);


          super.onCreateView(inflater, container, savedInstanceState);
          return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnPeriodicohoy) {

            String url = "https://issuu.com/periodicoamqueretaro/stacks/781a7ee05c4f4d5f8251c9fa82c6f106";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }else if(v.getId() == R.id.btnExcelsior){

            String url = "https://issuu.com/periodicoamqueretaro/stacks/36e0d1b658384c75a55773051c04a2cd";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }else if(v.getId() == R.id.btnVsd){

            String url = "https://issuu.com/periodicoamqueretaro/stacks/87c73b629b6740cb97e12c1254ae1e8d";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }else if(v.getId() == R.id.btnFaro){

            String url = "https://issuu.com/periodicoamqueretaro/stacks/aedc4c1270094354bd711fe8193c2379";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }else if(v.getId() == R.id.btnMujer){

            String url = "https://issuu.com/periodicoamqueretaro/stacks/41deb5422f6a430d90763bc28d657112";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }else if(v.getId() == R.id.btnCinefila){

            String url = "https://issuu.com/cinefila";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);


        }
    }
}
