package com.example.test;

/*
 *  Import android packages
 */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
/*
 *  Import Application package
 */

/**
 * Home Screen Activity class, having Pager adapter and bottom tabs
 * @author ABHISHEK
 */
public class HomeScreenActivity extends ActionBarActivity implements OnPageChangeListener, OnClickListener,
		android.content.DialogInterface.OnClickListener {
	/*
	 *  Views of this Activity
	 */
	private ViewPager mPager = null;
	private TextView[] mBottomTabTextView = new TextView[4];
	private ImageView[] mBottomTabImageView = new ImageView[4];
	private TextView[] mBottomTabNameTextView = new TextView[4];
	private TextView mLogout = null;
	private static final int NUMBER_OF_VIEW_TO_ALIVE = 4;
	
	// Array of drawable for their corresponding states
	private int[] mBottomImageResourceUnselected = { R.drawable.photo1, R.drawable.photo2, R.drawable.photo3,
			R.drawable.photo4};
	//private int[] mBottomImageResourceSelected = { R.drawable.home_selected, R.drawable.mycomic_selected,
		//	R.drawable.search_selected };
	private int[] mBottomImageResourceSelected = { R.drawable.photo1, R.drawable.photo2, R.drawable.photo3,
			R.drawable.photo4};
	
	/**
	 * @param isMyComicRequestSend : false to start mycomic request
	 */

	private HomePagerAdapter mAdapter = null;
	public static HomeScreenActivity sHomeScreen = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sHomeScreen = this;
		setContentView(R.layout.home_screen_activity);
		ActionBar actionBar = getSupportActionBar();
		LayoutInflater mInflater = LayoutInflater.from(this);

		View customView = mInflater.inflate(R.layout.home_screen_action_bar, null);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(customView, new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
				ActionBar.LayoutParams.MATCH_PARENT));
		mLogout = (TextView) customView.findViewById(R.id.txt_view_log_out);
		actionBar.setDisplayShowHomeEnabled(false); // remove app icon
		actionBar.setDisplayShowTitleEnabled(false); // remove app title
		actionBar.show();
		initialize();
		registerListener();

		setTabSelected(0);
		mAdapter = new HomePagerAdapter(getSupportFragmentManager());
		mPager.setOffscreenPageLimit(NUMBER_OF_VIEW_TO_ALIVE);
		mPager.setAdapter(mAdapter);
	}

	/*
	 * Clear the instance of comic detail screen, and delete the decrypted file
	 * @see android.support.v4.app.FragmentActivity#onResume()
	 */
	@Override
	protected void onResume() {
		super.onResume();

		/*
		 * delete the Decrypted file if exist
		 */
//		File decryptedFile = new File(XpinnOffUtil.loadPreference(Constants.DECRYPTED_FILE_PATH));
//
//		if(decryptedFile.exists()){
//			decryptedFile.delete();
//			XpinnOffUtil.clearPreference(Constants.DECRYPTED_FILE_PATH);
//			XpinnOffUtil.clearPreference(Constants.DECRYPTED_FILE_KEY);
//		}
	}

	/**
	 * Initialize activity views
	 */
	public void initialize() {
		mPager = (ViewPager) findViewById(R.id.pager);
		/*
		 * Initialize tab strips
		 */
		mBottomTabTextView[0] = (TextView) findViewById(R.id.txt_view_home_tab);
		mBottomTabTextView[1] = (TextView) findViewById(R.id.txt_view_mycomic_tab);
		mBottomTabTextView[2] = (TextView) findViewById(R.id.txt_view_free_tab);
		mBottomTabTextView[3] = (TextView) findViewById(R.id.txt_view_search_tab);

		/*
		 * Initialize bottom tab views
		 */
		mBottomTabImageView[0] = (ImageView) findViewById(R.id.img_view_home_tab);
		mBottomTabImageView[1] = (ImageView) findViewById(R.id.img_view_mycomic_tab);
		mBottomTabImageView[2] = (ImageView) findViewById(R.id.img_view_free_tab);
		mBottomTabImageView[3] = (ImageView) findViewById(R.id.img_view_search_tab);
		mBottomTabNameTextView[0] = (TextView) findViewById(R.id.txt_view_tab_home);
		mBottomTabNameTextView[1] = (TextView) findViewById(R.id.txt_view_tab_mycomic);
		mBottomTabNameTextView[2] = (TextView) findViewById(R.id.txt_view_tab_free);
		mBottomTabNameTextView[3] = (TextView) findViewById(R.id.txt_view_tab_search);

	}

	/**
	 * Called to register Listeners
	 */
	public void registerListener() {
		// Add loop to register listener for Bottom tab image views
		for (int i = 0; i < 4; i++) {
			mBottomTabImageView[i].setOnClickListener(this);
		}
		mPager.setOnPageChangeListener(this);
		mLogout.setOnClickListener(this);
	}

	/**
	 * Called to set the tab selected
	 * @param iPosition : Position of the Tab to be selected
	 */
	public void setTabSelected(int iPosition) {
		boolean state = false;
		/*
		 *  Add loop for Adding selected and unselected drawable for the image view
		 */
		for (int i = 0; i < 4; i++) {
			if (i == iPosition) {
				mBottomTabImageView[i].setImageDrawable(getResources().getDrawable(mBottomImageResourceSelected[i]));
				mBottomTabNameTextView[i].setTextColor(getResources().getColor(R.color.dark_blue));
				state = true;
			} else {
				mBottomTabImageView[i].setImageDrawable(getResources().getDrawable(mBottomImageResourceUnselected[i]));
				mBottomTabNameTextView[i].setTextColor(getResources().getColor(R.color.black));
				state = false;
			}
			mBottomTabTextView[i].setSelected(state);
		}
	}

	/*
	 * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrollStateChanged(int)
	 */
	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	/*
	 * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrolled(int, float, int)
	 */
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	/*
	 * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageSelected(int)
	 */
	@Override
	public void onPageSelected(int iPosition) {
		/*
		 * if network is available 
		 */
			//if position is 1 i.e mycomic and sMyComicRequest send is false 
			// then send my comic request
		setTabSelected(iPosition);
	}

	/*
	 * Called on bottom image click
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View iView) {
		/*
		 * if logout image is clicked
		 */
		if (iView.getId() == R.id.txt_view_log_out) {
			showDialog();
		}
		/*
		 * if bottom tabs are clicked
		 */
		else {
			setmPagerOnTabClick(iView.getId());
		}
	}

	/**
	 * Called to set page position on corresponding image click
	 * @param iTabId : Bottom Tab (Image View) id
	 */
	public void setmPagerOnTabClick(int iTabId) {
		/*
		 *  Add loop to find the id
		 */
		for (int i = 0; i < 4; i++) {
			/*
			 *  If view id match, the set page position
			 */
			if (mBottomTabImageView[i].getId() == iTabId) {
				mPager.setCurrentItem(i);
				setTabSelected(i);
				break;
			}
		}
	}

	/**
	 *Called to show Dialog for logout
	 */
	public void showDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("INFO");
		builder.setMessage("EXIT_MESSAGE");
		builder.setPositiveButton("OK", this);
		builder.setNegativeButton("CANCEL", this);
		builder.show();
	}

	/*
	 * Called on logout dialog click
	 * @see android.content.DialogInterface.OnClickListener#onClick(android.content.DialogInterface, int)
	 */
	@Override
	public void onClick(DialogInterface iDialog, int iWhich) {
		/*
		 * If ok button clicked then logout app 
		 */
		if (iWhich == DialogInterface.BUTTON_POSITIVE) {
			System.exit(0);
		}
		/*
		 *  if cancel button clicked then hide the dialog
		 */
		else {
			iDialog.dismiss();
		}
	}

	/*
	 * Prompt message to logout
	 * @see android.support.v4.app.FragmentActivity#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
		showDialog();
	}

	/*
	 * @see android.support.v4.app.FragmentActivity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		sHomeScreen = null;
	}
}