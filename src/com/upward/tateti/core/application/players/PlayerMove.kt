package com.upward.tateti.core.application.players

import com.upward.tateti.core.domain.board.Board
import com.upward.tateti.core.domain.board.GameStatus
import com.upward.tateti.core.domain.board.Position
import com.upward.tateti.core.domain.board.PositionFixedError

class PlayerMove(private val board: Board) {
    fun exec(position: Position): GameStatus {
        if (board.isFixed(position)) throw PositionFixedError()
        this.board.add(position)
        return board.gameStatus()
    }
}
