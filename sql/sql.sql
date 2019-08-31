CREATE DATABASE `pingGuo`;

USE `pingGuo`

CREATE TABLE `image`
(
  `imgId` BIGINT(10) PRIMARY KEY AUTO_INCREMENT COMMENT '图片编号',
  `clothingId` BIGINT(30) NOT NULL COMMENT '服装编号',
  `imgPath` VARCHAR(100) NOT NULL COMMENT '图片路径',
  `imgName` VARCHAR(50) COMMENT '图片名称'
)ENGINE=INNODB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8

CREATE TABLE `type`
(
  `typeId` BIGINT(10) PRIMARY KEY AUTO_INCREMENT COMMENT '服装类型编号',
  `typeName` VARCHAR(20) NOT NULL COMMENT '类型名称'
  
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

CREATE TABLE `clothing`
(
  `id` BIGINT(30) PRIMARY KEY AUTO_INCREMENT COMMENT '衣服id',
  `typeId` BIGINT(10) NOT NULL COMMENT '衣服类型',
  `size` VARCHAR(20) NOT NULL COMMENT '衣服尺码',
  `color` VARCHAR(25) NOT NULL COMMENT '衣服颜色',
  `brand` VARCHAR(30) COMMENT '品牌',
  `number` BIGINT(10) NOT NULL COMMENT '衣服数量',
  `title` VARCHAR(100) NOT NULL COMMENT '标题',
  `oldprice` DOUBLE(10,2) COMMENT '原价',
  `discountprice` DOUBLE(10,2) COMMENT '折后价',
  `time` DATE COMMENT '上市日期',
  `material` VARCHAR(30) COMMENT '材质',
  `code` VARCHAR(80) NOT NULL COMMENT '货号' 
  
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8

INSERT INTO `type` (`typeName`) VALUE ('羽绒服'),('大衣'),('休闲裤'),('棉衣')
INSERT INTO `type` (`typeName`) VALUE ('衬衫'),('夹克'),('毛衫'),('牛仔裤'),('西裤'),('T恤'),('单西'),('套西'),('皮带'),('毛衣')
SELECT * FROM `type`;