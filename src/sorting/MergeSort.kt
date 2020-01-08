package sorting

import java.util.*

fun <T> mergeSort(data: Array<T>): Array<T> {

    if (data.size > 1) {
        val middle = data.size / 2
        val lastIndex = data.size - 1
        val left = data.sliceArray(0 until middle)
        val right = data.sliceArray(middle ..lastIndex)

        mergeSort(left)
        mergeSort(right)

        var leftIndex = 0
        var rightIndex = 0
        var index = 0


        while (leftIndex < left.size && rightIndex < right.size) {
            if ((left[leftIndex] as Comparable<T>) <= right[rightIndex]) {
                data[index] = left[leftIndex]
                leftIndex += 1
            } else {
                data[index] = right[rightIndex]
                rightIndex += 1
            }
            index += 1
        }

        while (leftIndex < left.size) {
            data[index] = left[leftIndex]
            index += 1
            leftIndex += 1
        }

        while (rightIndex < right.size) {
            data[index] = right[rightIndex]
            index += 1
            rightIndex += 1
        }
    }
    return data
}

fun main() {
    val unsortedArray = doubleArrayOf(100.0, 1.9, -2.0, 9.1, 0.5).toTypedArray()
    val sortedArray = mergeSort(unsortedArray)
    print(Arrays.deepToString(sortedArray))
}