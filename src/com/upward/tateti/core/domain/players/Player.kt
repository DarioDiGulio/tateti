package com.upward.tateti.core.domain.players

class Player(val name: String, val symbol: Symbol) {
    var history = 0

    fun win() {
        history++
    }
}
