package com.upward.tateti.core.infrastructure.players

import com.upward.tateti.core.domain.board.Board
import com.upward.tateti.core.domain.players.Symbol

class InMemoryBoard : Board {
    private val matrix = Array(3) { Array(3) { Symbol.None } }
    private var lastPlayer = Symbol.O

    override fun add(x: Int, y: Int, symbol: Symbol) {
        lastPlayer = symbol
        matrix[x][y] = symbol
    }

    override fun get(x: Int, y: Int) = matrix[x][y]

    override fun lastPlayer() = lastPlayer
}
