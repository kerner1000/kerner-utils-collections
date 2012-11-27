package net.sf.kerner.utils.collections.applier;

public abstract class ApplierAbstract implements Applier {

    public static TYPE DEFAULT_FILTER_TYPE = TYPE.ALL;

    protected final TYPE type;

    public ApplierAbstract() {
        super();
        this.type = DEFAULT_FILTER_TYPE;
    }

    public ApplierAbstract(final TYPE type) {
        super();
        this.type = type;
    }

}
