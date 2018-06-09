CREATE TABLE IF NOT EXISTS `BM`(
    `bm_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`bm_fzj` CHAR(24) NOT NULL COMMENT '父键'
    ,`bm_mc` VARCHAR(200) NOT NULL COMMENT '名称'
    ,`bm_bianma` CHAR(10) NOT NULL COMMENT '编码'
    ,`bm_jianjie` TEXT NULL COMMENT '部门简介'
    ,`bm_tupian1` VARCHAR(200) NULL COMMENT '部门图片1'
    ,`bm_tupian2` VARCHAR(200) NULL COMMENT '部门图片2'
    ,`bm_chuangjianshijian` DATETIME NOT NULL COMMENT '部门创建时间'
    ,`bm_fuzhiren_zj` CHAR(24) NULL COMMENT '部门负责人主键'
    ,`bm_fuzhiren` VARCHAR(20) NULL COMMENT '部门负责人'
    ,`bm_zt` INT NOT NULL COMMENT '部门状态'

    ,PRIMARY KEY (`bm_zj`)
   ,KEY `bm_fzj` (`bm_fzj`)
   ,UNIQUE INDEX `bm_bianma` (`bm_bianma`)
   ,KEY `bm_fuzhiren_zj` (`bm_fuzhiren_zj`)
   ,KEY `bm_zt` (`bm_zt`)
)
COMMENT='部门管理'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;