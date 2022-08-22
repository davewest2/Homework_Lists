import junit.framework.TestCase.assertEquals
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
        assertEquals(arr.toList(), arrayOf(3))
    }

    @Test
    fun addsMultipleElements() {
        val arr = LinkedList()
        arr.add(3)
        arr.add(1)
        assertEquals(arr.toList(), arrayOf(3, 1))
    }

    @Test
    fun removesAnItem() {
        val arr = LinkedList()
        arr.add(3)
        arr.add(4)
        arr.remove(3)
        assertEquals(arr.toList(), arrayOf(4))
    }

    @Test
    fun removeMultipleItems() {
        val arr = LinkedList()
        arr.add(3)
        arr.add(1)
        arr.add(1)
        arr.remove(1)
        assertEquals(arr.toList(), arrayOf(3))
    }

    @Test
    fun removesNothing() {
        val arr = LinkedList()
        arr.add(3)
        arr.add(1)
        arr.remove(2)
        assertEquals(arr.toList(), arrayOf(3, 1))
    }
}
