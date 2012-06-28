package net.sf.kerner.utils.collections.list.visitor;

public interface VisitorApplierList<R, E> {

    void addVisitor(VisitorList<R, E> visitor);

    void clearVisitors();

    void visit(E e, int index);

}
