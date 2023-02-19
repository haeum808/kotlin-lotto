package lotto.entity

class WinLotto(val winNumber: Lotto, val bonus: LottoNumber) {
    init {
        require(!winNumber.numbers.contains(bonus)) {
            String.format(
                ERROR_MESSAGE_DUPLICATED_BONUS_NUMBER,
                winNumber.toString(),
                bonus.value
            )
        }
    }

    companion object {
        const val ERROR_MESSAGE_DUPLICATED_BONUS_NUMBER =
            "보너스 번호와 당첨 번호는 중복될 수 없습니다. 입력된 당첨 번호 : %s, 보너스 번호 : %d"
    }
}
