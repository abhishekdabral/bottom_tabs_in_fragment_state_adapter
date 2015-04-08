package com.example.test;

// Import Java and android packages
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
//Import Application packages

/**
 * View pager Adapter of {@link HomeScreenActivity}
 * @author ABHISHEK
 */
public class HomePagerAdapter extends FragmentStatePagerAdapter {

	/**
	 *  Number of Fragment pages in the view pager
	 */
	private static final int NUMBER_OF_PAGES = 4;
	private Fragment2 mFragment2 ;
	private Fragment4 mFragment4 ;
	private Fragment3 mFragment3 ;
	private Fragment1 mFragment1;

	/**
	 * @return : Instance of {@link Fragment3}
	 */
	public Fragment3 getmFragment3() {
		return mFragment3;
	}

	/**
	 * @return : Instance of {@link Fragment2}
	 */
	public Fragment2 getFragment2() {
		return mFragment2;
	}

	/**
	 * @return : Instance of {@link Fragment4}
	 */
	public Fragment4 getmFragment4() {
		return mFragment4;
	}

	/**
	 * {@link HomePagerAdapter} {@link Constructor}
	 * @param fm : {@link FragmentManager} instance
	 */
	public HomePagerAdapter(FragmentManager fm) {

		/*
		 * Instantiate view pager fragments
		 */
		super(fm);
		if(mFragment1 == null){
			mFragment1 = new Fragment1();
		}
		if (mFragment2 == null) {
			mFragment2 = new Fragment2();
		}
		if (mFragment4 == null) {
			mFragment4 = new Fragment4();
		}
		if (mFragment3 == null) {
			mFragment3 = new Fragment3();
		}
	}

	/*
	 * Called to get the selected fragment
	 * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
	 */
	@Override
	public Fragment getItem(int iPosition) {

		// Match the corresponding position
		switch (iPosition) {
		case 0:
			return getmFragment1();
		case 1:
			return getFragment2();
		case 2:
			return getmFragment3();
		case 3:
			return getmFragment4();
		default:
			return null;
		}
	}

	public Fragment1 getmFragment1() {
		return mFragment1;
	}

	/*
	 * Called to get the number of fragment pages in the view pager
	 * @see android.support.v4.view.PagerAdapter#getCount()
	 */
	@Override
	public int getCount() {
		return NUMBER_OF_PAGES;
	}
}




//	private int [] mImages = {R.drawable.home, R.drawable.mycomic, R.drawable.free, R.drawable.search};
//	private LayoutInflater mInflator;
//	
//	public HomePagerAdapter(Context iCon) {
//		mInflator = LayoutInflater.from(iCon);
//	}
//
//	@Override
//	public int getCount() {
//		// TODO Auto-generated method stub
//		return 4;
//	}
//	
//	@Override
//	public Object instantiateItem(ViewGroup container, int position) {
//		View view = mInflator.inflate(R.layout.test, null);
//		ImageView image = (ImageView) view.findViewById(R.id.image);
//		image.setImageResource(mImages[position]);
//	
//		container.addView(view);
//		return view;
//}
//	@Override
//	public boolean isViewFromObject(View view, Object object) {
//		
//		return view == ((LinearLayout) object);
//	}
//}
