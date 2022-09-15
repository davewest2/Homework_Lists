class LinkedList {
    // establishes an object which is an isolated node
    private var head: Node? = null

    // class definition of what a node looks like: a value and a pointer to
    // the next link (which is another node)
    class Node(var value: Int, var nextLink: Node?)

    fun add(item: Int) {
        // checks if there is a chain yet, if not, creates a new node, the
        // head, pointing to null
        if (head == null) {
            head = Node(item, null)
            // if there is a head, this while block steps down the chain until
            // the head is found (links to null)
        } else {
            var tailNode = head
            while (tailNode?.nextLink != null) {
                tailNode = tailNode.nextLink
            }
            // once found, this line adds a node to the tail and points it to
            // null
            tailNode?.nextLink = Node(item, null)
        }
    }

    fun contains(item: Int): Boolean {
        var current = head
        // again, while loop steps through the links of the chain
        while (current != null) {
            // if the item is found, the function returns true, job done
            if (item == current.value) {
                return true
            }
            //if the item isn't found the while loop continues stepping
            // through the links
            current = current.nextLink
        }
        // if the item is not found, false is returned, item not in list
        return false
    }

    fun remove(item: Int) {
        var current = head
        var prev: Node? = null
        while (current != null) {
            // this block handles removing an item
            if (current.value == item) {
                if (prev == null) {
                    head = current.nextLink
                } else {
                    prev.nextLink = current.nextLink
                }
            } else {
                // this block advances "previous" anchor another step along
                // the chain
                prev = current
            }
            // this block advances the "current" anchor another step along
            // the chain
            current = current.nextLink
        }
    }

    fun first(): Int {
        if (head != null) {
            return head!!.value
        } else {
            throw IllegalArgumentException("There is no list!")
        }
    }

    fun isEmpty(): Boolean {
        return head == null
    }

    fun last(): Int? {
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

    fun sizeList(): Int {
        var current = head
        var count = 0
        while (current != null) {
            current = current.nextLink
            count++
        }
        return count
    }

    fun get(index: Int): Int {
        var current = head
        var count = 0
        while (current != null) {
            if (count == index) {
                return current.value
            } else {
                current = current.nextLink
                count++
            }
        }
        throw ArrayIndexOutOfBoundsException(
            "Requested index $index is larger than list (size $count)"
        )
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
