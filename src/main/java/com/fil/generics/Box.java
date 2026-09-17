package com.fil.generics;

public class Box <T,V>{
    T t;
    V v;

    public Box(T t, V v) {
        this.t = t;
        this.v = v;
    }

    public Box<V,T> swap(){
        return new Box<>(v,t);
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
