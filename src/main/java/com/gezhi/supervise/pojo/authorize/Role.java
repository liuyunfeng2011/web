package com.gezhi.supervise.pojo.authorize;

import java.io.Serializable;

/**
 * 角色模型
 * @author Liuyf
 *
 */
public class Role implements Serializable{
	
    public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String roleName, String roleSign, String description) {
		super();
		this.roleName = roleName;
		this.roleSign = roleSign;
		this.description = description;
	}


	private int roleId;
    //角色名称
    private String roleName;
    //角色中文名称
    private String roleSign;
    //角色描述
    private String description;




	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleSign() {
        return roleSign;
    }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign == null ? null : roleSign.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }


    @Override
    public String toString() {
        return "Role [id=" + roleId + ", roleName=" + roleName + ", roleSign=" + roleSign + ", description=" + description + "]";
    }

}