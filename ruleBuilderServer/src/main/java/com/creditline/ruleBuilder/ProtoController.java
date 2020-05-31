package com.creditline.ruleBuilder;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.creditline.domain.ProtoModel;
import com.creditline.service.ProtoService;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/protoType")
public class ProtoController {
	
	@Inject
	private ProtoService service;
	
	private static final Logger logger = LoggerFactory.getLogger(ProtoController.class);
	
	protected Map<String, String> reqData;
	
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<ProtoModel>> list()  {
		
		ResponseEntity<List<ProtoModel>> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.listEmployee(), HttpStatus.OK);
			
		} catch (Exception e ) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> update( @RequestBody ProtoModel vo)  {
		
		ResponseEntity<String> entity = null;
		
		try {
			service.modifyEmployee(vo);
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e ) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
