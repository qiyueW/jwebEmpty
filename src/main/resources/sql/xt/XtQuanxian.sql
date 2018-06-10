CREATE TABLE IF NOT EXISTS `XtQuanxian`(
    `xt_quanxian_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`xt_quanxian_fzj` CHAR(24) NOT NULL COMMENT '父键'
    ,`xt_quanxian_px` INT NULL COMMENT '排序'
    ,`xt_quanxian_mc` VARCHAR(200) NOT NULL COMMENT '名称'
    ,`xt_quanxian_dm` VARCHAR(200) NOT NULL COMMENT '权限代码'
    ,`xt_quanxian_url` VARCHAR(200) NULL COMMENT 'url'
    ,`xt_quanxian_keshi` INT NOT NULL COMMENT '可视'
    ,`xt_quanxian_zhankai` VARCHAR(8) NULL COMMENT '展开'
    ,`xt_quanxian_bz` VARCHAR(200) NULL COMMENT '备注'
    ,`xt_quanxian_zt` INT NOT NULL COMMENT '状态'
    ,`xt_quanxian_gelibiaoshi` VARCHAR(200) NULL COMMENT '隔离标识'

    ,PRIMARY KEY (`xt_quanxian_zj`)
   ,KEY `xt_quanxian_fzj` (`xt_quanxian_fzj`)
   ,UNIQUE INDEX `xt_quanxian_dm` (`xt_quanxian_dm`)
   ,KEY `xt_quanxian_keshi` (`xt_quanxian_keshi`)
   ,KEY `xt_quanxian_zt` (`xt_quanxian_zt`)
)
COMMENT='系统权限'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;