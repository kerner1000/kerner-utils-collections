package net.sf.kerner.utils.collections.visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VisitorRememberSeen<T> implements VisitorDefault<T> {

    private final List<T> allElements = new ArrayList<T>();

    public synchronized List<T> getElementsSeen() {
        return Collections.unmodifiableList(allElements);
    }

    public synchronized Void visit(final T element) {
        allElements.add(element);
        return null;
    }

}
