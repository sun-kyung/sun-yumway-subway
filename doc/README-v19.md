# 19 - CRUD(Create/Retrieve/Update/Delete) 기능 완성

## 학습 목표

- 데이터를 등록/조회/수정/삭제하는 기능(CRUD)을 구현할 수 있다.

## 실습 소스 및 결과

- src/main/java/sunkyung/yumwaysubway/util/ArrayList.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/OrderHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/SideHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/BoardHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/OrderList.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/SideList.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/BoardList.java 변경
- src/main/java/sunkyung/yumwaysubway/App.java 변경

## 실습

### 작업1) ArrayList 클래스에 항목 값을 조회하고 변경하고 삭제하는 기능을 추가하라.

- ArrayList.java
  - 목록의 특정 위치에 저장된 항목을 꺼내주는 get()을 정의한다.
  - 목록의 특정 위치에 저장된 항목을 바꾸는 set()을 정의한다.
  - 목록의 특정 위치에 저장된 항목을 삭제하는 remove()를 정의한다.


### 작업2) 주문 데이터의 상세조회, 변경, 삭제 기능을 추가하라.

- OrderHandler.java (OrderHandler.java.01)
  - 상세조회 기능을 수행하는 detailOrder()을 정의한다.
  - 변경 기능을 수행하는 updateOrder()을 정의한다.
  - 삭제 기능을 수행하는 deleteOrder()을 정의한다.
- App.java
  - 상세조회, 변경, 삭제 명령에 대한 분기문을 추가한다.

#### 실행 결과

```
명령> /order/list
1, 허니오트, 치킨베이컨랜치, 슈레드, 모두, 스윗어니언
2, 플랫브레드, 에그마요, 슈레드, 모두, 스위트칠리

명령> /order/detail
번호? 2
빵: 플랫브레드
메인: 에그마요
치즈: 슈레드
채소: 모두
소스: 스위트칠리

명령> /order/detail
번호? 20
해당 수업을 찾을 수 없습니다.

명령> /order/update
번호? 2
빵(플랫브래드)? 파마산오레가노
메인(에그마요)?  <=== 입력하지 않으면 기존 값 사용
치즈(슈레드)? 아메리칸
채소(모두)? 노 토마토
소스(스위트칠리)? 
주문을 변경했습니다.

명령> /order/update
번호? 20
해당 주문을 찾을 수 없습니다.

명령> /order/delete
번호? 2
주문을 삭제했습니다.

명령> /order/delete
번호? 20
해당 주문을 찾을 수 없습니다.
```

### 작업3) OrderHandler 코드를 리팩토링하라.

- OrderHandler.java
    - 저장된 목록에서 수업 번호로 항목을 찾는 코드를 indexOfOrder() 메서드로 분리한다.
