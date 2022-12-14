package com.upward.tateti.core.domain.board

import com.upward.tateti.core.domain.players.Symbol

interface Board {
    fun lastPlayer(): Symbol
    fun isFixed(position: Position): Boolean
    fun get(position: Position): Symbol
    fun add(position: Position)
    fun gameStatus(): GameStatus
    fun isFull(): Boolean
    fun isEmpty(): Boolean
    fun reset()
}