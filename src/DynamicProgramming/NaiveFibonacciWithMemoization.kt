package DynamicProgramming

val memo: HashMap<Int, Int> = hashMapOf()
fun fib2(n: Int): Int {
    if (memo.containsKey(n)) {
        return memo[n]!!
    }

    return if (n <= 2) {
        1
    } else {
        val f = fib2(n-1) + fib2(n-2)
        memo[n] = f
        f
    }
}

fun main() {
    print(fib2(7))
}