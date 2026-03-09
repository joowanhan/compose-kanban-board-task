package woowacourse.kanban.board.study_self

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale

// 1. 실제 UI를 구성하는 컴포넌트 (매개변수 존재)
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

// 2. 미리보기를 위한 래퍼(Wrapper) 컴포넌트 (매개변수 없음)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    // 내부에서 실제 컴포넌트에 하드코딩된 더미 데이터를 주입한다.
    Column {
        Greeting(name = "Kotlin")
        Greeting(name = "Android")
    }
}

@PreviewFontScale
@Preview(showBackground = true, name = "Preview2 - fontscale")
@Composable
fun GreetingPreview2() {
    // 내부에서 실제 컴포넌트에 하드코딩된 더미 데이터를 주입한다.
    Greeting(name = "Kotlin")
}
