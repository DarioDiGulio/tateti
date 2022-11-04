package com.upward.tateti.core.application.players

import com.upward.tateti.core.domain.board.Board
import com.upward.tateti.core.domain.board.GameStatus
import com.upward.tateti.core.domain.board.Position
import com.upward.tateti.core.domain.board.PositionFixedError
import com.upward.tateti.core.domain.players.Players
import com.upward.tateti.core.domain.players.Symbol

class PlayerMove(private val board: Board, private val players: Players) {
    fun exec(position: Position): GameStatus {
        if (board.isFixed(position)) throw PositionFixedError()
        this.board.add(position)
        val gameStatus = board.gameStatus()
        if (gameStatus == GameStatus.XWin) players.getBySymbol(Symbol.X).win()
        return gameStatus
    }
}
