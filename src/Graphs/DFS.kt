package Graphs

var time = 0
var edgeType: HashMap<Pair<Vertex, Vertex>, EdgeType> = hashMapOf()
var topologicalSortedVertices:MutableList<Vertex> = mutableListOf()

fun dFS(g: Graph) {
    for (u in g.vertices) {
        if (u.color == Color.WHITE) {
            dFSVisit(g, u)
        }
    }
}

fun dFSVisit(g: Graph, u: Vertex) {
    time += 1
    u.startTime = time
    u.color = Color.GRAY

    for (v in g.adj[u]!!) {
        classifyEdge(u, v)

        if (v.color == Color.WHITE) {
            v.parent = u
            dFSVisit(g, v)
        }
    }

    time += 1
    u.endTime = time
    u.color = Color.BLACK
    topologicalSortedVertices.add(0, u)
}

fun classifyEdge(u:Vertex, v: Vertex) {
    when (v.color) {
        Color.WHITE -> edgeType[Pair(u, v)] = EdgeType.TREE_EDGE
        Color.GRAY -> edgeType[Pair(u, v)] = EdgeType.BACK_EDGE
        Color.BLACK -> {
            if (v.startTime < u.startTime) {
                edgeType[Pair(u, v)] = EdgeType.CROSS_EDGE
            } else if (v.startTime > u.startTime) {
                edgeType[Pair(u, v)] = EdgeType.FORWARD_EDGE
            }
        }
    }
}

fun getTopologicallySortedVertices() = topologicalSortedVertices

fun main() {

}
