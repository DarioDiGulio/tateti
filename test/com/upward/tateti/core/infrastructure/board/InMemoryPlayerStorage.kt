package com.upward.tateti.core.infrastructure.board

import com.upward.tateti.core.domain.players.Player
import com.upward.tateti.core.domain.players.Players

class InMemoryPlayerStorage: Players {
    private val players = mutableListOf<Player>()

    override fun add(player: Player) {
        players.add(player)
    }

    override fun get() = players
}
