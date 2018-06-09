CREATE TABLE IF NOT EXISTS `DanjuZiduan`(
    `danjuziduan_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`danju_zj` CHAR(24) NOT NULL COMMENT '表头id'
    ,`danjuziduan_mc` VARCHAR(200) NOT NULL COMMENT '字段名称'
    ,`danjuziduan_daima` VARCHAR(200) NOT NULL COMMENT '字段代码'
    ,`danjuziduan_leixing` VARCHAR(200) NULL COMMENT '字段类型'
    ,`danjuziduan_xiaoshudian` INT NULL COMMENT '字段小数点'
    ,`danjuziduan_changdu` VARCHAR(10) NULL COMMENT '字段长度'
    ,`danjuziduan_jiaonian` VARCHAR(10) NULL COMMENT '是否必须校验'
    ,`danjuziduan_jiaoniankuizhi` VARCHAR(300) NULL COMMENT '检验规则'
    ,`danjuziduan_bz` VARCHAR(200) NULL COMMENT '备注'
    ,`danjuziduan_px` INT NULL COMMENT '排序'

    ,PRIMARY KEY (`danjuziduan_zj`)
   ,KEY `danju_zj` (`danju_zj`)
   ,UNIQUE INDEX `danjuziduan_mc` (`danjuziduan_mc`, `danju_zj`)
   ,UNIQUE INDEX `danjuziduan_daima` (`danjuziduan_daima`, `danju_zj`)
)
COMMENT='单据字段管理'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;