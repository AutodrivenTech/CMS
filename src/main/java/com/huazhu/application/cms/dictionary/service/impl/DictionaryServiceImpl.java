package com.huazhu.application.cms.dictionary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.application.cms.dictionary.dao.DictionaryMapper;
import com.huazhu.application.cms.dictionary.entity.Dictionary;
import com.huazhu.application.cms.dictionary.service.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService {
	@Autowired
    private DictionaryMapper dictionaryMapper;
    
	@Override
	public List<Dictionary> queryDictionary(Dictionary dictionary) {
		// TODO Auto-generated method stub
		return dictionaryMapper.queryDictionary(dictionary);
	}

	@Override
	public Integer updateDictionarycmsToken(String value) {
		// TODO Auto-generated method stub
		return dictionaryMapper.updateDictionarycmsToken(value);
	}

}
