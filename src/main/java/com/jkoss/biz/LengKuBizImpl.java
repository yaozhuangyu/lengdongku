package com.jkoss.biz;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.aliyuncs.exceptions.ClientException;
import com.jkoss.bo.DTreePriNode;
import com.jkoss.dao.AreaInfoMapper;
import com.jkoss.dao.CabinatSettingMapper;
import com.jkoss.dao.CoolRegisterMapper;
import com.jkoss.dao.CustomerMapper;
import com.jkoss.dao.LocationSettingMapper;
import com.jkoss.dao.PriceSettingMapper;
import com.jkoss.dao.RepayRegisterMapper;
import com.jkoss.dao.SysRightMapper;
import com.jkoss.dao.SysRoleMapper;
import com.jkoss.dao.SysUserMapper;
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
import com.jkoss.tool.SmsDemo;

@Component
public class LengKuBizImpl implements LengKuBiz{
	
	@Autowired
	private SysUserMapper userinfomapper;
	@Autowired
	private CabinatSettingMapper cabmapper;
	@Autowired
	private AreaInfoMapper areamapper;
	@Autowired
	private LocationSettingMapper locationmapper;
	@Autowired
	private CoolRegisterMapper coolmapper;
	@Autowired
	private SysRightMapper sysRightMapper;
	@Autowired
	private RepayRegisterMapper repayDao;
	@Autowired
	private CustomerMapper ctmDao;
	@Autowired
	private PriceSettingMapper psDao;
	@Autowired
	private SysRoleMapper roDao;

	
	//========生成权限树=====//
	public Map<Integer,DTreePriNode> genPriTree(SysUser user){
		
		//System.out.println(user.getRole().getROLENAME());
		
		TreeMap<Integer,DTreePriNode> map = new TreeMap<>();
		DTreePriNode node = null;
		DTreePriNode prtNode = null;
		
		if(user.getRole().getRights()!=null) {
			for(SysRight srt : user.getRole().getRights()) {
				
				node = right2Node(srt);
				
				
				//取得父节点
				prtNode = right2Node(sysRightMapper.selectByRfloor(node.getPrtNo()));
				map.put(prtNode.getIndexNo(), prtNode);
				map.put(node.getIndexNo(), node);
				
				//System.out.println(srt.getRfloor() + "  :  " + srt.getParentid() + "  :  " + srt.getRightName() + "  :  " + srt.getRightURL());
			}
			
			/*Iterator iterator = map.keySet().iterator();
			
			while(iterator.hasNext()){
				DTreePriNode nd = map.get(iterator.next());
				System.out.println(nd.getIndexNo() + "  :  " + nd.getPrtNo() + "  :  " + nd.getText() + "  :  " + nd.getUri());
			}*/
			
			
			
		}else {
			return null;
		}
		
		
		return map;
		
	}




	private DTreePriNode right2Node(SysRight srt) {
		DTreePriNode node;
		node = new DTreePriNode();
		node.setIndexNo(srt.getRfloor());
		node.setPrtNo(srt.getParentid());
		node.setText(srt.getRightName());
		node.setUri(srt.getRightURL());
		return node;
	}

		

	
	@Override
	public SysUser login(String name) {
		// TODO Auto-generated method stub
		SysUser su = userinfomapper.selectByName(name);
		genPriTree(su);
		return su;
		
		// return userinfomapper.selectByName(name);
	}
	
	//===========用户管理============//
	
	public List<SysUser> listUsers() {
		// TODO Auto-generated method stub
		return userinfomapper.selectByAll();
	}
	
	@Override
	@Transactional
	public String addUser(SysUser user) {
		// TODO Auto-generated method stub
		return userinfomapper.insert(user)==1?"添加成功":"添加失败";
	}

	@Override
	@Transactional
	public String delUser(int userid) {
		// TODO Auto-generated method stub
		return userinfomapper.deleteByPrimaryKey(userid)==1?"删除成功":"删除失败";
	}

	@Override
	public SysUser findOneUser(int userid) {
		// TODO Auto-generated method stub
		return userinfomapper.selectByPrimaryKey(userid);
	}

	@Override
	public String updateUser(SysUser user) {
		// TODO Auto-generated method stub
		return userinfomapper.updateByPrimaryKey(user)==1?"更新成功":"更新失败";
	}
	
	
	
	public List<CabinatSetting> lscab() {
		// TODO Auto-generated method stub
		return cabmapper.lscab();
	}

	public List<CabinatSetting> lsCabById(int loc_id) {
		// TODO Auto-generated method stub
		return cabmapper.lsCabById(loc_id);
	}
	
	public String addcab(CabinatSetting cab) {
		// TODO Auto-generated method stub
		return cabmapper.addcab(cab)==1?"添加成功":"添加失败";
	}

