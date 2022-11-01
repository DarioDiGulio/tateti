package com.upward.tateti.core.infrastructure

import com.upward.tateti.core.domain.Player
import com.upward.tateti.core.domain.Players

class InMemoryPlayerStorage: Players {
    private val players = mutableListOf<Player>()

    override fun add(player: Player) {
        players.add(player)
    }

    override fun get() = players
}
