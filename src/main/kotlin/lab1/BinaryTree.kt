package lab1

class Node(var value: Int) {
    var left: Node? = null
    var right: Node? = null

    fun insert(value: Int) {
        if (value < this.value) {
            if (left == null) {
                left = Node(value)
            } else {
                left!!.insert(value)
            }
        } else {
            if (right == null) {
                right = Node(value)
            } else {
                right!!.insert(value)
            }
        }
    }

    fun contains(value: Int): Boolean {
        if (value == this.value) {
            return true
        }
        if (value < this.value) {
            if (left == null) {
                return false
            } else {
                return left!!.contains(value)
            }
        } else {
            if (right == null) {
                return false
            } else {
                return right!!.contains(value)
            }
        }
    }

    fun delete(value: Int, parent: Node?): Node? {
        if (value < this.value) {
            left = left?.delete(value, this)
        } else if (value > this.value) {
            right = right?.delete(value, this)
        } else {
            if (left == null && right == null) {
                return null
            } else if (left == null) {
                return right
            } else if (right == null) {
                return left
            } else {
                val temp = right!!.findMin()
                this.value = temp.value
                right = right!!.delete(temp.value, this)
            }
        }
        return this
    }

    fun findMin(): Node {
        if (left == null) {
            return this
        }
        return left!!.findMin()
    }

    fun findMax(): Node {
        if (right == null) {
            return this
        }
        return right!!.findMax()
    }

    fun find(value: Int): Node? {
        if (value == this.value) {
            return this
        }
        if (value < this.value) {
            if (left == null) {
                return null
            } else {
                return left!!.find(value)
            }
        } else {
            if (right == null) {
                return null
            } else {
                return right!!.find(value)
            }
        }
    }

    fun findParent(value: Int): Node? {
        if (left?.value == value || right?.value == value) {
            return this
        }
        if (value < this.value) {
            if (left == null) {
                return null
            } else {
                return left!!.findParent(value)
            }
        } else {
            if (right == null) {
                return null
            } else {
                return right!!.findParent(value)
            }
        }
    }

    fun findSuccessor(value: Int): Node? {
        var node = find(value)
        if (node == null) {
            return null
        }
        if (node.right != null) {
            return node.right!!.findMin()
        }
        var parent = findParent(value)
        while (parent != null && node == parent.right) {
            node = parent
            parent = findParent(parent.value)
        }
        return parent
    }

    fun findPredecessor(value: Int): Node? {
        var node = find(value)
        if (node == null) {
            return null
        }
        if (node.left != null) {
            return node.left!!.findMax()
        }
        var parent = findParent(value)
        while (parent != null && node == parent.left) {
            node = parent
            parent = findParent(parent.value)
        }
        return parent
    }

    fun printTree() {
        printTree("", true)
    }

    private fun printTree(prefix: String, isTail: Boolean) {
        println(prefix + (if (isTail) "I___ " else "I--- ") + value)
        left?.printTree(prefix + (if (isTail) "    " else "I   "), false)
        right?.printTree(prefix + (if (isTail) "    " else "I   "), true)
    }

}

class BinaryTree(var root: Node? = null) {
    fun insert(value: Int) {
        if (root == null) {
            root = Node(value)
        } else {
            root!!.insert(value)
        }
    }

    fun contains(value: Int): Boolean {
        if (root == null) {
            return false
        }
        return root!!.contains(value)
    }

    fun delete(value: Int) {
        root = root?.delete(value, null)
    }

    fun findMin(): Node? {
        return root?.findMin()
    }

    fun findMax(): Node? {
        return root?.findMax()
    }

    fun find(value: Int): Node? {
        return root?.find(value)
    }

    fun findParent(value: Int): Node? {
        return root?.findParent(value)
    }

    fun findSuccessor(value: Int): Node? {
        return root?.findSuccessor(value)
    }

    fun findPredecessor(value: Int): Node? {
        return root?.findPredecessor(value)
    }

    fun printTree() {
        root?.printTree()
    }
}