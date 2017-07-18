package hojak99.sample.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// @Controller 어노테이션은 스프링 프레임워크가 현재 클래스가 컨트롤러 라는 것을 명시해준다.
@Controller
public class SampleController {
	Logger log = Logger.getLogger(this.getClass());
	
	// @RequestMapping 어노테이션으로 DispatcherServlet 이 이 어노테이션은 기준으로 어떤
	// 컨트롤러의 메소드를 호출되어야 할지를 결정한다.
	@RequestMapping(value="/sample/openSampleList.do")
	public ModelAndView openSampleList(Map<String, Object> commandMap) throws Exception {
		
		// new ModelAndView("") 에서 생성자 부분은 이 컨트롤러가 실행되고 나서 보여줄 view 를 설정할 수 있음
		ModelAndView modelAndView = new ModelAndView("");
		log.debug("인터셉트 테스트");
		
		return modelAndView;
	}
}
