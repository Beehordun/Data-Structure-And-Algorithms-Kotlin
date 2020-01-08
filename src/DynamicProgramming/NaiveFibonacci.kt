package DynamicProgramming

fun fib(n: Int): Int {
    return if (n <= 2) {
        1
    } else {
        fib(n-1) + fib(n-2)
    }
}

fun main() {
    println(fib(6))
}