package com.creditline.persistence;

import java.util.List;

import com.creditline.domain.ProtoModel;

public interface ProtoDAO {
	public List<ProtoModel> list ( ) throws Exception;
	
	public void create(ProtoModel vo) throws Exception;
	
	public void update(ProtoModel vo) throws Exception;
	
	public void delete(Integer eno) throws Exception;
}
