package hexlet.code;

import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.LinkedHashMap;
import java.util.Objects;

public class BuilderDiff {
    public static List<Map<String, Object>> getDiff(Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String, Object>> list = new ArrayList<>();
        Set<String> keySet = new TreeSet<>(map1.keySet());
        keySet.addAll(map2.keySet());
        for (String key : keySet) {
            Map<String, Object> map = new LinkedHashMap<>();
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                map.put("key", key);
                map.put("oldValue", map1.get(key));
                map.put("status", "removed");
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                map.put("key", key);
                map.put("newValue", map2.get(key));
                map.put("status", "added");
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                map.put("key", key);
                map.put("oldValue", map1.get(key));
                map.put("newValue", map2.get(key));
                map.put("status", "updated");
            } else {
                map.put("key", key);
                map.put("oldValue", map1.get(key));
                map.put("status", "unchanged");
            }
            list.add(map);
        }
        return list;
    }
}
