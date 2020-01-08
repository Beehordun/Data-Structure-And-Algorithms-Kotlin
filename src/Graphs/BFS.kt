package Graphs

fun BFS(g: Graph, s: Vertex): Pair<HashMap<Vertex, Vertex?>, HashMap<Vertex, Int>> {
    val parent: HashMap<Vertex, Vertex?> = HashMap()
    val level: HashMap<Vertex, Int> = HashMap()
    var i = 1
    var frontier = mutableListOf<Vertex>()

    parent[s] = null
    level[s] = 0

    frontier.add(s)

    while (frontier.isEmpty().not()) {
        val next = mutableListOf<Vertex>()

        for (u in frontier) {
            for (v in g.adj[u]!!) {
                if (level.containsKey(v).not()) {
                    level[v] = i
                    parent[v] = u
                    next.add(v)
                }
            }
        }

        frontier = next
        i += 1
    }

    return Pair(parent, level)
}

fun main() {
    val g = Graph()

    val s = Vertex(0)
    val t = Vertex(1)
    val x = Vertex(2)
    val y = Vertex(3)
    val z = Vertex(4)


    g.addVertex(s)
    g.addVertex(t)
    g.addVertex(x)
    g.addVertex(y)
    g.addVertex(z)

    g.addWeightedEdge(s, t, 1)
    g.addWeightedEdge(s, y, 1)
    g.addWeightedEdge(t, x, 1)
    g.addWeightedEdge(y, z, 1)
    g.addWeightedEdge(x, z, 1)
    g.addWeightedEdge(z, x, 1)


    val (parent, level) = BFS(g, s)

    println(parent)
    println(level)

}