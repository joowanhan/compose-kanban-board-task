package woowacourse.kanban.board.study_self

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true, name = "Preview0")
fun RowTagCloud() {
    val tags = listOf("Kotlin", "Compose", "Android", "Studio", "Panda", "M4 Pro", "MacBook", "UI/UX", "Mobile")

    // horizontalArrangement: 아이템 간의 가로 간격
    // maxItemsInEachRow: 한 줄에 배치할 최대 아이템 개수 제한 가능
    Row(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        tags.forEach { tag ->
            SuggestionChip(
                onClick = { /* 클릭 이벤트 */ },
                label = { Text(tag) },
            )
        }
    }
}

@Composable
@Preview(showBackground = true, name = "Preview1")
fun FlowRowTagCloud() {
    val tags = listOf("Kotlin", "Compose", "Android", "Studio", "Panda", "M4 Pro", "MacBook", "UI/UX", "Mobile")

    // horizontalArrangement: 아이템 간의 가로 간격
    // maxItemsInEachRow: 한 줄에 배치할 최대 아이템 개수 제한 가능
    FlowRow(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        tags.forEach { tag ->
            SuggestionChip(
                onClick = { /* 클릭 이벤트 */ },
                label = { Text(tag) },
            )
        }
    }
}

@Composable
@Preview(showBackground = true, name = "LazyColumn")
fun LazyContactList() {
    val contacts = List(1000) { "사용자 #$it" } // 1000개의 대량 데이터

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        // stickyHeader와 같은 특수 기능을 사용할 수 있음
        item {
            Text(text = "연락처 목록", style = MaterialTheme.typography.headlineMedium)
        }

        // 대량의 아이템을 처리하는 핵심 섹션
        items(contacts) { name ->
            Card(
                modifier = Modifier.fillMaxWidth(),
            ) {
                ListItem(
                    headlineContent = { Text(name) },
                    supportingContent = { Text("상태 메시지 예시입니다.") },
                    leadingContent = { Icon(Icons.Default.Person, contentDescription = null) },
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, name = "Column")
fun ColumnContactList() {
    val contacts = List(1000) { "사용자 #$it" }
    // Column은 자체 스크롤 기능이 없으므로 스크롤 상태를 직접 관리해야 함
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState), // 스크롤 활성화
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(text = "연락처 목록", style = MaterialTheme.typography.headlineMedium)

        contacts.forEach { name ->
            Card(
                modifier = Modifier.fillMaxWidth(),
            ) {
                ListItem(
                    headlineContent = { Text(name) },
                    supportingContent = { Text("상태 메시지 예시입니다.") },
                    leadingContent = { Icon(Icons.Default.Person, contentDescription = null) },
                )
            }
        }
    }
}
