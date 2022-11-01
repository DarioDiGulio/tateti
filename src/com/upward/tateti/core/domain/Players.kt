package com.upward.tateti.core.domain

interface Players {
    fun add(player: Player)
    fun get(): List<Player>
}