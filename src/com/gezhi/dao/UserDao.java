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
	static final int PAGE_SIZE=5;
	//查询总页数
	public int getPageCount() throws Exception{
		int pageCount=0;
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT count(*) as count ");
		sb.append(" from users u ");
		sb.append(" left join user_info info ");
		sb.append(" on u.user_id=info.user_id WHERE user_type!=3");
		// 数据size
		// pagecount
		Connection conn=DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery(sb.toString());
		if(rs.next()){
			int rowCount=rs.getInt("count");
			pageCount=rowCount%PAGE_SIZE==0?rowCount/PAGE_SIZE:rowCount/PAGE_SIZE+1; 
			
		}
		DbUtil.closeConnection(conn);
		return pageCount;
	}
	
	
	/**
	 * 批量删除用户(后期可以替代单独删除)
	 *  USER_TYPE_DELETE-删除状态-3
	 * @param ids 需要删除的用户ID-数组
	 * @throws Exception 
	 */
	public void delUsersById(String [] ids) throws Exception{
		StringBuilder sb=new StringBuilder("update users set user_type= ? ");
		sb.append(" where user_id in ( ");
		for(int i=0;i<ids.length;i++){
			sb.append(ids[i]+",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("  )");
		Connection conn=DbUtil.getConnection();
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		ptmt.setInt(1, USER_TYPE_DELETE);
		//ptmt.setString(2, ids.toString());
		ptmt.executeUpdate();
	}
	public static void main(String[] args) {
		UserDao dao=new UserDao();
		try {
			System.out.println(dao.getUserByUserName("zhangsan"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws Exception 
	 * 查询所有用户
	 * @return 查询到的所有用户的信息
	 * @throws  
	 */
	public List<User> findUserByPage(int pageNow) throws Exception  {
		//计算limit分页相关参数
		int limitNum=(pageNow-1)*PAGE_SIZE;
		List<User> users=new ArrayList<>();
		//mysql
		Connection conn=DbUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT u.user_id,u.user_name,info.info_nickname,info.info_phone,info.info_email, ");
		sb.append(" info.info_gender,info.info_address ");
		sb.append(" from users u ");
		sb.append(" left join user_info info ");
		sb.append(" on u.user_id=info.user_id WHERE user_type!=3 limit ?,?");
//		Statement stmt=conn.createStatement();
//		ResultSet rs=stmt.executeQuery(sb.toString());
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		ptmt.setInt(1, limitNum);
		ptmt.setInt(2, PAGE_SIZE);
		ResultSet rs=ptmt.executeQuery();
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
	 * USER_TYPE_DELETE-删除状态-3
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
	
	
	public User getUserByUserName(String name) throws Exception{
		Connection conn=DbUtil.getConnection();
		String sql="select * from users where user_name=?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, name);
		ResultSet rs= ptmt.executeQuery();
		User user=null;
		if(rs.next()){
			user=new User();
			user.setUserName(rs.getString("user_name"));
			user.setUserType(Integer.parseInt(rs.getString("user_type")));
			
		}
		return user;
	}
}
