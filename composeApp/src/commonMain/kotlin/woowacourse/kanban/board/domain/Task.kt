package woowacourse.kanban.board.domain

data class Task(val title: String, val cardDescription: String = "", val chips: List<String> = emptyList(), val user: String = "알수없음") {
    init {
        require(title.isNotBlank()) { "제목은 비어 있거나 공백만 있을 수 없습니다." }
        require(chips.size <= 5) { "태그(칩)는 최대 5개까지만 허용됩니다." }
        chips.forEach { chip ->
            require(chip.length <= 5) { "각 태그(칩)는 최대 5자까지만 가능합니다." }
        }
    }
}
