package com.yihaoxing.demo.test.serialize;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author yihaoxing
 * @version 1.0
 */
public class C implements Serializable {

    private String s;
    private C parent;
    private C child;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public C getParent() {
        return parent;
    }

    public void setParent(C parent) {
        this.parent = parent;
    }

    public C getChild() {
        return child;
    }

    public void setChild(C child) {
        this.child = child;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        C c = (C) o;
        return Objects.equals(s, c.s) && Objects.equals(parent, c.parent) && Objects.equals(child, c.child);
    }
}
