package org.example

fun main() {
    // Avoid changing main function block
    val cache = LRUCache(2)
    cache.set(1, Position(1, 1))
    cache.set(2, Position(1, 2))
    println(cache.get(1))                // Position(x=1, y=1)
    cache.set(3, Position(1, 3))
    println(cache.get(2))                // null
    println(cache.data)                  // {1=Position(x=1, y=1), 3=Position(x=1, y=3)}
}

interface LRUCacheContract {
    fun set(key: Int, value: Position)
    fun get(key: Int): Position?
}

/**
 * LRUCache (Least recently used) will maintain the size by remove least recently used item when it is overflow.
 * @param size size of the data (immutable)
 */
class LRUCache(val size: Int) : LRUCacheContract {
    // declare a variable to holds the data, it should be mutable map
    val data = mutableMapOf<Int, Position>()

    /**
     * override function set
     *    if key already in the map, remove it, and re-insert (to make it most updated)
     *    if key is not in the map and the size still enough, just insert the value
     *    key is not in the map and the size is full, remove the first element from the map before insert new one
     */
    override fun set(key: Int, value: Position) {
        data.remove(key)
        if (data.size == size) {
            data.remove(data.keys.first())
        }
        data[key] = value
    }

    /**
     * override function get
     *     if key already in the map, remove it, and re-insert (to make it most updated)
     *     @return the value of provided key
     */
    override fun get(key: Int): Position? {
        val value = data[key]
        if (value != null) {
            data.remove(key)
            data[key] = value
        }
        return value
    }
}

/**
 * Define data class Position with 2 integer params (immutable)
 * @param x position in X
 * @param y position in Y
 */
data class Position(val x: Int, val y: Int)