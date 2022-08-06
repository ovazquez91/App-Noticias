package com.example.rssreader;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rssreader.Noticias.ReadRssQro;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

public class FragmentPulso extends Fragment {

    TextView textView;

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

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        PublisherAdView adView = (PublisherAdView)view.findViewById(R.id.banner_300x250);
        PublisherAdRequest request = new PublisherAdRequest.Builder().build();
        adView.loadAd(request);

        recyclerView= (RecyclerView) view.findViewById(R.id.recyclerview);
        ReadPulso readRss = new ReadPulso(this.getContext(), recyclerView);

        if (!verificaConexion(getContext())) {
            AlertDialog.Builder alert  = new AlertDialog.Builder(getContext());
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
            readRss.execute();
        }

        return view;
    }
}
