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
        var gameStatus = checkFirstRow()
        if (gameStatus == GameStatus.Playing) {
            gameStatus = checkSecondRow()
        }
        if (gameStatus == GameStatus.Playing) {
            gameStatus = checkThirdRow()
        }
        return gameStatus
    }

    private fun checkFirstRow(): GameStatus {
        val firstRowFirstColumn = this.get(Position(0, 0))
        val firstRowSecondColumn = this.get(Position(0, 1))
        val firstRowThirdColumn = this.get(Position(0, 2))
        return findWinner(firstRowFirstColumn, firstRowSecondColumn, firstRowThirdColumn)
    }

    private fun checkSecondRow(): GameStatus {
        val secondRowFirstColumn = this.get(Position(1, 0))
        val secondRowSecondColumn = this.get(Position(1, 1))
        val secondRowThirdColumn = this.get(Position(1, 2))
        return findWinner(secondRowFirstColumn, secondRowSecondColumn, secondRowThirdColumn)
    }

    private fun checkThirdRow(): GameStatus {
        val thirdRowFirstColumn = this.get(Position(2, 0))
        val thirdRowSecondColumn = this.get(Position(2, 1))
        val thirdRowThirdColumn = this.get(Position(2, 2))
        return findWinner(thirdRowFirstColumn, thirdRowSecondColumn, thirdRowThirdColumn)
    }

    private fun findWinner(first: Symbol, second: Symbol, third: Symbol): GameStatus {
        if (first == Symbol.X && second == Symbol.X && third == Symbol.X) return GameStatus.XWin
        if (first == Symbol.O && second == Symbol.O && third == Symbol.O) return GameStatus.OWin
        return GameStatus.Playing
    }

    override fun get(position: Position) = matrix[position.x][position.y]

    override fun lastPlayer() = lastPlayer

    override fun isFixed(position: Position) = matrix[position.x][position.y] != Symbol.None
}
