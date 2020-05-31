package com.creditline.ruleBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisTest 
{
	@Autowired
	SqlSession sqlSession;
	
    @Inject
    private SqlSessionFactory sqlFactory;
    
    protected Map<String, String> reqData ;
    
    @Test
    public void testFactory(){
    	this.reqData = new HashMap<String, String>();
    	reqData.put("key", "1");
    	List<RuleFileModel> list = sqlSession.selectList("rules.ruleInfo", this.reqData);
    	
    	System.out.println(list.get(0).getResult());
    	
    }
    
//    @Test
    public void testSession() throws Exception{
        
        try(SqlSession session = sqlFactory.openSession()){
            
            System.out.println(" >>>>>>>>>> session 출력 : "+session+"\n");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
