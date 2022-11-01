package com.upward.tateti.core.domain.board

import com.upward.tateti.core.domain.players.Symbol

interface Board {
    fun lastPlayer(): Symbol
    fun get(x: Int, y: Int): Symbol
    fun add(x: Int, y: Int, symbol: Symbol)
}