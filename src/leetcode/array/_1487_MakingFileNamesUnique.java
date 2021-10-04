package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class _1487_MakingFileNamesUnique {
	public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] ans = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                ans[i] = name;
                map.put(name, 0);
            } else {
                Integer version = map.get(name);
                version++;
                while (map.containsKey(name + "(" + version + ")"))
                    version++;
                String newName = name + "(" + version + ")";
                ans[i] = newName;
                map.put(newName, 0);
                map.put(name, version);
            }
        }
        return ans;
    }
}
