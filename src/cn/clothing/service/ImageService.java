package cn.clothing.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import cn.clothing.pojo.Clothing;
import cn.clothing.pojo.Image;

public interface ImageService {

	public boolean saveImg(Image image);
	
	//
	public boolean saveImgs(MultipartFile[] attachs,HttpServletRequest request,Clothing clothing);
	
}
