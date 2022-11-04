package com.upward.tateti.core.infrastructure.players

import com.upward.tateti.core.domain.players.Player
import com.upward.tateti.core.domain.players.Players
import com.upward.tateti.core.domain.players.Symbol

class InMemoryPlayerStorage: Players {
    private val players = mutableListOf<Player>()

    override fun add(player: Player) {
        players.add(player)
    }

    override fun get() = players

    override fun getBySymbol(symbol: Symbol) = players.first { it.symbol == symbol }
}
