package com.upward.tateti.core.domain.players

interface Players {
    fun add(player: Player)
    fun get(): List<Player>
    fun getBySymbol(symbol: Symbol): Player
}