CREATE TABLE IF NOT EXISTS `Loufang2`(
    `loufang_zj` CHAR(24) NOT NULL  COMMENT '父键'
    ,`loufang2_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '隔离标识'
    ,`loufang2_zj` CHAR(24) NOT NULL COMMENT '主键'
    ,`loufang2_bianhao` VARCHAR(20) NOT NULL COMMENT '编号'
    ,`loufang2_mingcheng` VARCHAR(20) NOT NULL COMMENT '名称'
    ,`loufang2_chuangwei` INT NOT NULL COMMENT '床位'
    ,`loufang2_ruzhurenshu` INT NOT NULL COMMENT '入住人数'
    ,`loufang2_ruzhuren_zj` TEXT NULL COMMENT '入住人主键集合'
    ,`loufang2_lx` VARCHAR(20) NULL COMMENT '房间类型'
    ,`loufang2_bz` VARCHAR(200) NULL COMMENT '备注'

   ,KEY `loufang_zj` (`loufang_zj`)
   ,KEY `loufang2_gelibiaoshi` (`loufang2_gelibiaoshi`)
    ,PRIMARY KEY (`loufang2_zj`)
   ,UNIQUE INDEX `loufang2_bianhao` (`loufang2_bianhao`, `loufang_zj`)
)
COMMENT='楼房2'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;