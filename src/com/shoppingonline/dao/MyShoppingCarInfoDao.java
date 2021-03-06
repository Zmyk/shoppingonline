package com.shoppingonline.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.shoppingonline.entity.Goods;
import com.shoppingonline.entity.GoodsType;
import com.shoppingonline.entity.MyShoppingCarInfo;
import com.shoppingonline.entity.ShoppingCar;

public class MyShoppingCarInfoDao {
	private static ArrayList<MyShoppingCarInfo> list;
	private static ArrayList<ShoppingCar> shoppingCarList;
	
	public static ArrayList<MyShoppingCarInfo> getMyShoppingCarInfo(HttpServletRequest request) {
		list = new ArrayList<MyShoppingCarInfo>();
		shoppingCarList = ShoppingCarDao.getMyShoppingCar(request);
		for(int i =0;i<shoppingCarList.size();i++){
			Goods g = new Goods();
			g.setGoodsID(shoppingCarList.get(i).getGoodsID());
			int typeid = GoodsDao.getTypeId(g);
			GoodsType gt = new GoodsType();
			gt.setTypeID(typeid);
			String type = GoodsTypeDao.getTypeByTypeID(gt);
			String goodsName = GoodsDao.getGoodsName(g);
			MyShoppingCarInfo msci = new MyShoppingCarInfo(shoppingCarList.get(i),type,goodsName);
			list.add(msci);
		}
		return list;
	}
	
	

}
