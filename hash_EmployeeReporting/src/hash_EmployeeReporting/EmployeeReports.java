package hash_EmployeeReporting;

import java.util.ArrayList;
import java.util.HashMap;

/*
 Find number of Employees Under every Employee
 Given a dictionary that contains mapping of employee and his manager as a number of (employee, manager) pairs like below.

 { "A", "C" },
 { "B", "C" },
 { "C", "F" },
 { "D", "E" },
 { "E", "F" },
 { "F", "F" } 

 In this example C is manager of A, 
 C is also manager of B, F is manager 
 of C and so on.
 Write a function to get no of employees under each manager in the hierarchy not just their direct reports. It may be assumed that an employee directly reports to only one manager. In the above dictionary the root node/ceo is listed as reporting to himself.

 Output should be a Dictionary that contains following.

 A - 0  
 B - 0
 C - 2
 D - 0
 E - 1
 F - 5 
 */
public class EmployeeReports {

	private static HashMap<String, Integer> result = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		String[] reportings = { "A,C", "B,C", "C,F", "D,E", "E,F", "F,F" };
		getReports(reportings);
	}

	public static void getReports(String[] reportings) {
		HashMap<String, ArrayList<String>> revMap = new HashMap<String, ArrayList<String>>();
		HashMap<String, String> dataMap = new HashMap<String, String>();
		//HashMap<String, Integer> ecMap = new HashMap<String, Integer>();

		int len = reportings.length;
		for (int i = 0; i < len; i++) {
			String[] st = reportings[i].split(",");
			String emp = st[0].trim();
			String mgr = st[1].trim();
			dataMap.put(emp, mgr);
			if (emp.equals(mgr)) {
				continue;
			}
			ArrayList<String> elist = new ArrayList<String>();
			//int count = 0;
			if (revMap.containsKey(mgr)) {
				elist = revMap.get(mgr);
				//count = ecMap.get(mgr);
			}
			elist.add(emp);
			//++count;
			revMap.put(mgr, elist);
			//ecMap.put(mgr, count);
		}
		
		for (String key : dataMap.keySet()) {
			populateResultUtil(key, revMap);
			//if (ecMap.containsKey(key)) {
				System.out.println(key + ": " + result.get(key));
		//	} else {
				//System.out.println(key + ": " + "0");
			//}
		}
	}

	private static int populateResultUtil(String mngr,
			HashMap<String, ArrayList<String>> mngrEmpMap ) {
		int count = 0;

		// means employee is not a manager of any other employee
		if (!mngrEmpMap.containsKey(mngr)) {
			result.put(mngr, 0);
			return 0;
		}

		// this employee count has already been done by this
		// method, so avoid re-computation
		else if (result.containsKey(mngr))
			count = result.get(mngr);

		else {
			ArrayList<String> directReportEmpList = mngrEmpMap.get(mngr);
			count = directReportEmpList.size();
			for (String directReportEmp : directReportEmpList)
				count += populateResultUtil(directReportEmp, mngrEmpMap);

			result.put(mngr, count);
		}
		return count;
	}
}
