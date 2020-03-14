package com.creditline.ruleBuilder;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.creditline.domain.protoModel;
import com.creditline.service.ProtoService;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/protoType")
public class protoController {
	
	@Inject
	private ProtoService service;
	
	private static final Logger logger = LoggerFactory.getLogger(protoController.class);
	
	protected Map<String, String> reqData;
	
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<protoModel>> list()  {
//		this.reqData = new HashMap<>();
//		this.reqData.put("EMPLOYEENO", "1");
		
		ResponseEntity<List<protoModel>> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.listEmployee(), HttpStatus.OK);
			
		} catch (Exception e ) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
