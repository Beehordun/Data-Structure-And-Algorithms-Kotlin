package sorting

import java.util.*


fun <T> swap(A: Array<T>, i: Int, largest: Int) {
    val holder = A[largest]
    A[largest] = A[i]
    A[i] = holder
}

fun <T> maxHeapify(data: Array<T>, i: Int) {
    val size = data.size
    val l = 2*i + 1
    val r = 2*i + 2
    var largest = i

    if (l < size && (data[l] as Comparable<T>) >  data[i]) largest = l

    if (r < size && (data[r] as Comparable<T>) > data[largest]) largest = r

    if (largest != i) {
        swap(data, i, largest)
        maxHeapify(data, largest)
    }
}


fun <T> minHeapify(data: Array<T>, i: Int) {
    val l = 2*i + 1
    val r = 2*i + 2
    val size = data.size
    var min = i

    if (l < size && (data[l] as Comparable<T>) <  data[i]) min = l

    if (r < size && (data[r] as Comparable<T>) < data[min]) min = r

    if (min != i) {
        swap(data, i, min)
        minHeapify(data, min)
    }
}

fun <T> buildMaxHeap(data: Array<T>) {
    val size = data.size
    val start = size/2

    for (i in start downTo 0) maxHeapify(data, i)
}

fun <T> buildMinHeap(data: Array<T>) {
    val size = data.size
    val start = size/2

    for (i in start downTo 0) minHeapify(data, i)
}

fun <T> heapSort(data: Array<T>): Array<T> {
    var index = data.size - 1
    buildMinHeap(data)
    val output = data.clone()
    var temp = data
    var i = 0

    while (index >= 0) {
        output[i] = temp[0]
        swap(temp, 0, index)

        index -= 1
        i += 1

        temp = temp.sliceArray(0 .. index)

        minHeapify(temp, 0)
    }
    return output
}

fun <T> extractMin(data: Array<T>): Pair<T, Array<T>> {
    buildMinHeap(data)

    val firstItem = data[0]
    lateinit var dataOut: Array<T>

    if (data.size == 1) {
        dataOut = data.clone()
    } else if (data.size > 1) {
        dataOut = data.sliceArray(1 until data.size)
    }

    return Pair(firstItem, dataOut)
}

fun main() {
    val unsortedArray = doubleArrayOf(1.9, 0.7, 6.5, 9.6, 8.5, 90.9).toTypedArray()
    val sortedArray = heapSort(unsortedArray)
    print(Arrays.deepToString(sortedArray))
}


