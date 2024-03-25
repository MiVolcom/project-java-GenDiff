package hexlet.code;

import com.fasterxml.jackson.annotation.JsonInclude;

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
                list.add(new Status(key,  map1.get(key), null, Status.DELETED));
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

    public static final class Status {

        public static final String DELETED = "deleted";
        public static final String ADDED = "added";
        public static final String CHANGED = "updated";
        public static final String UNCHANGED = "unchanged";

        private Object key;
        private Object oldValue;
        private Object newValue;
        private String status;


        Status(String keykey, Object oldvalue, Object newvalue, String statusname) {
            key = keykey;
            oldValue = oldvalue;
            newValue = newvalue;
            status = statusname;
        }

        public Object getKey() {
            return key;
        }

        public String getStatus() {
            return status;
        }

        public Object getOldValue() {
            return oldValue;
        }

        public Object getNewValue() {
            return newValue;
        }
    }
}
