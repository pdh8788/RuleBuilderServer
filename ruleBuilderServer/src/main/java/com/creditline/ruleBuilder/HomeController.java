package com.creditline.ruleBuilder;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	SqlSession sqlSession;
	
	protected Map<String, String> reqData;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
    	List<RuleFileModel> list = sqlSession.selectList("rules.ruleInfo", this.reqData);
    	
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView list() throws Exception {
		this.reqData = new HashMap<>();
		this.reqData.put("key", "1");
		
		List<RuleFileModel> list = sqlSession.selectList("rules.ruleInfo", this.reqData);
		// ModelAndView - 모델과 뷰
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value = "/rule", method = RequestMethod.POST)
	public ModelAndView test(HttpServletRequest httpServletRequest )
	{
		System.out.println("RequestMethod.POST");
		
		String id = httpServletRequest.getParameter("id");
		Map<String, Object> result = sqlSession.selectOne("rules.ruleInfo", this.reqData);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("studentId", id);
		return mav;
	}
}
