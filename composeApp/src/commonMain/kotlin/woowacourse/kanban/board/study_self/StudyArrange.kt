package woowacourse.kanban.board.study_self

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true, name = "Preview1")
fun LayoutExample() {
    // Row: 수평이 주축, 수직이 교차축
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        // 주축(수평) 배치: 요소들 사이 간격을 동일하게 배치
//        horizontalArrangement = Arrangement.SpaceEvenly,

        // 핵심 수정 부분: 10dp 간격을 유지하면서 주축(Horizontal)의 중앙(Center)에 배치
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        // 교차축(수직) 정렬: 요소들을 수직 중앙에 배치
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(modifier = Modifier.size(40.dp).background(Color.Red))
        Box(modifier = Modifier.size(40.dp).background(Color.Blue))
        Box(modifier = Modifier.size(40.dp).background(Color.Green))
    }
}
