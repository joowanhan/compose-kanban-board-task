package woowacourse.kanban.board.study_self.commonFeedback

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ModifierExample() {
    Row {
        // 예시 1: 배경 -> 패딩 -> 크기
        Box(
            Modifier
                .background(Color.Green) // 먼저 배경색 적용
                .padding(20.dp) // 그 다음 패딩 적용
                .size(100.dp), // 마지막으로 크기 지정
        )
        // 예시 2: 패딩 -> 크기 -> 배경
        Box(
            Modifier
                .padding(20.dp) // 먼저 패딩 적용
                .size(100.dp) // 그 다음 크기 지정
                .background(Color.Green), // 마지막으로 배경색 적용
        )
    }
}
