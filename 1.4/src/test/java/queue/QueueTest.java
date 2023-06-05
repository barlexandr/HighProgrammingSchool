package queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void ternTheQueue_test() {
        var queue = new Queue<>();
        queue.enqueue(1.0);
        queue.enqueue("2");
        queue.enqueue(3.0);

        queue.ternTheQueue(1);

        var result1 = queue.dequeue();
        var result2 = queue.dequeue();
        var result3 = queue.dequeue();
        var result4 = queue.dequeue();

        assertEquals(result1, "2");
        assertEquals(result2, 3.0);
        assertEquals(result3, 1.0);
        assertNull(result4);
    }

    @Test
    void ternTheQueueCircle_test() {
        var queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue("2");
        queue.enqueue(3.0);

        queue.ternTheQueue(3);

        var result1 = queue.dequeue();
        var result2 = queue.dequeue();
        var result3 = queue.dequeue();
        var result4 = queue.dequeue();

        assertEquals(result1, 1);
        assertEquals(result2, "2");
        assertEquals(result3, 3.0);
        assertNull(result4);
    }

    @Test
    void test_enqueue() {
        var queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue("2");
        queue.enqueue(3.0);

        var result1 = queue.dequeue();
        var result2 = queue.dequeue();
        queue.enqueue(10);
        var result3 = queue.dequeue();
        var result4 = queue.dequeue();
        var result5 = queue.dequeue();

        assertEquals(result1, 1);
        assertEquals(result2, "2");
        assertEquals(result3, 3.0);
        assertEquals(result4, 10);
        assertNull(result5);
    }

}