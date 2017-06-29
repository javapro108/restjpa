package web.app.common;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class SystemServices extends Thread {
	private static SystemServices instance = null;
	private Map<String, User> liveUsers = new HashMap<String, User>();
	private Map<String, LockObject> lockObjects = new HashMap<String, LockObject>();
	private boolean runService = false;
	
	public static SystemServices getInstance() {
		if (instance == null) {
			instance = new SystemServices();
		}
		return instance;
	}

	public void run() {		
		System.out.println("System Service Started");
		this.runService = true;
		while(this.runService){
			System.out.println("Service Running :" + new Date());
			this.cleanLiveUsers();
			this.cleanLocks();
			try {
				Thread.sleep(1800000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				this.runService = false;								
			}

		} 		
	}

	public void stopService() {
		this.runService = false;
	}	
	
	public void addLiveUser(String token, User user) {
		synchronized (this.liveUsers) {
			liveUsers.put(token, user);
		}
	}
	
	private void cleanLiveUsers(){
		Date currentTime = new Date();
		//System.out.println("Inside Clean Live Users" + currentTime);
		synchronized(liveUsers){
			Iterator<Entry<String, User>> it = liveUsers.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry<String, User> entry = it.next();
				User user = entry.getValue();
				Date lastLoginTime = user.getLastLoginTime();				

				System.out.println("User session : " + user.getUserName() + "Login Time: " + lastLoginTime);
				
				if ((currentTime.getTime() - lastLoginTime.getTime()) > 1800000) {
					System.out.println("User session expired:" + user.getUserName());
					it.remove();
				}								
			}
		}
	}
	

	private void cleanLocks(){	
		Date currentTime = new Date();
		//System.out.println("Inside Clean Locks" + currentTime);
		synchronized(lockObjects){
			Iterator<Entry<String, LockObject>> it = lockObjects.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry<String, LockObject> entry = it.next();				 
				LockObject lockObject = entry.getValue();
				System.out.println("Lock Object: " 
									+ lockObject.getLockedBy() + ":" 
									+ lockObject.getObjectType() + ":"
									+ lockObject.getObjectId());
				Date lockTime = lockObject.getLockedTime(); 				
				if ((currentTime.getTime() - lockTime.getTime()) > 1800000) {
					System.out.println("Lock expired:" + entry.getKey());
					it.remove();
				}								
			}
		}		
	}
	
	
	public User getUser(String token) throws IllegalArgumentException, IllegalStateException {
		if (token == null) {
			throw new IllegalArgumentException();
		}
		User user = liveUsers.get(token);
		if (user == null) {
			throw new IllegalArgumentException();
		}
		Date lastLoginTime = user.getLastLoginTime();
		Date currentTime = new Date();

		if ((currentTime.getTime() - lastLoginTime.getTime()) > 1800000) {
			throw new IllegalStateException();
		}
		user.setLastLoginTime(currentTime);
		return user;
	}

	public boolean lockObject(LockObject lockObject) {
		String key = lockObject.getObjectType() + ":" + lockObject.getObjectId();
		synchronized (this.lockObjects) {
			LockObject lock = lockObjects.get(key);
			if (lock != null) {
				if (lock.getLockedBy().equals(lockObject.getLockedBy())) {
					lockObject.setLockedTime(new Date());
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
	
	public boolean unLockObject(LockObject lockObject) {
		String key = lockObject.getObjectType() + ":" + lockObject.getObjectId();
		synchronized (this.lockObjects) {
			LockObject lock = lockObjects.get(key);
			if (lock != null) {
				this.lockObjects.remove(key);
				return true;
			} else {
				return false;
			}
		}
	}
	

}
