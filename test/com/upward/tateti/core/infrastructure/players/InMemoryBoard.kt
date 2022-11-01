package com.upward.tateti.core.infrastructure.players

import com.upward.tateti.core.domain.board.Board
import com.upward.tateti.core.domain.board.Position
import com.upward.tateti.core.domain.players.Symbol

class InMemoryBoard : Board {
    private val matrix = Array(3) { Array(3) { Symbol.None } }
    private var lastPlayer = Symbol.O

    override fun add(position: Position, symbol: Symbol) {
        lastPlayer = symbol
        matrix[position.x][position.y] = symbol
    }

    override fun get(position: Position) = matrix[position.x][position.y]

    override fun lastPlayer() = lastPlayer
}
