package com.upward.tateti.core.infrastructure.players

import com.upward.tateti.core.domain.board.Board
import com.upward.tateti.core.domain.players.Symbol

class InMemoryBoard : Board {
    private val matrix = Array(3) { Array(3) { Symbol.None } }

    override fun get(x: Int, y: Int): Symbol {
        return matrix[x][y]
    }

    override fun add(x: Int, y: Int, symbol: Symbol) {
        matrix[x][y] = symbol
    }
}
