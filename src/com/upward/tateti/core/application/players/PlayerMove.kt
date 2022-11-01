package com.upward.tateti.core.application.players

import com.upward.tateti.core.domain.board.Board
import com.upward.tateti.core.domain.board.Position
import com.upward.tateti.core.domain.players.Symbol

class PlayerMove(private val board: Board) {
    fun exec(position: Position) {
        val symbol = if (board.lastPlayer() == Symbol.X) Symbol.O else Symbol.X
        this.board.add(position, symbol)
    }
}
