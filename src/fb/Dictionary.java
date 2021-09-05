package fb;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
  
  class Dict {
    String key;
    String value;
    Map<String, Dict> children;
    
    public Dict(String key, String value) {
      this.key = key;
      this.value = value;
      this.children = new HashMap<>();
    }
  }
  
  
  public static String output(String input, Dict dict) {
    if (input == null)
      return null;
    String[] keys = input.split(".");
    Dict point = dict;
    for (int i = 0; i < keys.length - 1; i++) {
      point = point.children.get(keys[i]);
      if (point == null)
        return null;
    }
    return point.value;
    
  }
  
  public static void main(String[] arg0) {
    
  }
  
  
}
