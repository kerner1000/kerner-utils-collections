package net.sf.kerner.utils.collections.visitor;


public interface VisitorApplier<R, E> {

    void addVisitor(Visitor<R, E> visitor);

    void clearVisitors();

    void visit(E e);

}
