package com.huazhu.application.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/springMVC")
public class SpringMVC {
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("title", "test spting boot mvc");
		return "test/index";
	}
	
	@RequestMapping("/getObjectMessage")
	@ResponseBody
	public Map<String,Object> getObjectMessage(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "成功");
		return map;
	}
	
	@RequestMapping("jsp")
	public String jsp(Model model) {
		model.addAttribute("title", "test spting boot mvc");
		return "index";
	}
	
	@RequestMapping("redirectjsp")
	public ModelAndView redirectjsp(ModelAndView mv) {
		mv = new ModelAndView("redirect:test/index.html");
		return mv;
	}

}
