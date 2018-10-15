package com.jkoss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jkoss.pojo.SysRight;

public interface SysRightMapper {
	
	@Select("select b.* from role2right a,`right` b" + 
			" where a.RIGHTID=b.right_id and a.ROLEID=#{roleid}")
	List<SysRight> selectByRoleID(@Param("roleid") int roleid);
	
	
	@Select("select * from `right` where rfloor=#{floor}")
	SysRight selectByRfloor(@Param("floor") int floor);
	
	@Select("select * from `right` where rightURL is not null")
	List<SysRight> selectAll();
	
	@Delete("delete from `role2right` where ROLEID =#{roleid}")
	int deleteRole2Rights(@Param("roleid") int roleid);
	
	@Insert("insert into `role2right` values(#{roleid},#{rightid})")
	int saveRole2Rights(@Param("roleid") int roleid,@Param("rightid") int rightid);
	
    int deleteByPrimaryKey(Integer right_id);

    int insert(SysRight record);

    int insertSelective(SysRight record);

    SysRight selectByPrimaryKey(Integer right_id);

    int updateByPrimaryKeySelective(SysRight record);

    int updateByPrimaryKey(SysRight record);
}