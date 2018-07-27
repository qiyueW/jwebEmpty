CREATE TABLE IF NOT EXISTS `ChaoDianbiaoFengtan`(
    `chaodianbiaofengtan_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`chaodianbiao_zj` CHAR(24) NOT NULL COMMENT '水表记录主键'
    ,`chaodianbiaofengtan_dian` DOUBLE(10,1) NOT NULL COMMENT '水'
    ,`chaodianbiaofengtan_dian_danjia` DOUBLE(7,3) NOT NULL COMMENT '水单价'
    ,`chaodianbiaofengtan_zhanyongtian` INT NOT NULL COMMENT '占用天数'
    ,`chaodianbiaofengtan_feiyong` DOUBLE(10,1) NOT NULL COMMENT '分摊费'
    ,`chaodianbiaofengtan_nfsj` DATETIME NULL COMMENT '纳费时间'
    ,`chaodianbiaofengtan_nfr_zj` CHAR(24) NOT NULL COMMENT '纳费人主键'
    ,`chaodianbiaofengtan_nfr` VARCHAR(20) NOT NULL COMMENT '纳费人'

    ,PRIMARY KEY (`chaodianbiaofengtan_zj`)
   ,KEY `chaodianbiao_zj` (`chaodianbiao_zj`)
   ,KEY `chaodianbiaofengtan_nfr_zj` (`chaodianbiaofengtan_nfr_zj`)
)
COMMENT='电表计费分摊'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;