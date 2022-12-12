package day08

import java.io.File

fun isVisible(row: Int, col: Int, forest: List<List<Int>>): Boolean {
    if (col == 0 || row == 0 || col == forest[row].size - 1 || row == forest.size - 1)
        return true

    val cellValue = forest[row][col]

    var up = true
    for (y in row - 1 downTo 0) {
        if (forest[y][col] >= cellValue)
            up = false
    }
    var down = true
    for (y in row + 1 until forest.size) {
        if (forest[y][col] >= cellValue)
            down = false
    }
    var left = true
    for (x in col - 1 downTo 0) {
        if (forest[row][x] >= cellValue)
            left = false
    }
    var right = true
    for (x in col + 1 until forest[row].size) {
        if (forest[row][x] >= cellValue)
            right = false
    }

    return up || down || left || right
}

fun getScenicScore(row: Int, col: Int, forest: List<List<Int>>): Int {
    val cellValue = forest[row][col]

    var up = 0
    for (y in 1..row) {
        up++
        if (forest[row - y][col] >= cellValue)
            break
    }
    var down = 0
    for (y in 1 until forest.size - row) {
        down++
        if (forest[row + y][col] >= cellValue)
            break
    }
    var left = 0
    for (x in 1..col) {
        left++
        if (forest[row][col - x] >= cellValue)
            break

    }
    var right = 0
    for (x in 1 until forest[row].size - col) {
        right++
        if (forest[row][col + x] >= cellValue)
            break
    }

    return up * down * left * right
}

fun part1(filename: String) {
    val input = File(filename).readLines()
    val forest = input.map { it.toList().map(Char::digitToInt) }
    var count = 0

    for (row in forest.indices) {
        for (col in forest[row].indices) {
            if (isVisible(row, col, forest))
                count++
        }
    }

    println("part 1: $count")
}

fun part2(filename: String) {
    val input = File(filename).readLines()
    val forest = input.map { it.toList().map(Char::digitToInt) }
    var maxScore = 0;

    for (row in forest.indices) {
        for (col in forest[row].indices) {
            val currentScore = getScenicScore(row, col, forest)
            if (currentScore > maxScore)
                maxScore = currentScore
        }
    }

    println("part 2: $maxScore")
}

fun main(args: Array<String>) {
    part1(args[0])
    part2(args[0])
}