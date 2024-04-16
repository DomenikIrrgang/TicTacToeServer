package my.depot.tictactoe.util

fun <T> Array<T>.hasValueConsecutively(value: T, amount: Int): Boolean {
    var count = 0
    for (item in this) {
        if (item == value) {
            count++
        } else {
            count = 0
        }
        if (count == amount) {
            return true
        }
    }
    return false
}