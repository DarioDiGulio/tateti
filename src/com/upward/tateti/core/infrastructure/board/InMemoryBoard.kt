package com.upward.tateti.core.infrastructure.board

import com.upward.tateti.core.domain.board.Board
import com.upward.tateti.core.domain.board.GameStatus
import com.upward.tateti.core.domain.board.Position
import com.upward.tateti.core.domain.players.Symbol

class InMemoryBoard: Board {
    private val matrix = Array(3) { Array(3) { Symbol.None } }
    private var lastPlayer = Symbol.O

    override fun add(position: Position) {
        val symbol = if (lastPlayer() == Symbol.X) Symbol.O else Symbol.X
        lastPlayer = symbol
        matrix[position.x][position.y] = symbol
    }

    override fun gameStatus(): GameStatus {
        var gameStatus = checkRows()
        if (gameStatus == GameStatus.Playing) {
            gameStatus = checkColumns()
        }
        if (gameStatus == GameStatus.Playing) {
            gameStatus = checkDiagonals()
        }
        if (gameStatus == GameStatus.Playing && this.isFull()) return GameStatus.Tie
        return gameStatus
    }

    private fun checkDiagonals(): GameStatus {
        var first = matrix[0][0]
        var second = matrix[1][1]
        var third = matrix[2][2]
        var gameStatus = findWinner(first, second, third)
        if (gameStatus == GameStatus.Playing) {
            first = matrix[0][2]
            second = matrix[1][1]
            third = matrix[2][0]
            gameStatus = findWinner(first, second, third)
        }
        return gameStatus
    }

    private fun checkColumns(): GameStatus {
        matrix.forEachIndexed { index, _ ->
            val gameStatus = findWinner(matrix[0][index], matrix[1][index], matrix[2][index])
            if (gameStatus != GameStatus.Playing) return gameStatus
        }
        return GameStatus.Playing
    }

    private fun checkRows(): GameStatus {
        matrix.forEach { row ->
            val gameStatus = findWinner(row[0], row[1], row[2])
            if (gameStatus != GameStatus.Playing) return gameStatus
        }
        return GameStatus.Playing
    }

    private fun findWinner(first: Symbol, second: Symbol, third: Symbol): GameStatus {
        if (first == Symbol.X && second == Symbol.X && third == Symbol.X) return GameStatus.XWin
        if (first == Symbol.O && second == Symbol.O && third == Symbol.O) return GameStatus.OWin
        return GameStatus.Playing
    }

    override fun isFull(): Boolean {
        matrix.forEach { row -> row.forEach { cell -> if (cell == Symbol.None) return false } }
        return true
    }

    override fun get(position: Position) = matrix[position.x][position.y]

    override fun lastPlayer() = lastPlayer

    override fun isFixed(position: Position) = matrix[position.x][position.y] != Symbol.None
}
