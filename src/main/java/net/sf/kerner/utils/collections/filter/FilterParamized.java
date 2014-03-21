package net.sf.kerner.utils.collections.filter;

public abstract class FilterParamized<T, P> implements Filter<T> {

    private P param;

    public FilterParamized(final P param) {
        this.param = param;
    }

    public synchronized P getParam() {
        return param;
    }

    public synchronized void setParam(final P param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + getParam();
    }

}
