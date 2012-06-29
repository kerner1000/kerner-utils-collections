package net.sf.kerner.utils.collections.visitor;

public interface VisitorApplier<R, E> extends Visitor<R, E> {

    void addVisitor(Visitor<R, E> visitor);

    void clearVisitors();

}
