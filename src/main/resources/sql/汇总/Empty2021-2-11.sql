-- --------------------------------------------------------
-- 主机:                           nuwait.cn
-- 服务器版本:                        5.7.26 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 Empty 的数据库结构
CREATE DATABASE IF NOT EXISTS `Empty` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `Empty`;

-- 导出  表 Empty.BM 结构
CREATE TABLE IF NOT EXISTS `BM` (
  `bm_zj` char(24) NOT NULL COMMENT '主键',
  `bm_fzj` char(24) NOT NULL COMMENT '父键',
  `bm_mc` varchar(200) NOT NULL COMMENT '名称',
  `bm_bianma` char(10) NOT NULL COMMENT '编码',
  `bm_jianjie` text COMMENT '部门简介',
  `bm_tupian1` varchar(200) DEFAULT NULL COMMENT '部门图片1',
  `bm_tupian2` varchar(200) DEFAULT NULL COMMENT '部门图片2',
  `bm_chuangjianshijian` datetime NOT NULL COMMENT '部门创建时间',
  `bm_fuzhiren_zj` char(24) DEFAULT NULL COMMENT '部门负责人主键',
  `bm_fuzhiren` varchar(20) DEFAULT NULL COMMENT '部门负责人',
  `bm_zt` int(11) NOT NULL COMMENT '部门状态',
  `bm_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  PRIMARY KEY (`bm_zj`),
  UNIQUE KEY `bm_bianma` (`bm_bianma`),
  KEY `bm_fzj` (`bm_fzj`),
  KEY `bm_fuzhiren_zj` (`bm_fuzhiren_zj`),
  KEY `bm_zt` (`bm_zt`),
  KEY `bm_gelibiaoshi` (`bm_gelibiaoshi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门管理';

-- 正在导出表  Empty.BM 的数据：~14 rows (大约)
DELETE FROM `BM`;
/*!40000 ALTER TABLE `BM` DISABLE KEYS */;
INSERT INTO `BM` (`bm_zj`, `bm_fzj`, `bm_mc`, `bm_bianma`, `bm_jianjie`, `bm_tupian1`, `bm_tupian2`, `bm_chuangjianshijian`, `bm_fuzhiren_zj`, `bm_fuzhiren`, `bm_zt`, `bm_gelibiaoshi`) VALUES
	('201807091755457650000018', '0', 'xxxxx总公司', 'zgs001', '', '', '', '2018-07-09 17:55:45', '', '', 1, 'fs001'),
	('201807091755581550000019', '0', 'xxxxx分公司', 'fgs001', '', '', '', '2018-07-09 17:55:58', '', '', 1, 'fs001'),
	('201807091756191510000020', '201807091755457650000018', '信息部', 'zgs001xxb', '', '', '', '2018-07-09 17:56:19', '', '', 1, 'fs001'),
	('201807091756353800000021', '201807091755457650000018', '人事部', 'zgs001rsb', '', '', '', '2018-07-09 17:56:35', '', '', 1, 'fs001'),
	('201807091756566050000022', '201807091755581550000019', '分公司人事部', 'fgs001rsb', '', '', '', '2018-07-09 17:56:56', '', '', 1, 'fs001'),
	('201807091811342660000050', '0', 'xx公司部门', 'fsfsf', '', '', '', '2018-07-09 18:11:34', '', '', 0, 'sz001'),
	('201807091811432520000051', '201807091811342660000050', 'xx公司部门2', 'fsfsf2', '', '', '', '2018-07-09 18:11:43', '', '', 0, 'sz001'),
	('201807091815301660000059', '0', '公司', 'gx', '', '', '', '2018-07-09 18:15:30', '', '', 1, 'zh001'),
	('201807091815397940000060', '201807091815301660000059', '部门', 'bm', '', '', '', '2018-07-09 18:15:39', '', '', 1, 'zh001'),
	('201807091815445680000061', '201807091815301660000059', '部门2', 'bm2', '', '', '', '2018-07-09 18:15:44', '', '', 1, 'zh001'),
	('201807100922159890000081', '201807091756566050000022', '4', '444', '44', '', '', '2018-07-10 09:22:15', '', '', 0, 'fs001'),
	('201807101725143380000084', '201807100922159890000081', 'abc', 'def', '', '', '', '2018-07-10 17:25:14', '', '', 0, 'fs001'),
	('201809271534235690000001', '201807091756191510000020', '213', '123123213', '', '', '', '2018-09-27 15:34:23', '', '', 0, 'fs001'),
	('201809271536157580000002', '201807091756353800000021', '123', '123123123', '', '', '', '2018-09-27 15:36:15', '', '', 0, 'fs001');
/*!40000 ALTER TABLE `BM` ENABLE KEYS */;

-- 导出  表 Empty.ChaoDianbiao 结构
CREATE TABLE IF NOT EXISTS `ChaoDianbiao` (
  `chaodianbiao_zj` char(24) NOT NULL COMMENT '主键',
  `chaodianbiao_loufang_zj` char(24) NOT NULL COMMENT '楼主键',
  `chaodianbiao_loufang_mc` varchar(20) NOT NULL COMMENT '楼名称',
  `chaodianbiao_loufang2_zj` char(24) NOT NULL COMMENT '房主键',
  `chaodianbiao_loufang2_bianma` varchar(20) NOT NULL COMMENT '房编号',
  `chaodianbiao_dushu1` double(10,1) NOT NULL COMMENT '上次读数',
  `chaodianbiao_riqi1` date DEFAULT NULL COMMENT '上次抄表日期',
  `chaodianbiao_dushu2` double(10,1) NOT NULL COMMENT '读数',
  `chaodianbiao_riqi2` date NOT NULL COMMENT '抄表日期',
  `chaodianbiao_dian` double(10,1) NOT NULL COMMENT '水(吨)',
  `chaodianbiao_dian_danjia` double(7,3) NOT NULL COMMENT '水单价',
  `chaodianbiao_dian_jine` double(10,1) NOT NULL COMMENT '金额',
  `chaodianbiao_zhidanshijian` datetime NOT NULL COMMENT '制单时间',
  `chaodianbiao_zhidanren` varchar(20) NOT NULL COMMENT '制单人',
  `chaodianbiao_zhidanren_zj` char(24) NOT NULL COMMENT '制单人主键',
  `chaodianbiao_fentanrenshu` int(11) NOT NULL COMMENT '分摊人数',
  `chaodianbiao_yj_fentanrenshu` int(11) NOT NULL COMMENT '已分摊人数',
  `chaodianbiao_zt` int(11) NOT NULL COMMENT '状态',
  `chaodianbiao_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  PRIMARY KEY (`chaodianbiao_zj`),
  KEY `chaodianbiao_loufang_zj` (`chaodianbiao_loufang_zj`),
  KEY `chaodianbiao_loufang2_zj` (`chaodianbiao_loufang2_zj`),
  KEY `chaodianbiao_zhidanren_zj` (`chaodianbiao_zhidanren_zj`),
  KEY `chaodianbiao_zt` (`chaodianbiao_zt`),
  KEY `chaodianbiao_gelibiaoshi` (`chaodianbiao_gelibiaoshi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='抄电表';

-- 正在导出表  Empty.ChaoDianbiao 的数据：~0 rows (大约)
DELETE FROM `ChaoDianbiao`;
/*!40000 ALTER TABLE `ChaoDianbiao` DISABLE KEYS */;
/*!40000 ALTER TABLE `ChaoDianbiao` ENABLE KEYS */;

-- 导出  表 Empty.ChaoDianbiaoFengtan 结构
CREATE TABLE IF NOT EXISTS `ChaoDianbiaoFengtan` (
  `chaodianbiaofengtan_zj` char(24) NOT NULL COMMENT '主键',
  `chaodianbiao_zj` char(24) NOT NULL COMMENT '水表记录主键',
  `chaodianbiaofengtan_dian` double(10,1) NOT NULL COMMENT '水',
  `chaodianbiaofengtan_dian_danjia` double(7,3) NOT NULL COMMENT '水单价',
  `chaodianbiaofengtan_zhanyongtian` int(11) NOT NULL COMMENT '占用天数',
  `chaodianbiaofengtan_feiyong` double(10,1) NOT NULL COMMENT '分摊费',
  `chaodianbiaofengtan_nfsj` datetime DEFAULT NULL COMMENT '纳费时间',
  `chaodianbiaofengtan_nfr_zj` char(24) NOT NULL COMMENT '纳费人主键',
  `chaodianbiaofengtan_nfr` varchar(20) NOT NULL COMMENT '纳费人',
  PRIMARY KEY (`chaodianbiaofengtan_zj`),
  KEY `chaodianbiao_zj` (`chaodianbiao_zj`),
  KEY `chaodianbiaofengtan_nfr_zj` (`chaodianbiaofengtan_nfr_zj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='电表计费分摊';

-- 正在导出表  Empty.ChaoDianbiaoFengtan 的数据：~0 rows (大约)
DELETE FROM `ChaoDianbiaoFengtan`;
/*!40000 ALTER TABLE `ChaoDianbiaoFengtan` DISABLE KEYS */;
/*!40000 ALTER TABLE `ChaoDianbiaoFengtan` ENABLE KEYS */;

-- 导出  表 Empty.ChaoShuibiao 结构
CREATE TABLE IF NOT EXISTS `ChaoShuibiao` (
  `chaoshuibiao_zj` char(24) NOT NULL COMMENT '主键',
  `chaoshuibiao_loufang_zj` char(24) NOT NULL COMMENT '楼主键',
  `chaoshuibiao_loufang_mc` varchar(20) NOT NULL COMMENT '楼名称',
  `chaoshuibiao_loufang2_zj` char(24) NOT NULL COMMENT '房主键',
  `chaoshuibiao_loufang2_bianma` varchar(20) NOT NULL COMMENT '房编号',
  `chaoshuibiao_dushu1` double(10,1) NOT NULL COMMENT '上次读数',
  `chaoshuibiao_riqi1` date DEFAULT NULL COMMENT '上次抄表日期',
  `chaoshuibiao_dushu2` double(10,1) NOT NULL COMMENT '读数',
  `chaoshuibiao_riqi2` date NOT NULL COMMENT '抄表日期',
  `chaoshuibiao_shui` double(10,1) NOT NULL COMMENT '水(吨)',
  `chaoshuibiao_shui_danjia` double(7,3) NOT NULL COMMENT '水单价',
  `chaoshuibiao_shui_jine` double(10,1) NOT NULL COMMENT '金额',
  `chaoshuibiao_zhidanshijian` datetime NOT NULL COMMENT '制单时间',
  `chaoshuibiao_zhidanren` varchar(20) NOT NULL COMMENT '制单人',
  `chaoshuibiao_zhidanren_zj` char(24) NOT NULL COMMENT '制单人主键',
  `chaoshuibiao_fentanrenshu` int(11) NOT NULL COMMENT '分摊人数',
  `chaoshuibiao_yj_fentanrenshu` int(11) NOT NULL COMMENT '已分摊人数',
  `chaoshuibiao_zt` int(11) NOT NULL COMMENT '状态',
  `chaoshuibiao_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  PRIMARY KEY (`chaoshuibiao_zj`),
  KEY `chaoshuibiao_loufang_zj` (`chaoshuibiao_loufang_zj`),
  KEY `chaoshuibiao_loufang2_zj` (`chaoshuibiao_loufang2_zj`),
  KEY `chaoshuibiao_zhidanren_zj` (`chaoshuibiao_zhidanren_zj`),
  KEY `chaoshuibiao_zt` (`chaoshuibiao_zt`),
  KEY `chaoshuibiao_gelibiaoshi` (`chaoshuibiao_gelibiaoshi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='抄水表';

-- 正在导出表  Empty.ChaoShuibiao 的数据：~2 rows (大约)
DELETE FROM `ChaoShuibiao`;
/*!40000 ALTER TABLE `ChaoShuibiao` DISABLE KEYS */;
INSERT INTO `ChaoShuibiao` (`chaoshuibiao_zj`, `chaoshuibiao_loufang_zj`, `chaoshuibiao_loufang_mc`, `chaoshuibiao_loufang2_zj`, `chaoshuibiao_loufang2_bianma`, `chaoshuibiao_dushu1`, `chaoshuibiao_riqi1`, `chaoshuibiao_dushu2`, `chaoshuibiao_riqi2`, `chaoshuibiao_shui`, `chaoshuibiao_shui_danjia`, `chaoshuibiao_shui_jine`, `chaoshuibiao_zhidanshijian`, `chaoshuibiao_zhidanren`, `chaoshuibiao_zhidanren_zj`, `chaoshuibiao_fentanrenshu`, `chaoshuibiao_yj_fentanrenshu`, `chaoshuibiao_zt`, `chaoshuibiao_gelibiaoshi`) VALUES
	('201808201722409220000005', '201808201438099740000001', '港湾公寓B栋', '201808201438099740000005', '107', 0.0, '2018-08-01', 12.0, '2018-08-18', 2.0, 0.340, 0.7, '2018-08-20 17:22:37', '汪春滋', '201807091801013420000036', 1, 0, 0, 'fs001'),
	('201808201722581860000007', '201808201438099740000001', '港湾公寓B栋', '201808201438099740000005', '107', 12.0, '2018-08-18', 12.0, '2018-08-19', 2.0, 0.340, 0.7, '2018-08-20 17:22:55', '汪春滋', '201807091801013420000036', 1, 0, 0, 'fs001');
/*!40000 ALTER TABLE `ChaoShuibiao` ENABLE KEYS */;

-- 导出  表 Empty.ChaoShuibiaoFengtan 结构
CREATE TABLE IF NOT EXISTS `ChaoShuibiaoFengtan` (
  `chaoshuibiaofengtan_zj` char(24) NOT NULL COMMENT '主键',
  `chaoshuibiao_zj` char(24) NOT NULL COMMENT '水表记录主键',
  `chaoshuibiaofengtan_shui` double(10,1) NOT NULL COMMENT '水',
  `chaoshuibiaofengtan_shui_danjia` double(7,3) NOT NULL COMMENT '水单价',
  `chaoshuibiaofengtan_zhanyongtian` int(11) NOT NULL COMMENT '占用天数',
  `chaoshuibiaofengtan_feiyong` double(10,1) NOT NULL COMMENT '分摊费',
  `chaoshuibiaofengtan_nfsj` datetime DEFAULT NULL COMMENT '纳费时间',
  `chaoshuibiaofengtan_nfr_zj` char(24) NOT NULL COMMENT '纳费人主键',
  `chaoshuibiaofengtan_nfr` varchar(20) NOT NULL COMMENT '纳费人',
  PRIMARY KEY (`chaoshuibiaofengtan_zj`),
  KEY `chaoshuibiao_zj` (`chaoshuibiao_zj`),
  KEY `chaoshuibiaofengtan_nfr_zj` (`chaoshuibiaofengtan_nfr_zj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='水表计费分摊';

-- 正在导出表  Empty.ChaoShuibiaoFengtan 的数据：~2 rows (大约)
DELETE FROM `ChaoShuibiaoFengtan`;
/*!40000 ALTER TABLE `ChaoShuibiaoFengtan` DISABLE KEYS */;
INSERT INTO `ChaoShuibiaoFengtan` (`chaoshuibiaofengtan_zj`, `chaoshuibiao_zj`, `chaoshuibiaofengtan_shui`, `chaoshuibiaofengtan_shui_danjia`, `chaoshuibiaofengtan_zhanyongtian`, `chaoshuibiaofengtan_feiyong`, `chaoshuibiaofengtan_nfsj`, `chaoshuibiaofengtan_nfr_zj`, `chaoshuibiaofengtan_nfr`) VALUES
	('201808201722409230000006', '201808201722409220000005', 2.0, 0.340, 1, 0.7, NULL, '201807091801013420000036', '汪春滋'),
	('201808201722581860000008', '201808201722581860000007', 2.0, 0.340, 2, 0.7, NULL, '201807091801013420000036', '汪春滋');
/*!40000 ALTER TABLE `ChaoShuibiaoFengtan` ENABLE KEYS */;

-- 导出  表 Empty.Gangwei 结构
CREATE TABLE IF NOT EXISTS `Gangwei` (
  `gangwei_zj` char(24) NOT NULL COMMENT '主键',
  `gangwei_fzj` char(24) NOT NULL COMMENT '父键',
  `gangwei_mc` varchar(20) NOT NULL COMMENT '名称',
  `gangwei_zhidanshijian` datetime NOT NULL COMMENT '制单时间',
  `gangwei_bz` varchar(1000) DEFAULT NULL COMMENT '备注',
  `gangwei_zt` int(11) NOT NULL COMMENT '状态',
  `gangwei_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  PRIMARY KEY (`gangwei_zj`),
  KEY `gangwei_fzj` (`gangwei_fzj`),
  KEY `gangwei_zt` (`gangwei_zt`),
  KEY `gangwei_gelibiaoshi` (`gangwei_gelibiaoshi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='岗位';

-- 正在导出表  Empty.Gangwei 的数据：~10 rows (大约)
DELETE FROM `Gangwei`;
/*!40000 ALTER TABLE `Gangwei` DISABLE KEYS */;
INSERT INTO `Gangwei` (`gangwei_zj`, `gangwei_fzj`, `gangwei_mc`, `gangwei_zhidanshijian`, `gangwei_bz`, `gangwei_zt`, `gangwei_gelibiaoshi`) VALUES
	('201807091757315730000023', '0', '技术类', '2018-07-09 17:57:31', '', 0, 'fs001'),
	('201807091757371360000024', '0', '服务类', '2018-07-09 17:57:37', '', 0, 'fs001'),
	('201807091757451710000025', '0', '生产类2', '2018-07-09 17:57:45', '', 0, 'fs001'),
	('201807091757562310000026', '201807091757315730000023', '软件开发', '2018-07-09 17:57:56', '', 0, 'fs001'),
	('201807091758046190000027', '201807091757315730000023', 'ERP工程师', '2018-07-09 17:58:04', '', 0, 'fs001'),
	('201807091758189930000028', '201807091757315730000023', 'IT工程师', '2018-07-09 17:58:18', '', 0, 'fs001'),
	('201807091812089440000052', '0', 'erp工程师', '2018-07-09 18:12:08', '', 0, 'sz001'),
	('201807091812178860000053', '0', '软件开发', '2018-07-09 18:12:17', '', 0, 'sz001'),
	('201807091815532290000062', '0', '软件开发', '2018-07-09 18:15:53', '', 1, 'zh001'),
	('201807091816004710000063', '0', 'erp工程师', '2018-07-09 18:16:00', '', 1, 'zh001');
/*!40000 ALTER TABLE `Gangwei` ENABLE KEYS */;

-- 导出  表 Empty.Loufang 结构
CREATE TABLE IF NOT EXISTS `Loufang` (
  `loufang_zj` char(24) NOT NULL COMMENT '主键',
  `loufangfl_zj` char(24) NOT NULL COMMENT '分类外键',
  `loufang_mc` varchar(20) NOT NULL COMMENT '名称',
  `loufang_dizhi` varchar(200) DEFAULT '' COMMENT '地址',
  `loufang_bz` varchar(200) DEFAULT '' COMMENT '备注',
  `loufang_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  `loufang_zt` int(11) NOT NULL COMMENT '状态',
  `loufang_danjian_chuangwei` int(11) DEFAULT '0' COMMENT '单间床位',
  `loufang_danjian_chuangwei2` int(11) DEFAULT '0' COMMENT '已用单间床位',
  `loufang_taojian_chuangwei` int(11) DEFAULT '0' COMMENT '套间床位',
  `loufang_taojian_chuangwei2` int(11) DEFAULT '0' COMMENT '已用套间床位',
  PRIMARY KEY (`loufang_zj`),
  KEY `loufangfl_zj` (`loufangfl_zj`),
  KEY `loufang_gelibiaoshi` (`loufang_gelibiaoshi`),
  KEY `loufang_zt` (`loufang_zt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='楼房';

-- 正在导出表  Empty.Loufang 的数据：~2 rows (大约)
DELETE FROM `Loufang`;
/*!40000 ALTER TABLE `Loufang` DISABLE KEYS */;
INSERT INTO `Loufang` (`loufang_zj`, `loufangfl_zj`, `loufang_mc`, `loufang_dizhi`, `loufang_bz`, `loufang_gelibiaoshi`, `loufang_zt`, `loufang_danjian_chuangwei`, `loufang_danjian_chuangwei2`, `loufang_taojian_chuangwei`, `loufang_taojian_chuangwei2`) VALUES
	('201808201438099740000001', '201808201414461680000001', '港湾公寓B栋', '珠海香洲唐家湾东岸村西堡路2号', '', 'fs001', 0, 33, 1, 24, 2),
	('201808201438336370000039', '201808201414461680000001', '港湾公寓A栋', '珠海香洲唐家湾东岸村西堡路2号', '', 'fs001', 0, 33, 0, 24, 0);
/*!40000 ALTER TABLE `Loufang` ENABLE KEYS */;

-- 导出  表 Empty.Loufang2 结构
CREATE TABLE IF NOT EXISTS `Loufang2` (
  `loufang_zj` char(24) NOT NULL COMMENT '父键',
  `loufang2_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  `loufang2_zj` char(24) NOT NULL COMMENT '主键',
  `loufang2_bianhao` varchar(20) NOT NULL COMMENT '编号',
  `loufang2_mingcheng` varchar(20) NOT NULL COMMENT '名称',
  `loufang2_chuangwei` int(11) NOT NULL COMMENT '床位',
  `loufang2_ruzhurenshu` int(11) NOT NULL COMMENT '入住人数',
  `loufang2_ruzhuren_zj` text COMMENT '入住人主键集合',
  `loufang2_lx` varchar(20) DEFAULT NULL COMMENT '房间类型',
  `loufang2_bz` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`loufang2_zj`),
  UNIQUE KEY `loufang2_bianhao` (`loufang2_bianhao`,`loufang_zj`),
  KEY `loufang_zj` (`loufang_zj`),
  KEY `loufang2_gelibiaoshi` (`loufang2_gelibiaoshi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='楼房2';

-- 正在导出表  Empty.Loufang2 的数据：~74 rows (大约)
DELETE FROM `Loufang2`;
/*!40000 ALTER TABLE `Loufang2` DISABLE KEYS */;
INSERT INTO `Loufang2` (`loufang_zj`, `loufang2_gelibiaoshi`, `loufang2_zj`, `loufang2_bianhao`, `loufang2_mingcheng`, `loufang2_chuangwei`, `loufang2_ruzhurenshu`, `loufang2_ruzhuren_zj`, `loufang2_lx`, `loufang2_bz`) VALUES
	('201808201438099740000001', 'fs001', '201808201438099740000002', '104', '104房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099740000003', '105', '105房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099740000004', '106', '106房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099740000005', '107', '107房', 1, 1, '201807091801013420000036', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000006', '108', '108房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000007', '201', '套间', 6, 2, '201807091801013420000036,201807091801013420000036', '套间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000008', '202', '202房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000009', '203', '203房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000010', '204', '204房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000011', '205', '205房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000012', '206', '206房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000013', '207', '207房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000014', '208', '208房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000015', '301', '301套间', 6, 0, '', '套间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000016', '302', '302房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000017', '303', '303房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000018', '304', '304房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000019', '305', '305房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000020', '306', '306房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000021', '307', '307房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000022', '308', '308房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000023', '401', '401套间', 6, 0, '', '套间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000024', '402', '402房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000025', '403', '403房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000026', '404', '404房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000027', '405', '405房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000028', '406', '406房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000029', '407', '407房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000030', '408', '408房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000031', '501', '501套间', 6, 0, '', '套间', ''),
	('201808201438099740000001', 'fs001', '201808201438099750000032', '502', '502房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099760000033', '503', '503房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099760000034', '504', '504房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099760000035', '505', '505房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099760000036', '506', '506房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099760000037', '507', '507房', 1, 0, '', '单间', ''),
	('201808201438099740000001', 'fs001', '201808201438099760000038', '508', '508房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000040', '104', '104房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000041', '105', '105房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000042', '106', '106房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000043', '107', '107房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000044', '108', '108房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000045', '201', '套间', 6, 0, '', '套间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000046', '202', '202房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000047', '203', '203房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000048', '204', '204房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000049', '205', '205房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000050', '206', '206房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000051', '207', '207房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000052', '208', '208房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000053', '301', '301套间', 6, 0, '', '套间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000054', '302', '302房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000055', '303', '303房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000056', '304', '304房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000057', '305', '305房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000058', '306', '306房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000059', '307', '307房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000060', '308', '308房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000061', '401', '401套间', 6, 0, '', '套间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000062', '402', '402房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000063', '403', '403房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000064', '404', '404房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000065', '405', '405房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000066', '406', '406房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000067', '407', '407房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000068', '408', '408房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000069', '501', '501套间', 6, 0, '', '套间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000070', '502', '502房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000071', '503', '503房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000072', '504', '504房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000073', '505', '505房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000074', '506', '506房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000075', '507', '507房', 1, 0, '', '单间', ''),
	('201808201438336370000039', 'fs001', '201808201438336380000076', '508', '508房', 1, 0, '', '单间', '');
/*!40000 ALTER TABLE `Loufang2` ENABLE KEYS */;

-- 导出  表 Empty.LoufangFL 结构
CREATE TABLE IF NOT EXISTS `LoufangFL` (
  `loufangfl_px` int(11) DEFAULT NULL COMMENT '排序',
  `loufangfl_zj` char(24) NOT NULL COMMENT '主键',
  `loufangfl_fzj` char(24) NOT NULL COMMENT '父主键',
  `loufangfl_mc` varchar(20) NOT NULL COMMENT '名称',
  `loufangfl_bz` varchar(200) DEFAULT NULL COMMENT '备注',
  `loufangfl_zt` int(11) NOT NULL COMMENT '状态',
  `loufangfl_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  PRIMARY KEY (`loufangfl_zj`),
  KEY `loufangfl_fzj` (`loufangfl_fzj`),
  KEY `loufangfl_zt` (`loufangfl_zt`),
  KEY `loufangfl_gelibiaoshi` (`loufangfl_gelibiaoshi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='楼房分类';

-- 正在导出表  Empty.LoufangFL 的数据：~2 rows (大约)
DELETE FROM `LoufangFL`;
/*!40000 ALTER TABLE `LoufangFL` DISABLE KEYS */;
INSERT INTO `LoufangFL` (`loufangfl_px`, `loufangfl_zj`, `loufangfl_fzj`, `loufangfl_mc`, `loufangfl_bz`, `loufangfl_zt`, `loufangfl_gelibiaoshi`) VALUES
	(0, '201808201414461680000001', '0', '珠海区', '', 1, 'fs001'),
	(0, '201808201414536560000002', '0', '深圳区', '', 1, 'fs001');
/*!40000 ALTER TABLE `LoufangFL` ENABLE KEYS */;

-- 导出  表 Empty.LoufangFYBZ 结构
CREATE TABLE IF NOT EXISTS `LoufangFYBZ` (
  `loufang_fybz_zj` char(24) NOT NULL COMMENT '主键',
  `loufang_fybz_loufang_zj` char(24) NOT NULL COMMENT '楼房主键',
  `loufang_fybz_loufang_mc` varchar(20) NOT NULL COMMENT '楼名',
  `loufang_fybz_dianfei` double(7,3) NOT NULL COMMENT '电费标准',
  `loufang_fybz_shuifei` double(7,3) NOT NULL COMMENT '水费标准',
  `loufang_fybz_shuifei_leng` double(7,3) NOT NULL COMMENT '冷水费标准',
  `loufang_fybz_shuifei_re` double(7,3) NOT NULL COMMENT '热水费标准',
  `loufang_fybz_meiqi` double(7,3) NOT NULL COMMENT '煤气费标准',
  `loufang_fybz_zt` int(11) NOT NULL COMMENT '状态',
  `loufang_fybz_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  PRIMARY KEY (`loufang_fybz_zj`),
  KEY `loufang_fybz_loufang_zj` (`loufang_fybz_loufang_zj`),
  KEY `loufang_fybz_zt` (`loufang_fybz_zt`),
  KEY `loufang_fybz_gelibiaoshi` (`loufang_fybz_gelibiaoshi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='楼房费用标准';

-- 正在导出表  Empty.LoufangFYBZ 的数据：~2 rows (大约)
DELETE FROM `LoufangFYBZ`;
/*!40000 ALTER TABLE `LoufangFYBZ` DISABLE KEYS */;
INSERT INTO `LoufangFYBZ` (`loufang_fybz_zj`, `loufang_fybz_loufang_zj`, `loufang_fybz_loufang_mc`, `loufang_fybz_dianfei`, `loufang_fybz_shuifei`, `loufang_fybz_shuifei_leng`, `loufang_fybz_shuifei_re`, `loufang_fybz_meiqi`, `loufang_fybz_zt`, `loufang_fybz_gelibiaoshi`) VALUES
	('201808201458475040000077', '201808201438099740000001', '港湾公寓B栋', 0.900, 0.340, 0.000, 0.000, 0.000, 1, 'fs001'),
	('201808201459014230000078', '201808201438336370000039', '港湾公寓A栋', 1.000, 0.222, 0.000, 0.000, 0.000, 1, 'fs001');
/*!40000 ALTER TABLE `LoufangFYBZ` ENABLE KEYS */;

-- 导出  表 Empty.LoufangNafei 结构
CREATE TABLE IF NOT EXISTS `LoufangNafei` (
  `loufangnafei_zj` char(24) NOT NULL COMMENT '主键',
  `loufangnafei_lou_zj` char(24) NOT NULL COMMENT '楼主键',
  `loufangnafei_fang_zj` char(24) NOT NULL COMMENT '房主键',
  `loufangnafei_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  `loufangnafei_lou_mc` varchar(20) NOT NULL COMMENT '楼名称',
  `loufangnafei_fang_bianma` varchar(20) NOT NULL COMMENT '房编码',
  `loufangnafei_ren` varchar(20) NOT NULL COMMENT '纳费人',
  `loufangnafei_ren_zj` char(24) NOT NULL COMMENT '纳费人主键',
  `loufangnafei_yingnariqi` date NOT NULL COMMENT '应纳日期',
  `loufangnafei_nafeiriqi` date DEFAULT NULL COMMENT '纳费日期',
  `loufangnafei_zongfeiyong` double(10,1) NOT NULL COMMENT '总费用',
  `loufangnafei_zongfeiyong2` double(10,1) NOT NULL COMMENT '已纳费用',
  `loufangnafei_fangzu` double(10,1) NOT NULL COMMENT '房租',
  `loufangnafei_feiyong_shui` double(10,1) NOT NULL COMMENT '水费',
  `loufangnafei_feiyong_shui_zj` text COMMENT '水费主键集合',
  `loufangnafei_feiyong_dian` double(10,1) NOT NULL COMMENT '电费',
  `loufangnafei_feiyong_dian_zj` text COMMENT '电费主键集合',
  `loufangnafei_feiyong_xm` double(10,1) NOT NULL COMMENT '项目费',
  `loufangnafei_feiyong_xm_zj` text COMMENT '项目费主键集合',
  `loufangnafei_feiyong_meiqi` double(10,1) DEFAULT NULL COMMENT '煤气费',
  `loufangnafei_feiyong_meiqi_zj` text COMMENT '煤气费主键集合',
  `loufangnafei_zt` int(11) NOT NULL COMMENT '状态',
  `loufangnafei_chuzhangshijian` datetime NOT NULL COMMENT '出账时间',
  PRIMARY KEY (`loufangnafei_zj`),
  KEY `loufangnafei_lou_zj` (`loufangnafei_lou_zj`),
  KEY `loufangnafei_fang_zj` (`loufangnafei_fang_zj`),
  KEY `loufangnafei_gelibiaoshi` (`loufangnafei_gelibiaoshi`),
  KEY `loufangnafei_lou_mc` (`loufangnafei_lou_mc`),
  KEY `loufangnafei_fang_bianma` (`loufangnafei_fang_bianma`),
  KEY `loufangnafei_ren_zj` (`loufangnafei_ren_zj`),
  KEY `loufangnafei_zt` (`loufangnafei_zt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='楼房纳费';

-- 正在导出表  Empty.LoufangNafei 的数据：~0 rows (大约)
DELETE FROM `LoufangNafei`;
/*!40000 ALTER TABLE `LoufangNafei` DISABLE KEYS */;
/*!40000 ALTER TABLE `LoufangNafei` ENABLE KEYS */;

-- 导出  表 Empty.LoufangXMF 结构
CREATE TABLE IF NOT EXISTS `LoufangXMF` (
  `loufangxmf_zj` char(24) NOT NULL COMMENT '主键',
  `loufangxmf_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  `loufangxmf_mc` varchar(20) NOT NULL COMMENT '项目名称',
  `loufangxmf_feiyong` int(11) NOT NULL COMMENT '项目费',
  `loufangxmf_zt` int(11) NOT NULL COMMENT '状态',
  PRIMARY KEY (`loufangxmf_zj`),
  UNIQUE KEY `loufangxmf_mc` (`loufangxmf_mc`,`loufangxmf_gelibiaoshi`),
  KEY `loufangxmf_gelibiaoshi` (`loufangxmf_gelibiaoshi`),
  KEY `loufangxmf_zt` (`loufangxmf_zt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='楼房项目费';

-- 正在导出表  Empty.LoufangXMF 的数据：~3 rows (大约)
DELETE FROM `LoufangXMF`;
/*!40000 ALTER TABLE `LoufangXMF` DISABLE KEYS */;
INSERT INTO `LoufangXMF` (`loufangxmf_zj`, `loufangxmf_gelibiaoshi`, `loufangxmf_mc`, `loufangxmf_feiyong`, `loufangxmf_zt`) VALUES
	('201807201104445840000011', 'fs001', '环境费', 15, 1),
	('201807201104580950000012', 'fs001', '卫生费', 15, 1),
	('201807201105074810000013', 'fs001', '网费', 40, 1);
/*!40000 ALTER TABLE `LoufangXMF` ENABLE KEYS */;

-- 导出  表 Empty.RY 结构
CREATE TABLE IF NOT EXISTS `RY` (
  `ry_zj` char(24) NOT NULL COMMENT '主键',
  `ry_bm` varchar(50) NOT NULL COMMENT '部门',
  `ry_bm_zj` char(24) NOT NULL COMMENT '部门主键',
  `ry_mc` varchar(20) NOT NULL COMMENT '人员名称',
  `ry_zhanghao` varchar(100) NOT NULL COMMENT '账号',
  `ry_mima` varchar(100) NOT NULL COMMENT '密码',
  `ry_xingbie` varchar(2) NOT NULL COMMENT '性别',
  `ry_ruzhiriqi` date NOT NULL COMMENT '入职日期',
  `ry_chushengriqi` date DEFAULT NULL COMMENT '出生日期',
  `ry_lizhiriqi` date DEFAULT NULL COMMENT '离职日期',
  `ry_jiguan` varchar(20) DEFAULT NULL COMMENT '籍贯',
  `ry_shouji1` varchar(20) DEFAULT NULL COMMENT '手机1',
  `ry_youxiang` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `ry_hunyin` varchar(2) DEFAULT NULL COMMENT '婚姻状态',
  `ry_gangwei_zj` char(24) DEFAULT NULL COMMENT '岗位主键',
  `ry_gangwei` varchar(50) DEFAULT NULL COMMENT '岗位',
  `ry_zhiwei_zj` char(24) DEFAULT NULL COMMENT '职位主键',
  `ry_zhiwei` varchar(50) DEFAULT NULL COMMENT '职位',
  `ry_tupian` varchar(200) DEFAULT NULL COMMENT '图片',
  `ry_bz` varchar(200) DEFAULT NULL COMMENT '备注',
  `ry_shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证号码',
  `ry_tupian_zhengjian1` varchar(200) DEFAULT NULL COMMENT '证件图_正面',
  `ry_tupian_zhengjian2` varchar(200) DEFAULT NULL COMMENT '证件图_反面',
  `ry_xianzhudizhi` varchar(200) DEFAULT NULL COMMENT '现住地址',
  `ry_jiatingdizhi` varchar(200) DEFAULT NULL COMMENT '家庭地址',
  `ry_jinjilianxiren` varchar(20) DEFAULT NULL COMMENT '紧急联系人',
  `ry_jinjilianxiren_dianhua` varchar(20) DEFAULT NULL COMMENT '紧急联系人电话',
  `ry_gudingdianhua1` varchar(20) DEFAULT NULL COMMENT '固定电话1',
  `ry_gudingdianhua2` varchar(20) DEFAULT NULL COMMENT '固定电话2',
  `ry_qitatongxing` varchar(50) DEFAULT NULL COMMENT '其他通信',
  `ry_qitatongxing1` varchar(50) DEFAULT NULL COMMENT '其他通信1',
  `ry_qitatongxing2` varchar(50) DEFAULT NULL COMMENT '其他通信2',
  `ry_qitatongxing3` varchar(50) DEFAULT NULL COMMENT '其他通信3',
  `ry_qitatongxing4` varchar(50) DEFAULT NULL COMMENT '其他通信4',
  `ry_qitatongxing5` varchar(50) DEFAULT NULL COMMENT '其他通信5',
  `ry_neibutongxing1` varchar(50) DEFAULT NULL COMMENT '内部通信1',
  `ry_neibutongxing2` varchar(50) DEFAULT NULL COMMENT '内部通信2',
  `ry_neibutongxing3` varchar(50) DEFAULT NULL COMMENT '内部通信3',
  `ry_neibutongxing4` varchar(50) DEFAULT NULL COMMENT '内部通信4',
  `ry_neibutongxing5` varchar(50) DEFAULT NULL COMMENT '内部通信5',
  `ry_neibutongxing6` varchar(50) DEFAULT NULL COMMENT '内部通信6',
  `ry_neibutongxing7` varchar(50) DEFAULT NULL COMMENT '内部通信7',
  `ry_neibutongxing8` varchar(50) DEFAULT NULL COMMENT '内部通信8',
  `ry_neibutongxing9` varchar(50) DEFAULT NULL COMMENT '内部通信9',
  `ry_neibutongxing10` varchar(50) DEFAULT NULL COMMENT '内部通信10',
  `ry_zhidanren_zj` char(24) NOT NULL COMMENT '制单人主键',
  `ry_zhidanren` varchar(200) NOT NULL COMMENT '制单人',
  `ry_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  `ry_zt` int(11) NOT NULL COMMENT '状态',
  PRIMARY KEY (`ry_zj`),
  UNIQUE KEY `ry_zhanghao` (`ry_zhanghao`,`ry_gelibiaoshi`),
  KEY `ry_bm_zj` (`ry_bm_zj`),
  KEY `ry_gangwei_zj` (`ry_gangwei_zj`),
  KEY `ry_zhiwei_zj` (`ry_zhiwei_zj`),
  KEY `ry_zhidanren_zj` (`ry_zhidanren_zj`),
  KEY `ry_zt` (`ry_zt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='人员管理';

-- 正在导出表  Empty.RY 的数据：~7 rows (大约)
DELETE FROM `RY`;
/*!40000 ALTER TABLE `RY` DISABLE KEYS */;
INSERT INTO `RY` (`ry_zj`, `ry_bm`, `ry_bm_zj`, `ry_mc`, `ry_zhanghao`, `ry_mima`, `ry_xingbie`, `ry_ruzhiriqi`, `ry_chushengriqi`, `ry_lizhiriqi`, `ry_jiguan`, `ry_shouji1`, `ry_youxiang`, `ry_hunyin`, `ry_gangwei_zj`, `ry_gangwei`, `ry_zhiwei_zj`, `ry_zhiwei`, `ry_tupian`, `ry_bz`, `ry_shenfenzheng`, `ry_tupian_zhengjian1`, `ry_tupian_zhengjian2`, `ry_xianzhudizhi`, `ry_jiatingdizhi`, `ry_jinjilianxiren`, `ry_jinjilianxiren_dianhua`, `ry_gudingdianhua1`, `ry_gudingdianhua2`, `ry_qitatongxing`, `ry_qitatongxing1`, `ry_qitatongxing2`, `ry_qitatongxing3`, `ry_qitatongxing4`, `ry_qitatongxing5`, `ry_neibutongxing1`, `ry_neibutongxing2`, `ry_neibutongxing3`, `ry_neibutongxing4`, `ry_neibutongxing5`, `ry_neibutongxing6`, `ry_neibutongxing7`, `ry_neibutongxing8`, `ry_neibutongxing9`, `ry_neibutongxing10`, `ry_zhidanren_zj`, `ry_zhidanren`, `ry_gelibiaoshi`, `ry_zt`) VALUES
	('201807091801013420000036', '信息部', '201807091756191510000020', '汪春滋', 'wangchunzi', '123', '男', '2018-07-09', NULL, NULL, '', '', '', '', '201807091757315730000023', '技术类', '201807091759326480000031', 'ceo', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'fs001', 1),
	('201807091801369260000037', '人事部', '201807091756353800000021', '小红', 'xiaohong', '123', '女', '2018-07-09', NULL, NULL, '', '', '', '', '201807091757371360000024', '服务类', '201807091759517570000034', '主管', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'fs001', 0),
	('201807091812594750000054', 'xx公司部门', '201807091811342660000050', '汪汪汪', 'wangchunzi1', '123', '男', '2018-07-09', NULL, NULL, '', '', '', '', '201807091812178860000053', '软件开发', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'sz001', 1),
	('201807091813590540000057', 'xx公司部门2', '201807091811432520000051', '222', '222', '222', '女', '2018-07-09', NULL, NULL, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'sz001', 1),
	('201807091816383470000066', '部门', '201807091815397940000060', '哈哈1', 'haha1', '123', '男', '2018-07-09', NULL, NULL, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'zh001', 1),
	('201807091816592270000067', '部门2', '201807091815445680000061', '哈哈2', 'haha2', '123', '女', '2018-07-09', NULL, NULL, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'zh001', 1),
	('201807181540196570000001', '人事部', '201807091756353800000021', '小红', 'xh', 'xh', '男', '2018-07-18', NULL, NULL, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'fs001', 0);
/*!40000 ALTER TABLE `RY` ENABLE KEYS */;

-- 导出  表 Empty.XtGuanliyuan 结构
CREATE TABLE IF NOT EXISTS `XtGuanliyuan` (
  `xt_guanliyuan_zj` char(24) NOT NULL COMMENT '管理员主键',
  `xt_guanliyuan_mc` varchar(20) NOT NULL COMMENT '管理员名称',
  `xt_guanliyuan_zhanghao` varchar(20) NOT NULL COMMENT '管理员账号',
  `xt_guanliyuan_mima` varchar(64) NOT NULL COMMENT '管理员密码',
  `xt_guanliyuan_youxiang` varchar(100) DEFAULT NULL COMMENT '管理员邮箱',
  `xt_guanliyuan_zt` int(11) NOT NULL COMMENT '管理员状态',
  `xt_guanliyuan_bz` varchar(200) DEFAULT NULL COMMENT '管理员备注',
  `xt_guanliyuan_quanxian` text COMMENT '管理员权限集合',
  `xt_guanliyuan_bm` text COMMENT '管理员部门集合',
  `xt_guanliyuan_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  `xt_guanliyuan_zhidanshijian` datetime NOT NULL COMMENT '制单时间',
  `xt_guanliyuan_jibie` int(1) unsigned NOT NULL,
  PRIMARY KEY (`xt_guanliyuan_zj`),
  KEY `xt_guanliyuan_zhanghao` (`xt_guanliyuan_zhanghao`),
  KEY `xt_guanliyuan_zt` (`xt_guanliyuan_zt`),
  KEY `xt_guanliyuan_gelibiaoshi` (`xt_guanliyuan_gelibiaoshi`),
  KEY `xt_guanliyuan_jibie` (`xt_guanliyuan_jibie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统管理员';

-- 正在导出表  Empty.XtGuanliyuan 的数据：~5 rows (大约)
DELETE FROM `XtGuanliyuan`;
/*!40000 ALTER TABLE `XtGuanliyuan` DISABLE KEYS */;
INSERT INTO `XtGuanliyuan` (`xt_guanliyuan_zj`, `xt_guanliyuan_mc`, `xt_guanliyuan_zhanghao`, `xt_guanliyuan_mima`, `xt_guanliyuan_youxiang`, `xt_guanliyuan_zt`, `xt_guanliyuan_bz`, `xt_guanliyuan_quanxian`, `xt_guanliyuan_bm`, `xt_guanliyuan_gelibiaoshi`, `xt_guanliyuan_zhidanshijian`, `xt_guanliyuan_jibie`) VALUES
	('201807030723353900000001', '超级管理员', 'S', 'pk9821888ww', '', 1, '', '', '', 'S', '2018-07-03 07:23:35', 1),
	('201807091746493090000004', '佛山xx公司', 'fsdemo', 'fsdemo', '', 1, '', 'service,yw_ml_loufang,chaoshuibiaoA,chaoshuibiao,chaoshuibiaoS,chaoshuibiaoD,chaoshuibiaoU,chaoshuibiaoE,chaoshuibiaoUE,chaoshuibiaoV,chaoshuibiaoUV,chaodianbiaoA,chaodianbiao,chaodianbiaoS,chaodianbiaoD,chaodianbiaoU,chaodianbiaoE,chaodianbiaoUE,chaodianbiaoV,chaodianbiaoUV,loufangchuzhang,loufangchuzhangS,loufangchuzhangA,loufangnafei,loufangnafeiS,loufangnafeiD,loufangnafeiU,loufangnafeiE,loufangnafeiUE,loufangnafeiV,loufangnafeiUV,base,bmA,bm,bmS,bmD,bmU,bmE,bmUE,bmV,bmUV,gangweiA,gangwei,gangweiS,gangweiD,gangweiU,gangweiE,gangweiUE,gangweiV,gangweiUV,ryA,ry,ryS,ryD,ryU,ryE,ryUE,ryV,ryUV,zhiweiA,zhiwei,zhiweiS,zhiweiD,zhiweiU,zhiweiE,zhiweiUE,zhiweiV,zhiweiUV,jc_ml_loufang,loufangflA,loufangfl,loufangflS,loufangflD,loufangflU,loufangflE,loufangflUE,loufangflV,loufangflUV,loufangA,loufang,loufangS,loufangD,loufangU,loufangE,loufangUE,loufangV,loufangUV,loufangxmfA,loufangxmf,loufangxmfS,loufangxmfD,loufangxmfU,loufangxmfE,loufangxmfUE,loufangxmfV,loufangxmfUV,loufangfybzA,loufangfybz,loufangfybzS,loufangfybzD,loufangfybzU,loufangfybzE,loufangfybzUE,loufangfybzV,loufangfybzUV,zhusuhetongA,zhusuhetong,zhusuhetongS,zhusuhetongD,zhusuhetongU,zhusuhetongE,zhusuhetongUE,zhusuhetongV,zhusuhetongUV,xt,xt_ml_zongguan,xt_ml_zongguan_1,xtjuese2A,xtjuese2,xtjuese2S,xtjuese2D,xtjuese2U,xtjuese2E,xtjuese2UE,xtjuese2V,xtjuese2UV,xtjuesequanxian2,xt_ml_zongguan_2,xtguanliyuan2A,xtguanliyuan2,xtguanliyuan2S,xtguanliyuan2D,xtguanliyuan2U,xtguanliyuan2E,xtguanliyuan2UE,xtguanliyuan2V,xtguanliyuan2UV,xtguanliyuanquanxian2_xiuganbm,xtguanliyuanjueseAUD,xtguanliyuanquanxian2_xiuganquanxian,xtryquanxian2,updatepassword2,xt_ml_fuguan,xt_ml_fuguanyuan_juese,xtjuese3A,xtjuese3,xtjuese3S,xtjuese3D,xtjuese3U,xtjuese3E,xtjuese3UE,xtjuese3V,xtjuese3UV,xtjuesequanxian3,updatepassword3,xtryquanxian3,updatepasswordUser', '', 'fs001', '2018-07-09 17:46:49', 2),
	('201807091747076600000005', '深圳xx公司', 'szdemo', 'szdemo', '', 1, '', 'service,yw_ml_loufang,chaoshuibiaoA,chaoshuibiao,chaoshuibiaoS,chaoshuibiaoD,chaoshuibiaoU,chaoshuibiaoE,chaoshuibiaoUE,chaoshuibiaoV,chaoshuibiaoUV,chaodianbiaoA,chaodianbiao,chaodianbiaoS,chaodianbiaoD,chaodianbiaoU,chaodianbiaoE,chaodianbiaoUE,chaodianbiaoV,chaodianbiaoUV,loufangchuzhang,loufangchuzhangS,loufangchuzhangA,loufangnafei,loufangnafeiS,loufangnafeiD,loufangnafeiU,loufangnafeiE,loufangnafeiUE,loufangnafeiV,loufangnafeiUV,base,bmA,bm,bmS,bmD,bmU,bmE,bmUE,bmV,bmUV,gangweiA,gangwei,gangweiS,gangweiD,gangweiU,gangweiE,gangweiUE,gangweiV,gangweiUV,ryA,ry,ryS,ryD,ryU,ryE,ryUE,ryV,ryUV,zhiweiA,zhiwei,zhiweiS,zhiweiD,zhiweiU,zhiweiE,zhiweiUE,zhiweiV,zhiweiUV,jc_ml_loufang,loufangflA,loufangfl,loufangflS,loufangflD,loufangflU,loufangflE,loufangflUE,loufangflV,loufangflUV,loufangA,loufang,loufangS,loufangD,loufangU,loufangE,loufangUE,loufangV,loufangUV,loufangxmfA,loufangxmf,loufangxmfS,loufangxmfD,loufangxmfU,loufangxmfE,loufangxmfUE,loufangxmfV,loufangxmfUV,loufangfybzA,loufangfybz,loufangfybzS,loufangfybzD,loufangfybzU,loufangfybzE,loufangfybzUE,loufangfybzV,loufangfybzUV,zhusuhetongA,zhusuhetong,zhusuhetongS,zhusuhetongD,zhusuhetongU,zhusuhetongE,zhusuhetongUE,zhusuhetongV,zhusuhetongUV,xt,xt_ml_zongguan,xt_ml_zongguan_1,xtjuese2A,xtjuese2,xtjuese2S,xtjuese2D,xtjuese2U,xtjuese2E,xtjuese2UE,xtjuese2V,xtjuese2UV,xtjuesequanxian2,xt_ml_zongguan_2,xtguanliyuan2A,xtguanliyuan2,xtguanliyuan2S,xtguanliyuan2D,xtguanliyuan2U,xtguanliyuan2E,xtguanliyuan2UE,xtguanliyuan2V,xtguanliyuan2UV,xtguanliyuanquanxian2_xiuganbm,xtguanliyuanjueseAUD,xtguanliyuanquanxian2_xiuganquanxian,xtryquanxian2,updatepassword2,xt_ml_fuguan,xt_ml_fuguanyuan_juese,xtjuese3A,xtjuese3,xtjuese3S,xtjuese3D,xtjuese3U,xtjuese3E,xtjuese3UE,xtjuese3V,xtjuese3UV,xtjuesequanxian3,updatepassword3,xtryquanxian3,updatepasswordUser', '', 'sz001', '2018-07-09 17:47:07', 2),
	('201807091747228780000006', '珠海xx公司', 'zhdemo', 'zhdemo', '', 1, '', 'service,yw_ml_loufang,chaoshuibiaoA,chaoshuibiao,chaoshuibiaoS,chaoshuibiaoD,chaoshuibiaoU,chaoshuibiaoE,chaoshuibiaoUE,chaoshuibiaoV,chaoshuibiaoUV,chaodianbiaoA,chaodianbiao,chaodianbiaoS,chaodianbiaoD,chaodianbiaoU,chaodianbiaoE,chaodianbiaoUE,chaodianbiaoV,chaodianbiaoUV,loufangchuzhang,loufangchuzhangS,loufangchuzhangA,loufangnafei,loufangnafeiS,loufangnafeiD,loufangnafeiU,loufangnafeiE,loufangnafeiUE,loufangnafeiV,loufangnafeiUV,base,bmA,bm,bmS,bmD,bmU,bmE,bmUE,bmV,bmUV,gangweiA,gangwei,gangweiS,gangweiD,gangweiU,gangweiE,gangweiUE,gangweiV,gangweiUV,ryA,ry,ryS,ryD,ryU,ryE,ryUE,ryV,ryUV,zhiweiA,zhiwei,zhiweiS,zhiweiD,zhiweiU,zhiweiE,zhiweiUE,zhiweiV,zhiweiUV,jc_ml_loufang,loufangflA,loufangfl,loufangflS,loufangflD,loufangflU,loufangflE,loufangflUE,loufangflV,loufangflUV,loufangA,loufang,loufangS,loufangD,loufangU,loufangE,loufangUE,loufangV,loufangUV,loufangxmfA,loufangxmf,loufangxmfS,loufangxmfD,loufangxmfU,loufangxmfE,loufangxmfUE,loufangxmfV,loufangxmfUV,loufangfybzA,loufangfybz,loufangfybzS,loufangfybzD,loufangfybzU,loufangfybzE,loufangfybzUE,loufangfybzV,loufangfybzUV,zhusuhetongA,zhusuhetong,zhusuhetongS,zhusuhetongD,zhusuhetongU,zhusuhetongE,zhusuhetongUE,zhusuhetongV,zhusuhetongUV,xt,xt_ml_zongguan,xt_ml_zongguan_1,xtjuese2A,xtjuese2,xtjuese2S,xtjuese2D,xtjuese2U,xtjuese2E,xtjuese2UE,xtjuese2V,xtjuese2UV,xtjuesequanxian2,xt_ml_zongguan_2,xtguanliyuan2A,xtguanliyuan2,xtguanliyuan2S,xtguanliyuan2D,xtguanliyuan2U,xtguanliyuan2E,xtguanliyuan2UE,xtguanliyuan2V,xtguanliyuan2UV,xtguanliyuanquanxian2_xiuganbm,xtguanliyuanjueseAUD,xtguanliyuanquanxian2_xiuganquanxian,xtryquanxian2,updatepassword2,xt_ml_fuguan,xt_ml_fuguanyuan_juese,xtjuese3A,xtjuese3,xtjuese3S,xtjuese3D,xtjuese3U,xtjuese3E,xtjuese3UE,xtjuese3V,xtjuese3UV,xtjuesequanxian3,updatepassword3,xtryquanxian3,updatepasswordUser', '', 'zh001', '2018-07-09 17:47:22', 2),
	('201807091806192130000042', '我是辅管啊', 'fg', '123', '', 0, '', '', '201807091755457650000018,201807091756191510000020,201807091756353800000021', 'fs001', '2018-07-09 18:06:19', 3);
/*!40000 ALTER TABLE `XtGuanliyuan` ENABLE KEYS */;

-- 导出  表 Empty.XtGuanliyuanJuese 结构
CREATE TABLE IF NOT EXISTS `XtGuanliyuanJuese` (
  `xt_guanliyuanjuese_zj` char(24) NOT NULL COMMENT '主键',
  `xt_guanliyuan_zj` char(24) NOT NULL COMMENT '管理员主键',
  `xt_juese_zj` text COMMENT '角色主键集合',
  `xt_guanliyuanjuese_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  PRIMARY KEY (`xt_guanliyuanjuese_zj`),
  KEY `xt_guanliyuan_zj` (`xt_guanliyuan_zj`),
  KEY `xt_guanliyuanjuese_gelibiaoshi` (`xt_guanliyuanjuese_gelibiaoshi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员的角色';

-- 正在导出表  Empty.XtGuanliyuanJuese 的数据：~0 rows (大约)
DELETE FROM `XtGuanliyuanJuese`;
/*!40000 ALTER TABLE `XtGuanliyuanJuese` DISABLE KEYS */;
INSERT INTO `XtGuanliyuanJuese` (`xt_guanliyuanjuese_zj`, `xt_guanliyuan_zj`, `xt_juese_zj`, `xt_guanliyuanjuese_gelibiaoshi`) VALUES
	('201807110923142780000096', '201807091806192130000042', '201807091751543630000010', 'fs001');
/*!40000 ALTER TABLE `XtGuanliyuanJuese` ENABLE KEYS */;

-- 导出  表 Empty.XtJuese 结构
CREATE TABLE IF NOT EXISTS `XtJuese` (
  `xt_juese_zj` char(24) NOT NULL COMMENT '主键',
  `xt_juese_fzj` char(24) NOT NULL COMMENT '父键',
  `xt_juese_mc` varchar(200) NOT NULL COMMENT '名称',
  `xt_juese_dm` varchar(20) DEFAULT NULL COMMENT '代码',
  `xt_juese_gongsi` int(11) NOT NULL COMMENT '公私角色',
  `xt_juese_bz` varchar(200) DEFAULT NULL COMMENT '备注',
  `xt_juese_zt` int(11) NOT NULL COMMENT '状态',
  `xt_juese_gelibiaoshi` varchar(20) DEFAULT NULL COMMENT '隔离标识',
  `xt_juese_zhidanren_zj` char(24) NOT NULL COMMENT '制单人主键',
  `xt_juese_zhidanren` varchar(20) NOT NULL COMMENT '制单人',
  `xt_juese_zhidanshijian` datetime NOT NULL COMMENT '制单时间',
  `xt_juese_xiugairen_zj` char(24) DEFAULT NULL COMMENT '修改人主键',
  `xt_juese_xiugairen` varchar(20) DEFAULT NULL COMMENT '修改人',
  `xt_juese_xiugaishijian` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`xt_juese_zj`),
  KEY `xt_juese_fzj` (`xt_juese_fzj`),
  KEY `xt_juese_mc` (`xt_juese_mc`),
  KEY `xt_juese_gongsi` (`xt_juese_gongsi`),
  KEY `xt_juese_zt` (`xt_juese_zt`),
  KEY `xt_juese_zhidanren_zj` (`xt_juese_zhidanren_zj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统角色';

-- 正在导出表  Empty.XtJuese 的数据：~14 rows (大约)
DELETE FROM `XtJuese`;
/*!40000 ALTER TABLE `XtJuese` DISABLE KEYS */;
INSERT INTO `XtJuese` (`xt_juese_zj`, `xt_juese_fzj`, `xt_juese_mc`, `xt_juese_dm`, `xt_juese_gongsi`, `xt_juese_bz`, `xt_juese_zt`, `xt_juese_gelibiaoshi`, `xt_juese_zhidanren_zj`, `xt_juese_zhidanren`, `xt_juese_zhidanshijian`, `xt_juese_xiugairen_zj`, `xt_juese_xiugairen`, `xt_juese_xiugaishijian`) VALUES
	('201807091750513090000007', '0', 'xxx公司', '', 1, '', 1, 'fs001', '201807091746493090000004', '佛山xx公司', '2018-07-09 17:50:51', '', '', NULL),
	('201807091751328030000008', '201807091750513090000007', '总经理', '', 1, '', 1, 'fs001', '201807091746493090000004', '佛山xx公司', '2018-07-09 17:51:32', '', '', NULL),
	('201807091751498340000009', '201807091750513090000007', '信息部', '', 1, '', 1, 'fs001', '201807091746493090000004', '佛山xx公司', '2018-07-09 17:51:49', '', '', NULL),
	('201807091751543630000010', '201807091750513090000007', 'hr', '', 1, '', 1, 'fs001', '201807091746493090000004', '佛山xx公司', '2018-07-09 17:51:54', '', '', NULL),
	('201807091810146540000046', '0', '汪汪汪', '', 1, '', 1, 'sz001', '201807091747076600000005', '深圳xx公司', '2018-07-09 18:10:14', '', '', NULL),
	('201807091810214960000047', '201807091810146540000046', '汪汪汪汪汪', '', 1, '', 1, 'sz001', '201807091747076600000005', '深圳xx公司', '2018-07-09 18:10:21', '', '', NULL),
	('201807091817542110000068', '0', 'xx总监', '', 1, '', 1, 'zh001', '201807091747228780000006', '珠海xx公司', '2018-07-09 18:17:54', '', '', NULL),
	('201807091818034560000069', '201807091817542110000068', 'xx信息部管理', '', 1, '', 1, 'zh001', '201807091747228780000006', '珠海xx公司', '2018-07-09 18:18:03', '201807091747228780000006', '珠海xx公司', '2018-07-09 18:18:36'),
	('201807091818167430000070', '201807091817542110000068', 'hr', '', 1, '', 1, 'zh001', '201807091747228780000006', '珠海xx公司', '2018-07-09 18:18:16', '', '', NULL),
	('201807100930459680000082', '201807091751328030000008', 'dddd', '', 1, '', 0, 'fs001', '201807091746493090000004', '佛山xx公司', '2018-07-10 09:30:45', '', '', NULL),
	('201807101357503330000083', '0', 'aa', '', 1, 'gdgh', 0, 'zh001', '201807091747228780000006', '珠海xx公司', '2018-07-10 13:57:50', '', '', NULL),
	('201807110758058580000094', '0', '111111111', '', 1, '', 0, 'fs001', '201807091746493090000004', '佛山xx公司', '2018-07-11 07:58:05', '', '', NULL),
	('201807110758106270000095', '201807110758058580000094', '22222', '', 1, '', 0, 'fs001', '201807091746493090000004', '佛山xx公司', '2018-07-11 07:58:10', '', '', NULL),
	('201807112313439110000001', '0', 'kkkkk', '', 1, '', 0, 'fs001', '201807091746493090000004', '佛山xx公司', '2018-07-11 23:13:43', '', '', NULL);
/*!40000 ALTER TABLE `XtJuese` ENABLE KEYS */;

-- 导出  表 Empty.XTJueseQuanxian 结构
CREATE TABLE IF NOT EXISTS `XTJueseQuanxian` (
  `xt_juesequanxian_zj` char(24) NOT NULL COMMENT '主键',
  `xt_juese_zj` char(24) NOT NULL COMMENT '角色主键',
  `xt_juese_dm` varchar(20) NOT NULL COMMENT '角色代码',
  `xt_quanxian` text NOT NULL COMMENT '权限集合',
  `xt_zhidanren_zj` char(24) NOT NULL COMMENT '制单人',
  PRIMARY KEY (`xt_juesequanxian_zj`),
  KEY `xt_juese_zj` (`xt_juese_zj`),
  KEY `xt_zhidanren_zj` (`xt_zhidanren_zj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限';

-- 正在导出表  Empty.XTJueseQuanxian 的数据：~9 rows (大约)
DELETE FROM `XTJueseQuanxian`;
/*!40000 ALTER TABLE `XTJueseQuanxian` DISABLE KEYS */;
INSERT INTO `XTJueseQuanxian` (`xt_juesequanxian_zj`, `xt_juese_zj`, `xt_juese_dm`, `xt_quanxian`, `xt_zhidanren_zj`) VALUES
	('201807091805085440000038', '201807091750513090000007', '', 'base,bmA,bm,bmS,bmU,bmE,bmUE,bmV,bmUV,gangweiA,gangwei,gangweiS,gangweiU,gangweiE,gangweiUE,gangweiV,gangweiUV,ryA,ry,ryS,ryU,ryE,ryUE,ryV,ryUV,zhiweiA,zhiwei,zhiweiS,zhiweiU,zhiweiE,zhiweiUE,zhiweiV,zhiweiUV,jc_ml_loufang,loufangflA,loufangfl,loufangflS,loufangflU,loufangflE,loufangflUE,loufangflV,loufangflUV,xt,xt_ml_fuguan,xt_ml_fuguanyuan_juese,xtjuese3A,xtjuese3,xtjuese3S,xtjuese3D,xtjuese3U,xtjuese3E,xtjuese3UE,xtjuese3V,xtjuese3UV,xtjuesequanxian3,xtryquanxian3', '201807091746493090000004'),
	('201807091805134010000039', '201807091751328030000008', '', 'base,bmA,bm,bmS,bmU,bmE,bmUE,bmV,bmUV,gangweiA,gangwei,gangweiS,gangweiU,gangweiE,gangweiUE,gangweiV,gangweiUV,ryA,ry,ryS,ryU,ryE,ryUE,ryV,ryUV,zhiweiA,zhiwei,zhiweiS,zhiweiU,zhiweiE,zhiweiUE,zhiweiV,zhiweiUV,jc_ml_loufang,loufangflA,loufangfl,loufangflS,loufangflU,loufangflE,loufangflUE,loufangflV,loufangflUV,xt,xt_ml_fuguan,xt_ml_fuguanyuan_juese,xtjuese3A,xtjuese3,xtjuese3S,xtjuese3D,xtjuese3U,xtjuese3E,xtjuese3UE,xtjuese3V,xtjuese3UV,xtjuesequanxian3,xtryquanxian3', '201807091746493090000004'),
	('201807091805220010000041', '201807091751543630000010', '', 'base,bmA,bm,bmS,bmU,bmE,bmUE,bmV,bmUV,gangweiA,gangwei,gangweiS,gangweiU,gangweiE,gangweiUE,gangweiV,gangweiUV,ryA,ry,ryS,ryU,ryE,ryUE,ryV,ryUV,zhiweiA,zhiwei,zhiweiS,zhiweiU,zhiweiE,zhiweiUE,zhiweiV,zhiweiUV,jc_ml_loufang,loufangflA,loufangfl,loufangflS,loufangflU,loufangflE,loufangflUE,loufangflV,loufangflUV,xt,xt_ml_fuguan,xt_ml_fuguanyuan_juese,xtjuese3A,xtjuese3,xtjuese3S,xtjuese3D,xtjuese3U,xtjuese3E,xtjuese3UE,xtjuese3V,xtjuese3UV,xtjuesequanxian3,xtryquanxian3', '201807091746493090000004'),
	('201807091810418080000048', '201807091810146540000046', '', 'base,bmA,bm,bmS,bmU,bmE,bmUE,bmV,bmUV,xt,xt_ml_fuguan,xt_ml_fuguanyuan_juese,xtjuese3A,xtjuese3,xtjuese3S,xtjuese3D,xtjuese3U,xtjuese3E,xtjuese3UE,xtjuese3V,xtjuese3UV,xtjuesequanxian3,xtryquanxian3', '201807091747076600000005'),
	('201807091810574670000049', '201807091810214960000047', '', 'base,gangweiA,gangwei,gangweiS,gangweiU,gangweiE,gangweiUE,gangweiV,gangweiUV,ryA,ry,ryS,ryU,ryE,ryUE,ryV,ryUV,zhiweiA,zhiwei,zhiweiS,zhiweiU,zhiweiE,zhiweiUE,zhiweiV,zhiweiUV,jc_ml_loufang,loufangflA,loufangfl,loufangflS,loufangflU,loufangflE,loufangflUE,loufangflV,loufangflUV,xt,xt_ml_fuguan,xt_ml_fuguanyuan_juese,xtjuese3A,xtjuese3,xtjuese3S,xtjuese3D,xtjuese3U,xtjuese3E,xtjuese3UE,xtjuese3V,xtjuese3UV,xtjuesequanxian3,xtryquanxian3', '201807091747076600000005'),
	('201807091819012330000071', '201807091817542110000068', '', 'base,bmA,bm,bmS,bmU,bmE,bmUE,bmV,bmUV,gangweiA,gangwei,gangweiS,gangweiU,gangweiE,gangweiUE,gangweiV,gangweiUV,ryA,ry,ryS,ryU,ryE,ryUE,ryV,ryUV,zhiweiA,zhiwei,zhiweiS,zhiweiU,zhiweiE,zhiweiUE,zhiweiV,zhiweiUV,jc_ml_loufang,loufangflA,loufangfl,loufangflS,loufangflU,loufangflE,loufangflUE,loufangflV,loufangflUV,xt,xt_ml_fuguan,xt_ml_fuguanyuan_juese,xtjuese3A,xtjuese3,xtjuese3S,xtjuese3D,xtjuese3U,xtjuese3E,xtjuese3UE,xtjuese3V,xtjuese3UV,xtjuesequanxian3,xtryquanxian3', '201807091747228780000006'),
	('201807091819120900000072', '201807091818034560000069', '', 'xt,xt_ml_fuguan,xt_ml_fuguanyuan_juese,xtjuese3A,xtjuese3,xtjuese3S,xtjuese3D,xtjuese3U,xtjuese3E,xtjuese3UE,xtjuese3V,xtjuese3UV,xtjuesequanxian3,xtryquanxian3', '201807091747228780000006'),
	('201807091819184970000073', '201807091818167430000070', '', 'base,bmA,bm,bmS,bmU,bmE,bmUE,bmV,bmUV,gangweiA,gangwei,gangweiS,gangweiU,gangweiE,gangweiUE,gangweiV,gangweiUV,ryA,ry,ryS,ryU,ryE,ryUE,ryV,ryUV,zhiweiA,zhiwei,zhiweiS,zhiweiU,zhiweiE,zhiweiUE,zhiweiV,zhiweiUV,jc_ml_loufang,loufangflA,loufangfl,loufangflS,loufangflU,loufangflE,loufangflUE,loufangflV,loufangflUV,xt,xt_ml_fuguan,xt_ml_fuguanyuan_juese,xtjuese3A,xtjuese3,xtjuese3S,xtjuese3D,xtjuese3U,xtjuese3E,xtjuese3UE,xtjuese3V,xtjuese3UV,xtjuesequanxian3,xtryquanxian3', '201807091747228780000006'),
	('201807300244067700000001', '201807091751498340000009', '', 'service,yw_ml_loufang,chaoshuibiaoA,chaoshuibiao,chaoshuibiaoS,chaoshuibiaoD,chaoshuibiaoU,chaoshuibiaoE,chaoshuibiaoUE,chaoshuibiaoV,chaoshuibiaoUV,chaodianbiaoA,chaodianbiao,chaodianbiaoS,chaodianbiaoD,chaodianbiaoU,chaodianbiaoE,chaodianbiaoUE,chaodianbiaoV,chaodianbiaoUV,loufangchuzhang,loufangchuzhangS,loufangchuzhangA,loufangnafei,loufangnafeiS,loufangnafeiD,loufangnafeiU,loufangnafeiE,loufangnafeiUE,loufangnafeiV,loufangnafeiUV,base,bmA,bm,bmS,bmD,bmU,bmE,bmUE,bmV,bmUV,gangweiA,gangwei,gangweiS,gangweiD,gangweiU,gangweiE,gangweiUE,gangweiV,gangweiUV,ryA,ry,ryS,ryD,ryU,ryE,ryUE,ryV,ryUV,zhiweiA,zhiwei,zhiweiS,zhiweiD,zhiweiU,zhiweiE,zhiweiUE,zhiweiV,zhiweiUV,jc_ml_loufang,loufangflA,loufangfl,loufangflS,loufangflD,loufangflU,loufangflE,loufangflUE,loufangflV,loufangflUV,loufangA,loufang,loufangS,loufangD,loufangU,loufangE,loufangUE,loufangV,loufangUV,loufangxmfA,loufangxmf,loufangxmfS,loufangxmfD,loufangxmfU,loufangxmfE,loufangxmfUE,loufangxmfV,loufangxmfUV,loufangfybzA,loufangfybz,loufangfybzS,loufangfybzD,loufangfybzU,loufangfybzE,loufangfybzUE,loufangfybzV,loufangfybzUV,zhusuhetongA,zhusuhetong,zhusuhetongS,zhusuhetongD,zhusuhetongU,zhusuhetongE,zhusuhetongUE,zhusuhetongV,zhusuhetongUV,xt,xt_ml_fuguan,xt_ml_fuguanyuan_juese,xtjuese3A,xtjuese3,xtjuese3S,xtjuese3D,xtjuese3U,xtjuese3E,xtjuese3UE,xtjuese3V,xtjuese3UV,xtjuesequanxian3,updatepassword3,xtryquanxian3,updatepasswordUser', '201807091746493090000004');
/*!40000 ALTER TABLE `XTJueseQuanxian` ENABLE KEYS */;

-- 导出  表 Empty.XtQuanxian 结构
CREATE TABLE IF NOT EXISTS `XtQuanxian` (
  `xt_quanxian_zj` char(24) NOT NULL COMMENT '主键',
  `xt_quanxian_fzj` char(24) NOT NULL COMMENT '父键',
  `xt_quanxian_px` int(11) DEFAULT NULL COMMENT '排序',
  `xt_quanxian_mc` varchar(200) NOT NULL COMMENT '名称',
  `xt_quanxian_dm` varchar(200) NOT NULL COMMENT '权限代码',
  `xt_quanxian_url` varchar(200) DEFAULT NULL COMMENT 'url',
  `xt_quanxian_keshi` int(11) NOT NULL COMMENT '可视',
  `xt_quanxian_zhankai` varchar(8) DEFAULT NULL COMMENT '展开',
  `xt_quanxian_bz` varchar(200) DEFAULT NULL COMMENT '备注',
  `xt_quanxian_zt` int(11) NOT NULL COMMENT '状态',
  `xt_quanxian_gelibiaoshi` varchar(200) DEFAULT NULL COMMENT '隔离标识',
  `xt_quanxian_jibie` int(11) NOT NULL COMMENT '级别',
  PRIMARY KEY (`xt_quanxian_zj`),
  UNIQUE KEY `xt_quanxian_dm` (`xt_quanxian_dm`),
  KEY `xt_quanxian_fzj` (`xt_quanxian_fzj`),
  KEY `xt_quanxian_keshi` (`xt_quanxian_keshi`),
  KEY `xt_quanxian_zt` (`xt_quanxian_zt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统权限';

-- 正在导出表  Empty.XtQuanxian 的数据：~168 rows (大约)
DELETE FROM `XtQuanxian`;
/*!40000 ALTER TABLE `XtQuanxian` DISABLE KEYS */;
INSERT INTO `XtQuanxian` (`xt_quanxian_zj`, `xt_quanxian_fzj`, `xt_quanxian_px`, `xt_quanxian_mc`, `xt_quanxian_dm`, `xt_quanxian_url`, `xt_quanxian_keshi`, `xt_quanxian_zhankai`, `xt_quanxian_bz`, `xt_quanxian_zt`, `xt_quanxian_gelibiaoshi`, `xt_quanxian_jibie`) VALUES
	('201807030726395600000002', '0', 0, '业务操作区', 'service', '', 1, '', '', 0, '', 4),
	('201807030727005580000003', '0', 0, '基础资料区', 'base', '', 1, 'false', '', 0, '', 9),
	('201807030728131810000004', '0', 0, '系统管理区', 'xt', '', 1, 'true', '', 0, '', 5),
	('201807030729131540000005', '0', 0, '超级管理员专区', 'xt_chaojiguanliyuan', '', 1, 'true', '', 0, '', 1),
	('201807030730035500000006', '201807030728131810000004', 0, '总管专区', 'xt_ml_zongguan', '', 1, 'true', '', 0, '', 2),
	('201807030731186010000007', '201807030729131540000005', 0, '系统权限新增（根表）', 'xtquanxianA', 'xt/xtquanxian/add.jsp', 1, '', '', 0, '', 1),
	('201807030732242330000008', '201807030729131540000005', 0, '系统权限维护（根表）', 'xtquanxianS', 'xt/xtquanxian/list.jsp', 1, '', '', 0, '', 1),
	('201807032143155080000001', '201807030729131540000005', 0, '单据条件参数设置新增', 'xtshezhitiaojian', 'xt/xtshezhitiaojian/add.jsp', 1, '', '', 0, '', 1),
	('201807032143429830000002', '201807030729131540000005', 0, '单据条件参数设置维护', 'xtshezhitiaojianS', 'xt/xtshezhitiaojian/list.jsp', 1, '', '', 0, '', 1),
	('201807032146392230000003', '201807030729131540000005', 0, '总管中心', 'xtzhongguanzhongxin', '', 1, 'true', '', 0, '', 1),
	('201807032148228360000004', '201807032146392230000003', 0, '总管新增', 'xtguanliyuan1A', 'xt/xtguanliyuan/add.jsp', 1, 'true', '', 0, '', 1),
	('201807032148554220000005', '201807032146392230000003', 0, '总管维护', 'xtguanliyuan1S', 'xt/xtguanliyuan/list.jsp', 1, '', '', 0, '', 1),
	('201807032150110210000006', '201807032146392230000003', 0, '总管权限维护', 'xtguanliyuan1quanxian', 'xt/xtguanliyuan/quanxian.jsp', 1, '', '', 0, '', 1),
	('201807032201065500000009', '201807041617542110000003', 0, '辅管员新增', 'xtguanliyuan2A', 'xt/xtguanliyuan/add2.jsp', 1, '', '', 0, '', 2),
	('201807032202397260000011', '201807041617542110000003', 0, '辅管员维护', 'xtguanliyuan2', 'xt/xtguanliyuan/list2.jsp', 1, '', '', 0, '', 2),
	('201807032203393850000012', '201807032202397260000011', 0, '查询', 'xtguanliyuan2S', '', 0, '', '', 0, '', 2),
	('201807032204190020000013', '201807032202397260000011', 0, '删除', 'xtguanliyuan2D', '', 0, '', '', 0, '', 2),
	('201807032204271690000014', '201807032202397260000011', 0, '修改', 'xtguanliyuan2U', '', 0, '', '', 0, '', 2),
	('201807032205166390000015', '201807032202397260000011', 0, '审核', 'xtguanliyuan2E', '', 0, '', '', 0, '', 2),
	('201807032205279000000016', '201807032202397260000011', 0, '反审核', 'xtguanliyuan2UE', '', 0, '', '', 0, '', 2),
	('201807032205406280000017', '201807032202397260000011', 0, '作废', 'xtguanliyuan2V', '', 0, '', '', 0, '', 2),
	('201807032205504870000018', '201807032202397260000011', 0, '反作废', 'xtguanliyuan2UV', '', 0, '', '', 0, '', 2),
	('201807032222262540000020', '201807030727005580000003', 0, '部门新增', 'bmA', 'admin/base/bm/add.jsp', 1, '', '', 0, '', 9),
	('201807032222542560000021', '201807030727005580000003', 0, '部门维护', 'bm', 'admin/base/bm/list.jsp', 1, '', '', 0, '', 9),
	('201807032223167520000022', '201807032222542560000021', 0, '查询', 'bmS', '', 0, '', '', 0, '', 9),
	('201807032223317100000023', '201807032222542560000021', 0, '删除', 'bmD', '', 0, '', '', 0, '', 9),
	('201807032223445430000024', '201807032222542560000021', 0, '修改', 'bmU', '', 0, '', '', 0, '', 9),
	('201807032224120680000025', '201807032222542560000021', 0, '审核', 'bmE', '', 0, '', '', 0, '', 9),
	('201807032224209350000026', '201807032222542560000021', 0, '反审核', 'bmUE', '', 0, '', '', 0, '', 9),
	('201807032224386240000027', '201807032222542560000021', 0, '作废', 'bmV', '', 0, '', '', 0, '', 9),
	('201807032224512430000028', '201807032222542560000021', 0, '反作废', 'bmUV', '', 0, '', '', 0, '', 9),
	('201807032229349770000029', '201807030727005580000003', 0, '岗位新增', 'gangweiA', 'admin/base/gangwei/add.jsp', 1, '', '', 0, '', 9),
	('201807032229563950000030', '201807030727005580000003', 0, '岗位维护', 'gangwei', 'admin/base/gangwei/list.jsp', 1, '', '', 0, '', 9),
	('201807032230268510000031', '201807032229563950000030', 0, '查询', 'gangweiS', 'admin/base/gangwei/list.jsp', 0, '', '', 0, '', 9),
	('201807032230421890000032', '201807032229563950000030', 0, '删除', 'gangweiD', '', 0, '', '', 0, '', 9),
	('201807032230551270000033', '201807032229563950000030', 0, '修改', 'gangweiU', '', 0, '', '', 0, '', 9),
	('201807032231207230000034', '201807032229563950000030', 0, '审核', 'gangweiE', '', 0, '', '', 0, '', 9),
	('201807032231309470000035', '201807032229563950000030', 0, '反审核', 'gangweiUE', '', 0, '', '', 0, '', 9),
	('201807032231520350000036', '201807032229563950000030', 0, '作废', 'gangweiV', '', 0, '', '', 0, '', 9),
	('201807032232030710000037', '201807032229563950000030', 0, '反作废', 'gangweiUV', '', 0, '', '', 0, '', 9),
	('201807032235176860000038', '201807030727005580000003', 0, '人员新增', 'ryA', 'admin/base/ry/add.jsp', 1, '', '', 0, '', 9),
	('201807032235428250000039', '201807030727005580000003', 0, '人员维护', 'ry', 'admin/base/ry/list.jsp', 1, '', '', 0, '', 9),
	('201807032236052330000040', '201807032235428250000039', 0, '查询', 'ryS', '', 0, '', '', 0, '', 9),
	('201807032238037400000041', '201807032235428250000039', 0, '删除', 'ryD', '', 0, '', '', 0, '', 9),
	('201807032238150510000042', '201807032235428250000039', 0, '修改', 'ryU', '', 0, '', '', 0, '', 9),
	('201807032239563920000001', '201807032235428250000039', 0, '审核', 'ryE', '', 0, '', '', 0, '', 9),
	('201807032240400450000002', '201807032235428250000039', 0, '反审核', 'ryUE', '', 0, '', '', 0, '', 9),
	('201807032241304880000003', '201807032235428250000039', 0, '作废', 'ryV', '', 0, '', '', 0, '', 9),
	('201807032241405990000004', '201807032235428250000039', 0, '反作废', 'ryUV', '', 0, '', '', 0, '', 9),
	('201807040615076410000002', '201807041617542110000003', 0, '绑定辅管员管理范围', 'xtguanliyuanquanxian2_xiuganbm', 'xt/xtguanliyuan/quanxianfanwei.jsp', 1, '', '', 0, '', 2),
	('201807040618351370000004', '201807041617542110000003', 1, '绑定辅管员权限', 'xtguanliyuanquanxian2_xiuganquanxian', 'xt/xtguanliyuan/quanxian2.jsp', 1, '', '', 0, '', 2),
	('201807040828272540000020', '201807041617299390000002', 0, '角色新增', 'xtjuese2A', 'xt/xtjuese/add2.jsp', 1, '', '', 0, '', 2),
	('201807040828474630000021', '201807041617299390000002', 0, '角色维护', 'xtjuese2', 'xt/xtjuese/list2.jsp', 1, '', '', 0, '', 2),
	('201807040830102740000022', '201807040828474630000021', 0, '查询', 'xtjuese2S', '', 0, '', '', 0, '', 2),
	('201807040831569560000023', '201807040828474630000021', 0, '删除', 'xtjuese2D', '', 0, '', '', 0, '', 2),
	('201807040832109730000024', '201807040828474630000021', 0, '修改', 'xtjuese2U', '', 0, '', '', 0, '', 2),
	('201807040838255360000001', '201807040828474630000021', 0, '审核', 'xtjuese2E', '', 0, '', '', 0, '', 2),
	('201807040838579500000002', '201807040828474630000021', 0, '反审核', 'xtjuese2UE', '', 0, '', '', 0, '', 2),
	('201807040839182860000003', '201807040828474630000021', 0, '作废', 'xtjuese2V', '', 0, '', '', 0, '', 2),
	('201807040839299050000004', '201807040828474630000021', 0, '反作废', 'xtjuese2UV', '', 0, '', '', 0, '', 2),
	('201807041049298580000001', '201807071459406320000002', 0, '角色新增', 'xtjuese3A', 'xt/xtjuese/add3.jsp', 1, '', '', 0, '', 3),
	('201807041049567140000002', '201807071459406320000002', 0, '角色维护', 'xtjuese3', 'xt/xtjuese/list3.jsp', 1, '', '', 0, '', 3),
	('201807041050247510000003', '201807041049567140000002', 0, '查询', 'xtjuese3S', '', 0, '', '', 0, '', 3),
	('201807041050417100000004', '201807041049567140000002', 0, '删除', 'xtjuese3D', '', 0, '', '', 0, '', 3),
	('201807041050557100000005', '201807041049567140000002', 0, '修改', 'xtjuese3U', '', 0, '', '', 0, '', 3),
	('201807041051175870000006', '201807041049567140000002', 0, '审核', 'xtjuese3E', '', 0, '', '', 0, '', 3),
	('201807041051265140000007', '201807041049567140000002', 0, '反审核', 'xtjuese3UE', '', 0, '', '', 0, '', 3),
	('201807041051382590000008', '201807041049567140000002', 0, '作废', 'xtjuese3V', '', 0, '', '', 0, '', 3),
	('201807041051466030000009', '201807041049567140000002', 0, '反作废', 'xtjuese3UV', '', 0, '', '', 0, '', 3),
	('201807041602550730000001', '201807041617299390000002', 0, '绑定角色-权限', 'xtjuesequanxian2', 'xt/xtjuese/quanxian2.jsp', 1, '', '', 0, '', 2),
	('201807041617299390000002', '201807030730035500000006', 0, '角色', 'xt_ml_zongguan_1', '', 1, 'true', '目录', 0, '', 2),
	('201807041617542110000003', '201807030730035500000006', 0, '辅管员', 'xt_ml_zongguan_2', '', 1, 'true', '目录', 0, '', 2),
	('201807041632390330000001', '201807041617542110000003', 0, '绑定辅管员角色', 'xtguanliyuanjueseAUD', 'xt/xtguanliyuan/guanliyuanjuese2.jsp', 1, '', '', 0, '', 2),
	('201807050439132720000001', '201807030730035500000006', 0, '绑定业务员权限', 'xtryquanxian2', 'xt/xtryquanxian/xtryquanxian2.jsp', 1, '', '', 0, '', 2),
	('201807051627256720000001', '201807051629201460000002', 1, '绑定业务员权限（辅管员专用）', 'xtryquanxian3', 'xt/xtryquanxian/xtryquanxian3.jsp', 1, '', '', 0, '', 3),
	('201807051629201460000002', '201807030728131810000004', 0, '辅管员专区', 'xt_ml_fuguan', 'xt/xtryquanxian/xtryquanxian3.jsp', 1, 'true', '目录', 0, '', 3),
	('201807071247177580000001', '201807071459406320000002', 0, '绑定角色-权限', 'xtjuesequanxian3', 'xt/xtjuese/quanxian3.jsp', 1, '', '', 0, '', 3),
	('201807071459406320000002', '201807051629201460000002', 0, '角色', 'xt_ml_fuguanyuan_juese', '', 1, 'true', '目录', 0, '', 3),
	('201807072200431860000001', '201807030730035500000006', 0, '总管修改自己的账号密码', 'updatepassword2', '', 0, '', '', 0, '', 2),
	('201807072201383650000002', '201807051629201460000002', 0, '辅管修改自己的账号密码', 'updatepassword3', '', 0, '', '', 0, '', 3),
	('201807072202212950000003', '201807030728131810000004', 0, '业务员修改自己的账号密码', 'updatepasswordUser', '', 0, '', '', 0, '', 4),
	('201807090808191520000001', '201807030727005580000003', 0, '职位新增', 'zhiweiA', 'admin/base/zhiwei/add.jsp', 1, '', '', 0, '', 9),
	('201807090808397220000002', '201807030727005580000003', 0, '职位列表', 'zhiwei', 'admin/base/zhiwei/list.jsp', 1, '', '', 0, '', 9),
	('201807090809222420000003', '201807090808397220000002', 0, '查询', 'zhiweiS', '', 0, '', '', 0, '', 9),
	('201807090809380770000004', '201807090808397220000002', 0, '删除', 'zhiweiD', '', 0, '', '', 0, '', 9),
	('201807090809486620000005', '201807090808397220000002', 0, '修改', 'zhiweiU', '', 0, '', '', 0, '', 9),
	('201807090810086640000006', '201807090808397220000002', 0, '审核', 'zhiweiE', '', 0, '', '', 0, '', 9),
	('201807090810188810000007', '201807090808397220000002', 0, '反审核', 'zhiweiUE', '', 0, '', '', 0, '', 9),
	('201807090810368680000008', '201807090808397220000002', 0, '作废', 'zhiweiV', '', 0, '', '', 0, '', 9),
	('201807090810448510000009', '201807090808397220000002', 0, '反作废', 'zhiweiUV', '', 0, '', '', 0, '', 9),
	('201807090830006950000017', '201807030727005580000003', 0, '楼房基础资料', 'jc_ml_loufang', '', 1, 'false', '', 0, '', 4),
	('201807091318432020000001', '201807090830006950000017', 0, '楼房分类新增', 'loufangflA', 'admin/base/loufangfl/add.jsp', 1, '', '', 0, '', 4),
	('201807091319091340000002', '201807090830006950000017', 0, '楼房分类列表', 'loufangfl', 'admin/base/loufangfl/list.jsp', 1, '', '', 0, '', 4),
	('201807091319514950000003', '201807091319091340000002', 0, '查询', 'loufangflS', '', 0, '', '', 0, '', 4),
	('201807091321123400000004', '201807091319091340000002', 0, '删除', 'loufangflD', '', 0, '', '', 0, '', 4),
	('201807091321311340000005', '201807091319091340000002', 0, '修改', 'loufangflU', '', 0, '', '', 0, '', 4),
	('201807091321506620000006', '201807091319091340000002', 0, '审核', 'loufangflE', '', 0, '', '', 0, '', 4),
	('201807091322005470000007', '201807091319091340000002', 0, '反审核', 'loufangflUE', '', 0, '', '', 0, '', 4),
	('201807091322140350000008', '201807091319091340000002', 0, '作废', 'loufangflV', '', 0, '', '', 0, '', 4),
	('201807091322243580000009', '201807091319091340000002', 0, '反作废', 'loufangflUV', '', 0, '', '', 0, '', 4),
	('201807181257493030000004', '201807090830006950000017', 0, '楼房新增', 'loufangA', 'admin/base/loufang/add.jsp', 1, '', '', 0, '', 4),
	('201807181258288990000005', '201807090830006950000017', 0, '楼房维护', 'loufang', 'admin/base/loufang/list.jsp', 1, '', '', 0, '', 4),
	('201807181259497780000006', '201807181258288990000005', 0, '查询', 'loufangS', '', 0, '', '', 0, '', 4),
	('201807181300024830000007', '201807181258288990000005', 0, '删除', 'loufangD', '', 0, '', '', 0, '', 4),
	('201807181302339970000001', '201807181258288990000005', 0, '修改', 'loufangU', '', 0, '', '', 0, '', 4),
	('201807181302539460000002', '201807181258288990000005', 0, '审核', 'loufangE', '', 0, '', '', 0, '', 4),
	('201807181303032900000003', '201807181258288990000005', 0, '反审核', 'loufangUE', '', 0, '', '', 0, '', 4),
	('201807181303122820000004', '201807181258288990000005', 0, '作废', 'loufangV', '', 0, '', '', 0, '', 4),
	('201807181303210460000005', '201807181258288990000005', 0, '反作废', 'loufangUV', '', 0, '', '', 0, '', 4),
	('201807181317590120000002', '201807090830006950000017', 1, '住宿合同新增', 'zhusuhetongA', 'admin/base/zhusuhetong/add.jsp', 1, '', '', 0, '', 4),
	('201807181318213770000003', '201807090830006950000017', 1, '住宿合同维护', 'zhusuhetong', 'admin/base/zhusuhetong/list.jsp', 1, '', '', 0, '', 4),
	('201807181318381290000004', '201807181318213770000003', 0, '查询', 'zhusuhetongS', '', 0, '', '', 0, '', 4),
	('201807181318459850000005', '201807181318213770000003', 0, '删除', 'zhusuhetongD', '', 0, '', '', 0, '', 4),
	('201807181318586490000006', '201807181318213770000003', 0, '修改', 'zhusuhetongU', '', 0, '', '', 0, '', 4),
	('201807181319164240000007', '201807181318213770000003', 0, '审核', 'zhusuhetongE', '', 0, '', '', 0, '', 4),
	('201807181319264330000008', '201807181318213770000003', 0, '反审核', 'zhusuhetongUE', '', 0, '', '', 0, '', 4),
	('201807181319337460000009', '201807181318213770000003', 0, '作废', 'zhusuhetongV', '', 0, '', '', 0, '', 4),
	('201807181319412780000010', '201807181318213770000003', 0, '反作废', 'zhusuhetongUV', '', 0, '', '', 0, '', 4),
	('201807201058086540000001', '201807090830006950000017', 0, '楼房项目费新增', 'loufangxmfA', 'admin/base/loufangxmf/add.jsp', 1, '', '', 0, '', 4),
	('201807201058238870000002', '201807090830006950000017', 0, '楼房项目费维护', 'loufangxmf', 'admin/base/loufangxmf/list.jsp', 1, '', '', 0, '', 4),
	('201807201058402940000003', '201807201058238870000002', 0, '查询', 'loufangxmfS', '', 0, '', '', 0, '', 4),
	('201807201059004380000004', '201807201058238870000002', 0, '删除', 'loufangxmfD', '', 0, '', '', 0, '', 4),
	('201807201059147290000005', '201807201058238870000002', 0, '修改', 'loufangxmfU', '', 0, '', '', 0, '', 4),
	('201807201059321690000006', '201807201058238870000002', 0, '审核', 'loufangxmfE', '', 0, '', '', 0, '', 4),
	('201807201059525450000007', '201807201058238870000002', 0, '反审核', 'loufangxmfUE', '', 0, '', '', 0, '', 4),
	('201807201100082440000008', '201807201058238870000002', 0, '作废', 'loufangxmfV', '', 0, '', '', 0, '', 4),
	('201807201100196170000009', '201807201058238870000002', 0, '反作废', 'loufangxmfUV', '', 0, '', '', 0, '', 4),
	('201807241614046590000001', '201807030726395600000002', 0, '楼房管理', 'yw_ml_loufang', '', 1, '', '', 0, '', 4),
	('201807241615226950000002', '201807241614046590000001', 0, '抄水表', 'chaoshuibiaoA', 'admin/service/chaoshuibiao/add.jsp', 1, '', '', 0, '', 4),
	('201807241616108260000003', '201807241614046590000001', 0, '水表维护', 'chaoshuibiao', 'admin/service/chaoshuibiao/list.jsp', 1, '', '', 0, '', 4),
	('201807241616377190000004', '201807241616108260000003', 0, '查询', 'chaoshuibiaoS', '', 0, '', '', 0, '', 4),
	('201807241617135670000005', '201807241616108260000003', 0, '删除', 'chaoshuibiaoD', '', 0, '', '', 0, '', 4),
	('201807241617233980000006', '201807241616108260000003', 0, '修改', 'chaoshuibiaoU', '', 0, '', '', 0, '', 4),
	('201807241617333340000007', '201807241616108260000003', 0, '审核', 'chaoshuibiaoE', '', 0, '', '', 0, '', 4),
	('201807241617441180000008', '201807241616108260000003', 0, '反审核', 'chaoshuibiaoUE', '', 0, '', '', 0, '', 4),
	('201807241617570720000009', '201807241616108260000003', 0, '作废', 'chaoshuibiaoV', '', 0, '', '', 0, '', 4),
	('201807241618065300000010', '201807241616108260000003', 0, '反作废', 'chaoshuibiaoUV', '', 0, '', '', 0, '', 4),
	('201807242230157320000001', '201807090830006950000017', 0, '楼房费用标准新增', 'loufangfybzA', 'admin/base/loufangfybz/add.jsp', 1, '', '', 0, '', 4),
	('201807242230483270000002', '201807090830006950000017', 0, '楼房费用标准维护', 'loufangfybz', 'admin/base/loufangfybz/list.jsp', 1, '', '', 0, '', 4),
	('201807242231369560000003', '201807242230483270000002', 0, '查询', 'loufangfybzS', '', 0, '', '', 0, '', 4),
	('201807242232019310000004', '201807242230483270000002', 0, '删除', 'loufangfybzD', '', 0, '', '', 0, '', 4),
	('201807242232286510000005', '201807242230483270000002', 0, '修改', 'loufangfybzU', '', 0, '', '', 0, '', 4),
	('201807242232485890000006', '201807242230483270000002', 0, '审核', 'loufangfybzE', '', 0, '', '', 0, '', 4),
	('201807242232585550000007', '201807242230483270000002', 0, '反审核', 'loufangfybzUE', '', 0, '', '', 0, '', 4),
	('201807242233081400000008', '201807242230483270000002', 0, '作废', 'loufangfybzV', '', 0, '', '', 0, '', 4),
	('201807242233186460000009', '201807242230483270000002', 0, '反作废', 'loufangfybzUV', '', 0, '', '', 0, '', 4),
	('201807271034465140000001', '201807241614046590000001', 0, '抄电表', 'chaodianbiaoA', 'admin/service/chaodianbiao/add.jsp', 1, '', '', 0, '', 4),
	('201807271035021190000002', '201807241614046590000001', 0, '电表维护', 'chaodianbiao', 'admin/service/chaodianbiao/list.jsp', 1, '', '', 0, '', 4),
	('201807271035211870000003', '201807271035021190000002', 0, '查询', 'chaodianbiaoS', '', 0, '', '', 0, '', 4),
	('201807271035293620000004', '201807271035021190000002', 0, '删除', 'chaodianbiaoD', '', 0, '', '', 0, '', 4),
	('201807271035404100000005', '201807271035021190000002', 0, '修改', 'chaodianbiaoU', '', 0, '', '', 0, '', 4),
	('201807271035563220000006', '201807271035021190000002', 0, '审核', 'chaodianbiaoE', '', 0, '', '', 0, '', 4),
	('201807271036112750000007', '201807271035021190000002', 0, '反审核', 'chaodianbiaoUE', '', 0, '', '', 0, '', 4),
	('201807271036217380000008', '201807271035021190000002', 0, '作废', 'chaodianbiaoV', '', 0, '', '', 0, '', 4),
	('201807271036305500000009', '201807271035021190000002', 0, '反作废', 'chaodianbiaoUV', '', 0, '', '', 0, '', 4),
	('201807271541538080000012', '0', 0, '报表区', 'baobiao', '', 1, '', '', 0, '', 4),
	('201807271542440420000013', '201807271541538080000012', 0, '楼房报表', 'baobiao_ml_loufang', '', 1, '', '', 0, '', 4),
	('201807282155021270000001', '201807241614046590000001', 1, '纳费', 'loufangnafei', 'admin/service/loufangnafei/list.jsp', 1, '', '', 0, '', 4),
	('201807282155443520000003', '201807282155021270000001', 0, '查询', 'loufangnafeiS', '', 0, '', '', 0, '', 4),
	('201807282155521360000004', '201807282155021270000001', 0, '删除', 'loufangnafeiD', '', 0, '', '', 0, '', 4),
	('201807282156148950000005', '201807282155021270000001', 0, '修改', 'loufangnafeiU', '', 0, '', '', 0, '', 4),
	('201807282156249600000006', '201807282155021270000001', 0, '审核', 'loufangnafeiE', '', 0, '', '', 0, '', 4),
	('201807282156341270000007', '201807282155021270000001', 0, '反审核', 'loufangnafeiUE', '', 0, '', '', 0, '', 4),
	('201807282156420120000008', '201807282155021270000001', 0, '作废', 'loufangnafeiV', '', 0, '', '', 0, '', 4),
	('201807282156494200000009', '201807282155021270000001', 0, '反作废', 'loufangnafeiUV', '', 0, '', '', 0, '', 4),
	('201807291657105380000001', '201807241614046590000001', 0, '出账维护', 'loufangchuzhang', 'admin/service/loufangchuzhang/list.jsp', 1, '', '', 0, '', 4),
	('201807291657323830000002', '201807291657105380000001', 0, '查询', 'loufangchuzhangS', '', 0, '', '', 0, '', 4),
	('201807291658040800000003', '201807291657105380000001', 0, '出账', 'loufangchuzhangA', '', 0, '', '', 0, '', 4);
/*!40000 ALTER TABLE `XtQuanxian` ENABLE KEYS */;

-- 导出  表 Empty.XtRYQuanxian 结构
CREATE TABLE IF NOT EXISTS `XtRYQuanxian` (
  `xt_ryquanxian_zj` char(24) NOT NULL COMMENT '主键',
  `xt_ry_zj` char(24) NOT NULL COMMENT '人员主键',
  `xt_juese_zj` text COMMENT '角色主键集合',
  `xt_quanxian` text COMMENT '权限代码集合',
  `xt_ryquanxian_zhidanshijian` datetime NOT NULL COMMENT '制单时间',
  `xt_ryquanxian_zhidanren` char(24) NOT NULL COMMENT '制单人',
  `xt_ryquanxian_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  PRIMARY KEY (`xt_ryquanxian_zj`),
  KEY `xt_ry_zj` (`xt_ry_zj`),
  KEY `xt_ryquanxian_zhidanren` (`xt_ryquanxian_zhidanren`),
  KEY `xt_ryquanxian_gelibiaoshi` (`xt_ryquanxian_gelibiaoshi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='人员权限';

-- 正在导出表  Empty.XtRYQuanxian 的数据：~4 rows (大约)
DELETE FROM `XtRYQuanxian`;
/*!40000 ALTER TABLE `XtRYQuanxian` DISABLE KEYS */;
INSERT INTO `XtRYQuanxian` (`xt_ryquanxian_zj`, `xt_ry_zj`, `xt_juese_zj`, `xt_quanxian`, `xt_ryquanxian_zhidanshijian`, `xt_ryquanxian_zhidanren`, `xt_ryquanxian_gelibiaoshi`) VALUES
	('201807091814504870000058', '201807091812594750000054', '201807091810146540000046', '', '2018-07-09 18:14:50', '201807091747076600000005', 'sz001'),
	('201807091819466450000074', '201807091816383470000066', '201807091817542110000068', '', '2018-07-09 18:19:46', '201807091747228780000006', 'zh001'),
	('201807091827386300000075', '201807091801013420000036', '201807091751498340000009', 'service,yw_ml_loufang,chaoshuibiaoA,chaoshuibiao,chaoshuibiaoS,chaoshuibiaoD,chaoshuibiaoU,chaoshuibiaoE,chaoshuibiaoUE,chaoshuibiaoV,chaoshuibiaoUV,base,bmA,bm,bmS,bmU,bmE,bmUE,bmV,bmUV,gangweiA,gangwei,gangweiS,gangweiU,gangweiE,gangweiUE,gangweiV,gangweiUV,ryA,ry,ryS,ryU,ryE,ryUE,ryV,ryUV,zhiweiA,zhiwei,zhiweiS,zhiweiU,zhiweiE,zhiweiUE,zhiweiV,zhiweiUV,jc_ml_loufang,loufangflA,loufangfl,loufangflS,loufangflU,loufangflE,loufangflUE,loufangflV,loufangflUV', '2018-07-09 18:27:38', '201807091746493090000004', 'fs001'),
	('201807100735528190000080', '201807091801369260000037', '201807091750513090000007,201807100930459680000082', 'base,bmA,bm,bmS,bmU,bmE,bmUE,bmV,bmUV,gangweiA,gangwei,gangweiS,gangweiU,gangweiE,gangweiUE,gangweiV,gangweiUV,ryA,ry,ryS,ryU,ryE,ryUE,ryV,ryUV,zhiweiA,zhiwei,zhiweiS,zhiweiU,zhiweiE,zhiweiUE,zhiweiV,zhiweiUV,jc_ml_loufang,loufangflA,loufangfl,loufangflS,loufangflU,loufangflE,loufangflUE,loufangflV,loufangflUV', '2018-07-10 07:35:52', '201807091746493090000004', 'fs001');
/*!40000 ALTER TABLE `XtRYQuanxian` ENABLE KEYS */;

-- 导出  表 Empty.XTShezhiTiaojian 结构
CREATE TABLE IF NOT EXISTS `XTShezhiTiaojian` (
  `xt_shezhi_tiaojian_zj` char(24) NOT NULL COMMENT '主键',
  `xt_shezhi_tiaojian_mc` varchar(20) NOT NULL COMMENT '展示名称',
  `xt_shezhi_tiaojian_zhi` varchar(200) NOT NULL COMMENT '使用值',
  `xt_shezhi_tiaojian_bz` varchar(200) DEFAULT NULL COMMENT '备注',
  `xt_shezhi_tiaojian_zt` int(11) NOT NULL COMMENT '单据状态管理',
  PRIMARY KEY (`xt_shezhi_tiaojian_zj`),
  UNIQUE KEY `xt_shezhi_tiaojian_mc` (`xt_shezhi_tiaojian_mc`),
  UNIQUE KEY `xt_shezhi_tiaojian_zhi` (`xt_shezhi_tiaojian_zhi`),
  KEY `xt_shezhi_tiaojian_zt` (`xt_shezhi_tiaojian_zt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统设置_条件';

-- 正在导出表  Empty.XTShezhiTiaojian 的数据：~16 rows (大约)
DELETE FROM `XTShezhiTiaojian`;
/*!40000 ALTER TABLE `XTShezhiTiaojian` DISABLE KEYS */;
INSERT INTO `XTShezhiTiaojian` (`xt_shezhi_tiaojian_zj`, `xt_shezhi_tiaojian_mc`, `xt_shezhi_tiaojian_zhi`, `xt_shezhi_tiaojian_bz`, `xt_shezhi_tiaojian_zt`) VALUES
	('201807040804077640000001', '系统管理员', 'XtGuanliyuan', '', 1),
	('201807040852543740000001', '系统权限管理', 'XtQuanxian', '', 1),
	('201807051707030320000004', '人员管理', 'RY', '', 1),
	('201807051928040700000001', '系统角色管理', 'XtJuese', '', 1),
	('201807051930280020000008', '部门管理', 'BM', '', 1),
	('201807051931304210000014', '岗位', 'Gangwei', '', 1),
	('201807051932147170000019', '职位', 'Zhiwei', '', 1),
	('201807051933060430000024', '楼房分类', 'LoufangFL', '', 1),
	('201808020148183550000008', '楼', 'Loufang', '', 0),
	('201808020152088410000020', '房', 'Loufang2', '', 0),
	('201808020153570440000027', '楼房-项目费', 'LoufangXMF', '', 0),
	('201808020155282490000031', '楼房-费用标准', 'LoufangFYBZ', '', 0),
	('201808020201320180000036', '楼房-住宿合同', 'ZhusuHetong', '', 0),
	('201808020205568960000054', '楼房-抄电表', 'ChaoDianbiao', '', 0),
	('201808020208445430000069', '楼房-抄水表', 'ChaoShuibiao', '', 0),
	('201808020213398590000086', '楼房-纳费', 'LoufangNafei', '', 0);
/*!40000 ALTER TABLE `XTShezhiTiaojian` ENABLE KEYS */;

-- 导出  表 Empty.XTShezhiTiaojian1 结构
CREATE TABLE IF NOT EXISTS `XTShezhiTiaojian1` (
  `xt_shezhi_tiaojian1_zj` char(24) NOT NULL COMMENT '主键',
  `xt_shezhi_tiaojian_zj` char(24) NOT NULL COMMENT '表头主键',
  `xt_shezhi_tiaojian1_mc` varchar(20) NOT NULL COMMENT '条件名',
  `xt_shezhi_tiaojian1_zhi` varchar(200) NOT NULL COMMENT '条件值',
  PRIMARY KEY (`xt_shezhi_tiaojian1_zj`),
  UNIQUE KEY `xt_shezhi_tiaojian1_mc` (`xt_shezhi_tiaojian1_mc`,`xt_shezhi_tiaojian_zj`),
  UNIQUE KEY `xt_shezhi_tiaojian1_zhi` (`xt_shezhi_tiaojian1_zhi`,`xt_shezhi_tiaojian_zj`),
  KEY `xt_shezhi_tiaojian_zj` (`xt_shezhi_tiaojian_zj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统设置_条件1';

-- 正在导出表  Empty.XTShezhiTiaojian1 的数据：~155 rows (大约)
DELETE FROM `XTShezhiTiaojian1`;
/*!40000 ALTER TABLE `XTShezhiTiaojian1` DISABLE KEYS */;
INSERT INTO `XTShezhiTiaojian1` (`xt_shezhi_tiaojian1_zj`, `xt_shezhi_tiaojian_zj`, `xt_shezhi_tiaojian1_mc`, `xt_shezhi_tiaojian1_zhi`) VALUES
	('201807040810468140000006', '201807040804077640000001', '管理员名称', 'xt_guanliyuan_mc'),
	('201807040810468140000007', '201807040804077640000001', '管理员账号', 'xt_guanliyuan_zhanghao'),
	('201807040810468140000008', '201807040804077640000001', '管理员邮箱', 'xt_guanliyuan_youxiang'),
	('201807040810468140000009', '201807040804077640000001', '管理员状态', 'xt_guanliyuan_zt'),
	('201807040810468140000010', '201807040804077640000001', '隔离标识', 'xt_guanliyuan_gelibiaoshi'),
	('201807040810468140000011', '201807040804077640000001', '级别(2总管,3辅管,4业务员)', 'xt_guanliyuan_jibie'),
	('201807040810468140000012', '201807040804077640000001', '制单时间', 'xt_guanliyuan_zhidanshijian'),
	('201807040852543740000002', '201807040852543740000001', '级别', 'xt_quanxian_jibie'),
	('201807040852543740000003', '201807040852543740000001', '可视（1可视，0不可视）', 'xt_quanxian_keshi'),
	('201807040852543740000004', '201807040852543740000001', '状态', 'xt_quanxian_zt'),
	('201807040852543740000005', '201807040852543740000001', '权限代码', 'xt_quanxian_dm'),
	('201807040852543740000006', '201807040852543740000001', '名称', 'xt_quanxian_mc'),
	('201807040852543740000007', '201807040852543740000001', 'url', 'xt_quanxian_url'),
	('201807040852543740000008', '201807040852543740000001', '展开', 'xt_quanxian_zhankai'),
	('201807040852543740000009', '201807040852543740000001', '隔离标识', 'xt_quanxian_gelibiaoshi'),
	('201807051707030330000005', '201807051707030320000004', '部门', 'ry_bm'),
	('201807051707030330000006', '201807051707030320000004', '人员名称', 'ry_mc'),
	('201807051707030330000007', '201807051707030320000004', '账号', 'ry_zhanghao'),
	('201807051707030330000008', '201807051707030320000004', '状态', 'ry_zt'),
	('201807051707030330000009', '201807051707030320000004', '性别', 'ry_xingbie'),
	('201807051707030330000010', '201807051707030320000004', '入职日期', 'ry_ruzhiriqi'),
	('201807051707030330000011', '201807051707030320000004', '出生日期', 'ry_chushengriqi'),
	('201807051707030330000012', '201807051707030320000004', '离职日期', 'ry_lizhiriqi'),
	('201807051707030330000013', '201807051707030320000004', '籍贯', 'ry_jiguan'),
	('201807051707030330000014', '201807051707030320000004', '手机1', 'ry_shouji1'),
	('201807051707030330000015', '201807051707030320000004', '邮箱', 'ry_youxiang'),
	('201807051707030330000016', '201807051707030320000004', '婚姻状态', 'ry_hunyin'),
	('201807051707030330000017', '201807051707030320000004', '岗位', 'ry_gangwei'),
	('201807051707030330000018', '201807051707030320000004', '职位', 'ry_zhiwei'),
	('201807051707030330000019', '201807051707030320000004', '备注', 'ry_bz'),
	('201807051707030330000020', '201807051707030320000004', '身份证号码', 'ry_shenfenzheng'),
	('201807051707030330000021', '201807051707030320000004', '现住地址', 'ry_xianzhudizhi'),
	('201807051707030340000022', '201807051707030320000004', '家庭地址', 'ry_jiatingdizhi'),
	('201807051707030340000023', '201807051707030320000004', '紧急联系人', 'ry_jinjilianxiren'),
	('201807051707030340000024', '201807051707030320000004', '紧急联系人电话', 'ry_jinjilianxiren_dianhua'),
	('201807051707030340000025', '201807051707030320000004', '固定电话1', 'ry_gudingdianhua1'),
	('201807051707030340000026', '201807051707030320000004', '固定电话2', 'ry_gudingdianhua2'),
	('201807051707030340000027', '201807051707030320000004', '其他通信', 'ry_qitatongxing'),
	('201807051707030340000028', '201807051707030320000004', '其他通信1', 'ry_qitatongxing1'),
	('201807051707030340000029', '201807051707030320000004', '其他通信2', 'ry_qitatongxing2'),
	('201807051707030340000030', '201807051707030320000004', '其他通信3', 'ry_qitatongxing3'),
	('201807051707030340000031', '201807051707030320000004', '其他通信4', 'ry_qitatongxing4'),
	('201807051707030340000032', '201807051707030320000004', '其他通信5', 'ry_qitatongxing5'),
	('201807051707030340000033', '201807051707030320000004', '内部通信1', 'ry_neibutongxing1'),
	('201807051707030340000034', '201807051707030320000004', '内部通信2', 'ry_neibutongxing2'),
	('201807051707030340000035', '201807051707030320000004', '内部通信3', 'ry_neibutongxing3'),
	('201807051707030340000036', '201807051707030320000004', '内部通信4', 'ry_neibutongxing4'),
	('201807051707030340000037', '201807051707030320000004', '内部通信5', 'ry_neibutongxing5'),
	('201807051707030340000038', '201807051707030320000004', '内部通信6', 'ry_neibutongxing6'),
	('201807051707030340000039', '201807051707030320000004', '内部通信7', 'ry_neibutongxing7'),
	('201807051707030340000040', '201807051707030320000004', '内部通信8', 'ry_neibutongxing8'),
	('201807051707030340000041', '201807051707030320000004', '内部通信9', 'ry_neibutongxing9'),
	('201807051707030340000042', '201807051707030320000004', '内部通信10', 'ry_neibutongxing10'),
	('201807051707030340000043', '201807051707030320000004', '制单人', 'ry_zhidanren'),
	('201807051928040710000002', '201807051928040700000001', '名称', 'xt_juese_mc'),
	('201807051928040710000003', '201807051928040700000001', '状态', 'xt_juese_zt'),
	('201807051928040710000004', '201807051928040700000001', '制单人', 'xt_juese_zhidanren'),
	('201807051928040710000005', '201807051928040700000001', '制单时间', 'xt_juese_zhidanshijian'),
	('201807051928040710000006', '201807051928040700000001', '修改人', 'xt_juese_xiugairen'),
	('201807051928040710000007', '201807051928040700000001', '修改时间', 'xt_juese_xiugaishijian'),
	('201807051930280030000009', '201807051930280020000008', '名称', 'bm_mc'),
	('201807051930280030000010', '201807051930280020000008', '编码', 'bm_bianma'),
	('201807051930280030000011', '201807051930280020000008', '部门简介', 'bm_jianjie'),
	('201807051930280030000012', '201807051930280020000008', '部门创建时间', 'bm_chuangjianshijian'),
	('201807051930280030000013', '201807051930280020000008', '部门状态', 'bm_zt'),
	('201807051931304210000015', '201807051931304210000014', '名称', 'gangwei_mc'),
	('201807051931304210000016', '201807051931304210000014', '制单时间', 'gangwei_zhidanshijian'),
	('201807051931304210000017', '201807051931304210000014', '备注', 'gangwei_bz'),
	('201807051931304210000018', '201807051931304210000014', '状态', 'gangwei_zt'),
	('201807051932147170000020', '201807051932147170000019', '名称', 'zhiwei_mc'),
	('201807051932147170000021', '201807051932147170000019', '制单时间', 'zhiwei_zhidanshijian'),
	('201807051932147170000022', '201807051932147170000019', '备注', 'zhiwei_bz'),
	('201807051932147170000023', '201807051932147170000019', '状态', 'zhiwei_zt'),
	('201807082235341720000005', '201807051933060430000024', '名称', 'loufangfl_mc'),
	('201807082235341720000006', '201807051933060430000024', '备注', 'loufangfl_bz'),
	('201807082235341720000007', '201807051933060430000024', '状态', 'loufangfl_zt'),
	('201808020148183550000009', '201808020148183550000008', '名称', 'loufang_mc'),
	('201808020148183550000010', '201808020148183550000008', '地址', 'loufang_dizhi'),
	('201808020148183550000011', '201808020148183550000008', '备注', 'loufang_bz'),
	('201808020148183550000012', '201808020148183550000008', '状态', 'loufang_zt'),
	('201808020148183550000013', '201808020148183550000008', '单间床位', 'loufang_danjian_chuangwei'),
	('201808020148183550000014', '201808020148183550000008', '已用单间床位', 'loufang_danjian_chuangwei2'),
	('201808020148183550000015', '201808020148183550000008', '套间床位', 'loufang_taojian_chuangwei'),
	('201808020148183550000016', '201808020148183550000008', '已用套间床位', 'loufang_taojian_chuangwei2'),
	('201808020152088410000021', '201808020152088410000020', '编号', 'loufang2_bianhao'),
	('201808020152088410000022', '201808020152088410000020', '名称', 'loufang2_mingcheng'),
	('201808020152088410000023', '201808020152088410000020', '床位', 'loufang2_chuangwei'),
	('201808020152088410000024', '201808020152088410000020', '入住人数', 'loufang2_ruzhurenshu'),
	('201808020152088410000025', '201808020152088410000020', '房间类型', 'loufang2_lx'),
	('201808020152088410000026', '201808020152088410000020', '备注', 'loufang2_bz'),
	('201808020153570440000028', '201808020153570440000027', '项目名称', 'loufangxmf_mc'),
	('201808020153570440000029', '201808020153570440000027', '项目费', 'loufangxmf_feiyong'),
	('201808020153570440000030', '201808020153570440000027', '状态', 'loufangxmf_zt'),
	('201808020155282490000032', '201808020155282490000031', '楼名', 'loufang_fybz_loufang_mc'),
	('201808020155282490000033', '201808020155282490000031', '电费标准', 'loufang_fybz_dianfei'),
	('201808020155282490000034', '201808020155282490000031', '水费标准', 'loufang_fybz_shuifei'),
	('201808020155282490000035', '201808020155282490000031', '状态', 'loufang_fybz_zt'),
	('201808020201320180000037', '201808020201320180000036', '楼名称', 'zhusuhetong_loufang_mc'),
	('201808020201320180000038', '201808020201320180000036', '房编号', 'zhusuhetong_loufang2_bianhao'),
	('201808020201320180000039', '201808020201320180000036', '签约人', 'zhusuhetong_qianyueren'),
	('201808020201320180000040', '201808020201320180000036', '押金', 'zhusuhetong_yajin'),
	('201808020201320180000041', '201808020201320180000036', '租金', 'zhusuhetong_zujin'),
	('201808020201320180000042', '201808020201320180000036', '开始日期', 'zhusuhetong_kaishiriqi'),
	('201808020201320180000043', '201808020201320180000036', '结束日期', 'zhusuhetong_jieshuriqi'),
	('201808020201320180000044', '201808020201320180000036', '计费方式(1入住日;2月底;3指定)', 'zhusuhetong_jffs'),
	('201808020201320180000045', '201808020201320180000036', '计费方式-指定日期', 'zhusuhetong_jffs_zdrq'),
	('201808020201320180000046', '201808020201320180000036', '最小住宿日期', 'zhusuhetong_zuixiaozhusuriqi'),
	('201808020201320180000047', '201808020201320180000036', '制单时间', 'zhusuhetong_zhidanshijian'),
	('201808020201320180000048', '201808020201320180000036', '制单人', 'zhusuhetong_zhidanren'),
	('201808020201320180000049', '201808020201320180000036', '修改时间', 'zhusuhetong_xiugaishijian'),
	('201808020201320180000050', '201808020201320180000036', '修改人', 'zhusuhetong_xiugairen'),
	('201808020201320180000051', '201808020201320180000036', '备注', 'zhusuhetong_bz'),
	('201808020201320180000052', '201808020201320180000036', '项目费', 'zhusuhetong_tj_xml'),
	('201808020201320180000053', '201808020201320180000036', '楼房项目', 'zhusuhetong_xml_zj'),
	('201808020205568970000055', '201808020205568960000054', '楼名称', 'chaodianbiao_loufang_mc'),
	('201808020205568970000056', '201808020205568960000054', '房编号', 'chaodianbiao_loufang2_bianma'),
	('201808020205568970000057', '201808020205568960000054', '上次读数', 'chaodianbiao_dushu1'),
	('201808020205568970000058', '201808020205568960000054', '上次抄表日期', 'chaodianbiao_riqi1'),
	('201808020205568970000059', '201808020205568960000054', '读数', 'chaodianbiao_dushu2'),
	('201808020205568970000060', '201808020205568960000054', '抄表日期', 'chaodianbiao_riqi2'),
	('201808020205568970000061', '201808020205568960000054', '水(吨)', 'chaodianbiao_dian'),
	('201808020205568970000062', '201808020205568960000054', '水单价', 'chaodianbiao_dian_danjia'),
	('201808020205568970000063', '201808020205568960000054', '金额', 'chaodianbiao_dian_jine'),
	('201808020205568970000064', '201808020205568960000054', '制单时间', 'chaodianbiao_zhidanshijian'),
	('201808020205568970000065', '201808020205568960000054', '制单人', 'chaodianbiao_zhidanren'),
	('201808020205568970000066', '201808020205568960000054', '分摊人数', 'chaodianbiao_fentanrenshu'),
	('201808020205568970000067', '201808020205568960000054', '已分摊人数', 'chaodianbiao_yj_fentanrenshu'),
	('201808020205568970000068', '201808020205568960000054', '状态', 'chaodianbiao_zt'),
	('201808020208445430000070', '201808020208445430000069', '楼名称', 'chaoshuibiao_loufang_mc'),
	('201808020208445430000071', '201808020208445430000069', '房编号', 'chaoshuibiao_loufang2_bianma'),
	('201808020208445430000072', '201808020208445430000069', '上次读数', 'chaoshuibiao_dushu1'),
	('201808020208445430000073', '201808020208445430000069', '上次抄表日期', 'chaoshuibiao_riqi1'),
	('201808020208445430000074', '201808020208445430000069', '读数', 'chaoshuibiao_dushu2'),
	('201808020208445430000075', '201808020208445430000069', '抄表日期', 'chaoshuibiao_riqi2'),
	('201808020208445430000076', '201808020208445430000069', '水(吨)', 'chaoshuibiao_shui'),
	('201808020208445430000077', '201808020208445430000069', '水单价', 'chaoshuibiao_shui_danjia'),
	('201808020208445430000078', '201808020208445430000069', '金额', 'chaoshuibiao_shui_jine'),
	('201808020208445430000079', '201808020208445430000069', '制单时间', 'chaoshuibiao_zhidanshijian'),
	('201808020208445430000080', '201808020208445430000069', '制单人', 'chaoshuibiao_zhidanren'),
	('201808020208445440000081', '201808020208445430000069', '分摊人数', 'chaoshuibiao_fentanrenshu'),
	('201808020208445440000082', '201808020208445430000069', '已分摊人数', 'chaoshuibiao_yj_fentanrenshu'),
	('201808020208445440000083', '201808020208445430000069', '状态', 'chaoshuibiao_zt'),
	('201808020213398600000087', '201808020213398590000086', '楼名称', 'loufangnafei_lou_mc'),
	('201808020213398600000088', '201808020213398590000086', '房编码', 'loufangnafei_fang_bianma'),
	('201808020213398600000089', '201808020213398590000086', '纳费人', 'loufangnafei_ren'),
	('201808020213398600000090', '201808020213398590000086', '应纳日期', 'loufangnafei_yingnariqi'),
	('201808020213398600000091', '201808020213398590000086', '纳费日期', 'loufangnafei_nafeiriqi'),
	('201808020213398600000092', '201808020213398590000086', '总费用', 'loufangnafei_zongfeiyong'),
	('201808020213398600000093', '201808020213398590000086', '已纳费用', 'loufangnafei_zongfeiyong2'),
	('201808020213398600000094', '201808020213398590000086', '房租', 'loufangnafei_fangzu'),
	('201808020213398600000095', '201808020213398590000086', '水费', 'loufangnafei_feiyong_shui'),
	('201808020213398600000096', '201808020213398590000086', '电费', 'loufangnafei_feiyong_dian'),
	('201808020213398600000097', '201808020213398590000086', '项目费', 'loufangnafei_feiyong_xm'),
	('201808020213398600000098', '201808020213398590000086', '状态', 'loufangnafei_zt'),
	('201808020213398600000099', '201808020213398590000086', '出账时间', 'loufangnafei_chuzhangshijian');
/*!40000 ALTER TABLE `XTShezhiTiaojian1` ENABLE KEYS */;

-- 导出  表 Empty.XTTiaojian 结构
CREATE TABLE IF NOT EXISTS `XTTiaojian` (
  `xt_tiaojian_zj` char(24) NOT NULL COMMENT '主键',
  `xt_shezhi_tiaojian_zj` char(24) NOT NULL COMMENT '模块主键',
  `xt_shezhi_tiaojian_mc` varchar(20) NOT NULL COMMENT '模块名称',
  `xt_shezhi_tiaojian_zhi` varchar(20) NOT NULL COMMENT '使用值',
  `xt_tiaojian_mc` varchar(20) NOT NULL COMMENT '条件方案名称',
  `xt_tiaojian_zhidanren_zj` char(24) NOT NULL COMMENT '方案制定人主键',
  `xt_tiaojian_zhidanren` varchar(20) NOT NULL COMMENT '制定人名称',
  `xt_tiaojian_gelibiaoshi` varchar(20) NOT NULL COMMENT '单据隔离标识',
  `xt_tiaojian_zt` int(11) NOT NULL COMMENT '状态',
  PRIMARY KEY (`xt_tiaojian_zj`),
  KEY `xt_shezhi_tiaojian_zj` (`xt_shezhi_tiaojian_zj`),
  KEY `xt_shezhi_tiaojian_mc` (`xt_shezhi_tiaojian_mc`),
  KEY `xt_shezhi_tiaojian_zhi` (`xt_shezhi_tiaojian_zhi`),
  KEY `xt_tiaojian_mc` (`xt_tiaojian_mc`),
  KEY `xt_tiaojian_zhidanren_zj` (`xt_tiaojian_zhidanren_zj`),
  KEY `xt_tiaojian_gelibiaoshi` (`xt_tiaojian_gelibiaoshi`),
  KEY `xt_tiaojian_zt` (`xt_tiaojian_zt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统条件管理';

-- 正在导出表  Empty.XTTiaojian 的数据：~15 rows (大约)
DELETE FROM `XTTiaojian`;
/*!40000 ALTER TABLE `XTTiaojian` DISABLE KEYS */;
INSERT INTO `XTTiaojian` (`xt_tiaojian_zj`, `xt_shezhi_tiaojian_zj`, `xt_shezhi_tiaojian_mc`, `xt_shezhi_tiaojian_zhi`, `xt_tiaojian_mc`, `xt_tiaojian_zhidanren_zj`, `xt_tiaojian_zhidanren`, `xt_tiaojian_gelibiaoshi`, `xt_tiaojian_zt`) VALUES
	('201807040804282050000003', '201807040804077640000001', '系统管理员', 'XtGuanliyuan', '列出总管', '201807030723353900000001', '超级管理员', 'S', 0),
	('201807040853310560000010', '201807040852543740000001', '系统权限管理', 'XtQuanxian', '可视菜单', '201807030723353900000001', '超级管理员', 'S', 0),
	('201807082235146290000003', '201807040852543740000001', '系统权限管理', 'XtQuanxian', '可视菜单', '201807030723353900000001', '超级管理员', 'S', 0),
	('201807092016429200000078', '201807051928040700000001', '系统角色管理', 'XtJuese', '列出新增的', '201807091746493090000004', '佛山xx公司', 'fs001', 0),
	('201807101838576780000086', '201807040804077640000001', '系统管理员', 'XtGuanliyuan', '列出辅管', '201807091746493090000004', '佛山xx公司', 'fs001', 0),
	('201807101839497980000088', '201807040804077640000001', '系统管理员', 'XtGuanliyuan', '未审核的辅管', '201807091746493090000004', '佛山xx公司', 'fs001', 0),
	('201807101840515490000090', '201807051707030320000004', '人员管理', 'RY', '找到审核的汪春滋', '201807091746493090000004', '佛山xx公司', 'fs001', 0),
	('201807161714094400000008', '201807051707030320000004', '人员管理', 'RY', '找到汪春滋', '201807091801013420000036', '汪春滋', 'fs001', 0),
	('201807161720541700000003', '201807051707030320000004', '人员管理', 'RY', '新增的人员', '201807091801013420000036', '汪春滋', 'fs001', 0),
	('201807161729568460000005', '201807051707030320000004', '人员管理', 'RY', '找到审核的汪春滋或女的', '201807091801013420000036', '汪春滋', 'fs001', 0),
	('201808020144250310000006', '201807051933060430000024', '楼房分类', 'LoufangFL', '1', '201807091801013420000036', '汪春滋', 'fs001', 0),
	('201808020148395990000017', '201808020148183550000008', '楼', 'Loufang', '审核的', '201807091801013420000036', '汪春滋', 'fs001', 0),
	('201808020209408160000084', '201808020208445430000069', '楼房-抄水表', 'ChaoShuibiao', '10天内', '201807091801013420000036', '汪春滋', 'fs001', 0),
	('201808020214040570000100', '201808020213398590000086', '楼房-纳费', 'LoufangNafei', '本月', '201807091801013420000036', '汪春滋', 'fs001', 0),
	('201808201524176790000088', '201808020201320180000036', '楼房-住宿合同', 'ZhusuHetong', '107', '201807091801013420000036', '汪春滋', 'fs001', 0);
/*!40000 ALTER TABLE `XTTiaojian` ENABLE KEYS */;

-- 导出  表 Empty.XTTiaojian1 结构
CREATE TABLE IF NOT EXISTS `XTTiaojian1` (
  `xt_tiaojian1_zj` char(24) NOT NULL COMMENT '主键',
  `xt_tiaojian_zj` char(24) NOT NULL COMMENT '表头主键',
  `xt_tiaojian1_kuohao` varchar(20) DEFAULT NULL COMMENT '括号区',
  `xt_tiaojian1_lianjiefu` varchar(20) DEFAULT NULL COMMENT '接连符',
  `xt_tiaojian1_lianjiefu_mc` varchar(20) DEFAULT NULL COMMENT '接连符展示名',
  `xt_shezhi_tiaojian1_mc` varchar(20) DEFAULT NULL COMMENT '条件区展示名',
  `xt_shezhi_tiaojian1_zhi` varchar(200) DEFAULT NULL COMMENT '条件区值',
  `xt_tiaojian1_panduan` varchar(20) DEFAULT NULL COMMENT '判断区',
  `xt_tiaojian1_panduan_mc` varchar(20) DEFAULT NULL COMMENT '判断区展示名',
  `xt_tiaojian1_zhi` varchar(20) DEFAULT NULL COMMENT '条件值',
  PRIMARY KEY (`xt_tiaojian1_zj`),
  KEY `xt_tiaojian_zj` (`xt_tiaojian_zj`),
  KEY `xt_shezhi_tiaojian1_mc` (`xt_shezhi_tiaojian1_mc`),
  KEY `xt_shezhi_tiaojian1_zhi` (`xt_shezhi_tiaojian1_zhi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统条件表体';

-- 正在导出表  Empty.XTTiaojian1 的数据：~28 rows (大约)
DELETE FROM `XTTiaojian1`;
/*!40000 ALTER TABLE `XTTiaojian1` DISABLE KEYS */;
INSERT INTO `XTTiaojian1` (`xt_tiaojian1_zj`, `xt_tiaojian_zj`, `xt_tiaojian1_kuohao`, `xt_tiaojian1_lianjiefu`, `xt_tiaojian1_lianjiefu_mc`, `xt_shezhi_tiaojian1_mc`, `xt_shezhi_tiaojian1_zhi`, `xt_tiaojian1_panduan`, `xt_tiaojian1_panduan_mc`, `xt_tiaojian1_zhi`) VALUES
	('201807040816197540000016', '201807040816197540000015', '', '', '', '级别(2总管,3辅管,4业务员)', 'xt_guanliyuan_jibie', '=', '等于', '3'),
	('201807040853310560000011', '201807040853310560000010', '', '', '', '可视（1可视，0不可视）', 'xt_quanxian_keshi', '=', '等于', '1'),
	('201807051707368810000045', '201807051707368810000044', '', '', '', '人员名称', 'ry_mc', '=', '等于', '汪春滋'),
	('201807051708542620000048', '201807051708270440000046', '', '', '', '入职日期', 'ry_ruzhiriqi', 'IN', '在什么之中', '2天内'),
	('201807051934253800000031', '201807051933579220000028', '', '', '', '编码', 'bm_bianma', 'LIKE%', '左包含', 'xxb'),
	('201807051935026710000033', '201807051935026710000032', '', '', '', '人员名称', 'ry_mc', '=', '等于', '汪春滋'),
	('201807051935362950000035', '201807051935362950000034', '', '', '', '状态', 'gangwei_zt', '=', '等于', '新增'),
	('201807080345401310000005', '201807080345401300000004', '', '', '', '人员名称', 'ry_mc', '%LIKE%', '包含', 'c'),
	('201807082235146300000004', '201807082235146290000003', '', '', '', '可视（1可视，0不可视）', 'xt_quanxian_keshi', '=', '等于', '1'),
	('201807082237193040000008', '201807040804282050000003', '', '', '', '级别(2总管,3辅管,4业务员)', 'xt_guanliyuan_jibie', '=', '等于', '2'),
	('201807092016429200000079', '201807092016429200000078', '', '', '', '状态', 'xt_juese_zt', '=', '等于', '新增'),
	('201807101838576780000087', '201807101838576780000086', '', '', '', '级别(2总管,3辅管,4业务员)', 'xt_guanliyuan_jibie', '=', '等于', '3'),
	('201807101839497980000089', '201807101839497980000088', '', '', '', '管理员状态', 'xt_guanliyuan_zt', '<>', '不等于', '审核'),
	('201807101841496450000092', '201807101840515490000090', '', '', '', '人员名称', 'ry_mc', '=', '等于', '汪春滋'),
	('201807101841496460000093', '201807101840515490000090', '', 'AND', '并且', '状态', 'ry_zt', '=', '等于', '审核'),
	('201807161717537820000001', '201807161714094400000008', '', '', '', '人员名称', 'ry_mc', '=', '等于', '汪春滋'),
	('201807161717537820000002', '201807161714094400000008', '', 'AND', '并且', '状态', 'ry_zt', '=', '等于', '审核'),
	('201807161720541700000004', '201807161720541700000003', '', '', '', '状态', 'ry_zt', '=', '等于', '保存'),
	('201807161729568460000006', '201807161729568460000005', '(', '', '', '', '', '', '', ''),
	('201807161729568460000007', '201807161729568460000005', '', '', '', '人员名称', 'ry_mc', '=', '等于', '汪春滋'),
	('201807161729568460000008', '201807161729568460000005', '', 'AND', '并且', '状态', 'ry_zt', '=', '等于', '审核'),
	('201807161729568460000009', '201807161729568460000005', ')', '', '', '', '', '', '', ''),
	('201807161729568460000010', '201807161729568460000005', '', 'OR', '或', '性别', 'ry_xingbie', '=', '等于', '女'),
	('201808020144250310000007', '201808020144250310000006', '', '', '', '名称', 'loufangfl_mc', '%LIKE%', '包含', '1'),
	('201808020149090260000019', '201808020148395990000017', '', '', '', '状态', 'loufang_zt', '=', '等于', '审核'),
	('201808020209408160000085', '201808020209408160000084', '', '', '', '抄表日期', 'chaoshuibiao_riqi2', 'IN', '在什么之中', '10天内'),
	('201808020214040570000101', '201808020214040570000100', '', '', '', '出账时间', 'loufangnafei_chuzhangshijian', 'IN', '在什么之中', '本月'),
	('201808201524176790000089', '201808201524176790000088', '', '', '', '房编号', 'zhusuhetong_loufang2_bianhao', '=', '等于', '107');
/*!40000 ALTER TABLE `XTTiaojian1` ENABLE KEYS */;

-- 导出  表 Empty.Zhiwei 结构
CREATE TABLE IF NOT EXISTS `Zhiwei` (
  `zhiwei_zj` char(24) NOT NULL COMMENT '主键',
  `zhiwei_fzj` char(24) NOT NULL COMMENT '父键',
  `zhiwei_mc` varchar(200) NOT NULL COMMENT '名称',
  `zhiwei_zhidanshijian` datetime NOT NULL COMMENT '制单时间',
  `zhiwei_bz` varchar(300) DEFAULT NULL COMMENT '备注',
  `zhiwei_zt` int(11) NOT NULL COMMENT '状态',
  `zhiwei_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  PRIMARY KEY (`zhiwei_zj`),
  KEY `zhiwei_fzj` (`zhiwei_fzj`),
  KEY `zhiwei_zt` (`zhiwei_zt`),
  KEY `zhiwei_gelibiaoshi` (`zhiwei_gelibiaoshi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='职位';

-- 正在导出表  Empty.Zhiwei 的数据：~13 rows (大约)
DELETE FROM `Zhiwei`;
/*!40000 ALTER TABLE `Zhiwei` DISABLE KEYS */;
INSERT INTO `Zhiwei` (`zhiwei_zj`, `zhiwei_fzj`, `zhiwei_mc`, `zhiwei_zhidanshijian`, `zhiwei_bz`, `zhiwei_zt`, `zhiwei_gelibiaoshi`) VALUES
	('201807091759142690000029', '0', 'xxxxx总公司', '2018-07-09 17:59:14', '', 0, 'fs001'),
	('201807091759208830000030', '0', 'xxxxx分公司', '2018-07-09 17:59:20', '', 0, 'fs001'),
	('201807091759326480000031', '201807091759142690000029', 'ceo', '2018-07-09 17:59:32', '', 0, 'fs001'),
	('201807091759396830000032', '201807091759142690000029', '总经理', '2018-07-09 17:59:39', '', 0, 'fs001'),
	('201807091759459070000033', '201807091759142690000029', '财务总经理', '2018-07-09 17:59:45', '', 0, 'fs001'),
	('201807091759517570000034', '201807091759142690000029', '主管', '2018-07-09 17:59:51', '', 0, 'fs001'),
	('201807091759579310000035', '201807091759208830000030', 'xx', '2018-07-09 17:59:57', '', 0, 'fs001'),
	('201807091813076710000055', '0', '主管', '2018-07-09 18:13:07', '', 0, 'sz001'),
	('201807091813121270000056', '0', '经理', '2018-07-09 18:13:12', '', 0, 'sz001'),
	('201807091816130710000064', '0', '总经理', '2018-07-09 18:16:13', '', 1, 'zh001'),
	('201807091816170330000065', '0', '主管', '2018-07-09 18:16:17', '', 1, 'zh001'),
	('201807092007420370000076', '0', 'xxxxxxxxx', '2018-07-09 20:07:42', '', 0, 'fs001'),
	('201807092007475660000077', '0', 'ddd22', '2018-07-09 20:07:47', '--', 0, 'fs001');
/*!40000 ALTER TABLE `Zhiwei` ENABLE KEYS */;

-- 导出  表 Empty.ZhusuHetong 结构
CREATE TABLE IF NOT EXISTS `ZhusuHetong` (
  `zhusuhetong_zj` char(24) NOT NULL COMMENT '主键',
  `zhusuhetong_gelibiaoshi` varchar(20) NOT NULL COMMENT '隔离标识',
  `zhusuhetong_zt` int(11) NOT NULL COMMENT '状态',
  `zhusuhetong_loufang_zj` char(24) NOT NULL COMMENT '楼主键',
  `zhusuhetong_loufang_mc` varchar(20) NOT NULL COMMENT '楼名称',
  `zhusuhetong_loufang2_zj` char(24) NOT NULL COMMENT '房主键',
  `zhusuhetong_loufang2_bianhao` varchar(20) NOT NULL COMMENT '房编号',
  `zhusuhetong_qianyueren` varchar(20) NOT NULL COMMENT '签约人',
  `zhusuhetong_qianyueren_zj` char(24) NOT NULL COMMENT '签约人主键',
  `zhusuhetong_zujin` int(11) DEFAULT NULL COMMENT '租金',
  `zhusuhetong_yajin` int(11) DEFAULT NULL COMMENT '押金',
  `zhusuhetong_kaishiriqi` date NOT NULL COMMENT '开始日期',
  `zhusuhetong_jieshuriqi` date DEFAULT NULL COMMENT '结束日期',
  `zhusuhetong_jffs` int(11) NOT NULL COMMENT '计费方式',
  `zhusuhetong_jffs_zdrq` int(11) DEFAULT NULL COMMENT '计费方式-指定日期',
  `zhusuhetong_zuixiaozhusuriqi` date DEFAULT NULL COMMENT '最小住宿日期',
  `zhusuhetong_zhidanshijian` datetime NOT NULL COMMENT '制单时间',
  `zhusuhetong_zhidanren` varchar(20) NOT NULL COMMENT '制单人',
  `zhusuhetong_zhidanren_zj` char(24) NOT NULL COMMENT '制单人主键',
  `zhusuhetong_xiugaishijian` datetime DEFAULT NULL COMMENT '修改时间',
  `zhusuhetong_xiugairen` varchar(20) DEFAULT NULL COMMENT '修改人',
  `zhusuhetong_xiugairen_zj` char(24) DEFAULT NULL COMMENT '修改人主键',
  `zhusuhetong_bz` varchar(200) DEFAULT NULL COMMENT '备注',
  `zhusuhetong_tj_xml` int(11) NOT NULL COMMENT '统计项目费',
  `zhusuhetong_xml_zj` text COMMENT '楼房项目',
  PRIMARY KEY (`zhusuhetong_zj`),
  KEY `zhusuhetong_gelibiaoshi` (`zhusuhetong_gelibiaoshi`),
  KEY `zhusuhetong_zt` (`zhusuhetong_zt`),
  KEY `zhusuhetong_loufang_zj` (`zhusuhetong_loufang_zj`),
  KEY `zhusuhetong_loufang2_zj` (`zhusuhetong_loufang2_zj`),
  KEY `zhusuhetong_qianyueren` (`zhusuhetong_qianyueren`),
  KEY `zhusuhetong_qianyueren_zj` (`zhusuhetong_qianyueren_zj`),
  KEY `zhusuhetong_jffs` (`zhusuhetong_jffs`),
  KEY `zhusuhetong_zhidanren_zj` (`zhusuhetong_zhidanren_zj`),
  KEY `zhusuhetong_xiugairen_zj` (`zhusuhetong_xiugairen_zj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='住宿合同';

-- 正在导出表  Empty.ZhusuHetong 的数据：~3 rows (大约)
DELETE FROM `ZhusuHetong`;
/*!40000 ALTER TABLE `ZhusuHetong` DISABLE KEYS */;
INSERT INTO `ZhusuHetong` (`zhusuhetong_zj`, `zhusuhetong_gelibiaoshi`, `zhusuhetong_zt`, `zhusuhetong_loufang_zj`, `zhusuhetong_loufang_mc`, `zhusuhetong_loufang2_zj`, `zhusuhetong_loufang2_bianhao`, `zhusuhetong_qianyueren`, `zhusuhetong_qianyueren_zj`, `zhusuhetong_zujin`, `zhusuhetong_yajin`, `zhusuhetong_kaishiriqi`, `zhusuhetong_jieshuriqi`, `zhusuhetong_jffs`, `zhusuhetong_jffs_zdrq`, `zhusuhetong_zuixiaozhusuriqi`, `zhusuhetong_zhidanshijian`, `zhusuhetong_zhidanren`, `zhusuhetong_zhidanren_zj`, `zhusuhetong_xiugaishijian`, `zhusuhetong_xiugairen`, `zhusuhetong_xiugairen_zj`, `zhusuhetong_bz`, `zhusuhetong_tj_xml`, `zhusuhetong_xml_zj`) VALUES
	('201808201501076580000079', 'fs001', 1, '201808201438099740000001', '港湾公寓B栋', '201808201438099750000007', '201', '汪春滋', '201807091801013420000036', 600, 1200, '2018-08-18', NULL, 1, 0, '2018-11-18', '2018-08-20 15:01:07', '汪春滋', '201807091801013420000036', NULL, '', '', '', 70, '卫生费,网费,环境费'),
	('201808201501448170000080', 'fs001', 1, '201808201438099740000001', '港湾公寓B栋', '201808201438099740000005', '107', '汪春滋', '201807091801013420000036', 600, 1200, '2018-08-18', NULL, 1, 0, '2018-11-18', '2018-08-20 15:01:44', '汪春滋', '201807091801013420000036', NULL, '', '', '', 70, '卫生费,网费,环境费'),
	('201808201502029610000081', 'fs001', 0, '201808201438099740000001', '港湾公寓B栋', '201808201438099750000007', '201', '汪春滋', '201807091801013420000036', 600, 1200, '2018-08-18', NULL, 1, 0, '2018-11-18', '2018-08-20 15:02:02', '汪春滋', '201807091801013420000036', NULL, '', '', '', 70, '卫生费,网费,环境费');
/*!40000 ALTER TABLE `ZhusuHetong` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
