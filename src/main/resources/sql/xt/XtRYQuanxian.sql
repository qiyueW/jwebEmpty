CREATE TABLE IF NOT EXISTS `XtRYQuanxian`(
    `xt_ryquanxian_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`xt_ry_zj` CHAR(24) NOT NULL COMMENT '人员主键'
    ,`xt_juese_zj` TEXT NULL COMMENT '角色主键集合'
    ,`xt_quanxian` TEXT NULL COMMENT '权限代码集合'
    ,`xt_ryquanxian_zhidanshijian` DATETIME NOT NULL COMMENT '制单时间'
    ,`xt_ryquanxian_zhidanren` CHAR(24) NOT NULL COMMENT '制单人'
    ,`xt_ryquanxian_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '隔离标识'

    ,PRIMARY KEY (`xt_ryquanxian_zj`)
   ,KEY `xt_ry_zj` (`xt_ry_zj`)
   ,KEY `xt_ryquanxian_zhidanren` (`xt_ryquanxian_zhidanren`)
   ,KEY `xt_ryquanxian_gelibiaoshi` (`xt_ryquanxian_gelibiaoshi`)
)
COMMENT='人员权限'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;