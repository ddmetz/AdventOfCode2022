package day06

import java.io.File

fun part1(filename: String) {
    val result = File(filename).readText().windowed(4)
        .indexOfFirst { window -> window.toSet().size == 4 } + 4
    println("part 2: $result")
}

fun part2(filename: String) {
    val result = File(filename).readText().windowed(14)
        .indexOfFirst { window -> window.toSet().size == 14 } + 14
    println("part 1: $result")
}

fun main(args: Array<String>) {
    part1(args[0])
    part2(args[0])
}