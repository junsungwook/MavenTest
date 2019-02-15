package com.mymaven.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mymaven.mybatis.mapper.MemberService;
import com.mymaven.mybatis.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//Autowired�� ���� �����ε� �̸����� ã�� �� �ְ� �Ѵ�
	@Resource(name="mService")
	private MemberService mService;
	
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
	
	
	//insert-form
	@RequestMapping("insert")
	public String insert() {
		return "memberInsert";
	}
	
	//insert
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String insert(MemberVO user) {
		mService.insert(user);
		return "memberInsert";
	}
	
	//list
	/*
	 * @RequestMapping("list") public String list(Model model) { 
	 * List<MemberVO> list = mService.list(); 
	 * //��Ʈ����Ʈ ��Ű�� 
	 * model.addAttribute("list",list); 
	 * return "list"; }
	 */
	
	
	
	@RequestMapping("list")
	   public String list(HttpServletRequest req) {
	      List<MemberVO> arr =mService.list();
	      int count = arr.size();
	      String pageNum = req.getParameter("pageNum")==null?"1":req.getParameter("pageNum");
	      int currentPage = Integer.parseInt(pageNum);
	      int pageSize = 5;
	      int startRow = (currentPage-1)*pageSize+1; //2page -> 6����ۺ���
	      int endRow = currentPage*pageSize;
	      
	      String word="";
		  String field="";
		  if(req.getParameter("word")!=null){
			word=req.getParameter("word");
			field=req.getParameter("field");
		  }

	      List<MemberVO> parr = mService.memberList(startRow,endRow,field,word);
	      
	      
	      //����������
	      int totpage = count/pageSize+(count%pageSize==0?0:1);
	      int blockpage =3; 
	      int startpage=((currentPage-1)/blockpage)*blockpage+1;
	      int endpage=startpage+blockpage-1;
	      
	      if(endpage > totpage) endpage=totpage;
	      
	      req.setAttribute("totpage", totpage);
	      req.setAttribute("startpage", startpage);
	      req.setAttribute("endpage", endpage);
	      req.setAttribute("currentPage", currentPage);
	      req.setAttribute("blockpage", blockpage);
	      
	      int number=count-(currentPage-1)*pageSize;
	      req.setAttribute("number",number);
	      req.setAttribute("arr", parr);
	      return "list";
	   }
	

	
	/*
	 * @RequestMapping("list") 
	 * public void list(Model model) { 
	 * List<MemberVO> list = mService.list();
	 * model.addAttribute("list",list); 
	 * 
	 * �̷��� �ϸ� ���� ���� ���� �� �ڵ����� list��� �̸��� jsp�� �����Ѵ�
	 * �� ���� ���� �̸��� jsp ������ �̸��� ���� �� ���� ���� �����
	 * }
	 */
	
	//detail ���� ������ �����ؼ� �ẽ �Ϻη�
	@RequestMapping("detail")
	public void detail(String id, Model model) {
		MemberVO user = mService.detail(id);
		model.addAttribute("user",user);
	}
	
	//detail ���� ������ �����ؼ� �ẽ �Ϻη�
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(MemberVO user) {
		 mService.update(user);
		 return "redirect:list";
	}
	
	@RequestMapping("delete")
	public String delete(String id) {
		mService.delete(id);
		return "redirect:list";
	}
	/*
	 * �˻����
	 * @RequestMapping("search") public String search(String field, String
	 * word,Model model) { List<MemberVO> list = mService.select(field,word);
	 * model.addAttribute("list",list); return "list"; }
	 */
	
	
	/*
	  return "redirect:list" �� list��� ���ε� �̸��� ȣ���ϴ� ��
	  return "list" �� list.jsp�� ����� ��
	*/
	
}
