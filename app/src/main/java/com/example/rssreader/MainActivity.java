package com.example.rssreader;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v4.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.rssreader.Cine.Cine;
import com.example.rssreader.Contacto.Contacto;
import com.example.rssreader.Deportes.Deportes;
import com.example.rssreader.Economia.Economia;
import com.example.rssreader.FragmentPulso;
import com.example.rssreader.FragmentAM;
import com.example.rssreader.Mujer.Mujer;
import com.example.rssreader.Noticias.Mexico;
import com.example.rssreader.Noticias.Mundo;
import com.example.rssreader.Noticias.Queretaro;
import com.example.rssreader.Opinion.Opinion;
import com.example.rssreader.Vida.Vida;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, FragmentDrawer.FragmentDrawerListener {
    RecyclerView recyclerView;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentDrawer drawerFragment;


    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //TOOLBAR
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setLogo(R.drawable.logoamgris);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            //TOOLBAR

            // MENU
            drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
            drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
            drawerFragment.setDrawerListener(this);
            //MENU

            //TABS
            tabLayout = (TabLayout) findViewById(R.id.tabLayout);
            tabLayout.addTab(tabLayout.newTab().setText("Pulso AM"));
            tabLayout.addTab(tabLayout.newTab().setText("Reportajes"));
            tabLayout.addTab(tabLayout.newTab().setText("Impreso"));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            viewPager = (ViewPager) findViewById(R.id.pager);
            Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());
            viewPager.setAdapter(adapter);
            tabLayout.setOnTabSelectedListener(this);
            //TAB

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            android.os.Process.killProcess(android.os.Process.myPid());// Kill the app on click of back button.
        }
        return super.onKeyDown(keyCode, event);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.title_home);
        switch (position) {
            case 0:
                Intent qro = new Intent(this, Queretaro.class);
                startActivity(qro);
                break;
            case 1:
                Intent mexico = new Intent(this, Mexico.class);
                startActivity(mexico);
                //fragment = new FragmentPulso(
                break;
            case 2:
                Intent mundo = new Intent(this, Mundo.class);
                startActivity(mundo);
                break;
            case 3:
                Intent economia = new Intent(this, Economia.class);
                startActivity(economia);
                break;
            case 4:
                Intent deportes = new Intent(this, Deportes.class);
                startActivity(deportes);
                break;

            case 5:
                Intent mujer = new Intent(this, Mujer.class);
                startActivity(mujer);
                break;

            case 6:
                Intent vida = new Intent(this, Vida.class);
                startActivity(vida);
                break;

            case 7:
                Intent opinion = new Intent(this, Opinion.class);
                startActivity(opinion);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
}
