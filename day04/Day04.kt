package day04

import java.io.File

fun part1(filename: String) {
    var total = 0
    File(filename).forEachLine {
        val (a, b, c, d) = it.split('-', ',')
        val range1 = a.toInt()..b.toInt()
        val range2 = c.toInt()..d.toInt()
        if (range1.first in range2 && range1.last in range2)
            total++
        else if (range2.first in range1 && range2.last in range1)
            total++
    }
    println("part 1: $total")
}

fun part2(filename: String) {
    var total = 0
    File(filename).forEachLine {
        val (a, b, c, d) = it.split('-', ',')
        val range1 = a.toInt()..b.toInt()
        val range2 = c.toInt()..d.toInt()
        if (range1.first in range2 || range1.last in range2)
            total++
        else if (range2.first in range1 || range2.last in range1)
            total++
    }
    println("part 2: $total")
}

fun main(args: Array<String>) {
    part1(args[0])
    part2(args[0])
}