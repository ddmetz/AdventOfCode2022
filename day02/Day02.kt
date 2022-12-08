package day02

import java.io.File

fun part1(filename: String) {
    var score = 0
    File(filename).forEachLine {
        val a = it[0]
        val x = it[2]
        when (a to x) {
            'A' to 'X' -> score += 3 + 1
            'A' to 'Y' -> score += 6 + 2
            'A' to 'Z' -> score += 0 + 3
            'B' to 'X' -> score += 0 + 1
            'B' to 'Y' -> score += 3 + 2
            'B' to 'Z' -> score += 6 + 3
            'C' to 'X' -> score += 6 + 1
            'C' to 'Y' -> score += 0 + 2
            'C' to 'Z' -> score += 3 + 3
        }
    }
    println("part 1: $score")
}

fun part2(filename: String) {
    var score = 0
    File(filename).forEachLine {
        val a = it[0]
        val x = it[2]
        when (a to x) {
            'A' to 'X' -> score += 0 + 3
            'A' to 'Y' -> score += 3 + 1
            'A' to 'Z' -> score += 6 + 2
            'B' to 'X' -> score += 0 + 1
            'B' to 'Y' -> score += 3 + 2
            'B' to 'Z' -> score += 6 + 3
            'C' to 'X' -> score += 0 + 2
            'C' to 'Y' -> score += 3 + 3
            'C' to 'Z' -> score += 6 + 1
        }
    }
    println("part 2: $score")
}

fun main(args: Array<String>) {
    part1(args[0])
    part2(args[0])
}