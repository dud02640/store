package com.codefarm.kim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.junit.runner.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codefarm.service.SampleService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Resource(name="sampleService")
    private SampleService sampleService;
	
	@RequestMapping(value = "/home.do")
	public String home(HttpServletRequest req,Model model) {
		HttpSession session =req.getSession();
		session.invalidate();     
		return "/home";
	}
     
	@RequestMapping(value = "/booklist.do")
	public String booklist(HttpServletRequest req,Map<String,Object> paraMap,Model model)throws Exception {
		HttpSession session =req.getSession();
/*		ModelAndView mv1=new ModelAndView("/home");*/
/*		if(session == null){
			return main.do
		}*/

		String id,pw;
		
		if(session.getAttribute("id")==null||session.getAttribute("pw")==null)
		{
			id = req.getParameter("id");
			pw = req.getParameter("pw");
			if(req.getParameter("id").equals("admin")&&req.getParameter("pw").equals("1234")){
				return "/admin";
			}
		}
		else{
			id = (String) session.getAttribute("id");
			pw = (String) session.getAttribute("pw");
		}
		System.out.print(id);
		System.out.print(pw);
	
		String searching = req.getParameter("searching");
		String search = req.getParameter("search");
		
		paraMap.put("search",search);
		paraMap.put("searching",searching);
		paraMap.put("id",id);
		paraMap.put("pw",pw);
		
		List<Map<String,Object>> list = sampleService.selectBoardList(paraMap);
		List<Map<String,Object>> loginlist = sampleService.selectlogincheck(paraMap);
		if(loginlist.isEmpty()||loginlist==null){
			String message="아이디랑 비밀번호를 확인해주세요";
			req.setAttribute("mes",message);
			return "/home";
		}
		session.setAttribute("id",id);
		session.setAttribute("pw",pw);
		
		model.addAttribute("paraMap",paraMap);
		model.addAttribute("list", list);
		model.addAttribute("loginlist", loginlist);
		return "/booklist";
	}
/*	@RequestMapping(value = "/signup1.do", method = RequestMethod.GET)
	public ModelAndView signup1(Map<String,Object> commandMap)throws Exception {
		ModelAndView mv=new ModelAndView("/signup");
		
		sampleService.insertBoard(commandMap);

		return mv;
	}*/
	@RequestMapping(value = "/signup.do")
	public String signup1(HttpServletRequest req,Model model)throws Exception {
/*		model.addAttribute("id", req.getParameter("id"));
		model.addAttribute("pw", req.getParameter("pw"));
		model.addAttribute("phone", req.getParameter("phone"));
		model.addAttribute("address", req.getParameter("address"));
		sampleService.insertBoard(model);*/
		return "/signup";
	}
	@RequestMapping(value = "/insert.do")
	public String insertdo(HttpServletRequest req,Map<String,Object> paraMap,Model model)throws Exception {
		paraMap.put("id",req.getParameter("id"));
		paraMap.put("pw",req.getParameter("pw"));
		paraMap.put("phone",req.getParameter("phone"));
		paraMap.put("name",req.getParameter("name"));
		paraMap.put("address",req.getParameter("address"));
		paraMap.put("point",req.getParameter("point"));
		try{
			sampleService.insertBoardList(paraMap);
		}catch(Exception e){
			System.out.print(e.getMessage());
			JOptionPane.showMessageDialog(null, "중복된 아이디 입니다. 아이디를 바꿔서 입력해주세요.!", "회원가입 에러", JOptionPane.ERROR_MESSAGE);
			return "/signup";
		}
		return "/home";
	}
	@RequestMapping(value = "/insertproduct.do")
	public String insertproductdo(HttpServletRequest req,Map<String,Object> paraMap,Model model)throws Exception {	
		paraMap.put("productname",req.getParameter("productname"));
		paraMap.put("price",req.getParameter("price"));
		paraMap.put("autor",req.getParameter("autor"));
		paraMap.put("publisher",req.getParameter("publisher"));
		paraMap.put("basketYN","N");
		sampleService.insertProductList(paraMap);

/*		return "redirect:/admin.do";*/
		return "/admin";
	}
/*	@RequestMapping(value = "/logincheck.do")
	public ModelAndView logincheck(HttpServletRequest req,Map<String,Object> paraMap)throws Exception {
		ModelAndView mv=new ModelAndView("forward:/booklist.do");

		HttpSession session= req.getSession();
		session.getAttribute("id");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		paraMap.put("id",id);
		paraMap.put("pw",pw);
		
		List<Map<String,Object>> list = sampleService.selectlogincheck(paraMap);
		if(list.isEmpty()){
			mv.setViewName("/home");
		}
		mv.addAllObjects(paraMap);
		return mv;		
	}*/

	@RequestMapping(value = "/basket.do")
	public String basket(HttpServletRequest req,Map<String,Object> paraMap,Model model)throws Exception {
		String productid =req.getParameter("productid");
		HttpSession session= req.getSession();
		
		/*System.out.print(session.getAttribute("id"));*/
		paraMap.put("id",session.getAttribute("id"));
		paraMap.put("productid",productid);
		paraMap.put("purchaseYN","N");
		paraMap.put("date","date");
		paraMap.put("basketYN","Y");
		sampleService.insertbasketlist(paraMap);
		sampleService.updatebasketlist(paraMap);
		return "forward:/booklist.do";		
	}
	@RequestMapping(value = "/room.do")
	public String room(HttpServletRequest req,Map<String,Object> paraMap,Model model)throws Exception {
		HttpSession session= req.getSession();

		paraMap.put("id",session.getAttribute("id"));
		paraMap.put("pw",session.getAttribute("pw"));
		
		List<Map<String,Object>> loginlist = sampleService.selectlogincheck(paraMap);
		List<Map<String,Object>> purchaselist = sampleService.selectpurchaselist(paraMap);

		model.addAttribute("loginlist", loginlist);
		model.addAttribute("purchaselist", purchaselist);
		model.addAttribute(paraMap);
		
		return "/room";		
	}
	@RequestMapping(value = "/updatepoint.do")
	public String updatepoint(HttpServletRequest req,Map<String,Object> paraMap,Model model)throws Exception {
		int price = Integer.parseInt(req.getParameter("price"));
		int point = Integer.parseInt(req.getParameter("point"));
		int uppoint= point-price;
		HttpSession session= req.getSession();
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		
		paraMap.put("id",id);
		paraMap.put("pw",pw);
		
		String productid =req.getParameter("productid");
		
		paraMap.put("uppoint", uppoint);
		paraMap.put("productid", productid);
		paraMap.put("purchaseYN", "Y");

		session.setAttribute("id",id);
		session.setAttribute("pw",pw);
		sampleService.updatepoint(paraMap);
		sampleService.updatepurchaseYN(paraMap);
		model.addAttribute(paraMap);
		
		return "forward:/room.do";		
	}
	@RequestMapping(value = "/admin.do")
	public String admin(HttpServletRequest req,Map<String,Object> paraMap,Model model)throws Exception {
		
		return "/admin";		
	}
	@RequestMapping(value = "/deletebasket.do")
	public String deletebasket(HttpServletRequest req,Map<String,Object> paraMap,Model model)throws Exception {
		String productid =req.getParameter("productid");
		String point = req.getParameter("point");
		HttpSession session= req.getSession();
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		System.out.print(id);
		paraMap.put("id",id);
		paraMap.put("pw",pw);
		paraMap.put("productid", productid);
		
		sampleService.deletebasket(paraMap);
		return "forward:/room.do";		
	}
}