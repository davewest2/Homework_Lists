import junit.framework.TestCase.*
import org.junit.Test

class OrderedQueueTest {

    @Test
    fun addsItemToOrderedQueue() {
        var arr = OrderedQueue()
        arr.addItemToOrderedQueue(3)
        arr.addItemToOrderedQueue(1)
        arr.addItemToOrderedQueue(5)
        arr.addItemToOrderedQueue(2)
        arr.addItemToOrderedQueue(4)
        assertEquals(arr.toList(), listOf(1,2,3,4,5))
    }

    @Test
    fun removeLastItem() {
        var arr = OrderedQueue()
        arr.addItemToOrderedQueue(1)
        arr.addItemToOrderedQueue(2)
        arr.addItemToOrderedQueue(3)
        val removed = arr.removeFromQueue()
        assertEquals(removed, 1)
    }

    @Test
    fun removeLastItemFindsEmptyQueue() {
        val arr = OrderedQueue()
        try {
            arr.removeFromQueue()
            fail()
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "The queue is empty!")
        }
    }

    @Test
    fun returnsFirstItemInOQ() {
        var arr = OrderedQueue()
        arr.addItemToOrderedQueue(1)
        arr.addItemToOrderedQueue(2)
        arr.addItemToOrderedQueue(3)
        val firstItem = arr.peek()
        assertEquals(firstItem, 1)
    }

    @Test
    fun throwsExceptionIfFirstItemIsEmpty() {
        val arr = OrderedQueue()
        try {
            arr.peek()
            fail()
        } catch (e: IllegalArgumentException){
            assertEquals(e.message, "The queue is empty!")
        }
    }

    @Test
    fun countsOrderedQueue() {
        var arr = OrderedQueue()
        arr.addItemToOrderedQueue(1)
        arr.addItemToOrderedQueue(1)
        arr.addItemToOrderedQueue(1)
        val size = arr.sizeOQ()
        assertEquals(size, 3)
    }

    @Test
    fun returnsTrueIfOqIsEmpty() {
        val arr = OrderedQueue()
        val emptyQueue = arr.isEmptyOQ()
        assertEquals(emptyQueue, true)
    }
}