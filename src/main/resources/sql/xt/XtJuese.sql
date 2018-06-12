CREATE TABLE IF NOT EXISTS `XtJuese`(
    `xt_juese_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`xt_juese_fzj` CHAR(24) NOT NULL COMMENT '父键'
    ,`xt_juese_mc` VARCHAR(200) NOT NULL COMMENT '名称'
    ,`xt_juese_dm` VARCHAR(20) NOT NULL COMMENT '代码'
    ,`xt_juese_gongsi` INT NOT NULL COMMENT '公私角色'
    ,`xt_juese_bz` VARCHAR(200) NULL COMMENT '备注'
    ,`xt_juese_zt` INT NOT NULL COMMENT '状态'
    ,`xt_juese_gelibiaoshi` VARCHAR(20) NULL COMMENT '隔离标识'
    ,`xt_juese_zhidanren_zj` CHAR(24) NOT NULL COMMENT '制单人主键'
    ,`xt_juese_zhidanren` VARCHAR(20) NOT NULL COMMENT '制单人'
    ,`xt_juese_zhidanshijian` DATETIME NOT NULL COMMENT '制单时间'
    ,`xt_juese_xiugairen_zj` CHAR(24) NULL COMMENT '修改人主键'
    ,`xt_juese_xiugairen` VARCHAR(20) NULL COMMENT '修改人'
    ,`xt_juese_xiugaishijian` DATETIME NULL COMMENT '修改时间'

    ,PRIMARY KEY (`xt_juese_zj`)
   ,KEY `xt_juese_fzj` (`xt_juese_fzj`)
   ,UNIQUE INDEX `xt_juese_mc` (`xt_juese_mc`)
   ,UNIQUE INDEX `xt_juese_dm` (`xt_juese_dm`)
   ,KEY `xt_juese_gongsi` (`xt_juese_gongsi`)
   ,KEY `xt_juese_zt` (`xt_juese_zt`)
   ,KEY `xt_juese_zhidanren_zj` (`xt_juese_zhidanren_zj`)
)
COMMENT='系统角色'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;