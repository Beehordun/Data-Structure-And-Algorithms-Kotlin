package sorting

import java.util.*

/*
Best case:  Time is O(N) and Space is O(1)
Average case: Time is 0(N**N) and Space is O(1)
Worst case: Time is 0(N**N) and Space is O(1)
*/

fun <T> bubbleSort(data: Array<T>): Array<T> {
    val lastIndex = data.size - 1

    @Suppress("Unchecked_cast")
    for (pass in (0..lastIndex)) {
        var hasSwapped = false
        for (index in 0 until lastIndex) {
            if ((data[index] as Comparable<T>) > data[index + 1]) {
                swapData(data, index, index+1)
                hasSwapped = true
            }
        }
        if (hasSwapped.not()) break
    }
    return data
}

fun main() {
    val sortedArray = selectionSort(arrayOf('g','y', 'a', 'd'))
    print(Arrays.deepToString(sortedArray))
    sortedArray.sortedArray()
}
