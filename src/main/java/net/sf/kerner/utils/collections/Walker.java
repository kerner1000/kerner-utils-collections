package net.sf.kerner.utils.collections;

public interface Walker<E> {

    void beforeWalk();

    void afterWalk();

}
