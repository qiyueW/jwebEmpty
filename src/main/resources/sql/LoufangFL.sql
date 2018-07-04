CREATE TABLE IF NOT EXISTS `LoufangFL`(
    `loufangfl_px` INT NULL  COMMENT '排序'
    ,`loufangfl_zj` CHAR(24) NOT NULL COMMENT '主键'
    ,`loufangfl_fzj` CHAR(24) NOT NULL COMMENT '父主键'
    ,`loufangfl_mc` VARCHAR(20) NOT NULL COMMENT '名称'
    ,`loufangfl_bz` VARCHAR(200) NULL COMMENT '备注'
    ,`loufangfl_zt` INT NOT NULL COMMENT '状态'
    ,`loufangfl_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '隔离标识'

    ,PRIMARY KEY (`loufangfl_zj`)
   ,KEY `loufangfl_fzj` (`loufangfl_fzj`)
   ,KEY `loufangfl_zt` (`loufangfl_zt`)
   ,KEY `loufangfl_gelibiaoshi` (`loufangfl_gelibiaoshi`)
)
COMMENT='楼房分类'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;