package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerOrder {
	private static int freshPromotion(String[][] codeList, String[] shoppingCart) {
//      Start at 0 index for both the code list and shopping cart.
      int cartIdx = 0, codeIdx = 0;
      while (cartIdx < shoppingCart.length && codeIdx < codeList.length) {
          String cur = shoppingCart[cartIdx];
//          If the first fruit of the codeList is anything or if it matches the current fruit at the cart idx.
          if((codeList[codeIdx][0].equals("anything") || codeList[codeIdx][0].equals(cur)) && hasOrder(shoppingCart, cartIdx, codeList[codeIdx])){
              cartIdx += codeList[codeIdx++].length;
          }else{
              cartIdx++;
          }
      }
//      If the all the codeList is present then return 1, else 0.
      return codeIdx == codeList.length ? 1 : 0;
  }

  private static boolean hasOrder(String[] shoppingCart, int idx, String[] order) {
//      Loop through the codeList to check if the fruits are in order.
      for (String s : order) {
          if (idx < shoppingCart.length && (s.equals("anything") || shoppingCart[idx].equals(s))){
              idx++;
          }else{
              return false;
          }
      }
      return true;
  }
  
  private static int freshPromotion(List<String> codeList, List<String> shoppingCart) {
//    Start at 0 index for both the code list and shopping cart.
    int cartIdx = 0, codeIdx = 0;
    while (cartIdx < shoppingCart.size() && codeIdx < codeList.size()) {
        String cur = shoppingCart.get(cartIdx);
//        If the first fruit of the codeList is anything or if it matches the current fruit at the cart idx.
        String code = codeList.get(codeIdx);
        String[] codeArr = code.split(",");
        if((codeArr[0].equals("anything") || codeArr[0].equals(cur)) && hasOrder(shoppingCart, cartIdx, codeArr)){
        	String[] tmpCodeArr = codeList.get(codeIdx++).split(",");
            cartIdx += tmpCodeArr.length;
        }else{
            cartIdx++;
        }
    }
//    If the all the codeList is present then return 1, else 0.
    return codeIdx == codeList.size() ? 1 : 0;
}

private static boolean hasOrder(List<String> shoppingCart, int idx, String[] order) {
//    Loop through the codeList to check if the fruits are in order.
    for (String s : order) {
        if (idx < shoppingCart.size() && (s.equals("anything") || shoppingCart.get(idx).equals(s))){
            idx++;
        }else{
            return false;
        }
    }
    return true;
}
  
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] codeList = {{"orange"}, {"apple", "apple"}, {"banana", "orange", "apple"}, {"banana"}};
		String[] shoppingCart = {"orange", "apple", "apple", "banana", "orange", "apple", "banana"};
		System.out.println(CustomerOrder.freshPromotion(codeList, shoppingCart));
		List<String> codeList2 = new ArrayList<>();
		codeList2.add("orange");
		codeList2.add("apple,apple");
		codeList2.add("banana,orange,apple");
		codeList2.add("banana");
		List<String> shoppingCart2 = Arrays.asList(shoppingCart);
		System.out.println(CustomerOrder.freshPromotion(codeList2, shoppingCart2));
	}

}
