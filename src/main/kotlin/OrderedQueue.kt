class OrderedQueue<T>(val ordering: (a: T, b: T) -> Int) {
    // establishes an object which is an isolated node
    // OrderedQueue will need to be updated to take a `sort(a: T, b: T): Int` function to
    //be able to sort non-numeric types
    private var head: Node<T>? = null

    // class definition of what a node looks like: a value and a pointer to
    // the next link (which is another node)
    class Node<T>(var value: T, var nextLink: Node<T>?)

/* Ordered Queue Homework
    An ordered queue (or priority queue) is a specialised queue that maintains an internal ordering of
    items. Any item can be added to an ordered queue, but the lowest value in the queue will always be
    returned first.  */
//The implementation of OrderedQueue will need to be updated to take a `sort(a: T, b: T): Int` function to
//be able to sort non-numeric types


    fun addItemToOrderedQueue(item: T) {
        var current = head
        var prev: Node<T>? = null
        if (head == null) {
            head = Node(item, null)
        } else {
            while (current != null) {
                // if the item is less than the current node's value then
                // this block establishes a new node with new value pointed
                // to by previous and pointing to current
                if (ordering(item, current.value) == 1) {
                        break
                    } else if (ordering(item, current.value) == 0){
                        break
                    }
                //if the item is bigger than current value the prev anchor is
                // advanced
                else {
                    prev = current
                }
                //the current anchor is then advanced
                current = current.nextLink
            }
            if (prev == null) {
                head = Node(item, current)
            } else {
                prev.nextLink = Node(item, current)
            }
        }
    }
    fun removeFromQueue(): T? {
//Return the last element of the queue and remove it from the queue. This should be the smallest
//element in the queue. If the queue is empty, throw an exception.
        if (head?.value == null) {
            throw java.lang.IllegalArgumentException("The queue is empty!")
        } else {
            head?.nextLink = null
            return head?.value
        }
    }

    fun peek(): T {
        /*Like dequeue, return the last element of the queue, but do not
        remove it from the queue. If the queue is empty, throw an exception*/
        if (head?.value == null) {
            throw IllegalArgumentException("The queue is empty!")
        } else {
            return head!!.value
        }
    }

    fun sizeOQ(): Int {
        var current = head
        var counter = 0
        while (current != null){
            current = current.nextLink
            counter++
        }
        return counter
    }

fun isEmptyOQ(): Boolean {
    return head == null
}

    // Ignore my implementation, I am just used to make testing easier, see
// LinkedListTest.kt!
    fun toList(): List<T> {
        val arr = mutableListOf<T>()
        var cur = head
        while (cur != null) {
            arr.add(cur.value)
            cur = cur.nextLink
        }
        return arr.toList()
    }
}
