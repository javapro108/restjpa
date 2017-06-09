package web.app.common;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SystemServices {
<<<<<<< HEAD
=======
	private static SystemServices instance = null;
	private Map<String, User> liveUsers = new HashMap<String, User>();
	private Map<String, LockObject> lockObjects;
>>>>>>> branch 'master' of https://github.com/javapro108/restjpa.git
	
<<<<<<< HEAD
	private static SystemServices instance = null;
	private Map<String, User> liveUsers = new HashMap<String, User>();
	private Map<String, LockObject> lockObjects;
	
=======
>>>>>>> branch 'master' of https://github.com/javapro108/restjpa.git
	public static SystemServices getInstance(){
		if (instance == null){
			instance = new SystemServices();
		}
		return instance;
	}
	
	public void addLiveUser(String token, User user){
		liveUsers.put(token, user);
	}
	
	public User getUser(String token) throws IllegalArgumentException, IllegalStateException{
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
	
<<<<<<< HEAD
	public boolean lockObject(LockObject lockObject){
=======
	
	public synchronized boolean lockObject(LockObject lockObject){
>>>>>>> branch 'master' of https://github.com/javapro108/restjpa.git
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
