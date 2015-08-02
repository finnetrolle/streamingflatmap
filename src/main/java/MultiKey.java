import java.util.Arrays;

/**
 * Created by finnetrolle on 02.08.2015.
 */
public class MultiKey {

    private Object[] keys;

    public MultiKey(Object... keys) {
        this.keys = new Object[keys.length];
        for (int i = 0; i < keys.length; ++i) {
            this.keys[i] = keys[i];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MultiKey)) return false;

        MultiKey that = (MultiKey) o;

        if (!Arrays.equals(keys, that.keys)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return keys != null ? Arrays.hashCode(keys) : 0;
    }

    @Override
    public String toString() {
        return "MultiKey{" +
                "keys=" + Arrays.toString(keys) +
                '}';
    }
}
