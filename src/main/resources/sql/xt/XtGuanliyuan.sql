CREATE TABLE `XtGuanliyuan` (
	`xt_guanliyuan_zj` CHAR(24) NOT NULL COMMENT '管理员主键',
	`xt_guanliyuan_mc` VARCHAR(20) NOT NULL COMMENT '管理员名称',
	`xt_guanliyuan_zhanghao` VARCHAR(20) NOT NULL COMMENT '管理员账号',
	`xt_guanliyuan_mima` VARCHAR(64) NOT NULL COMMENT '管理员密码',
	`xt_guanliyuan_youxiang` VARCHAR(100) NULL DEFAULT NULL COMMENT '管理员邮箱',
	`xt_guanliyuan_zt` INT(11) NOT NULL COMMENT '管理员状态',
	`xt_guanliyuan_bz` VARCHAR(200) NULL DEFAULT NULL COMMENT '管理员备注',
	`xt_guanliyuan_quanxian` TEXT NULL DEFAULT NULL COMMENT '管理员权限集合',
	`xt_guanliyuan_bm` TEXT NULL DEFAULT NULL COMMENT '管理员部门集合',
	`xt_guanliyuan_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '隔离标识',
	`xt_guanliyuan_zhidanshijian` DATETIME NOT NULL COMMENT '制单时间',
	`xt_guanliyuan_jibie` INT(1) UNSIGNED NOT NULL,
	PRIMARY KEY (`xt_guanliyuan_zj`),
	INDEX `xt_guanliyuan_zhanghao` (`xt_guanliyuan_zhanghao`),
	INDEX `xt_guanliyuan_zt` (`xt_guanliyuan_zt`),
	INDEX `xt_guanliyuan_gelibiaoshi` (`xt_guanliyuan_gelibiaoshi`),
	INDEX `xt_guanliyuan_jibie` (`xt_guanliyuan_jibie`)
)
COMMENT='系统管理员'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
