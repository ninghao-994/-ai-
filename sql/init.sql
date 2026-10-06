-- ============================================================
-- 智慧农业植物病虫害 AI 识别系统 - 建表脚本
-- 数据库：pai
-- 说明：本次完善数据字典、登录、算子、数据集（含分类、实体）4 个模块
-- ============================================================

CREATE DATABASE IF NOT EXISTS `pai` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `pai`;

-- ----------------------------
-- 1. 数据字典表
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `parent_id` int NOT NULL COMMENT '父字典ID（0表示一级字典）',
  `dict_code` varchar(50) NOT NULL COMMENT '字典编码',
  `dict_value` varchar(50) NOT NULL COMMENT '字典值',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '是否删除（0未删除 1删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='数据字典表';

-- ----------------------------
-- 2. 用户表
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码（MD5加密）',
  `real_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `telephone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `header_url` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int NOT NULL DEFAULT 0 COMMENT '用户状态（0未禁用 1禁用）',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '是否删除（0未删除 1删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- ----------------------------
-- 3. 算子表
-- ----------------------------
DROP TABLE IF EXISTS `o_operator`;
CREATE TABLE `o_operator` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `operator_name` varchar(50) NOT NULL COMMENT '算子名称',
  `operator_type` int NOT NULL COMMENT '算子类型（0基础算子 1自定义算子）',
  `operator_url` varchar(50) NOT NULL COMMENT '算子路径',
  `operator_category` int NOT NULL COMMENT '算子分类（1网络结构 2优化器 3损失函数）',
  `create_by` int DEFAULT NULL COMMENT '创建用户',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '是否删除（0未删除 1删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='算子表';

-- ----------------------------
-- 4. 数据集表
-- ----------------------------
DROP TABLE IF EXISTS `d_dataset`;
CREATE TABLE `d_dataset` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `dataset_name` varchar(50) NOT NULL COMMENT '数据集名称',
  `dataset_type` int NOT NULL COMMENT '数据集类型（对应数据字典ID）',
  `dataset_desc` varchar(255) DEFAULT NULL COMMENT '数据集详情',
  `dataset_status` int NOT NULL DEFAULT 0 COMMENT '数据集状态（0初始化 1上传中 2已上传）',
  `dataset_usage` int NOT NULL COMMENT '数据集用途（0初始化训练 1优化训练 2评估）',
  `create_by` int DEFAULT NULL COMMENT '创建用户',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '是否删除（0未删除 1删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='数据集表';

-- ----------------------------
-- 5. 分类表
-- ----------------------------
DROP TABLE IF EXISTS `d_classify`;
CREATE TABLE `d_classify` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `dataset_id` int NOT NULL COMMENT '数据集ID',
  `classify_name` varchar(50) NOT NULL COMMENT '分类名称',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '是否删除（0未删除 1删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='分类表';

-- ----------------------------
-- 6. 实体表
-- ----------------------------
DROP TABLE IF EXISTS `d_entity`;
CREATE TABLE `d_entity` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `classify_id` int NOT NULL COMMENT '分类ID',
  `entity_url` varchar(255) NOT NULL COMMENT '实体图片名称',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '是否删除（0未删除 1删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='实体表';

-- ============================================================
-- 种子数据
-- ============================================================

-- 数据字典：数据集类型
INSERT INTO `sys_dictionary` (`id`, `parent_id`, `dict_code`, `dict_value`, `is_deleted`) VALUES
(1, 0, 'DATASET_TYPE', '数据集类型', 0),
(2, 1, 'IMAGE_CLASSIFICATION', '图像分类', 0);

-- 默认用户 briup / briup（密码为 md5("briup") = 5fa4d6fc78072f42e0b9817d310bcd35）
INSERT INTO `auth_user` (`id`, `username`, `password`, `real_name`, `telephone`, `header_url`, `status`, `is_deleted`) VALUES
(1, 'briup', '5fa4d6fc78072f42e0b9817d310bcd35', '管理员', '13800138000', 'https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg', 0, 0);

-- 示例算子
INSERT INTO `o_operator` (`id`, `operator_name`, `operator_type`, `operator_url`, `operator_category`, `create_by`, `is_deleted`) VALUES
(1, 'BriupInceptionV3', 0, 'nn.BriupInceptionV3', 1, 1, 0),
(2, 'BriupResNet50', 0, 'nn.BriupResNet50', 1, 1, 0),
(3, 'BriupAdagrad', 0, 'optimizer.BriupAdagrad', 2, 1, 0),
(4, 'BriupAdam', 0, 'optimizer.BriupAdam', 2, 1, 0),
(5, 'SparseCategoricalCrossentropy', 0, 'keras.losses.SparseCategoricalCrossentropy', 3, 1, 0);
