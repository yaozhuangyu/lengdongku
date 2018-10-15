package com.jkoss.biz;

import java.util.List;
import java.util.Map;

import com.jkoss.bo.DTreePriNode;
import com.jkoss.pojo.Acclf;
import com.jkoss.pojo.AreaInfo;
import com.jkoss.pojo.CabinatSetting;
import com.jkoss.pojo.CoolRegister;
import com.jkoss.pojo.Customer;
import com.jkoss.pojo.LocationSetting;
import com.jkoss.pojo.PriceSetting;
import com.jkoss.pojo.RepayRegister;
import com.jkoss.pojo.SysRight;
import com.jkoss.pojo.SysRole;
import com.jkoss.pojo.SysUser;

public interface LengKuBiz {
	
	//权限管理相关============
	List<SysRole> lsAllRole();
	List<SysRight> lsAllRight();
	String updateRights(int roleid,int[] right_id);
	
	//========================

	SysUser login(String name);

	List<CabinatSetting> lscab();
	
	Map<Integer,DTreePriNode> genPriTree(SysUser user);

	List<CabinatSetting> lsCabById(int loc_id);

	String addcab(CabinatSetting cab);

	String delcab(String cab_id);

	CabinatSetting onecab(String cab_id);

	String updtcab(CabinatSetting cab);

	List<AreaInfo> lsarea();

	List<LocationSetting> lsloc(int area_id);
	
	List<CoolRegister> lsCool();
	
	List<LocationSetting> lsloc1();
	
	String clear(int loc_id) ;
	
	String updLoc(int[] cab_id,int loc_id) ;
	
	
	String addCool(CoolRegister cr);
	
	String delcool(Integer cool_id);
	
	CoolRegister onecool(Integer cool_id);
	
	String updtcool(CoolRegister cr);
	
	List<CoolRegister> queryLikeCool(String nameorid);
	
	//======用户管理=========//
	List<SysUser> listUsers();
	
	String addUser(SysUser user);
	String delUser(int userid);
	SysUser findOneUser(int userid);
	String updateUser(SysUser user);
	
	List<RepayRegister> findAll();
	Customer findCustomerName(Integer CUSTOMERID);
	String addrepay(RepayRegister repr);
	String delrepay(Integer ID);
	RepayRegister onerepay(Integer reid);
	String updrepay(RepayRegister ID);
	List<RepayRegister> serepay(Integer CUSTOMERID);
	
	//价格设置表
	List<PriceSetting> lsPs();
	List<Acclf> selectLikeByName(String cusname);
	
	//找回密码
	String yzm(String phone);
	String updPass(String phone,String password);

}
