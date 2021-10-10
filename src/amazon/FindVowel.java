package amazon;

//一个连续的substring里至少包含一个元音，一个辅音，则算一个segment。求一个string里最多有多少个segment
public class FindVowel {
	
	public static int findVowel(String s) {
	    int n = s.length(), count = 0;
	    char[] arr = s.toCharArray();
	    for(int i = 0; i < n; i++) {
	        int v_count = 0, c_count = 0;
	        while(i < n && (v_count == 0 || c_count == 0)) {
	            if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
	                v_count++;
	            }
	            else
	                c_count++;
	            i++;
	        }
	        i--;
	        if(v_count > 0 && c_count > 0)
	            count++;
	    }
	   return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FindVowel.findVowel("good"));
	}

}
