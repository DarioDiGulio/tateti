package com.upward.tateti.core.domain.players

interface Players {
    fun add(player: Player)
    fun get(): List<Player>
}