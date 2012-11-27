package net.sf.kerner.utils.collections.equalator;

import java.util.List;

import net.sf.kerner.utils.collections.Equalator;

public interface EqualatorApplier<T> extends Equalator<T> {

    void addEqualator(Equalator<T> equalator);

    List<Equalator<T>> getEqualators();

}
