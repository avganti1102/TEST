package Lesson10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<Integer> ali = new ArrayList<>(5);
		ali.add(3);
		ali.add(2);
		
		Collections.sort(ali);
		for (Integer integer : ali) {
			System.out.println(integer);
		}
//		System.out.println(ali.size());
//		Map<Integer, String> m = new HashMap<>();
//		m.put(1, "a");
//		m.put(2, "B");
//		System.out.println(m.putAll(13););
	}
}
