package com.example.hp.chack;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;


public class FruitsActivity extends Activity implements OnClickListener, OnTouchListener {
	private String type = "";

	ImageView nextBtn = null;
	ImageView playBtn = null;
	ImageView prevBtn = null;

	ImageView itemImage = null;
	ImageView itemName = null;

	private int currentPosition = 0;
	private int totalItem = 0;
	
	private MediaPlayer mediaPlayer = null;

	ResourcePool resourcePool = new ResourcePool();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.taw_activity_detail);

		AdView adView = (AdView)this.findViewById(R.id.adView);
		
		AdRequest adRequest = new AdRequest.Builder()
		    .build();
		adView.loadAd(adRequest);
		
		
		Bundle bundle = getIntent().getExtras();
		type = bundle.getString("type");

		nextBtn = (ImageView) findViewById(R.id.nextId);
		playBtn = (ImageView) findViewById(R.id.playId);
		prevBtn = (ImageView) findViewById(R.id.prevId);
		nextBtn.setOnTouchListener(this);
		playBtn.setOnTouchListener(this);
		prevBtn.setOnTouchListener(this);
		
		itemImage = (ImageView) findViewById(R.id.itemImageId);
		itemName = (ImageView) findViewById(R.id.itemNameId);

		nextBtn.setOnClickListener(this);
		playBtn.setOnClickListener(this);
		prevBtn.setOnClickListener(this);
		itemImage.setOnClickListener(this);
		itemName.setOnClickListener(this);

		if (type.equals(ResourcePool.FRUIT)) {
			totalItem = resourcePool.fruitImages.length;
			itemImage.setImageResource(resourcePool.fruitImages[currentPosition]);
			itemName.setImageResource(resourcePool.fruitsNames[currentPosition]);
		} else {
			totalItem = resourcePool.animalImages.length;
			itemImage.setImageResource(resourcePool.animalImages[currentPosition]);
			itemName.setImageResource(resourcePool.animalNames[currentPosition]);
		}
		playSound();
		
		updatePreviousButton();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tawmain, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.nextId:
			gotoNext();
			break;
		case R.id.prevId:
			gotoPrevious();
			break;
		case R.id.playId:
			playSound();
			break;
		case R.id.itemImageId:
		case R.id.itemNameId:
			if(type.equals(ResourcePool.FRUIT))
			{
				mediaPlayer = MediaPlayer.create(FruitsActivity.this, resourcePool.fruitsSound[currentPosition]);
			}
			else{
				mediaPlayer = MediaPlayer.create(FruitsActivity.this, resourcePool.animalSound[currentPosition]);
			}
			mediaPlayer.start();
			break;
			

		default:
			break;
		}
	}

	private void gotoNext(){
		currentPosition++;
		updateNextButton();
		updatePreviousButton();
		if(currentPosition >= 0 && currentPosition < totalItem)
		{
			if(type.equals(ResourcePool.FRUIT))
			{
				itemImage.setImageResource(resourcePool.fruitImages[currentPosition]);
				itemName.setImageResource(resourcePool.fruitsNames[currentPosition]);
			}
			else{
				itemImage.setImageResource(resourcePool.animalImages[currentPosition]);
				itemName.setImageResource(resourcePool.animalNames[currentPosition]);
			}
			playSound();
		}
	}
	
	private void updateNextButton(){
		if(currentPosition == totalItem - 1){
			nextBtn.setAlpha(0.5f);
			nextBtn.setClickable(false);
		}
		else{
			nextBtn.setAlpha(1f);
			nextBtn.setClickable(true);
		}
	}
	
	private void updatePreviousButton(){
		if(currentPosition == 0){
			prevBtn.setAlpha(0.5f);
			prevBtn.setClickable(false);
		}
		else{
			prevBtn.setAlpha(1f);
			prevBtn.setClickable(true);
		}
	}

	private void gotoPrevious() {
		currentPosition--;
		updateNextButton();
		updatePreviousButton();
		if(currentPosition >= 0 && currentPosition < totalItem)
		{
			if(type.equals(ResourcePool.FRUIT))
			{
				itemImage.setImageResource(resourcePool.fruitImages[currentPosition]);
				itemName.setImageResource(resourcePool.fruitsNames[currentPosition]);
			}
			else{
				itemImage.setImageResource(resourcePool.animalImages[currentPosition]);
				itemName.setImageResource(resourcePool.animalNames[currentPosition]);
			}
			playSound();
		}
	}

	private void playSound() {
		if(type.equals(ResourcePool.FRUIT))
		{
			mediaPlayer = MediaPlayer.create(FruitsActivity.this, resourcePool.fruitsSound[currentPosition]);
		}
		else{
			mediaPlayer = MediaPlayer.create(FruitsActivity.this, resourcePool.animalSound[currentPosition]);
		}
		mediaPlayer.start();
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			v.setAlpha(0.5f);
			break;
		case MotionEvent.ACTION_UP:
			v.setAlpha(1.0f);
			break;

		default:
			break;
		}
		return false;
	}

}
