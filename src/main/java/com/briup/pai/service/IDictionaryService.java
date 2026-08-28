package com.briup.pai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.briup.pai.entity.dto.DictionarySaveDTO;
import com.briup.pai.entity.po.Dictionary;
import com.briup.pai.entity.vo.DictionaryEchoVO;
import com.briup.pai.entity.vo.DictionaryPageVO;
import com.briup.pai.entity.vo.DropDownVO;
import com.briup.pai.entity.vo.PageVO;

import java.util.List;

public interface IDictionaryService extends IService<Dictionary> {

    // 新增或者修改数据字典
    DictionaryEchoVO addOrModifyDictionary(DictionarySaveDTO dto);

    // 根据数据字典编号查询数据字典
    DictionaryEchoVO getDictionaryById(Integer dictionaryId);

    // 根据数据字典编号删除数据字典
    void removeDictionaryById(Integer dictionaryId);

    // 分页查询数据字典
    PageVO<DictionaryPageVO> getDictionaryByPage(Long pageNum, Long pageSize);

    // 查询数据字典下拉框数据
    List<DropDownVO> getDropDownList(String dictCode);

    // 根据数据字典编号查询数据字典值
    String getDictionaryValueById(Integer dictionaryId);
}