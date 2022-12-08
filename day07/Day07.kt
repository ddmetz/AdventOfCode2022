package day07

import java.io.File

class Dir(
    val name: String,
    val parent: Dir? = null,
    val child: MutableMap<String, Dir> = mutableMapOf(),
    var size: Int = 0
)

fun part1(filename: String) {
    val rootDir = Dir("/")
    val dirs = mutableListOf(rootDir)
    var current = rootDir
    File(filename).forEachLine {
        val words = it.split(" ")
        when {
            it.startsWith("$ cd ") -> {
                current = when (val n = it.drop(5)) {
                    "/" -> rootDir
                    ".." -> current.parent!!
                    else -> current.child.getValue(n)
                }
            }

            it.startsWith("dir") -> {
                val newDir = Dir(it.drop(4), parent = current)
                current.child[newDir.name] = newDir
                dirs.add(newDir)
            }

            it.first().isDigit() -> {
                val size = it.split(" ").first().toInt()
                current.size += size
                var p = current.parent
                while (p != null) {
                    p.size += size
                    p = p.parent
                }
            }
        }
    }
    var result = 0
    dirs.forEach {
        if (it.size <= 100000)
            result += it.size
    }
    println("part 1: $result")
}

fun part2(filename: String) {
    val rootDir = Dir("/")
    val dirs = mutableListOf(rootDir)
    var current = rootDir
    File(filename).forEachLine {
        val words = it.split(" ")
        when {
            it.startsWith("$ cd ") -> {
                current = when (val n = it.drop(5)) {
                    "/" -> rootDir
                    ".." -> current.parent!!
                    else -> current.child.getValue(n)
                }
            }

            it.startsWith("dir") -> {
                val newDir = Dir(it.drop(4), parent = current)
                current.child[newDir.name] = newDir
                dirs.add(newDir)
            }

            it.first().isDigit() -> {
                val size = it.split(" ").first().toInt()
                current.size += size
                var p = current.parent
                while (p != null) {
                    p.size += size
                    p = p.parent
                }
            }
        }
    }
    val result = dirs.filter { it.size >= 30000000 - (70000000 - rootDir.size) }.minOf { it.size }
    println("part 2: $result")
}

fun main(args: Array<String>) {
    part1(args[0])
    part2(args[0])
}