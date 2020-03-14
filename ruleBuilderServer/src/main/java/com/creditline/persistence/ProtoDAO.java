package com.creditline.persistence;

import java.util.List;

import com.creditline.domain.protoModel;

public interface ProtoDAO {
	public List<protoModel> list ( ) throws Exception;
	
	public void create(protoModel vo) throws Exception;
	
	public void update(protoModel vo) throws Exception;
	
	public void delete(Integer eno) throws Exception;
}
