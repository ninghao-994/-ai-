# 智慧农业植物病虫害 AI 识别系统（后端）

基于图像识别的人工智能平台，完成农作物病虫害程度检测模型的发布，实现智能检测、智能判断。本仓库为后端服务，采用前后端分离架构，前端通过 REST API 调用，接口文档由 Knife4j 自动生成。

## 技术栈

| 类别 | 技术 |
| --- | --- |
| 核心框架 | JDK 17、Spring Boot 3.2 |
| ORM | MyBatis-Plus |
| 数据库 | MySQL 8 |
| 缓存 | Redis + Spring Cache |
| 消息队列 | RabbitMQ |
| 认证 | JWT + 拦截器 + ThreadLocal |
| 参数校验 | JSR303（Spring Validation） |
| 文档 | Knife4j（OpenAPI 3） |
| 工具 | Hutool、Lombok、MapStruct、Fastjson2、EasyExcel、Druid |

## 功能模块

### 已实现

| 模块 | 说明 |
| --- | --- |
| 数据字典 | 字典的增删改查、分页、下拉框，Redis 缓存 |
| 统一认证登录 | 账号密码登录、手机验证码登录（验证码模拟发送）、获取当前用户 |
| 算子管理 | Excel 导入算子、条件分页、增删改查、批量删除、分类下拉框 |
| 数据集管理 | 数据集增删改查、分类管理、实体图片分页/批量删除（含文件同步处理） |

### 待实现（空壳）

模型管理、权限管理（用户/角色/权限）、日志管理、文件分片上传、模型训练/评估/发布等模块代码结构已就绪，待补充实现。

## 环境要求

- JDK 17
- Maven 3.6+
- MySQL 8（本项目默认端口 `43306`，库名 `pai`）
- Redis（默认 `localhost:6379`）

## 快速开始

### 1. 初始化数据库

```bash
mysql -uroot123 -p < sql/init.sql
```

脚本会创建数据库 `pai` 和 6 张表，并写入种子数据（数据字典、默认用户、示例算子）。

### 2. 修改配置

编辑 `src/main/resources/application-dev.yml`，按需修改数据库、Redis 连接信息及文件存储路径（`upload.nginx-file-path` / `upload.nginx-server`）。

### 3. 启动

```bash
mvn spring-boot:run
```

服务默认端口 `7777`。

### 4. 访问接口文档

Knife4j 接口文档：http://localhost:7777/doc.html

## 登录认证

1. 先调用登录接口获取 JWT 令牌：

```http
POST /login/withUsername
Content-Type: application/json

{ "username": "briup", "password": "briup" }
```

默认账号：`briup` / `briup`（密码以 MD5 存储，见 `sql/init.sql`）。

2. 后续请求在请求头携带令牌：

```
Authorization: <token>
```

登录、发送验证码等接口已放行，无需令牌；其余接口需通过 JWT 拦截器校验。

## 目录结构

```
src/main/java/com/briup/pai
├── common          # 常量、枚举、异常、统一返回、工具类
├── config          # 配置类（MyBatis-Plus、Redis、缓存、CORS、拦截器）
├── controller      # 控制层
├── convert         # MapStruct 对象转换
├── dao             # Mapper 数据访问层
├── entity          # dto / po / vo / message
└── service         # 业务逻辑接口及实现
sql/init.sql        # 建表脚本及种子数据
```
