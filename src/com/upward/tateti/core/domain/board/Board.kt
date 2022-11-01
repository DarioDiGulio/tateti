package com.upward.tateti.core.domain.board

import com.upward.tateti.core.domain.players.Symbol

interface Board {
    fun lastPlayer(): Symbol
    fun get(position: Position): Symbol
    fun add(position: Position, symbol: Symbol)
}