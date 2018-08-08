package com.huazhu.application.cms.dictionary.service;

import java.util.List;

import com.huazhu.application.cms.dictionary.entity.Dictionary;

public interface DictionaryService {
	
	List<Dictionary> queryDictionary(Dictionary dictionary);
	
	Integer updateDictionarycmsToken(String value);

}
