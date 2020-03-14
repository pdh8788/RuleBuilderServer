package com.creditline.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.creditline.domain.protoModel;

@Repository
public class ProtoDAOImpl implements ProtoDAO{
	
	@Inject
	private SqlSession session;
	
//	List<protoModel> list = sqlSession.selectList("proto.selectEmployee");
	private static String namespace = "proto";
	
	@Override
	public List<protoModel> list() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".list");
	}
	
	@Override
	public void create(protoModel vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", vo);
	}
	
	@Override
	public void update(protoModel vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".update", vo);
	}
	
	@Override
	public void delete(Integer eno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete", eno);
	}
}
