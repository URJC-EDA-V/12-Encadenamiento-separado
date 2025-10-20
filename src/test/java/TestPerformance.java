import es.urjc.grafo.EDA.mapas.Mapa;
import es.urjc.grafo.EDA.mapas.MapaEncadenamientoSeparado;
import es.urjc.grafo.EDA.mapas.SimpleMapa;
import es.urjc.grafo.EDA.mapas.UnsortedArrayMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.Map.Entry;

public class TestPerformance {

    int initialValues = 50000;
    int updates = 50000;

    @Test
    @Order(1)
    void timeConsumptionOfMapaEncadenamientoSeparado() {
        Random random = new Random();
        Mapa<Integer, Integer> freq = new MapaEncadenamientoSeparado<>();
        Instant start = Instant.now();
        for (int i = 0; i < initialValues; i++) {
            freq.put(random.nextInt(), random.nextInt());
        }

        for (int i = 0; i < updates; i++) {
            int key = random.nextInt();
            if (!freq.containsKey(key)) {
                freq.put(key, random.nextInt());
                freq.remove(key);
            } else {
                freq.put(key, random.nextInt());
            }
        }
        Duration duration = Duration.between(start, Instant.now());
        System.out.printf("With MapaEncadenamientoSeparado, the test took %d.%d seconds%n", duration.toSecondsPart(), duration.toMillisPart());
    }

    @Test
    @Order(2)
    void timeConsumptionOfSimpleMapa() {
        Random random = new Random();
        Mapa<Integer, Integer> freq = new SimpleMapa<>();
        Instant start = Instant.now();
        for (int i = 0; i < initialValues; i++) {
            freq.put(random.nextInt(), random.nextInt());
        }

        for (int i = 0; i < updates; i++) {
            int key = random.nextInt();
            if (!freq.containsKey(key)) {
                freq.put(key, random.nextInt());
                freq.remove(key);
            } else {
                freq.put(key, random.nextInt());
            }
        }
        Duration duration = Duration.between(start, Instant.now());
        System.out.printf("With SimpleMapa, the test took %d.%d seconds%n", duration.toSecondsPart(), duration.toMillisPart());
    }

    @Test
    @Order(3)
    void timeConsumptionOfHashMap() {
        Random random = new Random();
        Map<Integer, Integer> freq = new HashMap<>();
        Instant start = Instant.now();
        for (int i = 0; i < initialValues; i++) {
            freq.put(random.nextInt(), random.nextInt());
        }

        for (int i = 0; i < updates; i++) {
            int key = random.nextInt();
            if (!freq.containsKey(key)) {
                freq.put(key, random.nextInt());
                freq.remove(key);
            } else {
                freq.put(key, random.nextInt());
            }
        }
        Duration duration = Duration.between(start, Instant.now());
        System.out.printf("With HashMap, the test took %d.%d seconds%n", duration.toSecondsPart(), duration.toMillisPart());
    }

    @Test
    @Order(4)
    void timeConsumptionOfUnsortedArrayMap() {
        Random random = new Random();
        Mapa<Integer, Integer> freq = new UnsortedArrayMap<>();
        Instant start = Instant.now();
        for (int i = 0; i < initialValues; i++) {
            freq.put(random.nextInt(), random.nextInt());
        }

        for (int i = 0; i < updates; i++) {
            int key = random.nextInt();
            if (!freq.containsKey(key)) {
                freq.put(key, random.nextInt());
                freq.remove(key);
            } else {
                freq.put(key, random.nextInt());
            }
        }
        Duration duration = Duration.between(start, Instant.now());
        System.out.printf("With UnsortedArrayMap, the test took %d.%d seconds%n", duration.toSecondsPart(), duration.toMillisPart());
    }

}
