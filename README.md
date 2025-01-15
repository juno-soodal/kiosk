
<div align="center">

<!-- logo -->
# kiosk


</div> 

## 📝 소개

메뉴 선택, 장바구니 관리 및 주문 처리를 포함한 자바 콘솔 기반 프로그램입니다.

<br />

### 주요 기능
- 카테고리 선택: 다양한 메뉴 카테고리를 탐색할 수 있습니다.
- 메뉴 아이템 보기: 선택한 카테고리의 메뉴 아이템을 확인할 수 있습니다.
- 장바구니 추가: 메뉴 아이템을 장바구니에 추가할 수 있습니다.
- 장바구니 보기: 장바구니에 담긴 아이템과 총 금액을 확인할 수 있습니다.
- 주문하기: 할인정책에 따라 주문을 완료하고 총 금액을 표시합니다.
- 주문 취소: 장바구니의 모든 아이템을 초기화합니다.

  <br />

### 아키텍처

- Config:Kiosk 실행하기 위해 필요한 인스턴스 생성
- KioskService: 사용자 입력과 애플리케이션 로직을 처리하는 메인 서비스.
- KioskUi: 디스플레이 출력 및 사용자 상호작용 관리.
- Category: 키오스크 메뉴들의 카테고리 관리
- Discount: 할인정보 관리
- MenuInputValidator:사용자 입력 검증
- Cart: 아이템 추가, 제거 및 표시와 같은 장바구니 작업 관리.
- Menu: 메뉴 카테고리와 아이템을 표현.
- MenuItem: 이름, 가격, 설명 등의 세부 정보를 가진 개별 메뉴 아이템.
```
lv6
┣ cart
┃ ┗ Cart.java
┣ config
┃ ┗ Config.java
┣ menu
┃ ┣ Category.java
┃ ┣ Menu.java
┃ ┗ MenuItem.java
┣ service
┃ ┣ Discount.java
┃ ┗ KioskService.java
┣ ui
┃ ┗ KioskUi.java
┣ validation
┃ ┗ MenuInputValidator.java
┗ Main.java
```
