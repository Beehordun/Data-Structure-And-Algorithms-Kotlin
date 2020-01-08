package Graphs

fun shortestPath(g: Graph, s: Vertex) {
    dFS(g)

    val topologicallySortedVertices = getTopologicallySortedVertices()
    initializeVertices(g, s)

    for (u in topologicallySortedVertices) {
        for (v in g.adj[u]!!) {
            relax(u, v, g)
        }
    }
}

fun initializeVertices(g: Graph, s: Vertex) {
    for (v in g.vertices) {
        v.parent = null
        v.dist = Int.MAX_VALUE
    }
    s.dist = 0
}

fun relax(u: Vertex, v: Vertex, g: Graph) {
    if (v.dist > u.dist + g.weight[Pair(u, v)]!!) {
        v.dist = u.dist + g.weight[Pair(u, v)]!!
        v.parent = u
    }
}