import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class HashMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, Integer> hm2 = new HashMap();
		hm2.put("lux", 1000);
		hm2.put("colgate", 500);
		hm2.put("pears", 2000);
		hm2.put("sony", 110);
		hm2.put("samsung", 660);

		for (Entry<String, Integer> m2 : hm2.entrySet()) {
			System.out.println(m2.getKey() + " " + m2.getValue());
		}
		
		HashMapDemo h1=new HashMapDemo();
		h1.update(hm2 );

	}
	
	void update(HashMap hmap){
		Set s1=hmap.entrySet();
		Iterator ite=s1.iterator();
		
		while(ite.hasNext()){
			Map.Entry mm1=(Entry) ite.next();
			System.out.println("values"+mm1.getValue());
		}
	}

}
