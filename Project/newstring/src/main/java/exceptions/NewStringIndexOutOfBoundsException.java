package exceptions;

import implement.NewString;

public class NewStringIndexOutOfBoundsException extends IndexOutOfBoundsException{
    private static final long serialVersionUID = -6762910422159637258L;

    /**
     * no detail message
     */
    public NewStringIndexOutOfBoundsException() {
        super();
    }

    /**
     * specified detail message
     * @param s
     */
    public NewStringIndexOutOfBoundsException(NewString s) {
        super(s.getString());
    }

    /**
     * illegal index argument exception
     * @param index
     */
    public NewStringIndexOutOfBoundsException(int index) {
        super("String index out of range: " + index);
    }
}
