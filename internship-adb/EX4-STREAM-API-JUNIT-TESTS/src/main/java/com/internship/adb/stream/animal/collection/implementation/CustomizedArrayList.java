package com.internship.adb.stream.animal.collection.implementation;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@NoArgsConstructor
public class CustomizedArrayList<E> extends ArrayList<E> {

    public CustomizedArrayList(Collection<? extends E> elements) {
        addAll(elements);
    }

    @Override
    public String toString() {
        Iterator<E> it = this.iterator();
        int index = -1;
        if (!it.hasNext()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while(true) {
                index++;
                E e = it.next();
                sb.append('[').append(index).append("] ");
                sb.append(e == this ? "(this Collection)" : e);
                if (!it.hasNext()) {
                    return sb.append(']').toString();
                }
                sb.append(',').append('\n');
            }
        }
    }
}
