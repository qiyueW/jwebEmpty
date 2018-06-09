CREATE TABLE IF NOT EXISTS `XTShezhiTiaojian1`(
    `xt_shezhi_tiaojian1_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`xt_shezhi_tiaojian_zj` CHAR(24) NOT NULL COMMENT '表头主键'
    ,`xt_shezhi_tiaojian1_mc` VARCHAR(20) NOT NULL COMMENT '条件名'
    ,`xt_shezhi_tiaojian1_zhi` VARCHAR(20) NOT NULL COMMENT '条件值'

    ,PRIMARY KEY (`xt_shezhi_tiaojian1_zj`)
   ,KEY `xt_shezhi_tiaojian_zj` (`xt_shezhi_tiaojian_zj`)
   ,UNIQUE INDEX `xt_shezhi_tiaojian1_mc` (`xt_shezhi_tiaojian1_mc`, `xt_shezhi_tiaojian_zj`)
   ,UNIQUE INDEX `xt_shezhi_tiaojian1_zhi` (`xt_shezhi_tiaojian1_zhi`, `xt_shezhi_tiaojian_zj`)
)
COMMENT='系统设置_条件1'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;