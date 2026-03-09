package woowacourse.kanban.board.domain

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TaskTest {

    @Test
    fun `제목이 비어 있거나 공백만 있는 경우 생성 불가능하다`() {
        assertFailsWith<IllegalArgumentException> {
            Task(title = "")
        }
        assertFailsWith<IllegalArgumentException> {
            Task(title = "   ")
        }
    }

    @Test
    fun `태그가 5개를 초과하면 생성 불가능하다`() {
        assertFailsWith<IllegalArgumentException> {
            Task(
                title = "정상 제목",
                chips = listOf("1", "2", "3", "4", "5", "6"),
            )
        }
    }

    @Test
    fun `태그의 글자수가 5자를 초과하면 생성 불가능하다`() {
        assertFailsWith<IllegalArgumentException> {
            Task(
                title = "정상 제목",
                chips = listOf("여섯글자태그"),
            )
        }
    }

    @Test
    fun `담당자가 null이거나 입력되지 않으면 기본값으로 알수없음이 할당된다`() {
        val task = Task(title = "제목")
        assertEquals("알수없음", task.user)
    }
}
