package com.upward.tateti.core.application.players

import com.upward.tateti.core.domain.board.Board
import com.upward.tateti.core.domain.players.Symbol

class PlayerMove(private val board: Board) {
    fun exec(x: Int, y: Int) {
        this.board.add(x, y, Symbol.X)
    }
}
