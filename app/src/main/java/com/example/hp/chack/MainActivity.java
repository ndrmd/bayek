package com.example.hp.chack;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;


public class MainActivity extends Activity implements OnClickListener{

	ImageButton fruitBtn = null;
	ImageButton animalBtn = null;
	ImageButton alphabetBtn = null;
	ImageButton numberBtn = null;
	ImageButton monthBtn = null;
	ImageButton weekBtn = null;
	ImageButton drawingBtn = null;
	ImageButton drawingNumberBtn = null;
	
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
		
		
		
		fruitBtn = (ImageButton)findViewById(R.id.fruitId);
		animalBtn = (ImageButton)findViewById(R.id.animalId);
		alphabetBtn = (ImageButton)findViewById(R.id.alphabetId);
		numberBtn = (ImageButton)findViewById(R.id.numberId);
		monthBtn = (ImageButton)findViewById(R.id.monthId);
		weekBtn = (ImageButton)findViewById(R.id.weekId);
		drawingBtn = (ImageButton)findViewById(R.id.drawingId);
		drawingNumberBtn = (ImageButton)findViewById(R.id.drawingNumberId);
		
		fruitBtn.setOnClickListener(this);
		animalBtn.setOnClickListener(this);
		alphabetBtn.setOnClickListener(this);
		numberBtn.setOnClickListener(this);
		monthBtn.setOnClickListener(this);
		weekBtn.setOnClickListener(this);
		drawingBtn.setOnClickListener(this);
		drawingNumberBtn.setOnClickListener(this);
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
		switch (v.getId()) {
		case R.id.fruitId:
			Intent fruitIntent = new Intent(MainActivity.this, FruitsActivity.class);
			fruitIntent.putExtra("type", ResourcePool.FRUIT);
			startActivity(fruitIntent);
			break;
		case R.id.animalId:
			Intent animalIntent = new Intent(MainActivity.this, FruitsActivity.class);
			animalIntent.putExtra("type", ResourcePool.ANIMAL);
			startActivity(animalIntent);
			break;
		case R.id.alphabetId:
			Intent alphabetIntent = new Intent(MainActivity.this, AlphabetActivity.class);
			startActivity(alphabetIntent);
			break;
		case R.id.numberId:
			Intent numberIntent = new Intent(MainActivity.this, NumberActivity.class);
			startActivity(numberIntent);
			break;
		case R.id.monthId:
			Intent monthIntent = new Intent(MainActivity.this, KnowledgeActivity.class);
			monthIntent.putExtra("type", ResourcePool.MONTH);
			startActivity(monthIntent);
			break;
		case R.id.weekId:
			Intent weekIntent = new Intent(MainActivity.this, KnowledgeActivity.class);
			weekIntent.putExtra("type", ResourcePool.WEEK);
			startActivity(weekIntent);
			break;
		case R.id.drawingId:
			Intent dawingIntent = new Intent(MainActivity.this, DrawingActivity.class);
			dawingIntent.putExtra("type", ResourcePool.DRAWING_ALPHABET);
			startActivity(dawingIntent);
			break;
		case R.id.drawingNumberId:
			Intent dawingNumberIntent = new Intent(MainActivity.this, DrawingActivity.class);
			dawingNumberIntent.putExtra("type", ResourcePool.NUMBER);
			startActivity(dawingNumberIntent);
			break;

		default:
			break;
		}
		
	}

}
