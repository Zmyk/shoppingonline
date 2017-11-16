package com.shoppingonline.dao;

import java.util.ArrayList;
import com.shoppingonline.entity.Goods;
import com.shoppingonline.entity.GoodsInfo;

public class GoodsInfoDao {
	private static ArrayList<GoodsInfo> goodInfolist;
	private static ArrayList<Goods> goodslist;
	
	public static ArrayList<GoodsInfo> getSpecial_offerGoodsInfo(){
		goodInfolist = new ArrayList<GoodsInfo>();
		goodslist = GoodsDao.getSpecial_offerGoods();
		for(int i=0;i<goodslist.size();i++){
			String goodTypeName = GoodsTypeDao.getGoodsTypeName(goodslist.get(i));
			GoodsInfo gi = new GoodsInfo(goodslist.get(i),goodTypeName);
			goodInfolist.add(gi);
		}
		return goodInfolist;
	}
	
	public static ArrayList<GoodsInfo> getIsnotSpecial_offerGoodsInfo(){
		goodInfolist = new ArrayList<GoodsInfo>();
		goodslist = GoodsDao.getIsnotSpecial_offerGoods();
		for(int i=0;i<goodslist.size();i++){
			String goodTypeName = GoodsTypeDao.getGoodsTypeName(goodslist.get(i));
			GoodsInfo gi = new GoodsInfo(goodslist.get(i),goodTypeName);
			goodInfolist.add(gi);
		}
		return goodInfolist;
	}
}
