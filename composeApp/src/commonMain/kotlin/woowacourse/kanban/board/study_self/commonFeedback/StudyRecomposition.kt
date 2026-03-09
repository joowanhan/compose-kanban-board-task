package woowacourse.kanban.board.study_self.commonFeedback

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, name = "Preview1")
@Composable
fun Counter() {
    var number by remember { mutableStateOf(0) }

    Column {
        Text(text = "카운터 앱!")
        Button(onClick = { number++ }) {
            Text(text = "카운팅: ", fontWeight = FontWeight.Bold)
            Text(text = number.toString())
        }
    }
}

@Preview(showBackground = true, name = "Preview2")
@Composable
fun Checker() {
    var checked by remember { mutableStateOf(false) }

    Column {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it },
        )
    }
}

//
// @Preview(showBackground = true, name = "Checker Preview")
// @Composable
// fun CheckerPreview() {
//    // We hold the state here for the preview
//    var isChecked by rememberSaveable { mutableStateOf(false) }
//
//    Checker(
//        checked = isChecked,
//        onCheckedChange = { isChecked = it },
//    )
// }
//
// @Composable
// fun Checker(checked: Boolean, onCheckedChange: (Boolean) -> Unit, modifier: Modifier = Modifier) {
//    Column(modifier = modifier.padding(16.dp)) {
//        Checkbox(
//            checked = checked,
//            onCheckedChange = onCheckedChange,
//        )
//    }
// }
