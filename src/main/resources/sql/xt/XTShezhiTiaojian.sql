CREATE TABLE IF NOT EXISTS `XTShezhiTiaojian`(
    `xt_shezhi_tiaojian_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`xt_shezhi_tiaojian_mc` VARCHAR(20) NOT NULL COMMENT '展示名称'
    ,`xt_shezhi_tiaojian_zhi` VARCHAR(20) NOT NULL COMMENT '使用值'
    ,`xt_shezhi_tiaojian_bz` VARCHAR(200) NULL COMMENT '备注'
    ,`xt_shezhi_tiaojian_zt` INT NOT NULL COMMENT '单据状态管理'

    ,PRIMARY KEY (`xt_shezhi_tiaojian_zj`)
   ,UNIQUE INDEX `xt_shezhi_tiaojian_mc` (`xt_shezhi_tiaojian_mc`)
   ,UNIQUE INDEX `xt_shezhi_tiaojian_zhi` (`xt_shezhi_tiaojian_zhi`)
   ,KEY `xt_shezhi_tiaojian_zt` (`xt_shezhi_tiaojian_zt`)
)
COMMENT='系统设置_条件'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;