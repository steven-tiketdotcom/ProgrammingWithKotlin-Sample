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
class LRUCache : LRUCacheContract {
    // declare a variable to holds the data, it should be mutable map

    /**
     * override function set
     *    if key already in the map, remove it, and re-insert (to make it most updated)
     *    if key is not in the map and the size still enough, just insert the value
     *    key is not in the map and the size is full, remove the first element from the map before insert new one
     */




    /**
     * override function get
     *     if key already in the map, remove it, and re-insert (to make it most updated)
     *     @return the value of provided key
     */






}

/**
 * Define data class Position with 2 integer params (immutable)
 * @param x position in X
 * @param y position in Y
 */
