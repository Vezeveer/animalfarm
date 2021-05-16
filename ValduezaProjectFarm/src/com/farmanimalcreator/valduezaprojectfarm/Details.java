package com.farmanimalcreator.valduezaprojectfarm;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends Activity {
	
	String animalType = "";
	String animalName = "";
	String animalColor = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		
		Intent intent = getIntent();
		animalType = intent.getStringExtra("animalType");
		animalColor = intent.getStringExtra("animalColor");
		animalName = intent.getStringExtra("animalName");
		
		TextView txtVAnimName = (TextView)findViewById(R.id.txtViewNameDetails);
		txtVAnimName.setText(animalName);
		
		// Set image based on animal and color
		ImageView image = (ImageView) findViewById(R.id.imageViewAnimal);
		Resources res = getResources();
		int resID = res.getIdentifier(animalType+animalColor , "drawable", getPackageName());
		Drawable drawable = res.getDrawable(resID );
		image.setImageDrawable(drawable );
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.details, menu);
		return true;
	}
	
	public void speak(View v){
		Toast.makeText(getApplicationContext(),
				Animal.speak(animalType),
				Toast.LENGTH_SHORT).show();
		
		System.out.println(animalType);
	}
	
	public void gotoMain(View view){
    	Intent intent = new Intent(this, MainActivity.class);
    	startActivity(intent);
    }

}
