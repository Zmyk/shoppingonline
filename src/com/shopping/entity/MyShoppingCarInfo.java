package com.shopping.entity;

import com.shopping.entity.ShoppingCar;

public class MyShoppingCarInfo {
	private ShoppingCar sc;
	private String goodstype_type;
	private String goods_goodsName;
	
	public MyShoppingCarInfo(ShoppingCar sc,String goodstype_type,String goods_goodsName){
		this.sc = sc;
		this.goodstype_type = goodstype_type;
		this.goods_goodsName = goods_goodsName;
	}


	public ShoppingCar getSc() {
		return sc;
	}

	public void setSc(ShoppingCar sc) {
		this.sc = sc;
	}

	public String getGoodstype_type() {
		return goodstype_type;
	}

	public void setGoodstype_type(String goodstype_type) {
		this.goodstype_type = goodstype_type;
	}

	public String getGoods_goodsName() {
		return goods_goodsName;
	}

	public void setGoods_goodsName(String goods_goodsName) {
		this.goods_goodsName = goods_goodsName;
	}


	
	

}
