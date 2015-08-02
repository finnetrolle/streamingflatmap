import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiKeyTest {

    private MultiKey key1;
    private MultiKey key2;
    private MultiKey key3;
    private MultiKey key1based;

    @Before
    public void before() {
        String key1a = "key1";
        Integer key1b = 1;
        String key2a = "key1";
        Integer key2b = 1;
        String key3a = "key1";
        Integer key3b = 2;
        key1 = new MultiKey(key1a, key1b);
        key2 = new MultiKey(key2a, key2b);
        key3 = new MultiKey(key3a, key3b);
        key1based = new MultiKey(key1a, key1b);
    }

    @Test
    public void testEquals() throws Exception {
        assertEquals(key1, key2);
        assertEquals(key1, key1based);
        assertEquals(key2, key1based);
        assertNotSame(key1, key3);
        assertNotSame(key2, key3);
        assertNotSame(key1based, key3);
    }

    @Test
    public void testHashCode() throws Exception {
        assertEquals(key1.hashCode(), key2.hashCode());
        assertEquals(key1.hashCode(), key1based.hashCode());
        assertEquals(key2.hashCode(), key1based.hashCode());
        assertNotSame(key1.hashCode(), key3.hashCode());
        assertNotSame(key2.hashCode(), key3.hashCode());
        assertNotSame(key1based.hashCode(), key3.hashCode());
    }
}