package com.gilang.androidlifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends TracerActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnActivity2 = (Button) findViewById(R.id.button1);
		btnActivity2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent;
				intent = new Intent(MainActivity.this, SecondActivity.class);
				startActivity(intent);
			}
		});

        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        String[] values = getResources().getStringArray(R.array.operating_systems);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, values);
        spinner1.setAdapter(adapter);
	}

}
