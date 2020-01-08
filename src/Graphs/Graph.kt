package Graphs

enum class Color {
    WHITE,
    GRAY,
    BLACK;
}

enum class EdgeType {
    TREE_EDGE,
    BACK_EDGE,
    FORWARD_EDGE,
    CROSS_EDGE;
}

class  Vertex constructor(val value: Int) {
    var parent: Vertex? = null
    var dist: Int = Int.MAX_VALUE
    var color = Color.WHITE
    var startTime = 0
    var endTime = 0
}

class Graph {
    var adj: HashMap<Vertex, MutableList<Vertex>> = HashMap()
    var vertices: MutableList<Vertex> = mutableListOf()
    var weight: HashMap<Pair<Vertex, Vertex>, Int> = HashMap()
    var edges: MutableList<Pair<Vertex, Vertex>> = mutableListOf()

    fun addWeightedEdge(u: Vertex, v: Vertex, w: Int) {
        if (adj.containsKey(u).not()) adj[u] = mutableListOf()

        adj[u]?.add(v)

        weight[Pair(u, v)] = w

        edges.add(Pair(u, v))
    }

    fun addVertex(v: Vertex) {
        vertices.add(v)
    }
}
