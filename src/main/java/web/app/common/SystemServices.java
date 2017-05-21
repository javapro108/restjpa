package web.app.common;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SystemServices {
	private static Map<String, User> liveUsers = new HashMap<String, User>();
	private static Map<String, LockObject> lockObjects;
	
	public static void addLiveUser(String token, User user){
		liveUsers.put(token, user);
	}
	
	public static User getUser(String token) throws IllegalArgumentException, IllegalStateException{
		if (token == null){
			throw new IllegalArgumentException();
		}
		User user = liveUsers.get(token);
		if (user == null){
			throw new IllegalArgumentException();
		}
		Date lastLoginTime = user.getLastLoginTime();
		Date currentTime = new Date();
		
		if( ( currentTime.getTime() - lastLoginTime.getTime() ) > 1800000 ){ 
			throw new IllegalStateException();			
		}
		user.setLastLoginTime(currentTime);				
		return user;
	}
	
	public static boolean lockObject(LockObject lockObject){
		String key = lockObject.getObjectType() + ":" + lockObject.getObjectId();
		LockObject lock = lockObjects.get(key);
		if ( lock != null ){
			if (lock.getLockedBy() == lockObject.getLockedBy()){
				return true;
			} else {
				return false;
			}
		} else {
			lockObject.setLockedTime(new Date());
			lockObjects.put(key, lockObject);
			return true;
		}
	}
	
}
