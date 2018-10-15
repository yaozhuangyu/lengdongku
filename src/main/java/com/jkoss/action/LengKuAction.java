package com.jkoss.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jkoss.biz.LengKuBiz;
import com.jkoss.bo.DTreePriNode;
import com.jkoss.pojo.CabinatSetting;
import com.jkoss.pojo.CoolRegister;
import com.jkoss.pojo.LocationSetting;
import com.jkoss.pojo.PriceSetting;
import com.jkoss.pojo.RepayRegister;
import com.jkoss.pojo.SysUser;

@Controller
@RequestMapping("/lk")
public class LengKuAction {
	
	@Autowired
	private LengKuBiz lkBiz;
	
	//登录
	@RequestMapping("/login")
	public String login(HttpServletRequest req,String name,String password) {
		
		SysUser user = lkBiz.login(name);
		if(user!=null) {
			if(user.getNAME().equals(name) && user.getPASSWORD().equals(password)) {
				
				req.getSession().setAttribute("user", user);
				return "/main.jsp";
			}
		}
		req.setAttribute("msg", "登录失败");
		return "/index.jsp";
	}
	
	//发送验证码给该手机号
		@RequestMapping("/yzm")
		@ResponseBody
		public String yzm(String ephone) {
			//如果该手机号有对应的用户则发送短信且将验证码返回到前端，否则返回错误信息
			return lkBiz.yzm(ephone);
		}
		//修改密码
		@RequestMapping("/updPass")
		@ResponseBody
		public String updPass(String phone,String password) {
			return lkBiz.updPass(phone, password);
		}
	
		//============生成权限树================//
	@RequestMapping("/genTree")
	@ResponseBody
	public Map<Integer,DTreePriNode> logined(HttpServletRequest req) {
		
		SysUser user = (SysUser)req.getSession().getAttribute("user");
		if(user==null) {
			return null;
		}
		return lkBiz.genPriTree(user);
	}
	
	//============权限管理================//
	@RequestMapping("/lsRole")
	public String lsAllRole(HttpServletRequest req) {
		//全部权限
		
		req.setAttribute("allRt", lkBiz.lsAllRight());
		req.setAttribute("role", lkBiz.lsAllRole());
		return "/lk/listRoles.jsp";
	}
	
	
	
	@RequestMapping("/updRights")
	public String updtRight(HttpServletRequest req,int roleid,int[] right_id) {

		req.setAttribute("msg", lkBiz.updateRights(roleid, right_id));
		
		
		
		return lsAllRole(req);
	}
	
	
	//注销
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "/index.jsp";
	}
	
	
	//区域、卡位、仓库
	@RequestMapping("/lscab")
	public String lscab(HttpServletRequest req,Integer loc_id) {
		
		
		if(req.getServletContext().getAttribute("allArea") == null) {
			req.getServletContext().setAttribute("allArea", lkBiz.lsarea());
		}
		if(loc_id ==null) {
			if(req.getSession().getAttribute("loc_id") != null ) {
				loc_id=(Integer) req.getSession().getAttribute("loc_id");
				req.setAttribute("allcab",lkBiz.lsCabById(loc_id));
				
			}else {
				req.setAttribute("allcab", lkBiz.lscab());
			}
			
		}
		else if(loc_id == 0) {
			req.setAttribute("allcab", lkBiz.lscab());
		}else {
			req.getSession().setAttribute("loc_id", loc_id);
			req.setAttribute("allcab",lkBiz.lsCabById(loc_id));
			
		}
		
		return "/lk/listCabinat.jsp";
	}
	
	@RequestMapping("/addcab")
	public String addcab(CabinatSetting cab,HttpServletRequest req) {
		req.setAttribute("msg", lkBiz.addcab(cab));
		return lscab(req,null);
	}
	
	@RequestMapping("/delcab")
	@ResponseBody
	public String delcab(String cab_id) {
		return lkBiz.delcab(cab_id);
	}
	
	@RequestMapping("/onecab")
	@ResponseBody
	public CabinatSetting onecab(String cab_id) {
		return lkBiz.onecab(cab_id);
	}
	
	@RequestMapping("/updtcab")
	public String updtcab(CabinatSetting cab,HttpServletRequest req) {
		req.setAttribute("msg", lkBiz.updtcab(cab));
		return lscab(req,null);
	}
	
	@RequestMapping("/lsLocByID")
	@ResponseBody
	public List<LocationSetting> lsLocByID(HttpServletRequest req,int area_id){
		return lkBiz.lsloc(area_id);
	}
	
	//卡位列表
	@RequestMapping("/lsLoc")
	public String lsLoc(HttpServletRequest req){
		req.setAttribute("listloc",lkBiz.lsloc1());
		return "/lk/listLocation.jsp";
	}
	@RequestMapping("/updLoc")
	public String updLoc(HttpServletRequest req,int[] cab_id,int loc_id) {
		if(cab_id==null) {
			req.setAttribute("msg", lkBiz.clear(loc_id));
		}else {
			req.setAttribute("msg", lkBiz.updLoc(cab_id, loc_id));
		}
		return lsLoc(req);
	}
	
	
	//===========用户管理===========//
	
