CREATE TABLE IF NOT EXISTS `XTTiaojian`(
    `xt_tiaojian_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`xt_shezhi_tiaojian_zj` CHAR(24) NOT NULL COMMENT '模块主键'
    ,`xt_shezhi_tiaojian_mc` VARCHAR(20) NOT NULL COMMENT '模块名称'
    ,`xt_shezhi_tiaojian_zhi` VARCHAR(20) NOT NULL COMMENT '使用值'
    ,`xt_tiaojian_mc` VARCHAR(20) NOT NULL COMMENT '条件方案名称'
    ,`xt_tiaojian_zhidanren_zj` CHAR(24) NOT NULL COMMENT '方案制定人主键'
    ,`xt_tiaojian_zhidanren` VARCHAR(20) NOT NULL COMMENT '制定人名称'
    ,`xt_tiaojian_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '单据隔离标识'
    ,`xt_tiaojian_zt` INT NOT NULL COMMENT '状态'

    ,PRIMARY KEY (`xt_tiaojian_zj`)
   ,KEY `xt_shezhi_tiaojian_zj` (`xt_shezhi_tiaojian_zj`)
   ,KEY `xt_shezhi_tiaojian_mc` (`xt_shezhi_tiaojian_mc`)
   ,KEY `xt_shezhi_tiaojian_zhi` (`xt_shezhi_tiaojian_zhi`)
   ,KEY `xt_tiaojian_mc` (`xt_tiaojian_mc`)
   ,KEY `xt_tiaojian_zhidanren_zj` (`xt_tiaojian_zhidanren_zj`)
   ,KEY `xt_tiaojian_gelibiaoshi` (`xt_tiaojian_gelibiaoshi`)
   ,KEY `xt_tiaojian_zt` (`xt_tiaojian_zt`)
)
COMMENT='系统条件管理'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;