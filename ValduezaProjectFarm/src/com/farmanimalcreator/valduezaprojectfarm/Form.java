package com.farmanimalcreator.valduezaprojectfarm;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Form extends Activity implements AdapterView.OnItemSelectedListener{

	public String animalType = "";
	public String animalName = "";
	public String animalColor = "";
	RadioGroup radioGroupColor;
	RadioButton radioButtonColor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form);
		
		// spinner logic
		Spinner animTypeSpinner = (Spinner)findViewById(R.id.spinnerAnimalType);
		ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.
				createFromResource(this, R.array.animalTypes,
						android.R.layout.simple_dropdown_item_1line);
		arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		animTypeSpinner.setAdapter(arrayAdapter);
		animTypeSpinner.setOnItemSelectedListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.form, menu);
		return true;
	}
	
	

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long arg3) {
		//Gets string at selected spinner drop down menu
		animalType = parent.getItemAtPosition(position).toString();
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		// Do nothing on nothing selected
	}
	
	public void gotoDetails(View v){
		
		EditText txtName = (EditText)findViewById(R.id.editTxtName);
		animalName = txtName.getText().toString();
		if(animalName.isEmpty()){
			Toast.makeText(getApplicationContext(),
					"Name must not be empty!",Toast.LENGTH_SHORT).show();
			return;
		}
		
		// Get color
		radioGroupColor = (RadioGroup)findViewById(R.id.radioGroupColor);
		radioButtonColor = (RadioButton)findViewById(radioGroupColor.getCheckedRadioButtonId());
        animalColor = radioButtonColor.getText().toString();
        
        
        // Pass variables to next window
		Intent intent = new Intent(this, Details.class);
		intent.putExtra("animalType", animalType);
		intent.putExtra("animalColor", animalColor);
		intent.putExtra("animalName", animalName);
    	startActivity(intent);
	}

}
