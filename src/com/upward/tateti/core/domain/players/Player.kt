package com.upward.tateti.core.domain.players

class Player(val name: String, val symbol: Symbol) {
    var history = 0
        private set

    fun win() {
        history++
    }

    fun reset() {
        history = 0
    }
}
