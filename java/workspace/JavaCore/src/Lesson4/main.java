package Lesson4;

public class main {
	private static void reverse(String str){
		String[] splits = str.split(" ");
		String[] arr = new String[splits.length];
		int ai = 0;
		for (int i = splits.length - 1; i >= 0; i--) 
		{
			if(!"".equals(splits[i])){
				arr[ai] = splits[i];
				ai+=1;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null)
				if(arr[i+1] != null)
				System.out.print(arr[i] + " ");
				else
					System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverse(" I am   DEV  ");
	}
}
/*
 * selection sort
 * merge sort
 * insertion sort
 */
