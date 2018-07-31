CREATE TABLE IF NOT EXISTS `LoufangNafei`(
    `loufangnafei_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`loufangnafei_lou_zj` CHAR(24) NOT NULL COMMENT '楼主键'
    ,`loufangnafei_fang_zj` CHAR(24) NOT NULL COMMENT '房主键'
    ,`loufangnafei_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '隔离标识'
    ,`loufangnafei_lou_mc` VARCHAR(20) NOT NULL COMMENT '楼名称'
    ,`loufangnafei_fang_bianma` VARCHAR(20) NOT NULL COMMENT '房编码'
    ,`loufangnafei_ren` VARCHAR(20) NOT NULL COMMENT '纳费人'
    ,`loufangnafei_ren_zj` CHAR(24) NOT NULL COMMENT '纳费人主键'
    ,`loufangnafei_yingnariqi` DATE NOT NULL COMMENT '应纳日期'
    ,`loufangnafei_nafeiriqi` DATE NULL COMMENT '纳费日期'
    ,`loufangnafei_zongfeiyong` DOUBLE(10,1) NOT NULL COMMENT '总费用'
    ,`loufangnafei_zongfeiyong2` DOUBLE(10,1) NOT NULL COMMENT '已纳费用'
    ,`loufangnafei_fangzu` DOUBLE(10,1) NOT NULL COMMENT '房租'
    ,`loufangnafei_feiyong_shui` DOUBLE(10,1) NOT NULL COMMENT '水费'
    ,`loufangnafei_feiyong_shui_zj` TEXT NULL COMMENT '水费主键集合'
    ,`loufangnafei_feiyong_dian` DOUBLE(10,1) NOT NULL COMMENT '电费'
    ,`loufangnafei_feiyong_dian_zj` TEXT NULL COMMENT '电费主键集合'
    ,`loufangnafei_feiyong_xm` DOUBLE(10,1) NOT NULL COMMENT '项目费'
    ,`loufangnafei_feiyong_xm_zj` TEXT NULL COMMENT '项目费主键集合'
    ,`loufangnafei_feiyong_meiqi` DOUBLE(10,1) NULL COMMENT '煤气费'
    ,`loufangnafei_feiyong_meiqi_zj` TEXT NULL COMMENT '煤气费主键集合'
    ,`loufangnafei_zt` INT NOT NULL COMMENT '状态'
    ,`loufangnafei_chuzhangshijian` DATETIME NOT NULL COMMENT '出账时间'

    ,PRIMARY KEY (`loufangnafei_zj`)
   ,KEY `loufangnafei_lou_zj` (`loufangnafei_lou_zj`)
   ,KEY `loufangnafei_fang_zj` (`loufangnafei_fang_zj`)
   ,KEY `loufangnafei_gelibiaoshi` (`loufangnafei_gelibiaoshi`)
   ,KEY `loufangnafei_lou_mc` (`loufangnafei_lou_mc`)
   ,KEY `loufangnafei_fang_bianma` (`loufangnafei_fang_bianma`)
   ,KEY `loufangnafei_ren_zj` (`loufangnafei_ren_zj`)
   ,KEY `loufangnafei_zt` (`loufangnafei_zt`)
)
COMMENT='楼房纳费'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;