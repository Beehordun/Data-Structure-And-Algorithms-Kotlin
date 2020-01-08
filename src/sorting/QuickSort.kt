package sorting

fun <T> quickSort(data: Array<T>): Array<T> {
    val lastIndex = data.size - 1
    quickSortRecur(data, 0, lastIndex)
    return data
}

fun <T> quickSortRecur(data: Array<T>, left: Int, right: Int) {
    if (left >= right) return
    val pivot = data[(left + right) / 2]
    val index = partition(data, left, right, pivot)
    quickSortRecur(data, left, index - 1)
    quickSortRecur(data, index, right)
}

@Suppress("Unchecked_cast")
fun <T> partition(data: Array<T>, left: Int, right: Int, pivot: T): Int {
    var leftCount = left
    var rightCount = right

    while (leftCount <= rightCount) {
        while (data[leftCount] as Comparable<T> < pivot) {
            leftCount ++
        }
        while (data[rightCount] as Comparable<T> > pivot) {
            rightCount --
        }
        if (left <= right) {
            swapData(data, leftCount, rightCount)
            leftCount ++
            rightCount --
        }
    }
    return leftCount
}
