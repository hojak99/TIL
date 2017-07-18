package hojak99.common.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * HandlerInterceptorAdapter 클래스를 상속받아서 만든 인터셉터 클래스이다.
 * preHandle() 메소드와 postHandle() 메소드는 각각 전처리기와 후처리기 메소드이다.
 * 여기서 인터셉터는 DispatcherServlet 이 컨트롤러를 호출하기 전, 후에 요청과 응답을 가로채서 가공할 수 있도록 해준다.
 * */
public class LoggerInterceptor extends HandlerInterceptorAdapter{
	
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(log.isDebugEnabled()){
			log.debug("================================    START \n");
			log.debug("Request URI \t :    " + request.getRequestURI());
		}
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		if(log.isDebugEnabled()){
			log.debug("================================    END \n");
		}
	}
}
