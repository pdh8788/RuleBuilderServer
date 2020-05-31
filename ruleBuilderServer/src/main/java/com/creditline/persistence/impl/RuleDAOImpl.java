package com.creditline.persistence.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.creditline.domain.ruleFileModel;
import com.creditline.persistence.RuleDAO;

@Repository
public class RuleDAOImpl implements RuleDAO{
	
	@Inject
	private SqlSession session;
	
//	List<protoModel> list = sqlSession.selectList("proto.selectEmployee");
	private static String namespace = "proto";
	
	@Override
	public List<ruleFileModel> list() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".list");
	}
	
	@Override
	public void create(ruleFileModel vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", vo);
	}
	
	@Override
	public void update(ruleFileModel vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".update", vo);
	}
	
	@Override
	public void delete(Integer eno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete", eno);
	}
	
	@Override
	public Integer existRule(Integer eno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".isExistRule", eno);
	}
}
