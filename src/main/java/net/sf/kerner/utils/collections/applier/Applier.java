package net.sf.kerner.utils.collections.applier;

public interface Applier {

    static enum TYPE {
        ALL, ONE;
    }

    void clear();

}
