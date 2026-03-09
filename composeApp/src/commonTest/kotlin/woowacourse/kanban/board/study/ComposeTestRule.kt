package woowacourse.kanban.board.study

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

class ComposeTestRule {

    @OptIn(ExperimentalComposeUiApi::class, ExperimentalTestApi::class)
    @Test
    fun testCommonButtonLogic() = runComposeUiTest {
        // 1. 공통 UI 배치
        setContent {
            var count by remember { mutableStateOf(0) }
            Button(
                onClick = { count++ },
                modifier = Modifier.testTag("counter_btn"),
            ) {
                Text("Count: $count")
            }
        }

        // 2. 상호작용 수행 (플랫폼 공통 API)
        onNodeWithTag("counter_btn").performClick()

        // 3. 결과 검증
        onNodeWithTag("counter_btn").assertTextContains("Count: 1")
    }
}
