package BinarySearchTree

import java.lang.Math.max

class Node(value: Int) {
    var height: Int = 0
    var left: Node? = null
    var right: Node? = null
    var key = value
}

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


    fun findMin(root: Node): Node {
        var current: Node = root
        while (current.left != null) {
            current = current.left as Node
        }
        return current
    }

    fun deleteNode(node: Node?, key: Int): Node? {
        var root = node

        // BST Deletion
        if (root == null) return root

        if (key < root.key) root.left = deleteNode(root.left, key)

        else if (key > root.key) root.right = deleteNode(root.right, key)

        else {
            // Case 1 : Root has 0 or 1 child
            if (root.right == null || root.left == null) {
                var temp: Node? = null
                if (root.right == null) temp = root.left
                else if (root.left == null) temp = root.right
                if (temp == null) {
                    temp = root
                    root = null
                }
                else {
                    root = temp
                }
            }
            // Root has 2 children
            else {
                val temp: Node = findMin(root.right as Node)
                root.key = temp.key

                root.right = deleteNode(root.right, temp.key)
            }
        }

        if (root == null) return root

        //Update Height
        root.height = max(height(root.right), height(root.left)) + 1

        // Get balance

        val balance = getBalance(root)

        // Left Left
        if (balance > 1 && key < root.left!!.key) return rightRotate(root)

        // Right right
        else if (balance < -1 && key > root.right!!.key) return leftRotate(root)

        // Left Right
        if (balance > 1 && key > root.left!!.key) {
            root.left = leftRotate(root.left!!)
            return rightRotate(root)
        }

        // Right Left
        if (balance < -1 && key < root.right!!.key) {
            root.right = rightRotate(root.right!!)
            return leftRotate(root)
        }

        return root
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

fun inOrderTraversal(node: Node) {
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

fun avlSort(data: IntArray) {
    val avlTree = AVLTree()
    for (i in data) avlTree.root = avlTree.insertNode(avlTree.root, i)
    inOrderTraversal(avlTree.root!!)
}

fun main() {
    /*val avlTree = AVLTree()

    avlTree.root = avlTree.insertNode(avlTree.root, 10)
    avlTree.root = avlTree.insertNode(avlTree.root, 20)
    avlTree.root = avlTree.insertNode(avlTree.root, 30)
    avlTree.root = avlTree.insertNode(avlTree.root, 40)
    avlTree.root = avlTree.insertNode(avlTree.root, 50)
    avlTree.root = avlTree.insertNode(avlTree.root, 25)
    avlTree.root = avlTree.deleteNode(avlTree.root, 30)


    inOrderTraversal(avlTree.root!!)*/

    val unsortedArray = intArrayOf(7, 0, 6, 1, 9, 23, 61)
    avlSort(unsortedArray)
}