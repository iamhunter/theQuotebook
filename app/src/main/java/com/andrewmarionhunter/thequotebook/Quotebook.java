package com.andrewmarionhunter.thequotebook;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class Quotebook extends ActionBarActivity {
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotebook);

        RelativeLayout touch = (RelativeLayout) findViewById(R.id.touch);
        final TextView quoteText = (TextView) findViewById(R.id.quote);
        final TextView personText = (TextView) findViewById(R.id.person);
        final ArrayList<Quote> quoteList = new ArrayList<Quote>();

        Quote quote1 = new Quote("I don't know who my grandfather was; I am much more concerned to know what his grandson will be.", "Abraham Lincoln");
        quoteList.add(quote1);
        Quote quote2 = new Quote("Since when have we Americans been expected to bow submissively to authority and speak with awe and reverence to those who represent us?", "William O. Douglas");
        quoteList.add(quote2);
        Quote quote3 = new Quote("Under a government which imprisons any unjustly, the true place for a just man is also a prison.", "Henry David Thoreau");
        quoteList.add(quote3);
        Quote quote4 = new Quote("Do one thing every day that scares you.", "Eleanor Roosevelt");
        quoteList.add(quote4);
        Quote quote5 = new Quote("Do you, Ambassador Zorin, deny that the USSR has placed and is placing medium - and intermediate - range missiles and sites in Cuba? Yes or no? Don't wait for the translation. Yes or no?  You are in the courtroom of world opinion. You have denied they exist, and I want to know if I understood you correctly. I am prepared to wait for my answer until hell freezes over. And I am also prepared to present the evidence in this room!", "Adlai Stevenson");
        quoteList.add(quote5);
        touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count < quoteList.size()) {
                    Quote q = quoteList.get(count);
                    quoteText.setText(q.getQuote());
                    personText.setText(q.getPerson());
                    count = count + 1;
                } else{
                    count = 0;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quotebook, menu);
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
