# Kotlin_Study

# 01. 개발 환경 준비하기

생성일: 2023년 11월 16일 오후 11:35

# 안드로이드 스튜디오 설치하기

## 스튜디오 설치하기

해당 내용은 학부 수업 중 이미 설치하였기 때문에 생략하였음!

# 첫번째 앱 만들기

## 앱 출시하기

1. APK 혹은 AAB 둘 중 하나를 준비한다. → Google Playstore에는 AAB를 사용해야 한다고 발표함
2. 앱 서명 키 만들기
    1. 서명 키를 개발자가 직접 만들어서 관리하기
    2. 구글 play에서 관리하기
3. Play Store 배포 전 준비하기
    1. AAB 파일 (Android App Bundle)
    2. 앱 아이콘 이미지
    3. 그래픽 이미지
    4. 휴대전화 스크린샷
    5. 7~10인치 태블릿 스크린샷
  
  # 02. 안드로이드 앱의 기본 구조

생성일: 2023년 11월 16일 오후 11:35

# 안드로이드 소개

### 안드로이드의 특징

1. 리눅스 기반
2. JAVA 혹은 Kotlin 언어 사용
3. 안드로이드의 라이브러리, 앱 등의 코드는 오픈소스이어야 함
4. 자유로운 제작
5. 모두가 같은 환경에서 같은 API를 사용할 수 있음

### 안드로이드 앱 개발의 특징

- 컴포넌트는 어플리케이션의 구성 요소
- 클래스로 컴포넌트 개발
- **BUT** 클래스는 모두 컴포넌트인 것은 아님!!

### 컴포넌트

**특징**

- 컴포넌트는 독립된 실행 단위이다
- 어플리케이션 라이브러리를 통한 다양한 개발 가능 (ex. 카메라 앱)
- 리소스의 활용이 다양함 (ex. Strins.xml)

**종류**

1. 액티비티 : 화면 구성
2. 서비스 : 백그라운드 작업
3. 컨텐츠 프로바이더 : 앱 데이터 공유
4. 브로드캐스트 리시버 : 부팅 완료, 방전 등의 상황

# 앱을 구성하는 파일 분석하기

### 모듈 폴더 구성

1. build.gradle : 빌드 설정 파일
    - 플러그인 설정
    - 컴파일 버전
    - 앱 식별자 설정
    - SDK 버전
    - 앱 버전
    - 컴파일 옵션
    - 라이브러리 설정
2. AndroidManifest : 앱의 메인 환경 파일
    - 네임스페이스 선언
    - 액티비티 선언
3. res : 리소스 폴더
    - drawable
    - layout
    - mipmap
    - values
4. activity_main.xml : 레이아웃 xml 파일
5. MainActivity.kt : 메인 액티비티 파일
# 03. 코틀린 시작하기

생성일: 2023년 11월 16일 오후 11:35

# 코틀린 언어

### 코틀린 언어의 특징

1. 표현력과 간결함
2. 안전한 코드 : **null 안정성**
3. 상호 운용성
4. 구조화 동시성 : **코루틴**

### 코틀린 기본 문법

코틀린 기본 문법은 편의상 JetBrains의 IntelliJ를 사용하였음!

```kotlin
//패키지명
package com.example.firstapplicationfortest
// 임포트문
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstapplicationfortest.ui.theme.FirstApplicationForTestTheme
// 클래스
class User {
    var name : String= "Siyoung" // 변수 타입 수동 지정, var은 수정 가능!!
    val lastName = "Lee"        // 변수 타입 자동 지정, val은 수정 불가!!
    var Hello = """
        Hello
        World
    """.trimIndent()
    //lastName = "Song"
    fun sayHello() : Unit { // Unit는 반환값이 없다는 뜻. void와 비슷함
        println("Hello, $name")
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstApplicationForTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}
//함수
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstApplicationForTestTheme {
        Greeting("Android")
    }
}
```

