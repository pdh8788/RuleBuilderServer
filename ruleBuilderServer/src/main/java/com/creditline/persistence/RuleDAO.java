package com.creditline.persistence;

import java.util.List;

import com.creditline.domain.ruleFileModel;

public interface RuleDAO {
	public List<ruleFileModel> list ( ) throws Exception;
	
	public void create(ruleFileModel vo) throws Exception;
	
	public void update(ruleFileModel vo) throws Exception;
	
	public void delete(Integer eno) throws Exception;
	
	public Integer existRule(Integer eno) throws Exception;
	
}
