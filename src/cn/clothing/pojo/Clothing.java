package cn.clothing.pojo;

import java.util.Date;
import java.util.List;

public class Clothing {

	private String id;				//衣服编号
	private Type typePojo;				//衣服类型
	private String size;			//衣服尺寸
	private String color;			//衣服颜色
	private String brand;			//品牌
	private int number;				//数量
	private String title;			//标题
	private double oldprice;		//原价
	private double discountprice;	//折后价
	private String listingTime;				//上是月份
	private String material;		//材质
	private String code;			//货号
	private List<Image> imgList;	//图片集合
	private Date insertTime;		//插入日期
	private Date updateTime;		//更新日期

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getOldprice() {
		return oldprice;
	}
	public void setOldprice(double oldprice) {
		this.oldprice = oldprice;
	}
	
	public double getDiscountprice() {
		return discountprice;
	}
	public void setDiscountprice(double discountprice) {
		this.discountprice = discountprice;
	}
	
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public List<Image> getImgList() {
		return imgList;
	}
	public void setImgList(List<Image> imgList) {
		this.imgList = imgList;
	}

	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getListingTime() {
		return listingTime;
	}
	public void setListingTime(String listingTime) {
		this.listingTime = listingTime;
	}
	public Type getTypePojo() {
		return typePojo;
	}
	public void setTypePojo(Type typePojo) {
		this.typePojo = typePojo;
	}
	
	
	

	
}
