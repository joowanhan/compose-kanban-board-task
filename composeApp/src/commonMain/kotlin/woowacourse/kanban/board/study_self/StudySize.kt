package woowacourse.kanban.board.study_self

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun StudySize() {
    Column {
//        WrapContentSizeExample()
//        RequiredSizeExample()
    }
}

@Preview(showBackground = true, name = "Preview1")
@Composable
fun WrapContentSizeExample() {
    // 부모 Box는 최소/최대 크기가 200.dp로 고정됨
    Box(modifier = Modifier.size(200.dp).background(Color.LightGray)) {
        Text(
            text = "Hello",
            modifier = Modifier
                // 부모는 200dp를 채우라고 요구하지만, 자식은 최소 제약을 무시하고
                // 텍스트의 실제 크기만큼만 줄어든 뒤 우측 하단에 정렬된다.
                .wrapContentSize(align = Alignment.BottomEnd)
                .background(Color.Yellow),
        )
    }
}

@Preview(showBackground = true, name = "Preview2")
@Composable
fun RequiredSizeExample() {
    // 부모 Box는 크기가 100.dp로 고정됨 (최대 크기 제약 = 100.dp)
    Box(modifier = Modifier.size(100.dp).background(Color.LightGray)) {
        Box(
            modifier = Modifier
                // 일반 size(150.dp)를 쓰면 부모의 최대 제약에 막혀 100.dp로 깎인다.
                // requiredSize(150.dp)를 쓰면 부모 제약을 무시하고 150.dp를 유지하여 부모 바깥으로 튀어나간다.
                .requiredSize(150.dp)
                .background(Color.Blue.copy(alpha = 0.5f)),
        )
    }
}
