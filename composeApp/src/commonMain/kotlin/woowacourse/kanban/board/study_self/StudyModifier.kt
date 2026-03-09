package woowacourse.kanban.board.study_self

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun StudyModifier() {
    ModifierExample()
}

@Composable
fun ModifierExample() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        // 1. 배경을 먼저 칠하고 패딩을 준 경우
        // 배경이 전체 Box 영역을 채운 뒤, 내부 콘텐츠(Text)와의 사이에 16dp의 여백이 생김.
        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(16.dp),
        ) {
            Text("배경 -> 패딩")
        }

        Spacer(modifier = Modifier.height(6.dp).background(Color.Green))

        // 2. 패딩을 먼저 주고 배경을 칠한 경우 -> 마진 효과 구현임!!
        // 바깥쪽에 16dp의 여백이 먼저 생기고, 남은 안쪽 영역에만 배경이 칠해짐.
        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.LightGray),
        ) {
            Text("패딩 -> 배경")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 3. 실전 복합 예시: 클릭 가능한 라운드형 버튼 (Custom Button)
        Box(
            modifier = Modifier
//                .fillMaxHeight()
//                .fillMaxSize()
                .fillMaxWidth() // 가로를 꽉 채움
                .clip(RoundedCornerShape(8.dp)) // 클릭 리플 이벤트를 둥근 모서리에 맞추기 위해 가장 먼저 clip 적용
                .clickable { /* 클릭 이벤트 처리 */ }
                .background(Color.Blue) // 배경색 설정
                .padding(16.dp), // 배경 안쪽으로 16dp 여백 (Text를 밀어냄)
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "클릭 가능한 컴포넌트", color = Color.White)
        }
    }
}

@Preview(showBackground = true, name = "Preview1")
@Composable
fun ModifierPreview1() {
    // 내부에서 실제 컴포넌트에 하드코딩된 더미 데이터를 주입한다.
    ModifierExample()
}

@Preview(showBackground = true, name = "Preview2")
@Composable
fun ModifierOrderExample() {
    // 1. 패딩이 외부에 적용된 경우 (배경색은 패딩 안쪽에만 칠해짐)
    Column {
        Box(
            modifier = Modifier
                .size(100.dp)
                .padding(16.dp) // 먼저 패딩 공간 확보
                .background(Color.Red), // 확보된 내부 공간에 배경색 칠함
        )

        // 2. 배경이 먼저 적용된 경우 (배경색이 전체 크기에 칠해진 후 내부 컨텐츠가 밀려남)
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red) // 먼저 100dp 전체에 배경색 칠함
                .padding(16.dp), // 그 다음 내부 컨텐츠를 위한 패딩 적용
        )
    }
}
