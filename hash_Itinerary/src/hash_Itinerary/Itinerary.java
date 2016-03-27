package hash_Itinerary;

import java.util.HashMap;

/*
 Find Itinerary from a given list of tickets
Given a list of tickets, find itinerary in order using the given list.

Example:

Input:
"Chennai" -> "Banglore"
"Bombay" -> "Delhi"
"Goa"    -> "Chennai"
"Delhi"  -> "Goa"

Output: 
Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,
 */
public class Itinerary {

	public static void main(String[] args) {
		String [] tickets = {
			"chennai,bangalore",
			"bombay,delhi",
			"goa,chennai",
			"delhi,goa"
		};
		
		printItinerary(tickets);
		
	}
	
	public static void printItinerary(String [] tickets) {
		if (tickets == null) {
			return;
		}
		
		HashMap<String, String> dataMap = new HashMap<String, String>();
		HashMap<String, String> revDataMap = new HashMap<String, String> ();
		
		for (int i=0; i<tickets.length; i++) {
			String [] cities = tickets[i].split(",");
			dataMap.put(cities[0].trim().toLowerCase(), cities[1].trim().toLowerCase());
			revDataMap.put(cities[1].trim().toLowerCase(), cities[0].trim().toLowerCase());
		}
		
		String startCity = "";
		for (String key: dataMap.keySet()) {
			if (!revDataMap.containsKey(key)) {
				startCity = key;
				break;
			}
		}
		System.out.print(startCity + " -> ");
		while (dataMap.containsKey(startCity)) {
			startCity = dataMap.get(startCity);
			System.out.print(startCity + " -> ");
		}
		System.out.println(" null ");
	}
}
