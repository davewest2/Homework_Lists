import junit.framework.TestCase.*
import org.junit.Test

class QueueTest {

    @Test
    fun addsItemToQueue() {
        var arr = Queue()
        arr.addToQueue(1)
        arr.addToQueue(2)
        assertEquals(arr.toList(), listOf(2,1))
    }

    @Test
    fun removesFirstInItem() {
        var arr = Queue()
        arr.addToQueue(1)
        arr.addToQueue(2)
        arr.addToQueue(3)
        println(arr.toList())
        arr.removeFromQueue()
        println(arr.toList())
        assertEquals(arr.toList(), listOf(3,2))
    }

    @Test
    fun peeksAtQueue() {
        var arr = Queue()
        arr.addToQueue(3)
        arr.addToQueue(2)
        arr.addToQueue(1)
        arr.peek()
        assertEquals(arr.peek(), 1)
    }

    @Test
    fun returnsLengthOfQueue() {
        var arr = Queue()
        arr.addToQueue(3)
        arr.addToQueue(2)
        arr.addToQueue(1)
        val size = arr.sizeOfQueue()
        println(size)
        assertEquals(size, 3)
    }

    @Test
    fun returnsTrueIfQueueEmpty() {
        val arr = Queue()
        val emptyQueue = arr.queueIsEmpty()
        assertEquals(emptyQueue, true)
    }
}