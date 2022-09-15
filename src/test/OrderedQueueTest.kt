import junit.framework.TestCase.*
import org.junit.Test

class Car(val year: Int, val make: String, val colour: String)
val myCar1 = Car(1950, "Cadillac","Pink" )
val myCar2 = Car(1970, "Datsun", "Cherry")
val myCar3 = Car(1985, "DeLorean", "Silver")
val myCar4 = Car(1930, "Ford", "Black")
val myCar5 = Car(1960, "Porsche", "White")

class OrderedQueueTest {
    private val numberOrdering: (a: Car, b: Car) -> Int = { a, b ->
        if (a.year < b.year) {
            1
        } else if (a.year == b.year) {
            0
        } else {
            -1
        }
    }
    private val stringOrderingMake: (a: Car, b: Car) -> Int = { a, b ->
        if (a.make < b.make) {
            1
        } else if (a.make == b.make) {
            0
        } else {
            -1
        }
    }
    private val stringOrderingColour: (a: Car, b: Car) -> Int = { a, b ->
        if (a.colour < b.colour) {
            1
        } else if (a.colour == b.colour) {
            0
        } else {
            -1
        }
    }

    @Test
    fun addsItemToOrderedQueueNumber() {
        val arr = OrderedQueue(numberOrdering)
        arr.add(myCar1)
        arr.add(myCar2)
        arr.add(myCar3)
        arr.add(myCar4)
        arr.add(myCar5)
        assertEquals(arr.toList(), listOf(myCar4, myCar2, myCar1, myCar3,
            myCar5))
    }

    @Test
    fun addsItemToOrderedQueueStringMake() {
        val arr = OrderedQueue(stringOrderingMake)
        arr.add(myCar1)
        arr.add(myCar2)
        arr.add(myCar3)
        arr.add(myCar4)
        arr.add(myCar5)
        assertEquals(arr.toList(), listOf(myCar1, myCar2, myCar3, myCar4,
            myCar5))
    }

    @Test
    fun addsItemToOrderedQueueStringColour() {
        val arr = OrderedQueue(stringOrderingColour)
        arr.add(myCar1)
        arr.add(myCar2)
        arr.add(myCar3)
        arr.add(myCar4)
        arr.add(myCar5)
        assertEquals(arr.toList(), listOf(myCar4, myCar2, myCar1, myCar3,
            myCar5))
    }

    @Test
    fun removeLastItem() {
        val arr = OrderedQueue(numberOrdering)
        arr.add(myCar1)
        arr.add(myCar2)
        arr.add(myCar3)
        val removed = arr.remove()
        assertEquals(removed, myCar2)
    }

    @Test
    fun removeLastItemFindsEmptyQueue() {
        val arr = OrderedQueue(numberOrdering)
        try {
            arr.remove()
            fail()
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "The queue is empty!")
        }
    }

    @Test
    fun returnsFirstItemInOQ() {
        val arr = OrderedQueue(numberOrdering)
        arr.add(myCar1)
        arr.add(myCar2)
        arr.add(myCar3)
        val firstItem = arr.peek()
        assertEquals(firstItem, myCar2)
    }

    @Test
    fun throwsExceptionIfFirstItemIsEmpty() {
        val arr = OrderedQueue(numberOrdering)
        try {
            arr.peek()
            fail()
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "The queue is empty!")
        }
    }

    @Test
    fun countsOrderedQueue() {
        val arr = OrderedQueue(numberOrdering)
        arr.add(myCar3)
        arr.add(myCar2)
        arr.add(myCar1)
        val size = arr.size()
        assertEquals(size, 3)
    }

    @Test
    fun returnsTrueIfOqIsEmpty() {
        val arr = OrderedQueue(numberOrdering)
        val emptyQueue = arr.isEmpty()
        assertEquals(emptyQueue, true)
    }

    // new class Cars, sort by ...whatever. Numeric field first, then non-
// numeric field.
}
