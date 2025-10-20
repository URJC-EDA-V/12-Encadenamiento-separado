import es.urjc.grafo.EDA.mapas.MapaEncadenamientoSeparado;
import org.junit.jupiter.api.Test;

import java.security.InvalidKeyException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class TestMapaEncadenamientoSeparado {


    private MapaEncadenamientoSeparado<String, Integer> instance;

    public TestMapaEncadenamientoSeparado() {
    }

    /**
     * Test of size method, of class MapaEncadenamientoSeparado.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        instance = new MapaEncadenamientoSeparado<>();
        assertEquals(0, instance.size());

        instance.put("Jose", 912127659);
        instance.put("Angel", 912127658);
        instance.put("Abraham", 912127657);
        instance.put("Mayte", 912127656);
        instance.put("Raul", 912127655);
        assertEquals(5, instance.size());

        instance.remove("Angel");
        assertEquals(4, instance.size());
    }

    /**
     * Test of isEmpty method, of class MapaEncadenamientoSeparado.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        instance = new MapaEncadenamientoSeparado<>();
        assertTrue(instance.isEmpty());
        instance.put("Jose", 912127654);
        assertFalse(instance.isEmpty());
        instance.remove("Jose");
        assertTrue(instance.isEmpty());
    }


    /**
     * Test of get method, of class MapaEncadenamientoSeparado.
     */
    @Test
    public void testPutAndGet() {
        instance = new MapaEncadenamientoSeparado<>();

        assertNull(instance.get("Jose"));

        instance.put("Jose", 912127654);
        instance.put("Mayte", 912127651);
        instance.put("Andres", 912127624);
        assertEquals(3, instance.size());
        assertEquals(912127654, instance.get("Jose").intValue());
        assertEquals(912127624, instance.get("Andres").intValue());
        instance.put("Jose", 5);
        assertEquals(5, instance.get("Jose").intValue());
    }


    /**
     * Test of remove method, of class MapaEncadenamientoSeparado.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        instance = new MapaEncadenamientoSeparado<>();
        instance.put("Jose", 912127651);
        instance.put("Andres", 912127624);
        instance.remove("Andres");
        assertEquals(1, instance.size());
        assertEquals(912127651, instance.get("Jose").intValue());
        assertNull(instance.get("Andres"));
    }


    /**
     * Test of keys method, of class MapaEncadenamientoSeparado.
     */
    @Test
    public void testKeys() {
        System.out.println("keys");
        Set<String> l = new HashSet<>();
        instance = new MapaEncadenamientoSeparado<>();
        instance.put("Angel", 912127654);
        l.add("Angel");
        instance.put("Jose", 912127651);
        l.add("Jose");
        instance.put("Andres", 912127624);
        l.add("Andres");
        Iterable<String> keys = instance.keys();


        assertEquals(3, l.size());

        for (String s : keys) {
            assertTrue(l.contains(s));
        }
    }

    /**
     * Test of values method, of class MapaEncadenamientoSeparado.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        instance = new MapaEncadenamientoSeparado<>();
        ArrayList<Integer> l = new ArrayList<>();
        instance.put("Angel", 912127654);
        l.add(912127654);
        instance.put("Jose", 912127651);
        l.add(912127651);
        instance.put("Andres", 912127624);
        l.add(912127624);
        Iterable<Integer> values = instance.values();


        for (Integer s : values) {
            assertTrue(l.contains(s));
        }

        assertEquals(3, l.size());

    }

    /**
     * Test of entries method, of class MapaEncadenamientoSeparado.
     */
    @Test
    public void testEntries() {
        System.out.println("entries");
        instance = new MapaEncadenamientoSeparado<>();
        ArrayList<Map.Entry<String, Integer>> l = new ArrayList<>();
        instance.put("Angel", 912127654);
        instance.put("Jose", 912127651);
        instance.put("Andres", 912127624);
        Iterable<Map.Entry<String, Integer>> entries = instance.entries();


        for (Map.Entry<String, Integer> i : entries) {
            l.add(i);
        }

        assertEquals(3, l.size());

        for (Map.Entry<String, Integer> e : entries) {
            assertTrue(l.contains(e));
        }
    }


    /**
     * Test of rehash method, of class MapaEncadenamientoSeparado.
     */
    @Test
    public void testRehash() {
        System.out.println("rehash");
        MapaEncadenamientoSeparado<Integer, Integer> listin1 = new MapaEncadenamientoSeparado<>(10);
        final int NUM_ENTRIES = 1000;

        // Testing size
        for (int cont = 0; cont < NUM_ENTRIES; cont++) {
            listin1.put(cont, cont);
        }
        assertEquals(NUM_ENTRIES, listin1.size());
    }

}
