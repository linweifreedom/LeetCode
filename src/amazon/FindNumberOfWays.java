package amazon;


/*The Amazon Kindle Store is an online e-book store where readers can choose a book from a wide range of categories. It also provides the ability to bookmark pages the user wishes to return to later. A book is represented as a binary string having two types of pages:

'0': an ordinary page
'1': a bookmarked page

Find the number of ways to select 3 pages in ascending index order such that no two adjacent selected pages are of the same type.

Example

book = '01001'

The following sequences of pages match the criterion:

[1, 2 ,3], that is, 01001 ¡ú 010.
[1, 2 ,4], that is, 01001 ¡ú 010.
[2, 3 ,5], that is, 01001 ¡ú 101.
[2, 4 ,5], that is, 01001 ¡ú 101.

The answer is 4.*/
public class FindNumberOfWays {

	public static int solve(String str){
		  int ans=0,c0=0,c1=0,c10=0,c01=0;        //     cx == count of pattern/subsequence x so far.  
		  for(int i=0;i<str.length();i++){       
		    if(str.charAt(i)=='0'){
		      c10+=c1;
		      c0++;
		      ans+=c01;
		    }else{
		      c01+=c0;
		      c1++;
		      ans+=c10;
		    }
		  }
		  return ans;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FindNumberOfWays.solve("01001"));
	}

}