```kotlin
import kotlinx.browser.document
import react.create
import react.dom.client.createRoot

fun main() {
    //val data0 : Int
    val data1 : Int = 10
    // 초기화 미루기
    lateinit val data2 : Int
    // null값은 뒤에 ? 붙이기
    var data3 : Int? = null
    // 모든 타입이 가능한 최상위 변수, Any
    val data4 : Any = "Helloooo"
    // collection, 0으로 초기화한 데이터를 3개 나열
    val dataCollection : Array<Int> = Array(3, { 0 })
    // 가변 리스틑 생성 시에는 mutable 사용. set & map을 사용 시에도 동일하게 적용된다
    var mutableList = mutableListOf<Int>(10, 20, 30)
}
//Int값 반환하는 sum 함수
fun sum(n : Int) : Int {
    var sum = 0
    // for문의 사용, ..n 은 0~n까지라는 뜻
    for (i in ..n) sum += i
    return sum
}
```
# 04. 코틀린 객체 지향 프로그래밍

생성일: 2023년 11월 16일 오후 11:36

### 객체지향 프로그래밍이란?

붕어빵 틀을 만들고, 붕어빵을 만드는 것!

- 붕어빵 틀을 내가 설계 함 : 아가미의 모양, 눈의 크기 등등 …. 클래스 설계
- 그 붕어빵 틀로 붕어빵을 만듬 : 조금 바삭하게 만든 붕어빵, 그냥 붕어빵 등등….객체 생성

# 클래스

```kotlin
import kotlinx.browser.document
import react.create
import react.dom.client.createRoot

fun main() {
}

class User {
    var name = "soyoung"
    var firstName = "Lee"
    // 생성자
    constructor(name : String, firstName : String) {
        this.name = name
        this.firstName = firstName
    }
    fun sayHello() {
        println("Hello, $firstName $name!")
    }
}
// 주생성자와 보조생성자
class User2 constructor() { //User2() 로 constructor 생략 가능
    init {
        println("this is an init message.")
    }

    var name = "soyoung"
    var firstName = "Lee"
}

class User3 {
    constructor(name : String) {
        println("only name typed")
    }
    constructor(name : String, firstName: String) {
        println("name and first name typed")
    }
}
```

### 클래스의 재사용

**오버라이딩** : 상위 클래스에 선언된 함수, 변수를 같은 이름으로 하위 클래스에서 다시 사용하는 것, 재정의

**접근 제한자**

- public : 모든 파일에서 접근 가능
- interna*l : 같은 모듈 내에서 접근 가능
- protected : 사용 불가
- private : 파일 내부에서만 접근 가능

### 클래스의 종류 #

1. 데이터 클래스 : 자주 사용하는 데이터를 객체로 묶어줌
2. 오브젝트 클래스 : **익명** 클래스, 이름이 없어 클래스를 선언하면서 동시에 객체를 생성해야 함 . . . 클래스에 선언한 멤버에 접근 불가….?
3. 컴패니언 클래스 : 멤버 변수나 함수를 믈래스 이름으로 접근할 때 사용

# 05. 코틀린의 유용한 기법

생성일: 2023년 11월 16일 오후 11:36

# 람다 함수

### 일반적인 함수 선언 방식

fun 함수(매개변수) : 리턴값 { 함수 본문 }

```kotlin
fun sum(num1 : Int, num2 : Int) : Int {
	return num1 + num2
}

```

### 람다 함수 선언 방식

중괄호 영역 내 함수 선언, 사용은 다음과 같이 함

```kotlin
val sum = {num1 : Int, num2 : Int → num1 + num2}

sum(10, 20)

val sum2 = {num1 : Int, num2 : Int -> num1 + num2}(10, 20)
//반환값이 한개
val printOne = (num : Int -> println("your number is $num"))
```

매개변수가 없는 경우

```kotlin
val printHello{->println("Hello!")}
val printHello2{println("Hello!!!")}
```

람다함수에 반환값이 있을 때 **return**을 사용할 수 있음

```kotlin
val some = {num1 : Int, numm2 : Int -> return num1 * num2}
```

### 고차 함수

함수를 매개변수로 전달받거나 반환하는 함수

```kotlin
fun hofFun(arg : (Int) -> Boolean) : {} -> String {
	val result = if(arg(10)) {
		"valid"
	}else {
		"invalid"
	}
	return {"hofFun result : $result"}
}
fun main() {
	val result = hofFun({no -> no > 0})
	println(result)
}
```

# Null 안전성

객체가 선언되었지만 초기화되지는 않은 상태

### ?연산자

 : 널 허용

```kotlin
var data : String? = "Lee"
var data : String? = null
```

