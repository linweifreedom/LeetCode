package amazon;

import java.util.Arrays;

/*�ҵ�����ǳ����ظ�char�Ժ���㷽ʽ������
 "t" -> 1
 "e" -> 1
 "s" -> 1
 "t" -> 1
 "te" -> 2
 "es" -> 2
 "st" -> 2
 "tes" -> 3
 "est" -> 3
 "test" -> 3
 Number of distinct chars - 1+1+1+1+2+2+2+3+3+3 = 19
 Output - 19
������oa����㷨
�����ǰͶ��͵��㷨
    "t" -> 1
    "e" -> 1
    "s" -> 1
    "t" -> 1
    "te" -> 2
    "es" -> 2
    "st" -> 2
    "tes" -> 3
    "est" -> 3
    "test" -> 2
    Number of distinct chars - 1+1+1+1+2+2+2+3+3+2 = 18
    Output - 18
���test�����ظ���t���㣬ֻ����es*/
public class _828 {

	public static int uniqueLetterStringFor828(String s) {
    	int n = s.length();
        int[] lastOccurance = new int[26];
        int[] lastTwoOccuranceDiff = new int[26];
        Arrays.fill(lastOccurance,-1);

        int totalUniqueCharSum = 0;
        int prevUniqueCharSum = 0;
        for(int i=0; i<n; i++){
            prevUniqueCharSum += (i - lastOccurance[s.charAt(i)-'A']);
            prevUniqueCharSum -= lastTwoOccuranceDiff[s.charAt(i)-'A'];
            lastTwoOccuranceDiff[s.charAt(i)-'A'] = 
                i - lastOccurance[s.charAt(i)-'A'];
            lastOccurance[s.charAt(i)-'A']=i;
            totalUniqueCharSum+=prevUniqueCharSum;
        }
        return totalUniqueCharSum;
    }
	
	//ÿ�θ����Ե�ǰ�ַ�Ϊ������substring, Ȼ��for loop������26���ַ����ִ������Ͼ��ǵ�ǰsubstring��unique�ַ���
	//                               T
	//                  S           ST
	//          E      ES          EST
	//    T    TE     TES         TEST
	//    1   1+2   1+2+3        2+3+4       =  19
	public static int uniqueLetterStringForAmazon(String s) {
		int res = 0;
        int[] substringEndWith = new int[128];
        
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            substringEndWith[x] = i + 1;
            
            for (int j = 0; j < 128; j++) {
                res += substringEndWith[j];
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(_828.uniqueLetterStringFor828("TEST"));
		System.out.println(_828.uniqueLetterStringForAmazon("test"));
	}

}
