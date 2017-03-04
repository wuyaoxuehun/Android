package com.example.haha2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RightFragment extends Fragment{

private	View view;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if(view==null){
		view=	inflater.inflate(R.layout.right_menu, container,false);
		}
		return view;
	}

}
