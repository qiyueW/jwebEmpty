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
    ,`xt_quanxian_jibie` INT NOT NULL COMMENT '级别'
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

CREATE TABLE IF NOT EXISTS `XTJueseQuanxian`(
    `xt_juesequanxian_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`xt_juese_zj` CHAR(24) NOT NULL COMMENT '角色主键'
    ,`xt_juese_dm` VARCHAR(20) NOT NULL COMMENT '角色代码'
    ,`xt_quanxian` TEXT NOT NULL COMMENT '权限集合'
    ,`xt_zhidanren_zj` CHAR(24) NOT NULL COMMENT '制单人'

    ,PRIMARY KEY (`xt_juesequanxian_zj`)
   ,KEY `xt_juese_zj` (`xt_juese_zj`)
   ,KEY `xt_zhidanren_zj` (`xt_zhidanren_zj`)
)
COMMENT='角色权限'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;