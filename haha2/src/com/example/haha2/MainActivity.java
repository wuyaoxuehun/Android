package com.example.haha2;

import java.util.ArrayList;
import java.util.List;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//		setContentView(R.layout.activity_main);
//		setBehindContentView(R.layout.left_menu_frame);
//		getSupportFragmentManager().beginTransaction().replace(R.id.id_left_menu_frame, new LeftFragment()).commit();
//		SlidingMenu smMenu=getSlidingMenu();
//		smMenu.setMode(SlidingMenu.LEFT_RIGHT);
//		smMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
//		smMenu.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);
//		smMenu.setShadowWidthRes(R.dimen.shadow_width);
//		smMenu.setShadowDrawable(R.drawable.shadow);
//		smMenu.setBehindOffsetRec(R.dimen.slidingmenu_offset);
//		smMenu.setFadeDegree(0.35f);
//		smMenu.setSecondaryShadowDrawable(R.drawable.shadow);
//		//设置右边（二级）侧滑菜单
//		smMenu.setSecondaryMenu(R.layout.right_menu_frame);
		
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		// 初始化SlideMenu
		Fragment leftMenuFragment = new LeftFragment();
		setBehindContentView(R.layout.left_menu_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.id_left_menu_frame, leftMenuFragment).commit();
		SlidingMenu menu = getSlidingMenu();
		menu.setMode(SlidingMenu.LEFT_RIGHT);
		// 设置触摸屏幕的模式
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
	    menu.setTouchmodeMarginThreshold(100);
	 //   menu.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setShadowWidthRes(R.dimen.shadow_width);//Rec 不能忘
		menu.setShadowDrawable(R.drawable.shadow);
		
		// 设置滑动菜单视图的宽度
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);//Rec 不能忘
	//	menu.setBehindWidth()
		// 设置渐入渐出效果的值
		
		menu.setFadeDegree(0.8f);
		 menu.setBehindScrollScale(0.1f);
		 
		menu.setSecondaryShadowDrawable(R.drawable.shadow);
		//设置右边（二级）侧滑菜单
		menu.setSecondaryMenu(R.layout.right_menu_frame);
		Fragment rightMenuFragment = new RightFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.id_right_menu_frame, rightMenuFragment).commit();
		
		initviewpager();
	}
	
	private ViewPager vpPager;
	private List<Fragment> fragments=new ArrayList<Fragment>(); 
	 private FragmentPagerAdapter fragmentPagerAdapter;
	private void initviewpager() {
		// TODO Auto-generated method stub
		vpPager=(ViewPager) findViewById(R.id.id_viewpager);
		fragments.add(new Tab1());
		fragments.add(new Tab2());
		fragments.add(new Tab3());
		
		fragmentPagerAdapter =new FragmentPagerAdapter(getSupportFragmentManager()) {
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return fragments.size();
			}
			
			@Override
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return fragments.get(arg0);//get 很重要；不是直接数组；
			}
		};
		vpPager.setAdapter(fragmentPagerAdapter);
	}

	public void showLeftMenu(View view)
	{
		getSlidingMenu().showMenu();
	}

	public void showRightMenu(View view)
	{
		getSlidingMenu().showSecondaryMenu();
	}
		
}
