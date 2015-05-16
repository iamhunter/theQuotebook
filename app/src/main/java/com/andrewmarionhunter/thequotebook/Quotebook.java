package com.andrewmarionhunter.thequotebook;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;


public class Quotebook extends ActionBarActivity {
    int count = 0;

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotebook);

        setTitle("My new title");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2054016110375376/7500253841");

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("YOUR_DEVICE_HASH")
                .build();

        mInterstitialAd.loadAd(adRequest);

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
        Quote quote5 = new Quote("Sitting at the table doesn't make you a diner, unless you eat some of what's on that plate. Being here in America doesn't make you an American. Being born here in America doesn't make you an American.", "Malcolm X");
        quoteList.add(quote5);
        Quote quote6 = new Quote("All free men, wherever they may live, are citizens of Berlin, and therefore, as a free man, I take pride in the words, Ich bin ein Berliner.", "John F. Kennedy");
        quoteList.add(quote6);
        Quote quote7 = new Quote("Is life so dear or peace so sweet as to be purchased at the price of chains and slavery? Forbid it, Almighty God! I know not what course others may take, but as for me, give me liberty, or give me death!", "Patrick Henry");
        quoteList.add(quote7);
        Quote quote8 = new Quote("No man is good enough to govern another man without his consent.", "Abraham Lincoln");
        quoteList.add(quote8);
        Quote quote9 = new Quote("No man is good enough to govern any woman without her consent.", "Susan B. Anthony");
        quoteList.add(quote9);
        Quote quote10 = new Quote("So, first of all, let me assert my firm belief that the only thing we have to fear is fear itself -- nameless, unreasoning, unjustified terror which paralyzes needed efforts to convert retreat into advance.", "Franklin D. Roosevelt");
        quoteList.add(quote10);
        Quote quote11 = new Quote("I think the most un-American thing you can say is, 'You can't say that.", "Garrison Keillor");
        quoteList.add(quote11);
        Quote quote12 = new Quote("Free speech is not to be regulated like diseased cattle and impure butter. The audience that hissed yesterday may applaud today, even for the same performance.", "William O. Douglas");
        quoteList.add(quote12);
        Quote quote13 = new Quote("I do not believe that women are better than men. We have not wrecked railroads, nor corrupted legislatures, nor done many unholy things that men have done; but then we must remember that we have not had the chance.", "Jane Addams");
        quoteList.add(quote13);
        Quote quote14 = new Quote("The Constitution only guarantees the American people the right to pursue happiness. You have to catch it yourself.", "Benjamin Franklin");
        quoteList.add(quote14);
        Quote quote15 = new Quote("What we obtain too cheap, we esteem too lightly; it is dearness only that gives everything its value", "Thomas Paine");
        quoteList.add(quote15);
        touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count < quoteList.size()) {
                    Quote q = quoteList.get(count);
                    quoteText.setText(q.getQuote());
                    personText.setText(q.getPerson());
                    count = count + 1;
                } else{
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }

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

}
