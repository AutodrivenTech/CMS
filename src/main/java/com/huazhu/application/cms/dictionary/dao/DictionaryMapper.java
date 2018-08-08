package com.huazhu.application.cms.dictionary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.huazhu.application.cms.dictionary.entity.Dictionary;

@Mapper
public interface DictionaryMapper {
	
	List<Dictionary> queryDictionary(Dictionary dictionary);
	
	Integer updateDictionarycmsToken(String value);

}
