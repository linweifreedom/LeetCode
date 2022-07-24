package amazon;

import java.util.List;

//Given N strings, choose the maximum number of strings such that in the overall chosen string's, each letter's count is even.
public class ChooseString {
/*
	public static int evenstring(String[] A){
	    List<Pair<Bitset<26>,Integer>> dp ;
	    dp.push_back(make_pair(bitset<26>(),0));
	    int res = 0;
	    for (String s : A) {
	        bitset<26> a ;         ;
	        for (char c : s)
	            a.flip(c-'a');                 //the bit is set on if  count of char is odd and 'off' if even
	        for (int i = dp.size() - 1; i >= 0; --i) {
	            bitset<26> c = dp[i].first;
	            int num=dp[i].second;
	            dp.push_back(make_pair(c^a,num+1));
	            if((c ^ a) !=0)            //if some character's count is odd
	                continue;
	            res = max(res, num+1); //if all the character's count is even take max
	        }
	    }
	    return res;
	}
	int main(){
	    vector<string>A={"abab","abf","cda","ad","ccc"};
	    cout<<evenstring(A);
	}
*/
}
