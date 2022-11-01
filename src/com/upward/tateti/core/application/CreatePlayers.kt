package com.upward.tateti.core.application

import com.upward.tateti.core.domain.Player
import com.upward.tateti.core.domain.Players

class CreatePlayers(private val players: Players) {
    fun exec(leftPlayerName: String, rightPlayerName: String) {
        val leftPlayer = Player(leftPlayerName)
        val rightPlayer = Player(rightPlayerName)
        this.players.add(leftPlayer)
        this.players.add(rightPlayer)
    }
}