CREATE TABLE IF NOT EXISTS `Loufang`(
    `loufang_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`loufangfl_zj` CHAR(24) NOT NULL COMMENT '分类外键'
    ,`loufang_mc` VARCHAR(20) NOT NULL COMMENT '名称'
    ,`loufang_dizhi` VARCHAR(200) NULL default "" COMMENT '地址'
    ,`loufang_bz` VARCHAR(200) NULL  default "" COMMENT '备注'
    ,`loufang_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '隔离标识'
    ,`loufang_zt` INT NOT NULL COMMENT '状态'
    ,`loufang_danjian_chuangwei` INT NULL  default 0 COMMENT '单间床位'
    ,`loufang_danjian_chuangwei2` INT NULL default 0  COMMENT '已用单间床位'
    ,`loufang_taojian_chuangwei` INT NULL  default 0 COMMENT '套间床位'
    ,`loufang_taojian_chuangwei2` INT NULL default 0 COMMENT '已用套间床位'

    ,PRIMARY KEY (`loufang_zj`)
   ,KEY `loufangfl_zj` (`loufangfl_zj`)
   ,KEY `loufang_gelibiaoshi` (`loufang_gelibiaoshi`)
   ,KEY `loufang_zt` (`loufang_zt`)
)
COMMENT='楼房'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;