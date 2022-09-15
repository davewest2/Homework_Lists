class Queue <T>{
    // establishes an object which is an isolated node
    private var head: Node<T>? = null

    // class definition of what a node looks like: a value and a pointer to
    // the next link (which is another node)
    class Node<T>(var value: T, var nextLink: Node<T>?)

// Queue Homework

    fun add(item: T) {
        /*Accept an item and add it to the queue.*/
        if (head != null) {
            head = Node(item, head)
        } else {
            head = Node(item, null)
        }
    }


    /*Return the last element of the queue and remove it from the queue. If
    the queue is empty, throw an exception.*/
    fun remove(): T {
        var current = head
        var prev: Node<T>? = null
        while (current != null) {
            if (current.nextLink == null) {
                if (prev == null) {
                    head = null
                } else {
                    prev.nextLink = null
                }
                return current.value
            } else {
                prev = current
                current = current.nextLink
            }
        }
        throw IllegalArgumentException("List is empty!")
    }

    fun peek():T {
        /*Like dequeue, return the last element of the queue, but do not remove it from the queue. If the
    queue is empty, throw an exception*/
        var current = head
        while (current != null) {
            if (current.nextLink == null) {
                return current.value
            } else {
                current = current.nextLink
            }
        }
        throw IllegalArgumentException("List is empty!")
    }

    fun size(): Int {
        /*Return the size of the queue.*/
        var current = head
        var counter = 0
        while (current != null) {
            current = current.nextLink
            counter++
        }
        return counter
    }


    fun queueIsEmpty(): Boolean {
        return head == null
    }
    /*Return true if the queue is empty*/


    // Ignore my implementation, I am just used to make testing easier, see
    // LinkedListTest.kt!
    fun toList(): List<T> {
        val arr = mutableListOf<T>()
        var cur = head;
        while (cur != null) {
            arr.add(cur.value)
            cur = cur.nextLink
        }
        return arr.toList()
    }
}
