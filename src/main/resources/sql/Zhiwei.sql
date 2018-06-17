CREATE TABLE IF NOT EXISTS `Zhiwei`(
    `zhiwei_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`zhiwei_fzj` CHAR(24) NOT NULL COMMENT '父键'
    ,`zhiwei_mc` VARCHAR(200) NOT NULL COMMENT '名称'
    ,`zhiwei_zhidanshijian` DATETIME NOT NULL COMMENT '制单时间'
    ,`zhiwei_bz` VARCHAR(300) NULL COMMENT '备注'
    ,`zhiwei_zt` INT NOT NULL COMMENT '状态'
    ,`zhiwei_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '隔离标识'

    ,PRIMARY KEY (`zhiwei_zj`)
   ,KEY `zhiwei_fzj` (`zhiwei_fzj`)
   ,KEY `zhiwei_zt` (`zhiwei_zt`)
   ,KEY `zhiwei_gelibiaoshi` (`zhiwei_gelibiaoshi`)
)
COMMENT='职位'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;