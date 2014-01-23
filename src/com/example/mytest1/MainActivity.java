package com.example.mytest1;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class MainActivity extends Activity {

	
	@SuppressLint("JavascriptInterface")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		WebView browser = (WebView) findViewById(R.id.webView1);
		browser.getSettings().setJavaScriptEnabled(true);
		browser.addJavascriptInterface(new JavaScriptInterface(this), 
				                      "AndroidInterface");
		
		// if the html file is in the app's memory space use:
		   browser.loadUrl("file:///android_asset/my_local_webpage1.html");

		// if the file is in the app's SD card use:
		// browser.loadUrl("file:///sdcard/my_local_webpage1.html");
		   
		// CAUTION: Manifest must include
		// <uses-permission android:name="android.permission.INTERNET"/>
		// <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>

	}//onCreate	

}
