package cn.clothing.pojo;

public class Image {

	private Integer imgId;		//图片id
	private String imgpath;		//图片路径
	private String imgName;		//图片名称
	private Clothing clothing;	//衣服
	
	public Integer getImgId() {
		return imgId;
	}
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	
	public Clothing getClothing() {
		return clothing;
	}
	public void setClothing(Clothing clothing) {
		this.clothing = clothing;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	
	
	
}
