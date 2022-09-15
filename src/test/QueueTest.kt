import junit.framework.TestCase.*
import org.junit.Test

class QueueTest {

    @Test
    fun addsItemToQueue() {
        var arr = Queue<Int>()
        arr.add(1)
        arr.add(2)
        assertEquals(arr.toList(), listOf(2,1))
    }

    @Test
    fun removesFirstInItem() {
        var arr = Queue<Int>()
        arr.add(1)
        arr.add(2)
        arr.add(3)
        println(arr.toList())
        arr.remove()
        println(arr.toList())
        assertEquals(arr.toList(), listOf(3,2))
    }

    @Test
    fun peeksAtQueue() {
        var arr = Queue<Int>()
        arr.add(3)
        arr.add(2)
        arr.add(1)
        arr.peek()
        assertEquals(arr.peek(), 3)
    }

    @Test
    fun returnsLengthOfQueue() {
        var arr = Queue<Int>()
        arr.add(3)
        arr.add(2)
        arr.add(1)
        val size = arr.size()
        println(size)
        assertEquals(size, 3)
    }

    @Test
    fun returnsTrueIfQueueEmpty() {
        val arr = Queue<Int>()
        val emptyQueue = arr.queueIsEmpty()
        assertEquals(emptyQueue, true)
    }
}