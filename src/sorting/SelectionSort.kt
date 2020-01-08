package sorting

@Suppress("Unchecked_cast")
fun <T> selectionSort(data: Array<T>): Array<T> {
    for (index in 0 until data.size) {
        var minIndex = index
        for (j in index + 1 until data.size) {
            if (data[minIndex] as Comparable<T> > data[j]) {
                minIndex = j
            }
        }
        swapData(data, minIndex, index)
    }
    return data
}