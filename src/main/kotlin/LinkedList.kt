class LinkedList {
    private var head: Node? = null

    class Node(val value: Int, var nextLink: Node?)

    fun add(item: Int) {
        if (head == null) {
            head = Node(item, null)
        } else {
            var tailNode = head
            while (tailNode?.nextLink != null) {
                tailNode = tailNode.nextLink
            }
            tailNode?.nextLink = Node(item, null)
        }
    }

    fun contains(item: Int): Boolean {
        var current = head
        while (current != null) {
            if (item == current.value) {
                return true
            }
            current = current.nextLink
        }
        return false
    }

    fun remove(item: Int) {
        var current = head
        var prev: Node? = null
        while (current != null) {
            // this block handles removing an item
            if (current.value == item){
                if (prev == null) {
                    head = current.nextLink
                } else {
                    prev.nextLink = current.nextLink
                }
            } else {
                // this block advances "previous" anchor
             prev = current
            }
            // this block advances the "current" anchor
            current = current.nextLink
        }
    }





// foo
    // add the other methods here

    // Ignore my implementation, I am just used to make testing easier, see
    // LinkedListTest.kt!
    fun toList(): List<Int> {
        val arr = mutableListOf<Int>()
        var cur = head;
        while (cur != null) {
            arr.add(cur.value)
            cur = cur.nextLink
        }
        return arr.toList()
    }
}
