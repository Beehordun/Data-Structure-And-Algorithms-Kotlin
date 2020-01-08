package sorting

import BinarySearchTree.AVLTree
import BinarySearchTree.Node
import BinarySearchTree.inOrderTraversal
import kotlin.math.max

class AVLTree {
    var root: Node? = null


    private fun height(node: Node?): Int {
        if (node == null) return -1
        return node.height
    }

    private fun updateHeight(node: Node): Int {
        return 1 + max(height(node.right), height(node.left))
    }

    private fun getBalance(node: Node): Int {
        return height(node.left) - height(node.right)
    }

    private fun leftRotate(x: Node): Node {
        val y = x.right!!
        val z = y.left

        y.left = x
        x.right = z

        x.height = updateHeight(x)
        y.height = updateHeight(y)

        return y
    }

    private fun rightRotate(x: Node): Node {
        val y = x.left!!
        val z = y.right

        y.right = x
        x.left = z

        x.height = updateHeight(x)
        y.height = updateHeight(y)

        return y
    }

    fun insertNode(node: Node?, key: Int): Node {

        // Insert key
        if (node == null) return Node(key)

        when {
            key < node.key -> node.left = insertNode(node.left, key)
            key > node.key -> node.right = insertNode(node.right, key)
            else -> return node
        }

        // Update height

        node.height = updateHeight(node)

        val balance = getBalance(node)

        // Left Left
        if (balance > 1 && key < node.left!!.key) return rightRotate(node)

        // Right right
        else if (balance < -1 && key > node.right!!.key) return leftRotate(node)

        // Left Right
        if (balance > 1 && key > node.left!!.key) {
            node.left = leftRotate(node.left!!)
            return rightRotate(node)
        }

        // Right Left
        if (balance < -1 && key < node.right!!.key) {
            node.right = rightRotate(node.right!!)
            return leftRotate(node)
        }

        return node
    }
}

private fun inOrderTraversal(node: Node) {
    if (node.left == null && node.right == null) print(node.key.toString() + " ")

    else if (node.left == null) {
        print(node.key.toString() + " ")
        inOrderTraversal(node.right!!)
    }
    else if (node.right == null) {
        inOrderTraversal(node.left!!)
        print(node.key.toString() + " ")
    }
    else {
        inOrderTraversal((node.left!!))
        print(node.key.toString() + " ")
        inOrderTraversal(node.right!!)
    }
}

private fun avlSort(data: IntArray) {
    val avlTree = AVLTree()
    for (i in data) avlTree.root = avlTree.insertNode(avlTree.root, i)
    inOrderTraversal(avlTree.root!!)
}


fun main() {
    val unsortedArray = intArrayOf(7, 0, 6, 1, 9, 23, 61)
    avlSort(unsortedArray)
}