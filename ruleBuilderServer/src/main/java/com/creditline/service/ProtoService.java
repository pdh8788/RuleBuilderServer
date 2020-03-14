package com.creditline.service;

import java.util.List;

import com.creditline.domain.protoModel;

public interface ProtoService {
	
	public void addEmployee(protoModel vo) throws Exception;
	
	public List<protoModel> listEmployee() throws Exception;
	
	public void modifyEmployee(protoModel vo) throws Exception;
	
	public void removeEmployee(Integer eno) throws Exception;
	
}
