package com.my.scala.chapter31;

import java.util.Collection;
import java.util.Vector;

public class Wild {
    Collection<?> contents() {
        Collection<String> stuff = new Vector<String>();
        stuff.add("a");
        stuff.add("b");
        stuff.add("see");
        return stuff;
    }
}
