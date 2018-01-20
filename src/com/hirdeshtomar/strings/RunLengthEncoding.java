package com.hirdeshtomar.strings;

/*
 * 
 * Given an input string, write a function that returns the Run Length Encoded string for the input string.
	For example, if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6”.
 */

public class RunLengthEncoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String str = "";
		
		StringBuilder builder = new StringBuilder();
		
		int count =1;
		char prev = 0;
		if(str.length() >0)
			prev  = str.charAt(0);
		
		for(int i=1; i<str.length(); i++) {
			
			char current = str.charAt(i);
			if(i ==str.length() -1) {
				if(prev == current)
					builder.append(prev).append(++count);
				else
					builder.append(prev).append(count).append(current).append(1);
			}
			else if(current == prev) {
				count++;
			} else {
				builder.append(prev).append(count);
				count = 1;
			}
			prev = current;	
		}
		
		System.out.println(builder.toString());
		
		/*
		Map<Character, Integer> hm = new LinkedHashMap<Character,Integer>();
		
		for(int i=0 ;i< str.length(); i++) {
			char key = str.charAt(i);
			if(hm.containsKey(key)){
				
				hm.put(key, hm.get(key) +  1);
			}
			else
				hm.put(key,1);
		}
		
		for(Map.Entry<Character,Integer> m : hm.entrySet())
			System.out.println(m.getKey() + " "+ m.getValue());
			*/
	}

}
