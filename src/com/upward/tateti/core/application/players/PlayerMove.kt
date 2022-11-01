package com.upward.tateti.core.application.players

import com.upward.tateti.core.domain.board.Board
import com.upward.tateti.core.domain.board.Position
import com.upward.tateti.core.domain.board.PositionFixedError
import com.upward.tateti.core.domain.players.Symbol

class PlayerMove(private val board: Board) {
    fun exec(position: Position) {
        val symbol = nextSymbol()
        if (board.isFixed(position)) throw PositionFixedError()
        this.board.add(position, symbol)
    }

    private fun nextSymbol() = if (board.lastPlayer() == Symbol.X) Symbol.O else Symbol.X
}
