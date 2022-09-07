class OrderedQueue {
    // establishes an object which is an isolated node
    private var head: Node? = null

    // class definition of what a node looks like: a value and a pointer to
    // the next link (which is another node)
    class Node(var value: Int, var nextLink: Node?)

/* Ordered Queue Homework
    An ordered queue (or priority queue) is a specialised queue that maintains an internal ordering of
    items. Any item can be added to an ordered queue, but the lowest value in the queue will always be
    returned first.  */

    fun addItemToOrderedQueue(item: Int) {
        var current = head
        var prev: Node? = null
        if (head == null) {
            head = Node(item, null)
        } else {
            while (current != null) {
                // if the item is less than the current node's value then
                // this block establishes a new node with new value pointed
                // to by previous and pointing to current
                if (item <= current.value) {
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
    fun removeFromQueue(): Int? {
//Return the last element of the queue and remove it from the queue. This should be the smallest
//element in the queue. If the queue is empty, throw an exception.
        if (head?.value == null) {
            throw java.lang.IllegalArgumentException("The queue is empty!")
        } else {
            head?.nextLink = null
            return head?.value
        }
    }

    fun peek(): Int {
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
    fun toList(): List<Int> {
        val arr = mutableListOf<Int>()
        var cur = head
        while (cur != null) {
            arr.add(cur.value)
            cur = cur.nextLink
        }
        return arr.toList()
    }
}
