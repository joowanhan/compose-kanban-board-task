package woowacourse.kanban.board

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kanbanboard.composeapp.generated.resources.Res
import kanbanboard.composeapp.generated.resources.default_planet
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview(showBackground = true)
fun App() {

    Column {
        CheckerScreen()
        TextExample()
        ImageExample()
        IconExample()
    }
}

@Composable
fun CheckerScreen() {
    var checked by remember { mutableStateOf(true) }

    CheckerView(checked = checked) {
        checked = !checked
    }
}

@Composable
fun CheckerView(checked: Boolean, check: () -> Unit) {
    Column {
        Checkbox(
            checked = checked,
            onCheckedChange = { check() },
        )
        if (checked) Text(text = "체크됨!!!")
    }
}

@Composable
fun TextExample() {
    Text(
        text = "Jetpack Compose Text 실습",      // 1. 표시할 문자열
        color = Color.Blue,            // 2. 글자 색상
        fontSize = 14.sp,              // 3. 글자 크기 (sp 단위 사용)
        fontStyle = FontStyle.Italic,  // 4. 글자 형태 (기울임꼴)
        fontWeight = FontWeight.Bold,   // 5. 글자 굵기 (굵게)
    )
}


@Composable
fun ImageExample() {
    Image(
        // R.drawable 대신 Res.drawable을 사용하며, 파라미터 이름은 'resource'이다.
        painter = painterResource(resource = Res.drawable.default_planet),
        contentDescription = "default_planet",
        modifier = Modifier.size(48.dp),
    )
}

@Composable
fun IconExample() {
    Image(
        painter = rememberVectorPainter(image = Icons.Default.Favorite),
        contentDescription = "좋아요 아이콘",
        modifier = Modifier.size(48.dp),
    )
}