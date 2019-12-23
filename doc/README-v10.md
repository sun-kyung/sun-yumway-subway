# 10 - 클래스로 메서드를 분류하기

## 학습 목표

- 클래스를 이용하여 관련 메서드를 묶어 관리할 수 있다.
- 리팩토링 기법 중에서 '클래스 추출(Extract Class)'을 수행할 수 있다.

## 실습 소스 및 결과

- src/main/java/sunkyung/yumwaysubway/App.java 변경
- src/main/java/sunkyung/yumwaysubway/OrderHandler.java 추가
- src/main/java/sunkyung/yumwaysubway/SideHandler.java 추가
- src/main/java/sunkyung/yumwaysubway/BoardHandler.java 추가

## 실습

### 작업1) 주문 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라.

- OrderHandler.java
    - 주문 관리와 관련된 메서드를 담을 클래스를 만든다.
    - `App.java` 에서 주문관리와 관련된 변수와 메서드를 `OrderHandler` 클래스로 옮긴다.
- App.java (App.java.02)
    - `OrderHandler` 클래스 사용한다.


### 작업2) 사이드 메뉴 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라.

- SideHandler.java
    - 사이드 메뉴 관리와 관련된 메서드를 담을 클래스를 만든다.
    - `App.java` 에서 사이드 메뉴관리와 관련된 변수와 메서드를 `SideHandler` 클래스로 옮긴다.
- App.java (App.java.02)
    - `SideHandler` 클래스 사용한다.


### 작업3) 게시물 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라.

- BoardHandler.java
    - 게시물 관리와 관련된 메서드를 담을 클래스를 만든다.
    - `App.java` 에서 게시물관리와 관련된 변수와 메서드를 `BoardHandler` 클래스로 옮긴다.
- App.java
    - `BoardHandler` 클래스 사용한다.
