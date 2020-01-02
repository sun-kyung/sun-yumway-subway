# 17 - 다형성과 형변환 응용

## 학습 목표

- 다형적 변수를 활용하여 다양한 타입의 데이터를 다룰 수 있다.
- 형변환을 이해하고 다룰 수 있다.

## 실습 소스 및 결과

- src/main/java/sunkyung/yumwaysubway/handler/OrderList.java 삭제
- src/main/java/sunkyung/yumwaysubway/handler/SideList.java 삭제
- src/main/java/sunkyung/yumwaysubway/handler/BoardList.java 삭제
- src/main/java/sunkyung/yumwaysubway/handler/ArrayList.java 추가
- src/main/java/sunkyung/yumwaysubway/handler/OrderHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/SideHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/BoardHandler.java 변경

## 실습

### 작업1) Order, Side, Board를 모두 다룰 수 있는 List 클래스를 만들라.

- ArrayList.java
    - OrderList, SideList, BoardList 클래스를 합쳐 한 클래스로 만든다.
- OrderHandler.java
    - `ArrayList` 클래스를 사용하여 데이터를 처리한다.
- SideHandler.java
    - `ArrayList` 클래스를 사용하여 데이터를 처리한다.
- BoardHandler.java
    - `ArrayList` 클래스를 사용하여 데이터를 처리한다.
