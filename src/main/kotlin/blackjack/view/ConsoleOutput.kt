package blackjack.view

import blackjack.domain.Constants.INITIAL_CARD_COUNT
import blackjack.domain.Player
import blackjack.domain.Players

class ConsoleOutput {
    fun printInitialCards(players: Players) {
        println("${players.list.joinToString { it.name }}에게 ${INITIAL_CARD_COUNT}장의 카드를 나누었습니다.")
        players.list.map { println(getPlayerInfo(it)) }
        println()
    }

    fun printPlayerCards(player: Player) = getPlayerInfo(player)

    fun printGameResult(players: Players) {
        players.list.map { println("${getPlayerInfo(it)} - 결과:") }
    }

    private fun getPlayerInfo(player: Player) = "${player.name}카드: ${player.cards}"
}
