CREATE TABLE IF NOT EXISTS `ChaoDianbiao`(
    `chaodianbiao_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`chaodianbiao_loufang_zj` CHAR(24) NOT NULL COMMENT '楼主键'
    ,`chaodianbiao_loufang_mc` VARCHAR(20) NOT NULL COMMENT '楼名称'
    ,`chaodianbiao_loufang2_zj` CHAR(24) NOT NULL COMMENT '房主键'
    ,`chaodianbiao_loufang2_bianma` VARCHAR(20) NOT NULL COMMENT '房编号'
    ,`chaodianbiao_dushu1` DOUBLE(10,1) NOT NULL COMMENT '上次读数'
    ,`chaodianbiao_riqi1` DATE NULL COMMENT '上次抄表日期'
    ,`chaodianbiao_dushu2` DOUBLE(10,1) NOT NULL COMMENT '读数'
    ,`chaodianbiao_riqi2` DATE NOT NULL COMMENT '抄表日期'
    ,`chaodianbiao_dian` DOUBLE(10,1) NOT NULL COMMENT '水(吨)'
    ,`chaodianbiao_dian_danjia` DOUBLE(7,3) NOT NULL COMMENT '水单价'
    ,`chaodianbiao_dian_jine` DOUBLE(10,1) NOT NULL COMMENT '金额'
    ,`chaodianbiao_zhidanshijian` DATETIME NOT NULL COMMENT '制单时间'
    ,`chaodianbiao_zhidanren` VARCHAR(20) NOT NULL COMMENT '制单人'
    ,`chaodianbiao_zhidanren_zj` CHAR(24) NOT NULL COMMENT '制单人主键'
    ,`chaodianbiao_fentanrenshu` INT NOT NULL COMMENT '分摊人数'
    ,`chaodianbiao_yj_fentanrenshu` INT NOT NULL COMMENT '已分摊人数'
    ,`chaodianbiao_zt` INT NOT NULL COMMENT '状态'
    ,`chaodianbiao_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '隔离标识'

    ,PRIMARY KEY (`chaodianbiao_zj`)
   ,KEY `chaodianbiao_loufang_zj` (`chaodianbiao_loufang_zj`)
   ,KEY `chaodianbiao_loufang2_zj` (`chaodianbiao_loufang2_zj`)
   ,KEY `chaodianbiao_zhidanren_zj` (`chaodianbiao_zhidanren_zj`)
   ,KEY `chaodianbiao_zt` (`chaodianbiao_zt`)
   ,KEY `chaodianbiao_gelibiaoshi` (`chaodianbiao_gelibiaoshi`)
)
COMMENT='抄电表'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;