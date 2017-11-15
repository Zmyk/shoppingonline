package com.shopping.entity;

public class Goods {
	private int goodsID;
	private int typeID;
	private String goodsName;
	private int price;
	private int goodsNum;
	private String special_offer;
	private int special_price;
	public int getSpecial_price() {
		return special_price;
	}

	public void setSpecial_price(int special_price) {
		this.special_price = special_price;
	}

	public String getSpecial_offer() {
		return special_offer;
	}

	public void setSpecial_offer(String special_offer) {
		this.special_offer = special_offer;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public Goods(){
		
	}

	public int getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(int goodsID) {
		this.goodsID = goodsID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
