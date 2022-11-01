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
        val firstRowFirstColumn = this.get(Position(0, 0))
        val firstRowSecondColumn = this.get(Position(0, 1))
        val firstRowThirdColumn = this.get(Position(0, 2))
        if (firstRowFirstColumn == Symbol.X && firstRowSecondColumn == Symbol.X && firstRowThirdColumn == Symbol.X) {
            return GameStatus.XWin
        }
        if (firstRowFirstColumn == Symbol.O && firstRowSecondColumn == Symbol.O && firstRowThirdColumn == Symbol.O) {
            return GameStatus.OWin
        }
        return GameStatus.Playing
    }

    override fun get(position: Position) = matrix[position.x][position.y]

    override fun lastPlayer() = lastPlayer

    override fun isFixed(position: Position) = matrix[position.x][position.y] != Symbol.None
}
