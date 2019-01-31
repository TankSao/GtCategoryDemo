package com.example.gtcategorydemo;

import com.example.gtcategorydemo.adapters.FragmentAdapter;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OnClickListener{

	private ImageView back,search;
	private ScrollView scView;
	private LinearLayout categorys;
	private ViewPager goods;
	private String[] categorysList;
	private TextView[] categoryTvs;
	private View views[];
	private LayoutInflater inflater;
	private FragmentAdapter adapter;
	private int currentItem=0;
	private int scrllViewWidth = 0, scrollViewMiddle = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();
        setListener();
        initCategorys();//初始化分类列表
        initViewPager();
    }


    private void initViewPager() {
		// TODO 自动生成的方法存根
		adapter = new FragmentAdapter(getSupportFragmentManager(),categorysList);
		goods.setAdapter(adapter);
		goods.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO 自动生成的方法存根
				if(goods.getCurrentItem()!=arg0)goods.setCurrentItem(arg0);
				if(currentItem!=arg0){
					changeTextColor(arg0);
					changeTextLocation(arg0);
				}
				currentItem=arg0;
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO 自动生成的方法存根
				
			}
		});
	}


	private void initCategorys() {
		// TODO 自动生成的方法存根
		categorysList = new String[]{"常见分类","生鲜蔬菜","化妆护肤","数码产品","家用电器","酒水饮料","汽车用品","鞋包服装","二手市场","金银珠宝","生活用品","户外运动"};
		categoryTvs=new TextView[categorysList.length];
		views=new View[categorysList.length];
		
		for (int i = 0; i < categorysList.length; i++) {
			View view=inflater.inflate(R.layout.item_category, null);
			view.setId(i);
			view.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 自动生成的方法存根
					goods.setCurrentItem(arg0.getId());
				}
			});
			TextView textView=(TextView) view.findViewById(R.id.text);
			textView.setText(categorysList[i]);
			categorys.addView(view);
			categoryTvs[i]=textView;
			views[i]=view;
		}
		changeTextColor(0);
	}
    
    //改变当前索引的状态
    private void changeTextColor(int id) {
		for (int i = 0; i < categoryTvs.length; i++) {
			if(i!=id){
				categoryTvs[i].setBackgroundResource(android.R.color.transparent);
				categoryTvs[i].setTextColor(0xff000000);
			}
		}
		categoryTvs[id].setBackgroundResource(android.R.color.white);
		categoryTvs[id].setTextColor(0xffff5d5e);
	}


	private void setListener() {
		// TODO 自动生成的方法存根
		back.setOnClickListener(this);
		search.setOnClickListener(this);
	}


	private void initViews() {
		// TODO 自动生成的方法存根
		inflater=LayoutInflater.from(this);
		back = (ImageView) findViewById(R.id.back);
		search = (ImageView) findViewById(R.id.search);
		scView = (ScrollView) findViewById(R.id.scView);
		categorys = (LinearLayout) findViewById(R.id.categorys);
		goods = (ViewPager) findViewById(R.id.goods);
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onClick(View view) {
		// TODO 自动生成的方法存根
		switch (view.getId()) {
		case R.id.back:
			finish();
			break;
		case R.id.search:
			Toast.makeText(MainActivity.this, "暂不支持", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}
	private void changeTextLocation(int clickPosition) {
		
		int x = (views[clickPosition].getTop() - getScrollViewMiddle() + (getViewheight(views[clickPosition]) / 2));
		scView.smoothScrollTo(0, x);
	}
	/**
	 * 返回scrollview的中间位置
	 * 
	 * @return
	 */
	private int getScrollViewMiddle() {
		if (scrollViewMiddle == 0)
			scrollViewMiddle = getScrollViewheight() / 2;
		return scrollViewMiddle;
	}
	
	/**
	 * 返回ScrollView的宽度
	 * 
	 * @return
	 */
	private int getScrollViewheight() {
		if (scrllViewWidth == 0)
			scrllViewWidth = scView.getBottom() - scView.getTop();
		return scrllViewWidth;
	}
	
	/**
	 * 返回view的宽度
	 * 
	 * @param view
	 * @return
	 */
	private int getViewheight(View view) {
		return view.getBottom() - view.getTop();
	}
}
