package amazon;

//һ��������substring�����ٰ���һ��Ԫ����һ������������һ��segment����һ��string������ж��ٸ�segment
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
