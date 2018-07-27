CREATE TABLE IF NOT EXISTS `ChaoShuibiaoFengtan`(
    `chaoshuibiaofengtan_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`chaoshuibiao_zj` CHAR(24) NOT NULL COMMENT '水表记录主键'
    ,`chaoshuibiaofengtan_shui` DOUBLE(10,1) NOT NULL COMMENT '水'
    ,`chaoshuibiaofengtan_shui_danjia` DOUBLE(7,3) NOT NULL COMMENT '水单价'
    ,`chaoshuibiaofengtan_feiyong` DOUBLE(10,1) NOT NULL COMMENT '分摊费'
    ,`chaoshuibiaofengtan_nfsj` DATETIME NULL COMMENT '纳费时间'
    ,`chaoshuibiaofengtan_nfr_zj` CHAR(24) NOT NULL COMMENT '纳费人主键'
    ,`chaoshuibiaofengtan_nfr` VARCHAR(20) NOT NULL COMMENT '纳费人'

    ,PRIMARY KEY (`chaoshuibiaofengtan_zj`)
   ,KEY `chaoshuibiao_zj` (`chaoshuibiao_zj`)
   ,KEY `chaoshuibiaofengtan_nfr_zj` (`chaoshuibiaofengtan_nfr_zj`)
)
COMMENT='水表计费分摊'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;