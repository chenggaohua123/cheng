package cn.clothing.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.clothing.pojo.Clothing;
import cn.clothing.pojo.Image;
import cn.clothing.pojo.Type;
import cn.clothing.service.ClothingService;
import cn.clothing.service.ImageService;
import cn.clothing.service.TypeService;
import cn.clothing.util.BasicController;
import cn.clothing.util.BiographyUtil;

@Controller
@RequestMapping("/clothing")
public class ClothingController extends BasicController{

	private static Logger logger=Logger.getLogger(ClothingController.class);
	
	/*@Resource(name="bc")
	private BasicController bc;*/
	@Resource
	private ClothingService clothingService;
	
	@Resource
	private ImageService imageService;
	@Resource
	private TypeService typeService;
	
	@RequestMapping("/index.html")
	public String index(@RequestParam(value="typeId",required=false)Integer typeId,Model model,HttpServletRequest request) throws Exception{
		logger.info("进入ClothingController的index方法>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		//List<Clothing> clothingList=clothingService.getAllClothing(typeId);
		BiographyUtil bu=getBiographyUtil();
		RowBounds rb=new RowBounds(0, 2);
		List<Clothing> clothingList=clothingService.getClothingListByPage(bu, rb);
		List<Type> typeList=typeService.getAllType();
		model.addAttribute("clothingList", clothingList);
		model.addAttribute("typeList",typeList);
		/*for(Clothing clothing:clothingList){
			System.out.println(clothing.getTypePojo().getTypeName()+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}*/
		logger.info("退出ClothingController的index方法>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return "index";
	}
	
	@RequestMapping("/addImg.html")
	public String addImg(Map<String,Object> model){
		List<Clothing> clothingList=clothingService.getClothing();
		model.put("clothingList", clothingList);
		return "addImg";
	}
	
	@RequestMapping("/saveImg.html")
	public String saveImg(HttpSession session,HttpServletRequest request,
						@RequestParam(value="a_idPicPath",required=false) MultipartFile[] attachs,
						@RequestParam(value="clothingId")Integer clothingId){
		String idPicPath=null;
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
						image.setClothing(clothingService.getClothingById(clothingId));
						image.setImgpath(idPicPath);
						image.setImgName(fileName);
						imageService.saveImg(image);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						request.setAttribute("uploadFileError", "图片保存失败");
					}
				}else{
					request.setAttribute("uploadFileError", "上传文件图片不正确");
				}
			}
		
		}
		return "index";
	}
	@RequestMapping("/saveClothing.html")
	public String saveClothing(Map<String,Object> model) throws Exception{
		List<Type> typeList=typeService.getAllType();
		model.put("typeList", typeList);
		return "addClothing";
	}
	
	@RequestMapping("/doSaveClothing")
	public String doSaveClothing(@RequestParam(value="code",required=false)String code,
			@RequestParam(value="title",required=false)String title,
			@RequestParam(value="typeId",required=false)Integer typeId,
			@RequestParam(value="size",required=false)String size,
			@RequestParam(value="color",required=false)String color,
			@RequestParam(value="brand",required=false)String brand,
			@RequestParam(value="number",required=false)Integer number,
			@RequestParam(value="oldprice",required=false)double oldprice,
			@RequestParam(value="discountprice",required=false)double discountprice,
			@RequestParam(value="listingTime",required=false)String listingTime,
			@RequestParam(value="material",required=false)String material,
			@RequestParam(value="clothingImg",required=false)MultipartFile[] attachs,
			Map<String,Object> model,HttpServletRequest request){
		Clothing clothing=new Clothing();
		String id=Long.toString(System.currentTimeMillis()+RandomUtils.nextInt(1000000));
		clothing.setCode(code);
		clothing.setId(id);
		clothing.setTitle(title);
		clothing.setTypePojo(typeService.getTypeById(typeId));
		clothing.setSize(size);
		clothing.setColor(color);
		clothing.setNumber(number);
		clothing.setOldprice(oldprice);
		clothing.setDiscountprice(discountprice);
		clothing.setListingTime(listingTime);
		clothing.setMaterial(material);
		clothing.setInsertTime(new Date());
		boolean flag=clothingService.addClothing(clothing);
		
		if(flag){
			imageService.saveImgs(attachs, request, clothing);
		}
		return "redirect:/frame.html";
		
	}
	
	@RequestMapping("/test.html")
	public String test(Model model) throws Exception{
		/*Clothing clothing=new Clothing();
		clothing.setTitle("111");
		clothingService.addClothing(clothing);*/
		typeService.getAllType();
		return "test";
	}
}
