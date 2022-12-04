package com.internship.adb.busses.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Shuffler<T> {

    public List<T> shuffle(T[] t) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, t);
        return shuffle(list);
    }

    public List<T> shuffle(List<T> list) {
        Collections.shuffle(list);
        return list;
    }
}