//	用户列表
	@RequestMapping("/lsUser")
	public String listUser(HttpServletRequest req) {
		req.setAttribute("uers", lkBiz.listUsers());
		return "listUser.jsp";
	}
	
	//添加
	@RequestMapping("/addUser") 
	  public String addParking(HttpServletRequest req,SysUser user) {
		  req.setAttribute("users", lkBiz.addUser(user));
		  return    listUser(req);
	  }
	
	  @RequestMapping("/delUser") 
	  @ResponseBody
	  public String delParking(HttpServletRequest req,int userid) {
		  return    lkBiz.delUser(userid) ;
	  }
	  
	  //查询一个
	  @RequestMapping("/oneUser") 
	  @ResponseBody
	  public SysUser findOneUser(HttpServletRequest req,int userid) {
		  return lkBiz.findOneUser(userid);
	  }
	  
    @RequestMapping("/updtUser") 
	  public String updateUser(HttpServletRequest req,SysUser user) {
		  req.setAttribute("msg", lkBiz.updateUser(user));
	      return  listUser(req);
	  }
    
    
 // 补时列表
 	@RequestMapping("/lsrepay")
 	public String listrepay(HttpServletRequest req) {
 		req.getSession().setAttribute("akk", lkBiz.findAll());
 		return "/lk/lsRepay.jsp";
 	}
 	@RequestMapping("/addrepay")
 	public String addarrange(HttpServletRequest req, RepayRegister repr) {
 	    req.setAttribute("msg", lkBiz.addrepay(repr));
 		return listrepay(req);
 	}
 	@RequestMapping("/delrepay")
 	@ResponseBody
 	public String delrepay( HttpServletRequest req,Integer ID) {
 		
 		return lkBiz.delrepay(ID);
 	}
 	@RequestMapping("/onerepay")
 	@ResponseBody
 	public RepayRegister onerepay( HttpServletRequest req,Integer reid) {
 		
 		return lkBiz.onerepay(reid);
 	}
 	@RequestMapping("/updrepay")
 	public String updaterepay( HttpServletRequest req,RepayRegister ID) {
 		   req.setAttribute("msg",lkBiz.updrepay(ID));
 		return listrepay(req);
 	}
 	@RequestMapping("/serrepay")
 	public String searchrepay( HttpServletRequest req,Integer CUSTOMERID) {
 		if(CUSTOMERID!=null) {
 			req.getSession().setAttribute("akk",lkBiz.serepay(CUSTOMERID) );
 			return "/lk/lsRepay.jsp";
 		}
 		return listrepay(req);
 	}
	
	
	//打冷登记表
	@RequestMapping("/lsCool")
	public String listCoolRegister(HttpServletRequest req) {
		req.getSession().setAttribute("lsCr", lkBiz.lsCool());
		return "listCoolRegister.jsp";
	}
	
	@RequestMapping("/addCool")
	public String addCoolRegister(HttpServletRequest req,CoolRegister cr) {
		req.getSession().setAttribute("addCr", lkBiz.addCool(cr));
		return "redirect:lsCool.do";
	}
	
	@RequestMapping("/delCool")
	@ResponseBody
	public String delcab(Integer cool_id) {
		return lkBiz.delcool(cool_id);
	}
	
	@RequestMapping("/oneCool")
	@ResponseBody
	public CoolRegister onecool(Integer cool_id) {
		return lkBiz.onecool(cool_id);
	}

	@RequestMapping("/updtCool")
	public String updtcool(CoolRegister cr,HttpServletRequest req) {
		req.setAttribute("msg", lkBiz.updtcool(cr));
		return "redirect:lsCool.do";
	}
	
	@RequestMapping("/likeCool")
	public String queryLikeCool(HttpServletRequest req,String nameorid) {
		List<CoolRegister> list = lkBiz.queryLikeCool(nameorid);
		if(list.isEmpty()) {
			req.getSession().setAttribute("lsCr",list);
			req.setAttribute("msg","抱歉，没有查到您想要的数据!");
			return "listCoolRegister.jsp";
		}else {
			req.getSession().setAttribute("lsCr",list);
			return "listCoolRegister.jsp";
		}
		
	}
	
	//价格设置表
	@RequestMapping("/lsPs")
	public String listPriceSetting(HttpServletRequest req) {
		List<PriceSetting> lsps = lkBiz.lsPs();
		req.getSession().setAttribute("lsps", lsps);
		return "listPriceSetting.jsp";
	}
	
	/*@RequestMapping("/likeCusName")
	public String selectLikeByCusName(HttpServletRequest req,String cusname) {
		List<Acclf> list = lkBiz.selectLikeByName(cusname);
		if(list.isEmpty()) {
			req.getSession().setAttribute("lsps",list);
			req.setAttribute("msg","抱歉，没有查到您想要的数据!");
			return "listPriceSetting.jsp";
		}else {
			req.getSession().setAttribute("lsps",list);
			return "listPriceSetting.jsp";
		}
		
	}*/
	
	

}
