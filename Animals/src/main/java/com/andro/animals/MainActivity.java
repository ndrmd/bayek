package com.andro.animals;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends Activity implements OnClickListener {

    ImageButton fruitBtn = null;
    ImageButton animalBtn = null;

    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.taw_activity_main);

		/*AdView adview = (AdView)findViewById(R.id.adView);
		AdRequest re = new AdRequest();
		re.setTesting(true);
		adview.loadAd(re);*/
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-1219685878939660/4111676430");

        // Create ad request.
        AdRequest adRequest = new AdRequest.Builder().build();

        // Begin loading your interstitial.
        interstitial.loadAd(adRequest);

        animalBtn = (ImageButton) findViewById(R.id.animalId);

        //fruitBtn.setOnClickListener(this);
        animalBtn.setOnClickListener(this);
    }

    public void displayInterstitial() {
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        displayInterstitial();
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tawmain, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
		/*switch (v.getId()) {
		case R.id.fruitId:
			Intent fruitIntent = new Intent(MainActivity.this, FruitsActivity.class);
			fruitIntent.putExtra("type", ResourcePool.FRUIT);
			startActivity(fruitIntent);
			break;
		case R.id.animalId:*/
        Intent animalIntent = new Intent(MainActivity.this, FruitsActivity.class);
        animalIntent.putExtra("type", ResourcePool.ANIMAL);
        startActivity(animalIntent);
			/*break;

		default:
			break;
		}*/

    }

}
