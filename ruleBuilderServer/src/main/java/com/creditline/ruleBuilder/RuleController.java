package com.creditline.ruleBuilder;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.creditline.domain.ruleFileModel;
import com.creditline.service.RuleService;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/rule")
public class RuleController {
	
	@Inject
	private RuleService service;
	
	private static final Logger logger = LoggerFactory.getLogger(RuleController.class);
	
	protected Map<String, String> reqData;
	
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<ruleFileModel>> list()  {
		
		ResponseEntity<List<ruleFileModel>> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.listRule(), HttpStatus.OK);
			
		} catch (Exception e ) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> update( @RequestBody JSONObject vo)  {
		
		ResponseEntity<String> entity = null;
		
		try {
			
//			if( service.isExistRule(vo.getRuleId()) ) {
//				// rule이 존재 update
//			} else {
//			   // rule이 미존재 insert
//				
//			}
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e ) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
