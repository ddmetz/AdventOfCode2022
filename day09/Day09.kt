package day09

import java.io.File
import kotlin.math.absoluteValue
import kotlin.math.sign

fun Sequence<Pair<Int, Int>>.followHead(): Sequence<Pair<Int, Int>> {
    return sequence {
        var tailX = 0
        var tailY = 0
        yield(Pair(tailX, tailY))

        for ((headX, headY) in this@followHead) {
            val dX = headX - tailX
            val dY = headY - tailY

            if (dX.absoluteValue <= 1 && dY.absoluteValue <= 1)
                continue

            tailX = if (dX.absoluteValue >= dY.absoluteValue)
                headX - dX.sign
            else
                headX

            tailY = if (dX.absoluteValue <= dY.absoluteValue)
                headY - dY.sign
            else
                headY

            yield(Pair(tailX, tailY))
        }
    }
}

fun part1(filename: String) {
    val input = File(filename).readLines()

    val headSequence = sequence {
        var x = 0
        var y = 0
        yield(Pair(x, y))
        input.forEach {
            val instruction = it.split(" ")
            when (instruction[0]) {
                "U" -> repeat(instruction[1].toInt()) { yield(Pair(x, --y)) }
                "D" -> repeat(instruction[1].toInt()) { yield(Pair(x, ++y)) }
                "L" -> repeat(instruction[1].toInt()) { yield(Pair(--x, y)) }
                "R" -> repeat(instruction[1].toInt()) { yield(Pair(++x, y)) }
            }
        }
    }

    val result = headSequence.followHead().toSet().size

    println("part 1: $result")
}

fun part2(filename: String) {
    val input = File(filename).readLines()

    val headSequence = sequence {
        var x = 0
        var y = 0
        yield(Pair(x, y))
        input.forEach {
            val instruction = it.split(" ")
            when (instruction[0]) {
                "U" -> repeat(instruction[1].toInt()) { yield(Pair(x, --y)) }
                "D" -> repeat(instruction[1].toInt()) { yield(Pair(x, ++y)) }
                "L" -> repeat(instruction[1].toInt()) { yield(Pair(--x, y)) }
                "R" -> repeat(instruction[1].toInt()) { yield(Pair(++x, y)) }
            }
        }
    }

    val result = headSequence
        .followHead()
        .followHead()
        .followHead()
        .followHead()
        .followHead()
        .followHead()
        .followHead()
        .followHead()
        .followHead()
        .toSet().size

    println("part 2: $result")
}

fun main(args: Array<String>) {
    part1(args[0])
    part2(args[0])
}