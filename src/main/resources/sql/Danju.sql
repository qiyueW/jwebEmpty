 CREATE TABLE IF NOT EXISTS `Danju`(
    `danjufl_zj` CHAR(24) NULL  COMMENT '分类ID'
    ,`danju_zj` CHAR(24) NOT NULL COMMENT '主键'
    ,`danju_mc` VARCHAR(200) NOT NULL COMMENT '模块名'
    ,`danju_daima` VARCHAR(200) NOT NULL COMMENT '模块代码'
    ,`danju_qianzhui` VARCHAR(200) NULL COMMENT '单据前缀'
    ,`danju_shijian` VARCHAR(200) NULL COMMENT '单据时间'
    ,`danju_liushuihao` VARCHAR(200) NULL COMMENT '单据流水号'
    ,`danju_bz` VARCHAR(200) NULL COMMENT '备注'
    ,`danju_zhidanren_zj` CHAR(24) NULL COMMENT '制单人'
    ,`danju_zhidanshijian` DATETIME NOT NULL COMMENT '制单时间'
    ,`danju_xiugairen_zj` CHAR(24) NULL COMMENT '修改人'
    ,`danju_xiugaishijian` DATETIME NULL COMMENT '修改时间'
    ,`danju_px` INT NULL COMMENT '排序'
    ,`danju_zt` INT NOT NULL COMMENT '单据状态'

   ,KEY `danjufl_zj` (`danjufl_zj`)
    ,PRIMARY KEY (`danju_zj`)
   ,UNIQUE INDEX `danju_daima` (`danju_daima`)
   ,KEY `danju_zhidanren_zj` (`danju_zhidanren_zj`)
   ,KEY `danju_xiugairen_zj` (`danju_xiugairen_zj`)
   ,KEY `danju_zt` (`danju_zt`)
)
COMMENT='单据管理'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;