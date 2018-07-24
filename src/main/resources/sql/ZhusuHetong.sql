CREATE TABLE IF NOT EXISTS `ZhusuHetong`(
    `zhusuhetong_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`zhusuhetong_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '隔离标识'
    ,`zhusuhetong_zt` INT NOT NULL COMMENT '状态'
    ,`zhusuhetong_loufang_zj` CHAR(24) NOT NULL COMMENT '楼主键'
    ,`zhusuhetong_loufang_mc` VARCHAR(20) NOT NULL COMMENT '楼名称'
    ,`zhusuhetong_loufang2_zj` CHAR(24) NOT NULL COMMENT '房主键'
    ,`zhusuhetong_loufang2_bianhao` VARCHAR(20) NOT NULL COMMENT '房编号'
    ,`zhusuhetong_qianyueren` VARCHAR(20) NOT NULL COMMENT '签约人'
    ,`zhusuhetong_qianyueren_zj` CHAR(24) NOT NULL COMMENT '签约人主键'
    ,`zhusuhetong_zujin` INT NULL COMMENT '租金'    
    ,`zhusuhetong_yajin` INT NULL COMMENT '押金'
    ,`zhusuhetong_kaishiriqi` DATE NOT NULL COMMENT '开始日期'
    ,`zhusuhetong_jieshuriqi` DATE NULL COMMENT '结束日期'
    ,`zhusuhetong_jffs` INT NOT NULL COMMENT '计费方式'
    ,`zhusuhetong_jffs_zdrq` INT NULL COMMENT '计费方式-指定日期'
    ,`zhusuhetong_zuixiaozhusuriqi` DATE NULL COMMENT '最小住宿日期'
    ,`zhusuhetong_zhidanshijian` DATETIME NOT NULL COMMENT '制单时间'
    ,`zhusuhetong_zhidanren` VARCHAR(20) NOT NULL COMMENT '制单人'
    ,`zhusuhetong_zhidanren_zj` CHAR(24) NOT NULL COMMENT '制单人主键'
    ,`zhusuhetong_xiugaishijian` DATETIME NULL COMMENT '修改时间'
    ,`zhusuhetong_xiugairen` VARCHAR(20) NULL COMMENT '修改人'
    ,`zhusuhetong_xiugairen_zj` CHAR(24) NULL COMMENT '修改人主键'
    ,`zhusuhetong_bz` VARCHAR(200) NULL COMMENT '备注'
    ,`zhusuhetong_tj_xml` INT NOT NULL COMMENT '统计项目费'
    ,`zhusuhetong_xml_zj` TEXT NULL COMMENT '楼房项目'

    ,PRIMARY KEY (`zhusuhetong_zj`)
   ,KEY `zhusuhetong_gelibiaoshi` (`zhusuhetong_gelibiaoshi`)
   ,KEY `zhusuhetong_zt` (`zhusuhetong_zt`)
   ,KEY `zhusuhetong_loufang_zj` (`zhusuhetong_loufang_zj`)
   ,KEY `zhusuhetong_loufang2_zj` (`zhusuhetong_loufang2_zj`)
   ,KEY `zhusuhetong_qianyueren` (`zhusuhetong_qianyueren`)
   ,KEY `zhusuhetong_qianyueren_zj` (`zhusuhetong_qianyueren_zj`)
   ,KEY `zhusuhetong_jffs` (`zhusuhetong_jffs`)
   ,KEY `zhusuhetong_zhidanren_zj` (`zhusuhetong_zhidanren_zj`)
   ,KEY `zhusuhetong_xiugairen_zj` (`zhusuhetong_xiugairen_zj`)
)
COMMENT='住宿合同'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;