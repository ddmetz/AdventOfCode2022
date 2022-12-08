package day03

import java.io.File

fun priority(c: Char): Int {
    when (c) {
        in 'a'..'z' -> return c.code - 96
        in 'A'..'Z' -> return c.code - 64 + 26
    }
    throw IllegalArgumentException()
}

fun part1(filename: String) {
    var prioritySum = 0
    File(filename).forEachLine {
        val first = it.substring(0, it.length / 2).toSet()
        val second = it.substring(it.length / 2).toSet()
        val intersection = first intersect second
        prioritySum += priority(intersection.first())
    }
    println("part 1: $prioritySum")
}

fun part2(filename: String) {
    var prioritySum = 0
    val lines: List<String> = File(filename).readLines()
    for (i in lines.indices step 3) {
        val line1 = lines[i].toSet()
        val line2 = lines[i + 1].toSet()
        val line3 = lines[i + 2].toSet()
        val intersection = line1 intersect line2 intersect line3
        prioritySum += priority(intersection.first())
    }
    println("part 2: $prioritySum")
}

fun main(args: Array<String>) {
    part1(args[0])
    part2(args[0])
}