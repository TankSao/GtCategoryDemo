package com.example.gtcategorydemo.framents;

import com.example.gtcategorydemo.R;
import com.example.gtcategorydemo.adapters.CommonAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

public class GoodsFragment extends Fragment{
	private String typename;
	private GridView gridview;
	private int[] drawables = new int[]{R.drawable.diannao,R.drawable.dianqi,R.drawable.huazhuang,R.drawable.nanzhuang,R.drawable.nvzhuang,R.drawable.nvxie,R.drawable.neiyi,R.drawable.diannao,R.drawable.dianqi,R.drawable.huazhuang,R.drawable.nanzhuang,R.drawable.nvzhuang,R.drawable.nvxie,R.drawable.neiyi,R.drawable.diannao,R.drawable.dianqi,R.drawable.huazhuang,R.drawable.nanzhuang,R.drawable.nvzhuang,R.drawable.nvxie,R.drawable.neiyi};
	private String[] names = new String[]{"电脑","家用电器","化妆品","男装","女装","女鞋","内衣","电脑","家用电器","化妆品","男装","女装","女鞋","内衣","电脑","家用电器","化妆品","男装","女装","女鞋","内衣"};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		View view = inflater.inflate(R.layout.fragment_goods, null);
		typename = getArguments().getString("typename");
		((TextView)view.findViewById(R.id.toptype)).setText(typename);
		gridview = (GridView) view.findViewById(R.id.gridview);
		getGoods(typename);//获取商品列表
		return view;
	}
	private void getGoods(String typename) {
		// TODO 自动生成的方法存根
		if(typename.equals("常见分类")){
			CommonAdapter adapter = new CommonAdapter(getActivity(),drawables,names);
			gridview.setAdapter(adapter);
		}
	}
}
