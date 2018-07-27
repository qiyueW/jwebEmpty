CREATE TABLE IF NOT EXISTS `ChaoShuibiao`(
    `chaoshuibiao_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`chaoshuibiao_loufang_zj` CHAR(24) NOT NULL COMMENT '楼主键'
    ,`chaoshuibiao_loufang_mc` VARCHAR(20) NOT NULL COMMENT '楼名称'
    ,`chaoshuibiao_loufang2_zj` CHAR(24) NOT NULL COMMENT '房主键'
    ,`chaoshuibiao_loufang2_bianma` VARCHAR(20) NOT NULL COMMENT '房编号'
    ,`chaoshuibiao_dushu1` DOUBLE(10,1) NOT NULL COMMENT '上次读数'
    ,`chaoshuibiao_riqi1` DATE NULL COMMENT '上次抄表日期'
    ,`chaoshuibiao_dushu2` DOUBLE(10,1) NOT NULL COMMENT '读数'
    ,`chaoshuibiao_riqi2` DATE NOT NULL COMMENT '抄表日期'
    ,`chaoshuibiao_shui` DOUBLE(10,1) NOT NULL COMMENT '水(吨)'
    ,`chaoshuibiao_shui_danjia` DOUBLE(7,3) NOT NULL COMMENT '水单价'
    ,`chaoshuibiao_shui_jine` DOUBLE(10,1) NOT NULL COMMENT '金额'
    ,`chaoshuibiao_zhidanshijian` DATETIME NOT NULL COMMENT '制单时间'
    ,`chaoshuibiao_zhidanren` VARCHAR(20) NOT NULL COMMENT '制单人'
    ,`chaoshuibiao_zhidanren_zj` CHAR(24) NOT NULL COMMENT '制单人主键'
    ,`chaoshuibiao_fentanrenshu` INT NOT NULL COMMENT '分摊人数'
    ,`chaoshuibiao_yj_fentanrenshu` INT NOT NULL COMMENT '已分摊人数'
    ,`chaoshuibiao_zt` INT NOT NULL COMMENT '状态'
    ,`chaoshuibiao_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '隔离标识'

    ,PRIMARY KEY (`chaoshuibiao_zj`)
   ,KEY `chaoshuibiao_loufang_zj` (`chaoshuibiao_loufang_zj`)
   ,KEY `chaoshuibiao_loufang2_zj` (`chaoshuibiao_loufang2_zj`)
   ,KEY `chaoshuibiao_zhidanren_zj` (`chaoshuibiao_zhidanren_zj`)
   ,KEY `chaoshuibiao_zt` (`chaoshuibiao_zt`)
   ,KEY `chaoshuibiao_gelibiaoshi` (`chaoshuibiao_gelibiaoshi`)
)
COMMENT='抄水表'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;