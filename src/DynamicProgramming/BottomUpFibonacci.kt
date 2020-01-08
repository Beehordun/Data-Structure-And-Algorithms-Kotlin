package DynamicProgramming

val memos: HashMap<Int, Int> = hashMapOf()
fun fib3(n: Int): Int {
    for (k in 1..n) {
        if (k <= 2) {
            memos[k] = 1
        } else {
            memos[k] = memos[k-1]!! + memos[k-2]!!
        }
    }

    return memos[n]!!
}

fun main() {
    println(fib3(2))
}