package com.upward.tateti.core.application.players

import com.upward.tateti.core.domain.players.Player
import com.upward.tateti.core.domain.players.Players
import com.upward.tateti.core.domain.players.Symbol

class CreatePlayers(private val players: Players) {
    fun exec(leftPlayerName: String, rightPlayerName: String) {
        val leftPlayer = Player(leftPlayerName, Symbol.X)
        val rightPlayer = Player(rightPlayerName, Symbol.O)
        this.players.add(leftPlayer)
        this.players.add(rightPlayer)
    }
}