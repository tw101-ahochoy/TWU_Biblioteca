package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by manderso on 4/29/14.
 */
public class StringJoiner {
    public String join(Collection<String> strings) {
        if (strings.size() == 0){
            return "";
        }

        List<String> otherStrings = new ArrayList<String>(strings);
        String joinedStrings = otherStrings.remove(0);

        for (String string : otherStrings) {
            joinedStrings += "\n" + string;
        }
        return joinedStrings;
    }
}
