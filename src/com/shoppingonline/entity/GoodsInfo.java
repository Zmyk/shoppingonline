package com.shoppingonline.entity;

public class GoodsInfo {
	private Goods good;
	private String goodTypeName;
	
	public GoodsInfo(Goods g,String GoodTypeName){
		this.good = g;
		this.goodTypeName = GoodTypeName;
	}

	public Goods getGood() {
		return good;
	}

	public void setGood(Goods good) {
		this.good = good;
	}

	public String getGoodTypeName() {
		return goodTypeName;
	}

	public void setGoodTypeName(String goodTypeName) {
		this.goodTypeName = goodTypeName;
	}

}
