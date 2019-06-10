package com.gezhi.supervise.pojo.authorize;
/**
 * 权限模型
 * @author Liuyf
 *
 */
public class Permission {
	
    public Permission(String permissionName, String permissionSign, String description) {
		super();
		this.permissionName = permissionName;
		this.permissionSign = permissionSign;
		this.description = description;
	}

	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int permissionId;
    //权限名字
    private String permissionName;
    //权限类容
    private String permissionSign;
    //权限描述
    private String description;


    public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionSign() {
        return permissionSign;
    }

    public void setPermissionSign(String permissionSign) {
        this.permissionSign = permissionSign == null ? null : permissionSign.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        return "Permission [id=" + permissionId + ", permissionName=" + permissionName + ", permissionSign=" + permissionSign + ", description=" + description + "]";
    }

}