package com.kjh.hojak.RestfulAPI_Server;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kjh.hojak.RestfulAPI_Server.config.DatabaseConfig;
import com.kjh.hojak.RestfulAPI_Server.mapper.BoardMapper;
import com.kjh.hojak.RestfulAPI_Server.vo.BoardVO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = DatabaseConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles("local")
public class RestfulApiServerApplicationTests {
	
	@Autowired(required = true)
	public BoardMapper mapper;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testMapper() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("ㅎㅇ");
		vo.setContent("ㅇㅉ");
		vo.setWriter("장");
		vo.setPassword("1234");
	}

}
