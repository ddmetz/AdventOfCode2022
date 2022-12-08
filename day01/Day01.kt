package day01

import java.io.File
import java.util.*

fun part1(filename: String) {
    var maxVal = 0
    var currentVal = 0
    File(filename).forEachLine {
        if (it.trim() == "") {
            if (currentVal > maxVal)
                maxVal = currentVal
            currentVal = 0
        } else {
            currentVal += it.toInt()
        }
    }
    println("part 1: $maxVal")
}

fun part2(filename: String) {
    val pq = PriorityQueue<Int>()
    var currentVal = 0
    File(filename).forEachLine {
        if (it.trim() == "") {
            if (pq.size >= 3) {
                if (currentVal > pq.peek()) {
                    pq.poll()
                    pq.add(currentVal)
                }
            } else {
                pq.add(currentVal)
            }
            currentVal = 0
        } else {
            currentVal += it.toInt()
        }
    }
    println("part 2: ${pq.sum()}")
}

fun main(args: Array<String>) {
    part1(args[0])
    part2(args[0])
}