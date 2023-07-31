package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceView;

public class Example1Controller2 implements Controller {

	
	public Example1Controller2() {
		System.out.println("Example1Controller2() ctor...");
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		System.out.println("handleRequest() invoked...");
		
		View view = new InternalResourceView("example2.jsp");
		ModelAndView mav = new ModelAndView(view);
		mav.addObject("msj", "Welcome to Spring MVC why u came back ");
		return mav;
	}
}
