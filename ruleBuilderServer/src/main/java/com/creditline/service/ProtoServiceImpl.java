package com.creditline.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.creditline.domain.ProtoModel;
import com.creditline.persistence.ProtoDAO;

@Service
public class ProtoServiceImpl implements ProtoService{
	@Inject
	private ProtoDAO dao;

	@Override
	public void addEmployee(ProtoModel vo) throws Exception {
		// TODO Auto-generated method stub
		dao.create(vo);
	}
	
	@Override
	public List<ProtoModel> listEmployee() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
		
	}
	
	@Override
	public void modifyEmployee(ProtoModel vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}
	
	@Override
	public void removeEmployee(Integer eno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(eno);
	}
}
