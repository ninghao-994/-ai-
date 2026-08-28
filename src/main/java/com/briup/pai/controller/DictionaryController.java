package com.briup.pai.controller;

import com.briup.pai.common.result.Result;
import com.briup.pai.common.validator.ValidatorGroups;
import com.briup.pai.entity.dto.DictionarySaveDTO;
import com.briup.pai.service.IDictionaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dictionary")
@Tag(name = "数据字典控制器")
public class DictionaryController {

    @Resource
    private IDictionaryService dictionaryService;

    @PostMapping
    @Operation(summary = "新增数据字典")
    public Result addDictionary(
            @RequestBody
            @Validated(ValidatorGroups.insert.class) DictionarySaveDTO dto) {
        return Result.success(dictionaryService.addOrModifyDictionary(dto));
    }

    @GetMapping("/{dictionaryId}")
    @Operation(summary = "修改数据字典的数据回显")
    public Result getDictionaryById(
            @PathVariable(value = "dictionaryId") Integer dictionaryId) {
        return Result.success(dictionaryService.getDictionaryById(dictionaryId));
    }

    @PutMapping
    @Operation(summary = "根据ID修改数据字典")
    public Result modifyDictionaryById(
            @RequestBody
            @Validated(ValidatorGroups.update.class) DictionarySaveDTO dto) {
        return Result.success(dictionaryService.addOrModifyDictionary(dto));
    }

    @DeleteMapping("/{dictionaryId}")
    @Operation(summary = "根据ID删除数据字典")
    public Result removeDictionaryById(
            @PathVariable(value = "dictionaryId") Integer dictionaryId) {
        dictionaryService.removeDictionaryById(dictionaryId);
        return Result.success();
    }

    @GetMapping("/{pageNum}/{pageSize}")
    @Operation(summary = "分页查询数据字典")
    public Result getDictionaryByPage(
            @PathVariable(value = "pageNum") Long pageNum,
            @PathVariable(value = "pageSize") Long pageSize) {
        return Result.success(dictionaryService.getDictionaryByPage(pageNum, pageSize));
    }

    @GetMapping("/getDropDownList/{dictCode}")
    @Operation(summary = "查询数据字典下拉框")
    public Result getDropDownList(
            @PathVariable(value = "dictCode") String dictCode) {
        return Result.success(dictionaryService.getDropDownList(dictCode));
    }
}