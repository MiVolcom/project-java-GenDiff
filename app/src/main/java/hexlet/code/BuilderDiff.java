package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

public class BuilderDiff {
    public static List<Status> getDiff(Map<String, Object> map1, Map<String, Object> map2) {
        List<Status> list = new ArrayList<>();
        Set<String> keySet = new TreeSet<>(map1.keySet());
        keySet.addAll(map2.keySet());
        for (String key : keySet) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                list.add(new Status(key, map1.get(key), null, Status.DELETED));
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                list.add(new Status(key, null, map2.get(key), Status.ADDED));
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                list.add(new Status(key, map1.get(key), map2.get(key), Status.CHANGED));
            } else {
                list.add(new Status(key, map1.get(key), null, Status.UNCHANGED));
            }

        }
        return list;
    }
}


