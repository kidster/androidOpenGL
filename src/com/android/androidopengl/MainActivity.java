package com.android.androidopengl;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.Menu;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.widget.*;

public class MainActivity extends Activity implements OnInitListener {
	
	private TextToSpeech tts;
	static final int TTS_CHECK_CODE = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView label = (TextView) findViewById(R.id.label);
		label.setText("Hello, Jorge");

		Toast helloToast = Toast.makeText(this, "Hello, Again",
				Toast.LENGTH_LONG);
		helloToast.setGravity(Gravity.CENTER, 0, 0);
		helloToast.show();

		AlertDialog helloAlert = new AlertDialog.Builder(this).create();
		helloAlert.setTitle("This is a Demo");
		helloAlert.setMessage("Hello, Once Again!");
		
		final GLSurfaceView drawSurface = new GLSurfaceView(this);
		drawSurface.setRenderer(new HelloRenderer());
		helloAlert.setButton(AlertDialog.BUTTON_POSITIVE,"Close", new DialogInterface.OnClickListener() {


			public void onClick(DialogInterface dialog, int which) {
				
				setContentView(drawSurface);
			}
		});
		helloAlert.setButton(AlertDialog.BUTTON_NEUTRAL,"Button2", new DialogInterface.OnClickListener() {


			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

			}
		});
		helloAlert.setButton(AlertDialog.BUTTON_NEGATIVE,"Button3", new DialogInterface.OnClickListener() {


			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

			}
		});
		helloAlert.show();
		
		tts = new TextToSpeech(this, this);
		
		GLSurfaceView drGlSurfaceView = new GLSurfaceView(this);
		drGlSurfaceView.setRenderer(new GLRendererEx());
		setContentView(drGlSurfaceView);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}


	public void onInit(int status) {
		tts.speak("No Ma Mess Wei", TextToSpeech.QUEUE_FLUSH, null);
		
	}

}
