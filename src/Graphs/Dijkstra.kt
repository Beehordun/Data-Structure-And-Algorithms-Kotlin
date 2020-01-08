package Graphs

import sorting.extractMin

fun dijkstra(g: Graph, s: Vertex) {
    initializeVertices(g, s)




    val shortestPathList = mutableListOf<Vertex>()
    var list = g.vertices.toTypedArray()

    while (list.isNotEmpty()) {
        val (u, newList) = extractMin(list)
        shortestPathList.add(u)

        for (v in g.adj[u]!!) {
            relax(u, v, g)
        }

        list = newList
    }
}

class A {
    lateinit var foo: String

    fun init() {
        println("Before --> ${::foo.isInitialized}")
        foo = "abc"
        println("After --> ${::foo.isInitialized}")
    }
}

fun main() {
    lateinit var test: Graph

    A().init()
}
