CREATE TABLE IF NOT EXISTS `LoufangFYBZ`(
    `loufang_fybz_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`loufang_fybz_loufang_zj` CHAR(24) NOT NULL COMMENT '楼房主键'
    ,`loufang_fybz_loufang_mc` VARCHAR(20) NOT NULL COMMENT '楼名'
    ,`loufang_fybz_dianfei` DOUBLE(7,3) NOT NULL COMMENT '电费标准'
    ,`loufang_fybz_shuifei` DOUBLE(7,3) NOT NULL COMMENT '水费标准'
    ,`loufang_fybz_shuifei_leng` DOUBLE(7,3) NOT NULL COMMENT '冷水费标准'
    ,`loufang_fybz_shuifei_re` DOUBLE(7,3) NOT NULL COMMENT '热水费标准'
    ,`loufang_fybz_meiqi` DOUBLE(7,3) NOT NULL COMMENT '煤气费标准'
    ,`loufang_fybz_zt` INT NOT NULL COMMENT '状态'
    ,`loufang_fybz_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '隔离标识'

    ,PRIMARY KEY (`loufang_fybz_zj`)
   ,KEY `loufang_fybz_loufang_zj` (`loufang_fybz_loufang_zj`)
   ,KEY `loufang_fybz_zt` (`loufang_fybz_zt`)
   ,KEY `loufang_fybz_gelibiaoshi` (`loufang_fybz_gelibiaoshi`)
)
COMMENT='楼房费用标准'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;