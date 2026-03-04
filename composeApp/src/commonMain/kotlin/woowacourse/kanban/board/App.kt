package woowacourse.kanban.board

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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


    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        // 1. 세로 배치: 자식들 사이에 20.dp 간격을 띄운다.
        verticalArrangement = Arrangement.spacedBy(20.dp),
        // 2. 가로 정렬: 모든 요소를 가로 중앙으로 모은다.
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CheckerScreen()
        TextExample()
        ImageExample()
        IconExample()
        SaveButton()
        HeartImageButton()
        StyledSaveButton()
        StyledHeartButton()
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

@Composable
fun SaveButton() {
    Button(
        onClick = {
            println("데이터가 저장되었습니다.")
        },
    ) {
        Text(text = "저장")
    }
}


@Composable
fun StyledSaveButton() {
    //    저장 여부를 기억
    var isSaved by remember { mutableStateOf(false) }

    Button(
        onClick = { isSaved = !isSaved }, // 클릭 시 상태 반전
        // 상태에 따른 색상 설정
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSaved) Color.Gray else Color.Blue,
            contentColor = Color.White,
        ),
        shape = RoundedCornerShape(8.dp), // 모서리를 약간 둥글게
    ) {
        Text(if (isSaved) "저장됨" else "저장")
    }
}

@Composable
fun HeartImageButton() {
    Button(
        onClick = {
            println("좋아요를 눌렀습니다!")
        },
    ) {
        // 이미지와 텍스트를 가로로 배치하기 위해 Row를 쓰지 않아도
        // Button 내부 기본 배치가 Row와 유사하게 작동한다.
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "좋아요",
            tint = Color.White, // 버튼 배경색과 대비되도록 흰색 설정
        )
        Text(text = "", modifier = Modifier.padding(start = 8.dp))
    }
}

@Composable
fun StyledHeartButton() {

    var isLiked by remember { mutableStateOf(false) }

    Button(
        onClick = { isLiked = !isLiked },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF0F0F0), // 연한 회색 배경
            contentColor = Color.Black,          // 기본 글자색
        ),
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "좋아요",
            // 2. 아이콘 색상만 빨간색으로 변경 (이유: 시각적으로 '활성화' 상태를 명확히 보여주기 위함)
            tint = if (isLiked) Color.Red else Color.Gray,
            modifier = Modifier.size(24.dp),
        )
        Text(
            text = if (isLiked) "좋아요 취소" else "좋아요",
            modifier = Modifier.padding(start = 8.dp),
        )
    }
}