	public String delcab(String cab_id) {
		// TODO Auto-generated method stub
		return cabmapper.delcab(cab_id)==1?"删除成功":"删除失败";
	}

	public CabinatSetting onecab(String cab_id) {
		// TODO Auto-generated method stub
		return cabmapper.onecab(cab_id);
	}

	public String updtcab(CabinatSetting cab) {
		// TODO Auto-generated method stub
		return cabmapper.updtcab(cab)==1?"修改成功":"修改失败";
	}

	public List<AreaInfo> lsarea() {
		// TODO Auto-generated method stub
		return areamapper.lsarea();
	}


	public List<LocationSetting> lsloc(int area_id) {
		// TODO Auto-generated method stub
		return locationmapper.lslocation(area_id);
	}

	public List<CoolRegister> lsCool() {
		// TODO Auto-generated method stub
		return coolmapper.lsCool();
	}

	public String addCool(CoolRegister cr) {
		return coolmapper.insert(cr)==1 ? "添加成功" :"添加失败";
	}

	public String delcool(Integer cool_id) {
		return coolmapper.deleteByPrimaryKey(cool_id)==1 ? "删除成功" :"删除失败";
	}

	public CoolRegister onecool(Integer cool_id) {
		// TODO Auto-generated method stub
		return coolmapper.selectByPrimaryKey(cool_id);
	}

	public String updtcool(CoolRegister cr) {
		// TODO Auto-generated method stub
		return coolmapper.updtcool(cr)==1?"修改成功":"修改失败";
	}

	public List<CoolRegister> queryLikeCool(String nameorid) {
		return coolmapper.queryLikeCool(nameorid);
	}
	
	public List<LocationSetting> lsloc1() {
		// TODO Auto-generated method stub
		return locationmapper.lslocation1();
	}

	public String updLoc(int[] cab_id,int loc_id) {
		// TODO Auto-generated method stub
		cabmapper.updall(loc_id);
		for (int i : cab_id) {
			cabmapper.cgstate(i);
		}
		return "修改成功";
	}

	public String clear(int loc_id) {
		return cabmapper.updall(loc_id)>0?"修改成功":"修改失败";
	}


	public List<RepayRegister> findAll() {
		// TODO Auto-generated method stub
		return repayDao.findAll();
	}

	public String addrepay(RepayRegister repr) {
		// TODO Auto-generated method stub
		return repayDao.insert(repr) == 1 ? "添加成功" : "添加失败";
	}

	public String delrepay(Integer ID) {
		// TODO Auto-generated method stub
		return repayDao.deleteByPrimaryKey(ID) == 1 ? "删除成功" : "删除失败";
	}

	public String updrepay(RepayRegister ID) {
		// TODO Auto-generated method stub
		return repayDao.updateByPrimaryKey(ID) == 1 ? "修改成功" : "修改失败";
	}

	public RepayRegister onerepay(Integer reid) {
		// TODO Auto-generated method stub
		return repayDao.selectByPrimaryKey(reid);
	}

	public List<RepayRegister> serepay(Integer CUSTOMERID) {
		// TODO Auto-generated method stub
		return repayDao.serepay(CUSTOMERID);
	}

	public Customer findCustomerName(Integer CUSTOMERID) {
		// TODO Auto-generated method stub
		return ctmDao.selectByPrimaryKey(CUSTOMERID);
	}

	/* 
	 * 价格设置表
	 */
	@Override
	public List<PriceSetting> lsPs() {
	
		return psDao.lsPs();
	}
	@Override
	public List<Acclf> selectLikeByName(String cusname) {
		return psDao.selectLikeByName(cusname);
	}
	
	
	//找回密码
	public String yzm(String phone) {
		// TODO Auto-generated method stub
		SysUser user=userinfomapper.queryUserByPhone(phone);
		if(user == null) {
			return "该手机没有对应的用户";
		}
		else {
			try {
				//发送验证码，并把验证码放回到前端
				System.out.println("发送信息");
				return SmsDemo.sendSms(phone);
				 
				
			} catch (ClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String updPass(String phone,String password) {
		// TODO Auto-generated method stub
		String i=userinfomapper.updPass(phone, password)>0?"更新成功":"更新失败";
		return i;
	}




	public List<SysRole> lsAllRole() {
		// TODO Auto-generated method stub
		return roDao.findAll();
	}




	@Override
	public List<SysRight> lsAllRight() {
		// TODO Auto-generated method stub
		return sysRightMapper.selectAll();
	}




	@Override
	@Transactional
	public String updateRights(int roleid, int[] right_id) {
		// 删除——》添加
		
		sysRightMapper.deleteRole2Rights(roleid);
		for (int i : right_id) {
			sysRightMapper.saveRole2Rights(roleid, i);
		}
		
		return "修改成功";
	}



}
