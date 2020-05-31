package com.creditline.service;

import java.util.List;

import com.creditline.domain.ruleFileModel;

public interface RuleService {
	
	public void addRule(ruleFileModel vo) throws Exception;
	
	public List<ruleFileModel> listRule() throws Exception;
	
	public void modifyRule(ruleFileModel vo) throws Exception;
	
	public void removeRule(Integer eno) throws Exception;
	
	public boolean isExistRule(Integer eno) throws Exception;
}
