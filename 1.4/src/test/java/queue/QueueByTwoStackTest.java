package queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueByTwoStackTest {

    @Test
    void dequeue() {
        var queue = new QueueByTwoStack<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        var result1 = queue.dequeue();
        var result2 = queue.dequeue();
        var result3 = queue.dequeue();
        queue.enqueue(6);
        var result4 = queue.dequeue();
        var result5 = queue.dequeue();
        queue.enqueue(7);
        var result6 = queue.dequeue();
        var result7 = queue.dequeue();
        var result8 = queue.dequeue();
        queue.enqueue(8);
        var result9 = queue.dequeue();


        assertEquals(result1, 1);
        assertEquals(result2, 2);
        assertEquals(result3, 3);
        assertEquals(result4, 4);
        assertEquals(result5, 5);
        assertEquals(result6, 6);
        assertEquals(result7, 7);
        assertNull(result8);
        assertEquals(result9, 8);
    }
}