package sr.demo.spring.gateway.app.filter;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class SessionSavingZuulPrefilter extends ZuulFilter {
	
	private static final Logger log = LoggerFactory.getLogger(SessionSavingZuulPrefilter.class);
	
	@Autowired
	SessionRepository<?> sessionRepository;

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context= RequestContext.getCurrentContext();
		HttpSession httpSession = context.getRequest().getSession();
		Session  session = sessionRepository.findById(httpSession.getId());
		context.addZuulRequestHeader("Cookie", "SESSION="+httpSession.getId());
		 log.info("ZuulPreFilter session proxy: {}", session.getId());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
