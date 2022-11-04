package com.upward.tateti.core.application.game

import com.upward.tateti.core.domain.board.Board
import com.upward.tateti.core.domain.players.Players

class ResetGame(private val players: Players, private val board: Board) {
    fun exec() {
        players.get().forEach { it.reset() }
        board.reset()
    }
}
