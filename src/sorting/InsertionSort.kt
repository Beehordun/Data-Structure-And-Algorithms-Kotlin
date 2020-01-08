package sorting

import java.util.*

fun <T> insertionSort(data: Array<T>): Array<T> {
    val lastIndex = data.size - 1

    @Suppress("Unchecked_cast")
    for (pos in (1..lastIndex)) {
        var index = pos
        val key = data[index] as Comparable<T>
        while (index >= 1 && key < (data[index - 1])) {
            swapData(data, index, index - 1)
            index -= 1
        }
    }
    return data
}

fun <T> swapData(data: Array<T>, first: Int, second: Int) {
    val holder = data[first]
    data[first] = data[second]
    data[second] = holder
}

fun main() {
    val sortedArray = insertionSort(arrayOf('i','s', 'z', 'd'))
    print(Arrays.deepToString(sortedArray))
    sortedArray.sortedArray()
}