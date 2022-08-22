class LinkedList {
    private val head: Node? = null

    class Node(val value: Int, val next: Node?)

    fun add(item: Int): Nothing {
        TODO("implement me")
    }

    fun remove(item: Int): Nothing {
        TODO("implement me")
    }

    // add the other methods here

    // Ignore my implementation, I am just used to make testing easier, see
    // LinkedListTest.kt!
    fun toList(): List<Int> {
        val arr = mutableListOf<Int>()
        var cur = head;
        while (cur != null) {
            arr.add(cur.value)
            cur = cur.next
        }
        return arr.toList()
    }
}
