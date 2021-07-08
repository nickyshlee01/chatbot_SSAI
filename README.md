## SNU 전기정보공학부 행정실 안내로봇 '테미'의 챗봇 앱 개발

### [프로젝트 원리]

<img src="https://user-images.githubusercontent.com/31657141/124757453-8ff93980-df68-11eb-82db-f649fcc1f4de.png" width="800">

1. 테미는 얼굴인식을 통해 다가온 사용자를 반기거나, 사용자가 먼저 대화를 시작할 수 있다.

   사용자는 전기정보공학부 행정실에 방문한 용건을 말한다. (화면의 버튼을 눌러서 간단한 질문을 대신할 수 있다.)

2. 테미 내장 STT (Speech to Text) 기능을 사용해 위의 질문을 텍스트로 변환한다.

3. 구글의 다이얼로그플로우에 미리 만들어놓은 프로젝트에 접근하여 텍스트를 Request로 보낸다.

4. Request에 대한 Response를 가져온다. Response는 대화의 의도나 맥락과 같은 정보가 포함되어 있는 패키지이다.

5. 다시 테미로 돌아와 콜백 함수가 실행되며, Response 중 사용할 정보를 처리한다.

6. 안드로이드 API의 TTS (Text to Speech) 기능을 사용하여 사용자에게 대답을 하고, 필요한 경우 대답에 맞는 행위를 한다.

   (선생님 자리로의 이동, 팝업, 웹 페이지 띄우기, 웹훅 등등)

<br>

Front end 작업 - UI, 얼굴인식, 테미의 지도, 위치, 경로 설정 및 이동 작업, STT, TTS 등등

Back end - 다이얼로그플로우 프로젝트 관리, Request & Response, 웹훅 등등

* * *
### [테미 사용]

테미 설정에서 '키오스크 모드' 설정을 통해, 본 프로젝트 앱을 기본 동작 화면으로 지정한다.

- 테미와 대화를 시작할 수 있는 방법은 총 3가지이다. (얼굴인식을 통한 반기기, '대화 시작' 버튼 누르기, "헤이 테미" 라고 말하기)

- 대화가 시작하면 대답을 하거나, 또는 메인 화면의 버튼을 활용하여 행정실에 방문한 용건을 말한다.

메인 화면의 버튼:

(새로 추가된 Configurable UI 기능을 통해 원하는대로 바꿀 수 있음)

> Page1 button

<img src="https://user-images.githubusercontent.com/31657141/110230649-cccf0880-7f55-11eb-95ac-10b19f5ed1f4.png" width="500">


> Page2 button

<img src="https://user-images.githubusercontent.com/31657141/110230651-d0628f80-7f55-11eb-86b3-a0eaf9090afd.png" width="500">

- 대화나 음성을 종료하고 싶으면, 대화 창의 바깥 쪽을 누른다.

- 사용자와 상호작용이 끝나고 5초가 지나면 테미는 자신의 위치를 확인하고 행정실 입구가 아니라면 자동 복귀한다.

   (홈베이스에서 충전하고 있는 경우는 자동 복귀 기능이 꺼진다.)

- 테미가 이동하는 도중에 멈추게 하면, 대화를 이어할 수 있다. 이때도 상호작용이 끝나면 자동 복귀한다.

* * *
### [테미 관리]

- 테미 관련 설정은 **앱의 설정 창** 이나, 테미의 내재된 설정에서 변경 가능하다.
   
> 앱 설정 창

<img src="https://user-images.githubusercontent.com/31657141/124870519-d2b92100-dffd-11eb-99ac-b04e06c711cd.PNG" width="500">

저장된 위치로 이동, 볼륨/조명 조절, 전원, 재시작, 위치 재조정, 설정 창 잠금 조정 등의 기능

(테미의 내재된 설정은 앱 설정 창에서 '테미 설정' 을 눌러서 접근 가능하기도 하다.)
  
** 간혹가다 테미가 자신의 현위치를 헷갈려서 오작동을 하는 경우 - '위치 재조정'을 눌러주면 된다.

** 전원, 볼륨 등의 하드 버튼은 보안을 위해 현재 이렇게 설정을 통해서만 접근할 수 있게 되어있다. 

<br> 

- 위에서 언급한 것과 같이 본 프로젝트 앱을 사용하기 위해서는 키오스크 모드로 설정을 해야 한다.

- 자동 복귀 기능이 작동하지 않는 경우, 테미 설정을 확인하여 자동 복귀 기능과 설정 권한 창을 확인한다.

