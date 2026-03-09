package woowacourse.kanban.board.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.domain.Task

@OptIn(ExperimentalTestApi::class)
class CardTest {

    @Test
    fun `모든 필드가 있는 카드 - 제목, 설명, 태그, 담당자가 모두 화면에 노출된다`() = runComposeUiTest {
        // given: 정상적인 비즈니스 규칙을 통과한 Task 객체 생성
        val task = Task(
            title = "UI 테스트 작성하기",
            cardDescription = "컴포즈 UI 테스트 코드를 작성한다.",
            chips = listOf("테스트", "UI"),
            user = "다이노",
        )

        // when: Compose 환경에 Card 렌더링
        setContent {
            Card(task = task)
        }

        // then: 각 필드의 텍스트를 가진 노드가 UI 트리에 존재하는지 단언
        onNodeWithText("UI 테스트 작성하기").assertExists()
        onNodeWithText("컴포즈 UI 테스트 코드를 작성한다.").assertExists()

        // useUnmergedTree = true: 하위 노드의 텍스트를 병합하지 않고 개별적으로 찾을때 유용함
        onNodeWithText("테스트", useUnmergedTree = true).assertExists()
        onNodeWithText("UI", useUnmergedTree = true).assertExists()
        onNodeWithText("다이노", useUnmergedTree = true).assertExists()
    }

    @Test
    fun `본문이 없는 카드 - 설명 필드가 화면에 노출되지 않는다`() = runComposeUiTest {
        val task = Task(
            title = "본문 없음 테스트",
            user = "다이노",
        )

        setContent {
            Card(task = task)
        }

        onNodeWithText("본문 없음 테스트").assertExists()
        // 본문 텍스트가 존재하지 않음을 검증
        onNodeWithText("컴포즈 UI 테스트 코드를 작성한다.").assertDoesNotExist()
    }
}
