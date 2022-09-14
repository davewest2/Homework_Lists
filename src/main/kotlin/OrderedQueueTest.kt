import junit.framework.TestCase.*
import org.junit.Test

class Car(val year: Int, val make: String, val colour: String)
val myCar1 = Car(1950, "Cadillac","Pink" )
val myCar2 = Car(1970, "Datsun", "Cherry")
val myCar3 = Car(1985, "DeLorean", "Silver")
val myCar4 = Car(1930, "Ford", "Black")
val myCar5 = Car(1960, "Porsche", "White")

class OrderedQueueTest {
    val numberOrdering: (a: Car, b: Car) -> Int = { a, b ->
        if (a.year < b.year) {
            1
        } else if (a.year == b.year) {
            0
        } else {
            -1
        }
    }
    val stringOrderingMake: (a: Car, b: Car) -> Int = { a, b ->
        if (a.make < b.make) {
            1
        } else if (a.make == b.make) {
            0
        } else {
            -1
        }
    }
    val stringOrderingColour: (a: Car, b: Car) -> Int = { a, b ->
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
        var arr = OrderedQueue(numberOrdering)
        arr.addItemToOrderedQueue(myCar1)
        arr.addItemToOrderedQueue(myCar2)
        arr.addItemToOrderedQueue(myCar3)
        arr.addItemToOrderedQueue(myCar4)
        arr.addItemToOrderedQueue(myCar5)
        assertEquals(arr.toList(), listOf(myCar4, myCar2, myCar1, myCar3,
            myCar5))
    }

    @Test
    fun addsItemToOrderedQueueStringMake() {
        var arr = OrderedQueue(stringOrderingMake)
        arr.addItemToOrderedQueue(myCar1)
        arr.addItemToOrderedQueue(myCar2)
        arr.addItemToOrderedQueue(myCar3)
        arr.addItemToOrderedQueue(myCar4)
        arr.addItemToOrderedQueue(myCar5)
        assertEquals(arr.toList(), listOf(myCar1, myCar2, myCar3, myCar4,
            myCar5))
    }

    @Test
    fun addsItemToOrderedQueueStringColour() {
        var arr = OrderedQueue(stringOrderingColour)
        arr.addItemToOrderedQueue(myCar1)
        arr.addItemToOrderedQueue(myCar2)
        arr.addItemToOrderedQueue(myCar3)
        arr.addItemToOrderedQueue(myCar4)
        arr.addItemToOrderedQueue(myCar5)
        assertEquals(arr.toList(), listOf(myCar4, myCar2, myCar1, myCar3,
            myCar5))
    }

    @Test
    fun removeLastItem() {
        var arr = OrderedQueue(numberOrdering)
        arr.addItemToOrderedQueue(myCar1)
        arr.addItemToOrderedQueue(myCar2)
        arr.addItemToOrderedQueue(myCar3)
        val removed = arr.removeFromQueue()
        assertEquals(removed, myCar2)
    }

    @Test
    fun removeLastItemFindsEmptyQueue() {
        var arr = OrderedQueue(numberOrdering)
        try {
            arr.removeFromQueue()
            fail()
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "The queue is empty!")
        }
    }

    @Test
    fun returnsFirstItemInOQ() {
        var arr = OrderedQueue(numberOrdering)
        arr.addItemToOrderedQueue(myCar1)
        arr.addItemToOrderedQueue(myCar2)
        arr.addItemToOrderedQueue(myCar3)
        val firstItem = arr.peek()
        assertEquals(firstItem, myCar2)
    }

    @Test
    fun throwsExceptionIfFirstItemIsEmpty() {
        var arr = OrderedQueue(numberOrdering)
        try {
            arr.peek()
            fail()
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "The queue is empty!")
        }
    }

    @Test
    fun countsOrderedQueue() {
        var arr = OrderedQueue(numberOrdering)
        arr.addItemToOrderedQueue(myCar3)
        arr.addItemToOrderedQueue(myCar2)
        arr.addItemToOrderedQueue(myCar1)
        val size = arr.sizeOQ()
        assertEquals(size, 3)
    }

    @Test
    fun returnsTrueIfOqIsEmpty() {
        var arr = OrderedQueue(numberOrdering)
        val emptyQueue = arr.isEmptyOQ()
        assertEquals(emptyQueue, true)
    }

    // new class Cars, sort by ...whatever. Numeric field first, then non
// numeric field.
}
