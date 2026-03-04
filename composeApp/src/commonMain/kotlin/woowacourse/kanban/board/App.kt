package woowacourse.kanban.board

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
        modifier = Modifier.fillMaxSize().padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
//        MessageList(messages = listOf("Hello", "World", "Jetpack", "Compose"))
        CircularIconExample()
        CheckerScreen()
        TextExample()
        ImageExample()
        IconExample()
        SaveButton()
        HeartImageButton()
        StyledSaveButton()
        StyledHeartButton()
        SimpleBox()
        ComplexBox()
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

@Composable
fun SimpleBox() {
    Box(
        modifier = Modifier.size(120.dp),
    ) {
        // 파란색 사각형, 왼쪽 위에 배치
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
                .align(Alignment.TopStart),
        )

        // 초록색 사각형, 오른쪽 아래에 배치
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .align(Alignment.BottomEnd),
        )
    }
}


@Composable
fun ComplexBox() {
    Box(
        modifier = Modifier.requiredSize(200.dp).background(Color.White),
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .align(Alignment.TopStart),
        )

        // 초록색 사각형, 오른쪽 아래에 배치
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Yellow)
                .align(Alignment.Center),
        )

        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
                .align(Alignment.BottomEnd),
        )
    }
}

// LazyColumn 실전 예시
@Composable
fun MessageList(messages: List<String>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp), // 항목 간 간격 설정
    ) {
        // 단일 헤더 항목
        item {
            Text(text = "메시지 목록", style = MaterialTheme.typography.headlineMedium)
        }

        // 리스트 기반 동적 항목
        items(messages) { message ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            ) {
                Text(
                    text = message,
                    modifier = Modifier.padding(16.dp),
                )
            }
        }
    }
}


@Composable
fun CircularIconExample() {
    // 1. 원형으로 자를 기준이 되는 부모 컨테이너
    Box(
        modifier = Modifier
            .size(100.dp) // 최종적으로 화면에 보여질 원의 크기
            .clip(CircleShape) // 내부 요소를 원형으로 자름
            .background(Color.White)
            .border(width = 10.dp, color = Color.Gray, shape = CircleShape) // 두꺼운 테두리 적용, // 아이콘의 뚫린 실루엣을 통해 보여질 색상(흰색)
//        contentAlignment = Alignment.Center,
    ) {
        // 2. 사각형 테두리를 숨기기 위해 확장된 AccountBox
        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = "Profile",
            tint = Color.Gray, // 배경이 될 원의 색상(회색)
            modifier = Modifier
                .requiredSize(135.dp)
//                .border(width = 30.dp, color = Color.Red), // 부모(100.dp)의 제약을 무시하고 크기를 강제로 키움


        )
    }
}