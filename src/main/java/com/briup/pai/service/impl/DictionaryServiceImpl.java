package com.briup.pai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.pai.dao.DictionaryMapper;
import com.briup.pai.entity.dto.DictionarySaveDTO;
import com.briup.pai.entity.po.Dictionary;
import com.briup.pai.entity.vo.DictionaryEchoVO;
import com.briup.pai.entity.vo.DictionaryPageVO;
import com.briup.pai.entity.vo.DropDownVO;
import com.briup.pai.entity.vo.PageVO;
import com.briup.pai.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements IDictionaryService {

    @Override
    public DictionaryEchoVO addOrModifyDictionary(DictionarySaveDTO dto) {
        return null;
    }

    @Override
    public DictionaryEchoVO getDictionaryById(Integer dictionaryId) {
        return null;
    }

    @Override
    public void removeDictionaryById(Integer dictionaryId) {

    }

    @Override
    public PageVO<DictionaryPageVO> getDictionaryByPage(Long pageNum, Long pageSize) {
        return null;
    }

    @Override
    public List<DropDownVO> getDropDownList(String dictCode) {
        return List.of();
    }

    @Override
    public String getDictionaryValueById(Integer dictionaryId) {
        return "";
    }
}