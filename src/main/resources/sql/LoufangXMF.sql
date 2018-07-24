CREATE TABLE IF NOT EXISTS `LoufangXMF`(
    `loufangxmf_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`loufangxmf_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '隔离标识'
    ,`loufangxmf_mc` VARCHAR(20) NOT NULL COMMENT '项目名称'
    ,`loufangxmf_feiyong` INT NOT NULL COMMENT '项目费'
    ,`loufangxmf_zt` INT NOT NULL COMMENT '状态'

    ,PRIMARY KEY (`loufangxmf_zj`)
   ,KEY `loufangxmf_gelibiaoshi` (`loufangxmf_gelibiaoshi`)
   ,UNIQUE INDEX `loufangxmf_mc` (`loufangxmf_mc`,`loufangxmf_gelibiaoshi`)
   ,KEY `loufangxmf_zt` (`loufangxmf_zt`)
)
COMMENT='楼房项目费'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;