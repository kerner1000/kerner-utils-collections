package net.sf.kerner.utils.collections;

public class ExceptionRuntimeDuplicateElement extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -8323720771155415135L;

    public ExceptionRuntimeDuplicateElement() {

    }

    public ExceptionRuntimeDuplicateElement(final String message) {
        super(message);

    }

    public ExceptionRuntimeDuplicateElement(final String message, final Throwable cause) {
        super(message, cause);

    }

    public ExceptionRuntimeDuplicateElement(final Throwable cause) {
        super(cause);

    }

}
