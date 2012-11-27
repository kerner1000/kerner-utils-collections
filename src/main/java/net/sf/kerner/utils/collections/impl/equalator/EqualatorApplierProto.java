package net.sf.kerner.utils.collections.impl.equalator;

import java.util.List;

import net.sf.kerner.utils.collections.Equalator;
import net.sf.kerner.utils.collections.applier.ApplierAbstract;
import net.sf.kerner.utils.collections.equalator.EqualatorApplier;
import net.sf.kerner.utils.collections.list.impl.UtilList;

public class EqualatorApplierProto<T> extends ApplierAbstract implements EqualatorApplier<T> {

    private final List<Equalator<T>> equalators = UtilList.newList();

    public EqualatorApplierProto() {
        super();
    }

    public EqualatorApplierProto(final TYPE type) {
        super(type);
    }

    public void addEqualator(final Equalator<T> equalator) {
        this.equalators.add(equalator);
    }

    public boolean areEqual(final T o1, final T o2) {
        switch (type) {
        case ALL:
            for (final Equalator<T> e : equalators) {
                if (e.areEqual(o1, o2)) {
                    // ok
                } else {
                    return false;
                }
            }
            return true;
        case ONE:
            for (final Equalator<T> e : equalators) {
                if (e.areEqual(o1, o2)) {
                    return true;
                } else {
                    // see what others say
                }
            }
            return false;
        default:
            throw new RuntimeException("unknown type " + type);
        }
    }

    public void clear() {
        this.equalators.clear();
    }

    public List<Equalator<T>> getEqualators() {
        return this.equalators;
    }

}
