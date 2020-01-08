package sorting

import java.util.*

fun countingSort(k: IntArray, exp: Int): IntArray {
    val lengthOfK = k.size
    val b = IntArray(lengthOfK)

    if (lengthOfK == 0) return IntArray(lengthOfK)

    val maxOfK = requireNotNull(k.max())
    val c = IntArray(maxOfK + 1)


    for (i in k) {
        val index = (i/exp)%10
        c[index] = c[index] + 1
    }

    for (i in 1 .. maxOfK) c[i] = c[i] + c[i -1]

    for (i in lengthOfK - 1 downTo 0) {
        val index = (k[i]/exp)%10
        b[c[index] -1] = k[i]
        c[index] = c[index] - 1
    }

    for (i in 0 until  lengthOfK) k[i] = b[i]

    return k
}

fun radixSort(a: IntArray): IntArray {
    if (a.isEmpty()) return IntArray(0)

    val m = requireNotNull(a.max())
    var exp = 1

    while ((m/exp) > 0) {
        countingSort(a, exp)
        exp *= 10
    }

    return a
}

fun main() {
    val a = intArrayOf(300, 992, 103, 980, 5040, 897, 890)
    val b = radixSort(a)
    print(Arrays.deepToString(b.toTypedArray()))
}