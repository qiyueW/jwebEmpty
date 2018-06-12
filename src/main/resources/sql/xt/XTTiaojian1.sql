CREATE TABLE IF NOT EXISTS `XTTiaojian1`(
    `xt_tiaojian1_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`xt_tiaojian_zj` CHAR(24) NOT NULL COMMENT '表头主键'
    ,`xt_tiaojian1_kuohao` VARCHAR(20) NULL COMMENT '括号区'
    ,`xt_tiaojian1_lianjiefu` VARCHAR(20) NULL COMMENT '接连符'
    ,`xt_tiaojian1_lianjiefu_mc` VARCHAR(20) NULL COMMENT '接连符展示名'
    ,`xt_shezhi_tiaojian1_mc` VARCHAR(20)  NULL COMMENT '条件区展示名'
    ,`xt_shezhi_tiaojian1_zhi` VARCHAR(200)  NULL COMMENT '条件区值'
    ,`xt_tiaojian1_panduan` VARCHAR(20)  NULL COMMENT '判断区'
    ,`xt_tiaojian1_panduan_mc` VARCHAR(20)  NULL COMMENT '判断区展示名'
    ,`xt_tiaojian1_zhi` VARCHAR(20) NULL COMMENT '条件值'

    ,PRIMARY KEY (`xt_tiaojian1_zj`)
   ,KEY `xt_tiaojian_zj` (`xt_tiaojian_zj`)
   ,KEY `xt_shezhi_tiaojian1_mc` (`xt_shezhi_tiaojian1_mc`)
   ,KEY `xt_shezhi_tiaojian1_zhi` (`xt_shezhi_tiaojian1_zhi`)
)
COMMENT='系统条件表体'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;