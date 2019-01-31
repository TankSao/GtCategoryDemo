package com.example.gtcategorydemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gtcategorydemo.R;

public class CommonAdapter extends BaseAdapter{
	private Context context;
	private int[] drawables;
	private String[] names;
	private LayoutInflater mInflater;
	public CommonAdapter() {
		// TODO 自动生成的构造函数存根
	}

	public CommonAdapter(Context activity, int[] drawables2,
			String[] names2) {
		// TODO 自动生成的构造函数存根
		super();
		this.drawables = drawables2;
		this.names = names2;
		this.context = activity;
		this.mInflater=LayoutInflater.from(activity);
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return names.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO 自动生成的方法存根
		return names[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		// TODO 自动生成的方法存根
		return arg0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		// TODO 自动生成的方法存根
		ViewHolder viewHolder;
		if(convertView==null){
			viewHolder=new ViewHolder();
			convertView=mInflater.inflate(R.layout.item_good, null);
			viewHolder.icon=(ImageView)convertView.findViewById(R.id.typeicon);
			viewHolder.name=(TextView)convertView.findViewById(R.id.typename);
			convertView.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder) convertView.getTag();
		}
		viewHolder.icon.setBackgroundResource(drawables[arg0]);
		viewHolder.name.setText(names[arg0]);
		
        return convertView;
	}
	
	private class ViewHolder{
		private ImageView icon;		
		private TextView name;
	}

}
