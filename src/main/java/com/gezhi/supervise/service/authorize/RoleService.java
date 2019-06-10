package com.gezhi.supervise.service.authorize;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gezhi.supervise.pojo.User;
import com.gezhi.supervise.pojo.authorize.Role;


/**
 * 角色 业务接口
 * 
 * @author StarZou
 * @since 2014年6月10日 下午4:15:01
 **/
public interface RoleService  {
    /**
     * 通过用户id 查询用户 拥有的角色
     * 
     * @param userId
     * @return
     */
    List<Role> selectRolesByUserId(int userId);
}
