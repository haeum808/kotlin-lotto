package lotto.entity

import lotto.model.Rank

class Lotto(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_COUNT) { String.format(ERROR_MESSAGE_WIN_NUMBER_IS_SIX, numbers.size) }
    }

    constructor(numbers: List<Int>) : this(numbers.map { LottoNumber.from(it) }.toSet())

    fun matchLottoNumberCount(lotto: Lotto): Int = numbers.intersect(lotto.numbers).size

    fun isMatchBonus(bonus: LottoNumber): Boolean = numbers.contains(bonus)

    fun determineRank(condition: Rank, winLotto: WinLotto): Boolean {
        val countOfMatch = matchLottoNumberCount(winLotto.winNumber)
        var isMatch = countOfMatch == condition.countOfMatch
        if (condition == Rank.MISS && countOfMatch in 0..2)
            return true
        if (condition.needBonus && !isMatchBonus(winLotto.bonus)) {
            isMatch = false
        }
        return isMatch
    }

    override fun toString(): String = "[${numbers.joinToString(", ") { it.value.toString() }}]"

    companion object {
        const val ERROR_MESSAGE_WIN_NUMBER_IS_SIX = "로또 번호는 6개여야 합니다. 입력된 로또 번호 개수는 %d 입니다."
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45
        const val LOTTO_COUNT = 6
    }
}
