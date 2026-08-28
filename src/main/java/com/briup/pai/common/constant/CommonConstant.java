package com.briup.pai.common.constant;

public class CommonConstant {

    // 下拉框缓存前缀
    public static final String DROPDOWN_CACHE_PREFIX = "Dropdown";

    // 列表缓存前缀
    public static final String LIST_CACHE_PREFIX = "List";

    // 详情信息缓存前缀
    public static final String DETAIL_CACHE_PREFIX = "Detail";

    // 工具方法：构建实体图片路径
    public static String createEntityPath(String prefix, Integer datasetId, String classifyName, String entityUrl) {
        return prefix + "/" + datasetId + "/" + classifyName + "/" + entityUrl;
    }
}
