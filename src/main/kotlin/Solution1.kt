import org.apache.commons.lang3.StringUtils
import java.util.*
import kotlin.collections.ArrayList

object Solution1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val reader = Scanner(System.`in`)
        val n = reader.nextInt()
        val names = ArrayList<String>()
        for (i in 0..n) {
            names.add(reader.nextLine())
        }

        val result = solve(names)
        if (result.isEmpty()) {
            println("Impossible")
        } else {
            println(result.joinToString(" "))
        }
    }


    /**
     * Finds the correct order of letters.
     * @return correct order if possible, empty list otherwise
     */
    fun solve(names: ArrayList<String>): List<Char> {
        val graph = ArrayList<Node>()
        for (char in 'a'..'z') {
            graph.add(Node(char))
        }

        for (i in 1 until names.size) {
            val diff_position = StringUtils.indexOfDifference(names[i - 1], names[i])
            if (diff_position == names[i].length) {
                return emptyList()
            } else if (diff_position == -1 || diff_position == names[i - 1].length) {
                continue
            } else {
                val edge_to = graph[getIndexFromChar(names[i - 1][diff_position])]
                val edge_from = graph[getIndexFromChar(names[i][diff_position])]
                edge_from.edges.add(edge_to)
            }
        }

        for (node in graph) {
            if (!node.visited && !checkNoCycles(node)) {
                return emptyList()
            }
        }

        for (node in graph) {
            node.visited = false
        }

        val result = ArrayList<Node>()
        for (node in graph) {
            if (!node.visited)
                doTopSort(node, result)
        }

        return result.map { node -> node.symbol }
    }

    private fun checkNoCycles(node: Node): Boolean {
        if (node.repeated)
            return false
        if (node.visited)
            return true

        node.repeated = true
        node.visited = true

        for (e in node.edges) {
            if (!checkNoCycles(e))
                return false
        }
        node.repeated = false
        return true
    }

    /**
     * Finds top sort of the graph.
     * @param node node to start search from
     * @param result topologically ordered nodes
     */
    private fun doTopSort(node: Node, result: MutableList<Node>) {
        node.visited = true
        for (e in node.edges) {
            if (!e.visited) {
                doTopSort(e, result)
            }
        }
        result.add(node)
    }

    private class Node(val symbol: Char) {
        // We dont need to store one edge twice.
        val edges = TreeSet<Node>(Comparator<Node> { o1, o2 -> Character.compare(o1.symbol, o2.symbol) })
        var visited = false
        var repeated = false
    }

    private fun getIndexFromChar(char: Char): Int = char - 'a'
}