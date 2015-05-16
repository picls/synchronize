package base;

import com.dao.*;

public class test {

	public static void main(String args[]) {
		BaseManager bm = new BaseManager(HibernateUtilFormal.currentSession(),false);
		System.out.println(bm.select("com.dao.User", 100l));
		System.exit(0);
	}
	
}
