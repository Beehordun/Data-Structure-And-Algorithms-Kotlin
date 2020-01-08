package Graphs

fun bellmanFord(g: Graph, s: Vertex): Boolean {
    initializeVertices(g, s)

    for (i in 1 .. g.vertices.size) {
        for ((u, v) in g.edges) {
            relax(u, v, g)
        }
    }

    for ((u, v) in g.edges) {
        if (v.dist > u.dist + g.weight[Pair(u,v)]!!) {
            return false
        }
    }

    return true
}
