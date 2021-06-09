package com.mylab.crawling;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mylab.crawling.vo.ResponseVO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * Jsoup ajax
	 * @param reqUrl
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getNews", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseVO getNews(@RequestParam(value="reqUrl") String reqUrl) throws IOException {
		
		String URL = reqUrl;
		Document doc = Jsoup.connect(URL).get();
		
		Elements elem = doc.select("div ul li");
		
		for (Element e : elem){
			System.out.println(e);
		}
		ResponseVO resVo = new ResponseVO().ok();
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("elem", elem.toString());
		resVo.setData(resMap);
		
		return resVo;
	}
	
}
