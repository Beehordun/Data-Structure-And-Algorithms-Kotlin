package sorting

import java.util.*

fun countingSort(k: IntArray): IntArray {
    val lengthOfK = k.size
    val b = IntArray(lengthOfK)

    if (lengthOfK == 0) return IntArray(lengthOfK)

    val maxOfK = requireNotNull(k.max())
    val c = IntArray(maxOfK + 1)


    for (i in k) c[i] = c[i] + 1

    for (i in 1 .. maxOfK) c[i] = c[i] + c[i -1]

    for (i in lengthOfK - 1 downTo 0) {
        b[c[k[i]] -1] = k[i]
        c[k[i]] = c[k[i]] - 1
    }

    return b
}

fun main() {
    val a = intArrayOf(3, 9, 1, 0, 5, 8, 0)
    val b = countingSort(a)
    print(Arrays.deepToString(b.toTypedArray()))
}