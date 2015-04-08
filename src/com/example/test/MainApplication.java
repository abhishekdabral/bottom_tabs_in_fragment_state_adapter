package com.example.test;

import android.app.Application;
import android.content.Context;
public class MainApplication extends Application{
	/**
	 * Context for Application
	 */
	private static Context sApplicationContext;
	/**
	 * To get the context of the current activity
	 * @return Context of the current activity
	 */
	public static Context getsApplicationContext() {
		return sApplicationContext;
	}
	/*
	 * Returning the context of the current activity
	 * @see android.app.Application#onCreate()
	 */
	@Override
	public void onCreate(){
		super.onCreate();
		sApplicationContext = this;
	}


}
