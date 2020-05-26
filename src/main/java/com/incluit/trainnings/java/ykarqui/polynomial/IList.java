package com.incluit.trainnings.java.ykarqui.polynomial;

public interface IList {
    void add(int x);

    boolean contains(int x);

    int get(int index);

    boolean isEmpty();

    int size();

    Iterator iterator();
    
}