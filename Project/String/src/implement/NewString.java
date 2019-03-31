package implement;

import exceptions.NewStringIndexOutOfBoundsException;

import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Arrays;

public final class NewString implements Serializable, Comparable<NewString>, CharSequence {

    /**
     * 이 값은 character 저장소로 사용된다.
     **/
    private final char[] value;

    /**
     * newString 에 대한 hash code 를 캐시
     **/
    private int hash;

    /**
     * 상호 운용성(interoperability) 를 위해 JDK 1.0.2 의 serialVersionUID 를 사용
     **/
    private static final long serialVersionUID = -6849794470754667710L;

    private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[0];

    // FIXME "" 원리 파악
    public NewString() {
        this.value = "".toCharArray();
    }

    public NewString(NewString original) {
        this.value = original.value;
        this.hash = original.hash;
    }

    public NewString(char value[]) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public NewString(char value[], int offset, int count) {
        if (offset < 0) {
            throw new NewStringIndexOutOfBoundsException(offset);
        }

        if (count <= 0) {
            if (count < 0) {
                throw new StringIndexOutOfBoundsException(count);
            }

            if (offset <= value.length) {
                this.value = "".toCharArray();
                return;
            }
        }

        if (offset > value.length - count) {
            throw new StringIndexOutOfBoundsException(offset + count);
        }
        this.value = Arrays.copyOfRange(value, offset, offset + count);
    }

    @Override
    public int length() {
        return value.length;
    }

    @Override
    public char charAt(int index) {
        if ((index < 0) || (index >= value.length)) {
            throw new NewStringIndexOutOfBoundsException(index);
        }
        return value[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        // FIXME substring 구현 시 구현 열
        return null;
    }

    @Override
    public int compareTo(NewString o) {
        int len1 = value.length;
        int len2 = o.value.length;
        int lim = Math.min(len1, len2);
        char v1[] = value;
        char v2[] = o.value;

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }

    public String getString() {
        return String.valueOf(value);
    }
}
