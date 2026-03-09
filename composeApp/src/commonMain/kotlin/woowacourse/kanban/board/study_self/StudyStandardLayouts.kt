package woowacourse.kanban.board.study_self

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true, name = "Preview1")
fun StandardLayoutExample() {
    // 1. Column: 전체적인 수직 구조 형성
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
//        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        // 2. Row: 가로로 아이템 배치
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier.size(40.dp).background(Color.Blue),
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "사용자 이름")
        }

        // 3. Box: 겹치기 구조
        Box(
            modifier = Modifier.size(100.dp).background(Color.LightGray),
        ) {
            Text(
                text = "중앙 배치",
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}
