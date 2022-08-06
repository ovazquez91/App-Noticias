package com.example.rssreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class Pdf extends AppCompatActivity {

    private WebView wv;

    String html = "<iframe src=\"http://static.issuu.com/widgets/shelf/index.html?folderId=781a7ee0-5c4f-4d5f-8251-c9fa82c6f106&amp;theme=theme3&amp;rows=1&amp;thumbSize=medium&amp;roundedCorners=false&amp;showTitle=true&amp;showAuthor=true&amp;shadow=true&amp;effect3d=true\" frameborder=\"0\" style=\"overflow:hidden;height:105%;width:105%;position:absolute;\" height=\"100%\" width=\"100%\"\"></iframe>\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        wv = (WebView)findViewById(R.id.webView);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadDataWithBaseURL("", html, "text/html", "UTF-8", "");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pdf, menu);
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
}
