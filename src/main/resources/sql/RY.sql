CREATE TABLE IF NOT EXISTS `RY`(
    `ry_zj` CHAR(24) NOT NULL  COMMENT '主键'
    ,`ry_bm` VARCHAR(50) NOT NULL COMMENT '部门'
    ,`ry_bm_zj` CHAR(24) NOT NULL COMMENT '部门主键'
    ,`ry_mc` VARCHAR(20) NOT NULL COMMENT '人员名称'
    ,`ry_zhanghao` VARCHAR(100) NOT NULL COMMENT '账号'
    ,`ry_mima` VARCHAR(100) NOT NULL COMMENT '密码'
    ,`ry_xingbie` VARCHAR(2) NOT NULL COMMENT '性别'
    ,`ry_ruzhiriqi` DATE NOT NULL COMMENT '入职日期'
    ,`ry_chushengriqi` DATE NULL COMMENT '出生日期'
    ,`ry_lizhiriqi` DATE NULL COMMENT '离职日期'
    ,`ry_jiguan` VARCHAR(20) NULL COMMENT '籍贯'
    ,`ry_shouji1` VARCHAR(20) NULL COMMENT '手机1'
    ,`ry_youxiang` VARCHAR(100) NULL COMMENT '邮箱'
    ,`ry_hunyin` VARCHAR(2) NULL COMMENT '婚姻状态'
    ,`ry_gangwei_zj` CHAR(24) NULL COMMENT '岗位主键'
    ,`ry_gangwei` VARCHAR(50) NULL COMMENT '岗位'
    ,`ry_zhiwei_zj` CHAR(24) NULL COMMENT '职位主键'
    ,`ry_zhiwei` VARCHAR(50) NULL COMMENT '职位'
    ,`ry_tupian` VARCHAR(200) NULL COMMENT '图片'
    ,`ry_bz` VARCHAR(200) NULL COMMENT '备注'
    ,`ry_shenfenzheng` VARCHAR(200) NULL COMMENT '身份证号码'
    ,`ry_tupian_zhengjian1` VARCHAR(200) NULL COMMENT '证件图_正面'
    ,`ry_tupian_zhengjian2` VARCHAR(200) NULL COMMENT '证件图_反面'
    ,`ry_xianzhudizhi` VARCHAR(200) NULL COMMENT '现住地址'
    ,`ry_jiatingdizhi` VARCHAR(200) NULL COMMENT '家庭地址'
    ,`ry_jinjilianxiren` VARCHAR(20) NULL COMMENT '紧急联系人'
    ,`ry_jinjilianxiren_dianhua` VARCHAR(20) NULL COMMENT '紧急联系人电话'
    ,`ry_gudingdianhua1` VARCHAR(20) NULL COMMENT '固定电话1'
    ,`ry_gudingdianhua2` VARCHAR(20) NULL COMMENT '固定电话2'
    ,`ry_qitatongxing` VARCHAR(50) NULL COMMENT '其他通信'
    ,`ry_qitatongxing1` VARCHAR(50) NULL COMMENT '其他通信1'
    ,`ry_qitatongxing2` VARCHAR(50) NULL COMMENT '其他通信2'
    ,`ry_qitatongxing3` VARCHAR(50) NULL COMMENT '其他通信3'
    ,`ry_qitatongxing4` VARCHAR(50) NULL COMMENT '其他通信4'
    ,`ry_qitatongxing5` VARCHAR(50) NULL COMMENT '其他通信5'
    ,`ry_neibutongxing1` VARCHAR(50) NULL COMMENT '内部通信1'
    ,`ry_neibutongxing2` VARCHAR(50) NULL COMMENT '内部通信2'
    ,`ry_neibutongxing3` VARCHAR(50) NULL COMMENT '内部通信3'
    ,`ry_neibutongxing4` VARCHAR(50) NULL COMMENT '内部通信4'
    ,`ry_neibutongxing5` VARCHAR(50) NULL COMMENT '内部通信5'
    ,`ry_neibutongxing6` VARCHAR(50) NULL COMMENT '内部通信6'
    ,`ry_neibutongxing7` VARCHAR(50) NULL COMMENT '内部通信7'
    ,`ry_neibutongxing8` VARCHAR(50) NULL COMMENT '内部通信8'
    ,`ry_neibutongxing9` VARCHAR(50) NULL COMMENT '内部通信9'
    ,`ry_neibutongxing10` VARCHAR(50) NULL COMMENT '内部通信10'
    ,`ry_zhidanren_zj` CHAR(24) NOT NULL COMMENT '制单人主键'
    ,`ry_zhidanren` VARCHAR(200) NOT NULL COMMENT '制单人'
    ,`ry_gelibiaoshi` VARCHAR(20) NOT NULL COMMENT '隔离标识'
    ,`ry_zt` INT NOT NULL COMMENT '状态'

    ,PRIMARY KEY (`ry_zj`)
   ,KEY `ry_bm_zj` (`ry_bm_zj`)
   ,UNIQUE INDEX `ry_zhanghao` (`ry_zhanghao`,`ry_gelibiaoshi`)
   ,KEY `ry_gangwei_zj` (`ry_gangwei_zj`)
   ,KEY `ry_zhiwei_zj` (`ry_zhiwei_zj`)
   ,KEY `ry_zhidanren_zj` (`ry_zhidanren_zj`)
   ,KEY `ry_zt` (`ry_zt`)
)
COMMENT='人员管理'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;