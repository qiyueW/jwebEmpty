CREATE TABLE IF NOT EXISTS `XtGuanliyuanJuese`(
    `xt_guanliyuanjuese_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`xt_guanliyuan_zj` CHAR(24) NOT NULL COMMENT '管理员主键'
    ,`xt_juese_zj` TEXT NULL COMMENT '角色主键集合'
    ,`xt_guanliyuanjuese_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '隔离标识'

    ,PRIMARY KEY (`xt_guanliyuanjuese_zj`)
   ,KEY `xt_guanliyuan_zj` (`xt_guanliyuan_zj`)
   ,KEY `xt_guanliyuanjuese_gelibiaoshi` (`xt_guanliyuanjuese_gelibiaoshi`)
)
COMMENT='管理员的角色'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;