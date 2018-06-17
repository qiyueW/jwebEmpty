CREATE TABLE IF NOT EXISTS `Gangwei`(
    `gangwei_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`gangwei_fzj` CHAR(24) NOT NULL COMMENT '父键'
    ,`gangwei_mc` VARCHAR(20) NOT NULL COMMENT '名称'
    ,`gangwei_zhidanshijian` DATETIME NOT NULL COMMENT '制单时间'
    ,`gangwei_bz` VARCHAR(1000) NULL COMMENT '备注'
    ,`gangwei_zt` INT NOT NULL COMMENT '状态'
    ,`gangwei_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '隔离标识'

    ,PRIMARY KEY (`gangwei_zj`)
   ,KEY `gangwei_fzj` (`gangwei_fzj`)
   ,KEY `gangwei_zt` (`gangwei_zt`)
   ,KEY `gangwei_gelibiaoshi` (`gangwei_gelibiaoshi`)
)
COMMENT='岗位'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;