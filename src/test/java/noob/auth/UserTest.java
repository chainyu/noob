package noob.auth;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chainyu.noob.model.auth.domain.User;
import com.chainyu.noob.service.auth.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:spring-context.xml",  
        "classpath:spring-dao.xml" })
public class UserTest {

	private static final Logger LOGGER = Logger  
            .getLogger(UserTest.class);  
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testInsert(){
		LOGGER.debug("test insert user......");
		User user=new User();
		Date date=new Date();
		user.setUserName("zhangsan");
		user.setPassword("123456");
		user.setStatus((byte)1);
		user.setCreateTime(date);
		int i = userService.save(user);
		LOGGER.debug("test insert user......result[{"+i+"}]");
	}
}
