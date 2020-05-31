package com.creditline.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.creditline.domain.ruleFileModel;
import com.creditline.persistence.RuleDAO;

@Service
public class RuleServiceImpl implements RuleService{
	@Inject
	private RuleDAO dao;

	@Override
	public void addRule(ruleFileModel vo) throws Exception {
		// TODO Auto-generated method stub
		dao.create(vo);
	}
	
	@Override
	public List<ruleFileModel> listRule() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
		
	}
	
	@Override
	public void modifyRule(ruleFileModel vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}
	
	@Override
	public void removeRule(Integer eno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(eno);
	}
	
	@Override
	public boolean isExistRule(Integer eno) throws Exception {
		// TODO Auto-generated method stub
		return dao.existRule(eno) == 0 ? false : true;
	}
}
