package day05

import java.io.File
import java.util.*

fun part1(filename: String) {
    val stacks = ArrayList<LinkedList<Char>>()
    val instructions = mutableListOf<Triple<Int, Int, Int>>()
    File(filename).forEachLine {
        if (it.contains("[")) {
            while (stacks.size <= (it.length / 4)) {
                stacks.add(LinkedList())
            }
            for (i in it.indices step 4) {
                if (it[i + 1].isLetter()) {
                    stacks[i / 4].addFirst(it[i + 1])
                }
            }
        } else if (it.startsWith("m")) {
            val words = it.split("move ", " from ", " to ")
            instructions.add(Triple(words[1].toInt(), words[2].toInt(), words[3].toInt()))
        }
    }
    stacks.forEach {
        println(it)
    }

    instructions.forEach {
        val from = stacks[it.second - 1]
        val to = stacks[it.third - 1]
        for (i in 0 until it.first) {
            to.addLast(from.removeLast())
        }
    }

    var result = ""
    stacks.forEach {
        result += it.last
    }
    println("part 1: $result")
}

fun part2(filename: String) {
    val stacks = ArrayList<LinkedList<Char>>()
    val instructions = mutableListOf<Triple<Int, Int, Int>>()
    File(filename).forEachLine {
        if (it.contains("[")) {
            while (stacks.size <= (it.length / 4)) {
                stacks.add(LinkedList())
            }
            for (i in it.indices step 4) {
                if (it[i + 1].isLetter()) {
                    stacks[i / 4].addFirst(it[i + 1])
                }
            }
        } else if (it.startsWith("m")) {
            val words = it.split("move ", " from ", " to ")
            instructions.add(Triple(words[1].toInt(), words[2].toInt(), words[3].toInt()))
        }
    }

    instructions.forEach {
        val moving = LinkedList<Char>()
        val from = stacks[it.second - 1]
        val to = stacks[it.third - 1]
        for (i in 0 until it.first) {
            moving.addLast(from.removeLast())
        }
        for (i in 0 until it.first) {
            to.addLast(moving.removeLast())
        }

    }

    var result = ""
    stacks.forEach {
        result += it.last
    }
    println("part 2: $result")
}

fun main(args: Array<String>) {
    part1(args[0])
    part2(args[0])
}