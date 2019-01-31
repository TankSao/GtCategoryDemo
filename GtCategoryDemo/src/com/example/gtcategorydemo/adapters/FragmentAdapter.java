package com.example.gtcategorydemo.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.gtcategorydemo.framents.GoodsFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
	private String[] list;
	public FragmentAdapter(FragmentManager fm) {
		super(fm);
	}
	public FragmentAdapter(FragmentManager fm,String[] list) {
		super(fm);
		this.list = list;
	}
	@Override
	public Fragment getItem(int arg0) {
		Fragment fragment =new GoodsFragment();
		Bundle bundle=new Bundle();
		String str=list[arg0];
		bundle.putString("typename",str);
		fragment.setArguments(bundle);
		return fragment;
	}
	
	@Override
	public int getCount() {
		return list.length;
	}
}
