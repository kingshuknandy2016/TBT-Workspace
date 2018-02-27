import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> hm1 = new HashMap();
		hm1.put("lux", "soap");
		hm1.put("colgate", "paste");
		hm1.put("pears", "soap");
		hm1.put("sony", "electronics");
		hm1.put("samsung", "electronics");

		for (Entry<String, String> m : hm1.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		HashMap<String, Integer> hm2 = new HashMap();
		hm2.put("lux", 1000);
		hm2.put("colgate", 500);
		hm2.put("pears", 2000);
		hm2.put("sony", 110);
		hm2.put("samsung", 660);

		for (Entry<String, Integer> m2 : hm2.entrySet()) {
			System.out.println(m2.getKey() + " " + m2.getValue());
		}

		HelloWorld h = new HelloWorld();
		int z = 0;
		String y = "electronics";
		h.updatePrices(hm1, hm2, y, z);

	}

	void updatePrices(HashMap hm1, HashMap hm2, String productCategory,
			int hikerate) {
		System.out.println("--------------------------------------------");
		Set<String> keyForSales = new HashSet<String>();

		Set s1 = hm1.entrySet();
		System.out.println("----------" + s1);
		Iterator ite = s1.iterator();
		while (ite.hasNext()) {
			Map.Entry mm1 = (Entry) ite.next();
			// System.out.println("Product Category:"+mm1.getValue()+"---"+"Brand:"+mm1.getKey());
			String ss1 = (String) mm1.getValue();
			if (ss1.endsWith(productCategory)) {
				keyForSales.add((String) mm1.getKey());
				// System.out.println(mm1.getKey());

			}
		}

		// ---------For display of the Temporary set----------------//
		// System.out.println("+++++"+keyForSales);
		Iterator ite3 = keyForSales.iterator();

		Set s2 = hm2.entrySet();
		Iterator ite2 = s2.iterator();

		while (ite3.hasNext()) {
			System.out.println("///////"+ite3.next());
			/*  String ss2 = (String) ite3.next();
			while (ite2.hasNext()) {
				Map.Entry mm2 = (Entry) ite2.next();
				String ss3 = (String) mm2.getKey();
				int i = (int) mm2.getValue();
				if (ss3.equalsIgnoreCase(ss2)) {
					System.out.println("inside");
					hm2.put(ss2, 20);
				}
			}*/
		}

		// ----------------------------------------------------------//

		// ----------------------For Displaying Sales      
		// details------------------------------------//
		Set s4 = hm2.entrySet();
		Iterator ite4 = s4.iterator();
		while (ite2.hasNext()) {
			Map.Entry mm4 = (Entry) ite4.next();
			System.out.println("-----" + mm4.getKey() + "----------"+ mm4.getValue());
		}

		// ----------------------------------------------------------//

	}

}