- 추가적인 설정은 Temi Center 에서 다룰 수 있다. (https://center.robotemi.com/)

<br>

- 프로젝트의 다이얼로그플로우 연동은 네트워크 연결이 있는 경우에만 가능하다.

- 연동을 위해서 구글 클라우드 프로젝트의 키가 필요하며, 이는 보안 상의 이유로 깃허브에 업로드되지 않는다.

- 테미의 상호작용 내용은 다이얼로그플로우에 기록되어, 'History' 창에서 모두 확인 가능하도록 해 았다.

<br>

- 테미의 출근 장소, 즉 대기 장소는 행정실 입구 근처이다.

- 테미의 퇴근 장소는 홈베이스가 있는 행정실 캐비닛 앞이다.

- 테미는 매일 주중 아침 9시에 출근하고, 오후 5시에 퇴근한다. 

<br>

- 배터리가 15% 아래로 떨어지면 홈베이스로 퇴근한다. 이때 상호작용은 무시한다.

- 테미가 다시 출근하는 것은, 그 다음날 아침 9시가 될 것이다.

<br>

- 현재 테미는 신속한 이동을 위해 장애물을 회피하는 경로를 택하지 않게 되어 있다.

- 빠르고 정확한 이동을 위해 한 위치에서 다른 위치로 경로를 지정하는 것이 효율적이다.

* * *
### [테미 기능]

#### <다이얼로그플로우 상의 기능>

- 업무에 따는 행정실 선생님 자리 안내

- 성함에 따른 행정실 선생님 자리 안내

- 행정실 선생님 부재 여부의 확인 (구글 클랜더와의 연동)

<br>

- 행정실, 학생센터, 해동, 과방, 전산실, 새장 등 301 동 건물 내 중요 위치 안내

- 화장실, 정수기 위치 안내

<br>

- 증명서 발급, 출입 등록, 사물함 신청 방법

- 장학금 관련 세부 질문에 대한 답변

- 영문성명변경, 전공학습도우미 등 질문에 대한 세부 답변

<br>

- 오늘의 날씨 안내 (웹훅)

- 윗공대 학식 안내 (웹훅)

- 네이버 백과사전 연동 (웹훅)

- 현재 신청 가능한 장학금 목록 (웹훅)

- 최근 인트라넷의 학부 공지 (웹훅, 메인 화면의 NOTICE 버튼으로도 확인 가능하다.)

<br>

- 자연스러운 일상 대화의 가능 (다이얼로그플로우 Small talk 기능 활용)

<br>

- 다국어 설정 (언어 버튼이 메인 화면에 있고, 이를 통해 버튼 및 대화 언어도 변경 가능하다.)

영어 설정 시 메인 화면 버튼:

> Page1 button

<img src="https://user-images.githubusercontent.com/31657141/110230750-54b51280-7f56-11eb-8dcc-2f21d3f87685.png" width="500">

> Page2 button

<img src="https://user-images.githubusercontent.com/31657141/110230754-5aaaf380-7f56-11eb-90ba-ae77b8292261.png" width="500">

<br>

- 열화상 카메라가 탑재된 태블릿 PC와의 연동 및 체온 측정 시작

   (현재 두 기기를 분리해서 사용하므로 이 기능은 사용하지 않는다. 메인 화면에 버튼이 있다.)


#### <이외의 추가 기능>

- 추가 정보 제공을 위한 팝업

> 팝업 창 예시

<img src="https://user-images.githubusercontent.com/31657141/124871147-a9e55b80-dffe-11eb-82c3-6f0bfe36ab2a.PNG" width="500">
<img src="https://user-images.githubusercontent.com/31657141/124871161-ace04c00-dffe-11eb-8b0e-2a4922d45cca.PNG" width="500">

- 인터넷 웹페이지 연계

   (학부 홈페이지, 주요 연락처, 대학 지도, 하이퍼링크 등등)

<br>

- **얼굴인식**을 통한 사용자 반기기 기능

- 상호작용이 끝나고 일정 시간이 지나면, 메인 화면으로 돌아가는 **Timeout** 기능

<br>

- **Configurable UI**

   앱 설정 창의 버튼 구성을 통해서 이 기능을 사용할 수 있다.
   
   <img src="https://user-images.githubusercontent.com/31657141/124871762-66d7b800-dfff-11eb-98be-22cc2991ef14.PNG" width="500">
   
   ** 커스텀 구성: 행정실 선생님께서 원하시는 버튼으로 메인 화면을 구성할 수 있게 해줌.
      
   (선택할 수 있는 버튼은 총 24가지)
   
   <img src="https://user-images.githubusercontent.com/31657141/124872198-e82f4a80-dfff-11eb-9aba-1f6d009466fd.png" width="500">
   
   <img src="https://user-images.githubusercontent.com/31657141/124872301-0c8b2700-e000-11eb-82d0-90dcb81b4c09.PNG" width="500">
   
   <br>
   
   ** 인기 구성: 현재까지 가장 많이 눌린 버튼 순서대로 메인 화면을 자동 구성함 **(Shared preference)**
   
   ** 구성 초기화: 버튼의 눌린 횟수를 초기화하고, 메인 화면도 기본 구성으로 다시 해줌.

<br>

- **와이파이 연결이 끊겼을 때 알리는 alert 활동** 기능

   (내부적으로 다시 행정실 와이파이에 연결하려고 시도함.)

> alert 활동 창

<img src="https://user-images.githubusercontent.com/31657141/124868233-71438300-dffa-11eb-84c1-77d11d71e503.png" width="500">

* * *




