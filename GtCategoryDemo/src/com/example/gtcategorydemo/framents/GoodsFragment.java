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
	private String[] names = new String[]{"����","���õ���","��ױƷ","��װ","Ůװ","ŮЬ","����","����","���õ���","��ױƷ","��װ","Ůװ","ŮЬ","����","����","���õ���","��ױƷ","��װ","Ůװ","ŮЬ","����"};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		View view = inflater.inflate(R.layout.fragment_goods, null);
		typename = getArguments().getString("typename");
		((TextView)view.findViewById(R.id.toptype)).setText(typename);
		gridview = (GridView) view.findViewById(R.id.gridview);
		getGoods(typename);//��ȡ��Ʒ�б�
		return view;
	}
	private void getGoods(String typename) {
		// TODO �Զ����ɵķ������
		if(typename.equals("��������")){
			CommonAdapter adapter = new CommonAdapter(getActivity(),drawables,names);
			gridview.setAdapter(adapter);
		}
	}
}
