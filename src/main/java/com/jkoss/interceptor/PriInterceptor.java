package com.jkoss.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jkoss.pojo.SysUser;

public class PriInterceptor implements HandlerInterceptor {
	
	private List<String> passed = new ArrayList<String>();

	public List<String> getPassed() {
		return passed;
	}

	public void setPassed(List<String> passed) {
		this.passed = passed;
	}

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		

	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object ob) throws Exception {
		
		String uri = req.getRequestURI();
		for (String psUri : passed) {
			if(uri.indexOf(psUri)>0) {
				return true;
			}
		}
		
		SysUser user = (SysUser) req.getSession().getAttribute("user");
		if(user!=null) {
			//放行
			return true;
		}
		req.getRequestDispatcher("/noright.jsp").forward(req, res);
		return false;
	}

}
