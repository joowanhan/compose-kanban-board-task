# 0단계 - 학습 내용 정리

## 1. UI 테스트 핵심 (Testing)

최신 Compose 환경에서는 `runComposeUiTest` 블록을 사용하여 테스트 환경을 간결하게 구성한다.

* **테스트의 세 기둥:**
* **Finders:** `onNodeWithText`, `onNodeWithTag` 등을 사용하여 시맨틱 트리에서 요소를 찾는다.
* **Actions:** `performClick`, `performTextInput` 등으로 사용자 동작을 시뮬레이션한다.
* **Assertions:** `assertIsDisplayed`, `assertTextEquals` 등으로 UI 상태를 검증한다.


* **전략:** 작성은 `commonTest`에서 공유하고, 실행은 속도가 빠른 `jvmTest` (Desktop 환경)에서 수행하여 개발 생산성을 높인다.

---

## 2. 리소스 관리 (CMP vs Android)

Compose Multiplatform 환경에서는 안드로이드 전용인 `R` 클래스 대신 플랫폼 공통인 `Res` 객체를 사용해야 한다.

* **파일 위치:** `composeApp/src/commonMain/composeResources/drawable/`
* **파일명 규칙:** 소문자 영문, 숫자, 언더바(`_`)만 허용 (한글, 공백, 대문자 불가).
* **호출 방식:** `painterResource(resource = Res.drawable.파일명)`
* **주의:** `R` 클래스 임포트 시 `Key.Companion.R`과 같은 잘못된 클래스가 임포트되지 않도록 주의한다.

---

## 3. 기본 컴포저블 & 스타일링

각 컴포저블은 파라미터를 통해 고유의 속성과 스타일을 제어한다.

| 컴포저블       | 핵심 속성                                  | 특징                           |
|------------|----------------------------------------|------------------------------|
| **Text**   | `color`, `fontSize(.sp)`, `fontWeight` | 문자열 표시 및 스타일링                |
| **Image**  | `painter`, `contentScale`              | 리소스 또는 비트맵 이미지 표시            |
| **Icon**   | `imageVector`, `tint`                  | 시스템 아이콘 표시 및 색상 입히기          |
| **Button** | `onClick`, `colors`, `shape`           | 클릭 이벤트 처리 및 슬롯 API 기반 콘텐츠 배치 |

---

## 4. 상태 관리 (State)

Compose UI는 상태가 바뀔 때마다 화면을 다시 그리는 **재구성(Recomposition)** 과정을 거친다.

* **`mutableStateOf(value)`:** Compose가 관찰할 수 있는 상태 변수를 생성한다.
* **`remember { }`:** 재구성 시에도 변수의 값을 메모리에 유지시킨다.
* **`by` 키워드:** 위임 프로퍼티를 통해 `.value` 없이 변수에 직접 접근한다.
* *필수 임포트:* `getValue`, `setValue`

---

## 5. 레이아웃과 배치 (Layouts)

### Column & Row

* **verticalArrangement:** 세로축 간격 및 정렬 (Top, Center, Bottom, spacedBy).
* **horizontalAlignment:** 가로축 정렬 (Start, CenterHorizontally, End).

### Box

* 요소를 **중첩(Stack)**하여 배치한다.
* `Modifier.align(Alignment.Center)` 등으로 자식 요소의 위치를 개별 제어한다.
* **주의:** 부모의 제약 조건 때문에 크기가 왜곡될 경우 `Modifier.size()` 대신 `Modifier.requiredSize()`를 사용하여 크기를 강제 고정한다.

---

## 6. 개발 도구 (Tooling)

* **@Preview:** 에뮬레이터 없이 UI를 확인하며, `showBackground`, `widthDp` 등의 파라미터로 환경을 시뮬레이션한다.
* **Live Edit:** 안드로이드 스튜디오 설정에서 활성화하여 코드 수정 시 에뮬레이터에 즉시 반영되도록 설정한다 (Flutter의 Hot Reload와 유사).