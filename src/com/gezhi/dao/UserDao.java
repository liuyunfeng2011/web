package com.gezhi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gezhi.pojo.User;
import com.gezhi.pojo.UserInfo;
import com.gezhi.util.DbUtil;

/**
 * 用户相关数据库操作
 * @author Liuyf
 *
 */
public class UserDao {
	//设置用户状态为禁用
	static final int USER_TYPE_DELETE=3;
	/**
	 * @throws Exception 
	 * 查询所有用户
	 * @return 查询到的所有用户的信息
	 * @throws  
	 */
	public List<User> findAllUser() throws Exception  {
		List<User> users=new ArrayList<>();
		//mysql
		Connection conn=DbUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT u.user_id,u.user_name,info.info_nickname,info.info_phone,info.info_email, ");
		sb.append(" info.info_gender,info.info_address ");
		sb.append(" from users u ");
		sb.append(" left join user_info info ");
		sb.append(" on u.user_id=info.user_id WHERE user_type!=3");
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sb.toString());
		User user=null;
		while(rs.next()){
			user=new User();
			user.setUserId(rs.getInt("user_id"));
			user.setUserName(rs.getString("user_name"));
			UserInfo info=new UserInfo();
			info.setNickName(rs.getString("info_nickname"));
			info.setPhone(rs.getString("info_phone"));
			info.setEmail(rs.getString("info_email"));
			info.setGender(rs.getInt("info_gender"));
			user.setUserInfo(info);
			users.add(user);
		}
		DbUtil.closeConnection(conn);
		return users;
	}
	
	/**
	 * 删除/禁用某个用户
	 * @param userId 需要操作的用户ID
	 * @throws Exception 
	 */
	public void delUser(int userId) throws Exception{
		Connection conn=DbUtil.getConnection();
		String sql="update users set user_type=? where user_id=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, USER_TYPE_DELETE);
		stmt.setInt(2, userId);
		stmt.executeUpdate();
	}
	public static void main(String[] args) {
		UserDao dao=new UserDao();
		try {
			System.out.println(dao.findAllUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
