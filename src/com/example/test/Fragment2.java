package com.example.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Fragment2 extends Fragment{

	private ImageView mImage;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_layout, null);
		mImage = (ImageView) view.findViewById(R.id.image);
		mImage.setImageResource(R.drawable.photo2);
		return view;
	}
}
