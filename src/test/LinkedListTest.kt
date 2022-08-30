import junit.framework.TestCase.*
import org.junit.Test

class LinkedListTest {
    @Test
    fun buildsAnEmptyList() {
        val arr = LinkedList()
        assertEquals(arr.toList(), listOf<Int>())
    }

    @Test
    fun addsOneElement() {
        val arr = LinkedList()
        arr.add(3)
        assertEquals(arr.toList(), listOf(3))
    }

    @Test
    fun addsMultipleElements() {
        val arr = LinkedList()
        arr.add(3)
        arr.add(1)
        assertEquals(arr.toList(), listOf(3, 1))
    }

    @Test
    fun containsAnItem() {
        val arr = LinkedList()
        arr.add(3)
        arr.add(1)
        assert(arr.contains(1))
    }

    @Test
    fun doesNotContainsAnItem() {
        val arr = LinkedList()
        arr.add(3)
        arr.add(1)
        assert(!arr.contains(0))
    }

    @Test
    fun removesAnItem() {
        val arr = LinkedList()
        arr.add(3)
        arr.add(4)
        arr.remove(3)
        assertEquals(arr.toList(), listOf(4))
    }

    @Test
    fun removeMultipleItems() {
        val arr = LinkedList()
        arr.add(3)
        arr.add(1)
        arr.add(1)
        arr.remove(1)
        assertEquals(arr.toList(), listOf(3))
    }

    @Test
    fun removesNothing() {
        val arr = LinkedList()
        arr.add(3)
        arr.add(1)
        arr.remove(2)
        assertEquals(arr.toList(), listOf(3, 1))
    }

    @Test
    fun findsFirst() {
        val arr = LinkedList()
        arr.add(1)
        arr.add(2)
        val first = arr.first()
        assertEquals(first, 1)
    }

    @Test
    fun throwsWhenFirstIsNull() {
        val arr = LinkedList()
        try {
            arr.first()
            fail()
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "There is no list!")
        }

    }

    @Test
    fun checksIfNotEmpty() {
        val arr = LinkedList()
        arr.add(1)
        val empty = arr.isEmpty()
        assertEquals(empty, false )
    }

    @Test
    fun checksIfEmpty() {
        val arr = LinkedList()
        val empty = arr.isEmpty()
        assertEquals(empty, true )
    }

    @Test
    fun findsLast(){
        val arr = LinkedList()
        arr.add(1)
        arr.add(2)
        arr.add(3)
        val lastVal = arr.last()
        assertEquals(lastVal, 3 )
    }
    @Test
    fun findsLastEmpty() {
        val arr = LinkedList()
        try {
            arr.last()
            fail()
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "There is no list!")
        }
    }

    @Test
    fun returnsSize() {
        val arr = LinkedList()
        arr.add(1)
        //arr.add(2)
        //arr.add(3)
        val arraySize = arr.sizeList()
        assertEquals(arraySize, 1)
    }
}
