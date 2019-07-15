
package com.doublechaintech.his.secuser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.his.BaseRowMapper;
import com.doublechaintech.his.userdomain.UserDomain;
import com.doublechaintech.his.secuserblocking.SecUserBlocking;

public class SecUserMapper extends BaseRowMapper<SecUser>{
	
	protected SecUser internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SecUser secUser = getSecUser();		
		 		
 		setId(secUser, rs, rowNumber); 		
 		setLogin(secUser, rs, rowNumber); 		
 		setMobile(secUser, rs, rowNumber); 		
 		setEmail(secUser, rs, rowNumber); 		
 		setPwd(secUser, rs, rowNumber); 		
 		setWeixinOpenid(secUser, rs, rowNumber); 		
 		setWeixinAppid(secUser, rs, rowNumber); 		
 		setAccessToken(secUser, rs, rowNumber); 		
 		setVerificationCode(secUser, rs, rowNumber); 		
 		setVerificationCodeExpire(secUser, rs, rowNumber); 		
 		setLastLoginTime(secUser, rs, rowNumber); 		
 		setDomain(secUser, rs, rowNumber); 		
 		setBlocking(secUser, rs, rowNumber); 		
 		setCurrentStatus(secUser, rs, rowNumber); 		
 		setVersion(secUser, rs, rowNumber);

		return secUser;
	}
	
	protected SecUser getSecUser(){
		return new SecUser();
	}		
		
	protected void setId(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(SecUserTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUser.setId(id);
	}
		
	protected void setLogin(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String login = rs.getString(SecUserTable.COLUMN_LOGIN);
		if(login == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUser.setLogin(login);
	}
		
	protected void setMobile(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String mobile = rs.getString(SecUserTable.COLUMN_MOBILE);
		if(mobile == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUser.setMobile(mobile);
	}
		
	protected void setEmail(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String email = rs.getString(SecUserTable.COLUMN_EMAIL);
		if(email == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUser.setEmail(email);
	}
		
	protected void setPwd(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String pwd = rs.getString(SecUserTable.COLUMN_PWD);
		if(pwd == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUser.setPwd(pwd);
	}
		
	protected void setWeixinOpenid(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String weixinOpenid = rs.getString(SecUserTable.COLUMN_WEIXIN_OPENID);
		if(weixinOpenid == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUser.setWeixinOpenid(weixinOpenid);
	}
		
	protected void setWeixinAppid(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String weixinAppid = rs.getString(SecUserTable.COLUMN_WEIXIN_APPID);
		if(weixinAppid == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUser.setWeixinAppid(weixinAppid);
	}
		
	protected void setAccessToken(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String accessToken = rs.getString(SecUserTable.COLUMN_ACCESS_TOKEN);
		if(accessToken == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUser.setAccessToken(accessToken);
	}
		
	protected void setVerificationCode(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer verificationCode = rs.getInt(SecUserTable.COLUMN_VERIFICATION_CODE);
		if(verificationCode == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUser.setVerificationCode(verificationCode);
	}
		
	protected void setVerificationCodeExpire(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date verificationCodeExpire = rs.getTimestamp(SecUserTable.COLUMN_VERIFICATION_CODE_EXPIRE);
		if(verificationCodeExpire == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUser.setVerificationCodeExpire(convertToDateTime(verificationCodeExpire));
	}
		
	protected void setLastLoginTime(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date lastLoginTime = rs.getTimestamp(SecUserTable.COLUMN_LAST_LOGIN_TIME);
		if(lastLoginTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUser.setLastLoginTime(convertToDateTime(lastLoginTime));
	}
		 		
 	protected void setDomain(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException{
 		String userDomainId = rs.getString(SecUserTable.COLUMN_DOMAIN);
 		if( userDomainId == null){
 			return;
 		}
 		if( userDomainId.isEmpty()){
 			return;
 		}
 		UserDomain luserDomain = secUser.getDomain();
 		if( luserDomain != null ){
 			//if the root object 'secUser' already have the property, just set the id for it;
 			luserDomain.setId(userDomainId);
 			
 			return;
 		}
 		secUser.setDomain(createEmptyDomain(userDomainId));
 	}
 	 		
 	protected void setBlocking(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException{
 		String secUserBlockingId = rs.getString(SecUserTable.COLUMN_BLOCKING);
 		if( secUserBlockingId == null){
 			return;
 		}
 		if( secUserBlockingId.isEmpty()){
 			return;
 		}
 		SecUserBlocking lsecUserBlocking = secUser.getBlocking();
 		if( lsecUserBlocking != null ){
 			//if the root object 'secUser' already have the property, just set the id for it;
 			lsecUserBlocking.setId(secUserBlockingId);
 			
 			return;
 		}
 		secUser.setBlocking(createEmptyBlocking(secUserBlockingId));
 	}
 	
	protected void setCurrentStatus(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String currentStatus = rs.getString(SecUserTable.COLUMN_CURRENT_STATUS);
		if(currentStatus == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUser.setCurrentStatus(currentStatus);
	}
		
	protected void setVersion(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(SecUserTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUser.setVersion(version);
	}
		
		

 	protected UserDomain  createEmptyDomain(String userDomainId){
 		UserDomain userDomain = new UserDomain();
 		userDomain.setId(userDomainId);
 		userDomain.setVersion(Integer.MAX_VALUE);
 		return userDomain;
 	}
 	
 	protected SecUserBlocking  createEmptyBlocking(String secUserBlockingId){
 		SecUserBlocking secUserBlocking = new SecUserBlocking();
 		secUserBlocking.setId(secUserBlockingId);
 		secUserBlocking.setVersion(Integer.MAX_VALUE);
 		return secUserBlocking;
 	}
 	
}


