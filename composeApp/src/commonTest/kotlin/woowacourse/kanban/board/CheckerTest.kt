package woowacourse.kanban.board

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class CheckerTest {

    @Test
    fun `체크박스 체크되지 않았으면 텍스트 미노출`() = runComposeUiTest {
        var checked by mutableStateOf(false)
        setContent {
            CheckerView(check = {}, checked = checked)
        }

        onNodeWithText("체크됨!!!")
            .assertDoesNotExist()
    }

    @Test
    fun `체크박스 체크되면 텍스트 노출`() = runComposeUiTest {
        var checked by mutableStateOf(true)
        setContent {
            CheckerView(check = {}, checked = checked)
        }

        onNodeWithText("체크됨!!!")
            .assertExists()
    }
}
