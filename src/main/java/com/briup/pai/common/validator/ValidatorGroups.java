package com.briup.pai.common.validator;

public class ValidatorGroups {
    // 新增校验组
    public interface insert {}

    // 更新校验组
    public interface update {}

    // 模型训练校验组
    public interface train {}

    // 模型评估校验组
    public interface evaluate {}
}