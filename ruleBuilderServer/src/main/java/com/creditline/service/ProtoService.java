package com.creditline.service;

import java.util.List;

import com.creditline.domain.ProtoModel;

public interface ProtoService {
	
	public void addEmployee(ProtoModel vo) throws Exception;
	
	public List<ProtoModel> listEmployee() throws Exception;
	
	public void modifyEmployee(ProtoModel vo) throws Exception;
	
	public void removeEmployee(Integer eno) throws Exception;
	
}
