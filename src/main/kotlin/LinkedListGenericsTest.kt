import junit.framework.TestCase.*
import org.junit.Test

class LinkedListGenericsTest {
    @Test
    fun buildsAnEmptyList() {
        val arr = LinkedListGenerics<Int>()
        assertEquals(arr.toList(), listOf<Int>())
    }

    @Test
    fun addsOneElement() {
        val arr = LinkedListGenerics<Int>()
        arr.add(3)
        assertEquals(arr.toList(), listOf(3))
    }

    @Test
    fun addsMultipleElements() {
        val arr = LinkedListGenerics<Int>()
        arr.add(3)
        arr.add(1)
        assertEquals(arr.toList(), listOf(3, 1))
    }

    @Test
    fun containsAnItem() {
        val arr = LinkedListGenerics<Int>()
        arr.add(3)
        arr.add(1)
        assert(arr.contains(1))
    }

    @Test
    fun doesNotContainsAnItem() {
        val arr = LinkedListGenerics<Int>()
        arr.add(3)
        arr.add(1)
        assert(!arr.contains(0))
    }

    @Test
    fun removesAnItem() {
        val arr = LinkedListGenerics<Int>()
        arr.add(3)
        arr.add(4)
        arr.remove(3)
        assertEquals(arr.toList(), listOf(4))
    }

    @Test
    fun removeMultipleItems() {
        val arr = LinkedListGenerics<Int>()
        arr.add(3)
        arr.add(1)
        arr.add(1)
        arr.remove(1)
        assertEquals(arr.toList(), listOf(3))
    }

    @Test
    fun removesNothing() {
        val arr = LinkedListGenerics<Int>()
        arr.add(3)
        arr.add(1)
        arr.remove(2)
        assertEquals(arr.toList(), listOf(3, 1))
    }

    @Test
    fun findsFirst() {
        val arr = LinkedListGenerics<Int>()
        arr.add(1)
        arr.add(2)
        val first = arr.first()
        assertEquals(first, 1)
    }

    @Test
    fun throwsWhenFirstIsNull() {
        val arr = LinkedListGenerics<Int>()
        try {
            arr.first()
            fail()
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "There is no list!")
        }
    }

    @Test
    fun checksIfNotEmpty() {
        val arr = LinkedListGenerics<Int>()
        arr.add(1)
        val empty = arr.isEmpty()
        assertEquals(empty, false )
    }

    @Test
    fun checksIfEmpty() {
        val arr = LinkedListGenerics<Int>()
        val empty = arr.isEmpty()
        assertEquals(empty, true )
    }

    @Test
    fun findsLast(){
        val arr = LinkedListGenerics<Int>()
        arr.add(1)
        arr.add(2)
        arr.add(3)
        val lastVal = arr.last()
        assertEquals(lastVal, 3 )
    }

    @Test
    fun findsLastEmpty() {
        val arr = LinkedListGenerics<Int>()
        try {
            arr.last()
            fail()
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "List is empty!")
        }
    }

    @Test
    fun returnsSize() {
        val arr = LinkedListGenerics<Int>()
        arr.add(1)
        //arr.add(2)
        //arr.add(3)
        val arraySize = arr.sizeList()
        assertEquals(arraySize, 1)
    }

    @Test
    fun returnsFromIndex() {
        val arr = LinkedListGenerics<Int>()
        arr.add(1)
        arr.add(25)
        arr.add(39)
        val test = arr.get(2)
        assertEquals(test, 39)
    }

    @Test
    fun throwsWhenGetInvalidIndex() {
        val arr = LinkedListGenerics<Int>()
        arr.add(1)
        try {
            arr.get(2)
            fail()
        } catch (e: ArrayIndexOutOfBoundsException) {
            assertEquals(e.message, "Requested index 2 is larger than list " +
                    "(size 1)")
        }
    }
}