### ?.연산자

 : 널 안전성 호출, 변수가 null인 상황을 고려해야 함. null이 아니면 접근 가능, null이면 접근 불가

```kotlin
var data : String? = "Lee"
var length = data?.length
```

### ?:연산자

 : 엘비스, 변수가  null인데 변수를 호출하거나 실행해야 할 구문이 있는 경우

```kotlin
fun main() {
	var data : String? = "Lee"
	data = null 
	println("data : ${data?.length ?: -1}")
}
```

### !!연산자

 : 예외 발생 시, 객체가 null이면 안될 때!

```kotlin
fun some(data : String) : Int {
	return data!!.length
}
```

# 06. 뷰를 이용한 화면 구성

생성일: 2023년 11월 17일 오전 12:16

# 화면을 구성하는 방법

### 액티비티-뷰 구조

- 컴포넌트 중, 화면을 출력하는 컴포넌트는 **액티비티Activity** 뿐!
- 액티비티 내 내용 표시는 **뷰View**를 통해 구성함 ex) ImageView, TextView (: View class)

 

### 액티비티 코드로 화면 구성하기

### 레이아웃 XML로 화면 구성하기

# 뷰 클래스

### 뷰 클래스의 기본 구조

**뷰 객체의 계층 구조**

![Untitled](https://github.com/jordan-comlinee/Kotlin_Study/assets/82654401/ccb034f3-06f2-4a87-9a1f-6ca5a7c50dd9)

- View : 뷰 클래스의 최상위 구조
- ViewGroup : View의 하위 클래스, 자체 UI가 없어 화면에 나오지 않고 View 여러개를 묶어서 제어할 목적
- TextView, ImageView… : 특정 UI를 출력할 목적으로 사용하는 클래스

**뷰의 중첩 구조**

- 레이아웃 클래스 : Linear Layout, ConstraintLayout, RelativeLayout… etc. 중첩하여 뷰를 복잡하게 구성할 수 있음
- 객체를 계층 구조로 만들어서 이용하는 패턴 : **컴포지트 패턴(Composite pattern)** or **객체 모델 (document object model)**

# 기본적인 뷰 살펴보기

- **텍스트뷰** TextView
- **이미지뷰** ImageView
- **버튼, 체크박스, 라디오버튼** Button, CheckBox, RadioGroup(RadioButton)
- **에디트 텍스트** EditText

# 뷰 바인딩

### 뷰 바인딩

기존 : findViewById()를 이용해서 xml과 activity를 일일히 연결해주어야 함 → 무의미한 반복작업

뷰 바인딩 : 레이아웃 xml 파일에 선언한 뷰 객체를 코드에서 쉽게 이용

### How to?

```kotlin
android {
	// 생략...
	viewBinding{
		enable = true
	}
}
// build.gradle
```

⚠️ 교재에는 enabled라 되어 있으나, enable 로 해야 함 (API 업데이트의 문제인 듯) + 컴파일 버을 34로 변경

### MainActivity

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 기존
        // setContentView(R.layout.activity_main)

        // 바인딩 객체 획득하기
        val binding = ActivityMainBinding.inflate(layoutInflater)
        // 액티비티 화면 출력
        setContentView(binding.root)

        binding.testTextView.setText("뷰 바인딩 성공!")

    }
}
```

# 카카오톡 비민번호 확인 화면 만들기

### 예제 따라하기

### Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16sp"
    tools:context=".KakaotalkPWActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/main_desc"
        android:textSize="17sp"/>

    <TextView
        android:id="@+id/textView2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10sp"
        android:text="leesoyoung0112@gmail.com"
        android:textColor="#CFCFCE"/>

    <View
        android:layout_width="match_parent"
        android:layout_height="1sp"
        android:background="#D4D4D3"
        android:layout_marginTop="10sp"
        />

    <EditText
        android:id="@+id/editTextTextPassword"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="비밀번호"
        android:inputType="textPassword" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10sp"
        android:text="@string/password_txt" />

    <Button
        android:id="@+id/button2"
        android:layout_width="300sp"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="16sp"
        android:text="확인" />
</LinearLayout>
```

### Design

![Untitled](https://github.com/jordan-comlinee/Kotlin_Study/assets/82654401/f8061d99-d001-43ae-b77d-6d8c9e35ab86)
