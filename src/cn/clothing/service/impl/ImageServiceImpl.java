package cn.clothing.service.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.clothing.dao.image.ImageMapper;
import cn.clothing.pojo.Clothing;
import cn.clothing.pojo.Image;
import cn.clothing.service.ImageService;
@Service
public class ImageServiceImpl implements ImageService {
	private static Logger logger=Logger.getLogger(ImageServiceImpl.class);
	
	@Resource
	private ImageMapper imageMapper;
	
	public boolean saveImg(Image image) {
		try {
			logger.info("进入saveImg方法>>>>>>>>>>>>>>>>>>>>>>>>");
			imageMapper.saveImg(image);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	/**
	 * 保存多张图片
	 */
	@Override
	public boolean saveImgs(MultipartFile[] attachs,HttpServletRequest request,Clothing clothing) {
		String idPicPath="";
		for (int i = 0; i < attachs.length; i++) {
			MultipartFile attach=attachs[i];
			
			if(!attach.isEmpty()){
				String path=request.getSession().getServletContext()
						.getRealPath("statics"+File.separator+"uploadfiles");
				String oldFileName=attach.getOriginalFilename();//原文件名
				//原文件后缀
				String prefix=FilenameUtils.getExtension(oldFileName);
				//设置字节
				int filesize=500000;	
				if(attach.getSize()>filesize){
					request.setAttribute("uploadFileError", "上次文件大小不的超过500kb");
				}else if(prefix.equalsIgnoreCase("jpg")
						|| prefix.equalsIgnoreCase("png")
						|| prefix.equalsIgnoreCase("jpeg")
						|| prefix.equalsIgnoreCase("pneg")){
					String fileName=System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_clothing.jpg";
					File targetFile=new File(path,fileName);
					if(!targetFile.exists()){
						targetFile.mkdirs();
					}
					try {
						attach.transferTo(targetFile);
						//图片路径
						idPicPath=path+File.separator+fileName;
						Image image=new Image();
						image.setClothing(clothing);
						image.setImgpath(idPicPath);
						image.setImgName(fileName);
						this.saveImg(image);
						return true;
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//request.setAttribute("uploadFileError", "图片保存失败");
					}
				}else{
					//request.setAttribute("uploadFileError", "上传文件图片不正确");
				}
			}
		
		}
		return false;
	}

}
