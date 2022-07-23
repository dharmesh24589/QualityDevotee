package com.qualitydevotee.utilities;

public class WaitHelper {
	
	public static void waitForSeconds(int id) {
		try {
			Thread.sleep(id*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
