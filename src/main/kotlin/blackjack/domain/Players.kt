package blackjack.domain

const val MAX_PLAYER_COUNT = 8

class Players(val list: List<Player>) {
    init {
        require(list.size <= MAX_PLAYER_COUNT) { "게임 정원을 초과하였습니다." }
    }
}
