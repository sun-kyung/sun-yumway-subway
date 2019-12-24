# 11 - 패키지로 클래스를 분류하기

## 학습 목표

- 패키지를 이용하여 역할에 따라 클래스를 분류할 수 있다.

## 실습 소스 및 결과

- sunkyung.yumwaysubway.handler 패키지 추가
- src/main/java/sunkyung/yumwaysubway/App.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/OrderHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/SideHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/BoardHandler.java 변경
- sunkyung.yumwaysubway.domain 패키지 추가
- src/main/java/sunkyung/yumwaysubway/domain/Order.java 변경
- src/main/java/sunkyung/yumwaysubway/domain/Side.java 변경
- src/main/java/sunkyung/yumwaysubway/domain/Board.java 변경
- src/main/java/sunkyung/yumwaysubway/domain/App.java 변경

## 실습

### 작업1) 데이터 타입 클래스를 별도의 패키지로 분류하라.

- 도메인 패키지 생성
    - `sunkyung.yumwaysubway.domain` 패키지 생성
- 도메인 클래스를 `domain` 패키지로 이동
    - `Order`, `Side`, `Board` 클래스를 `sunkyung.yumwaysubway.domain` 패키지로 옮긴다.
    - 다른 패키지에서 변수에 접근할 수 있도록 접근 제어를 `public` 으로 변경
- 핸들러 클래스에 import 문 추가
    - `OrderHandler`, `SideHandler`, `BoardHandler` 클래스를 변경한다.


### 작업2) 사용자 명령을 처리하는 클래스를 별도의 패키지로 분류하라.

- 핸들러 패키지 생성
    - `sunkyung.yumwaysubway.handler` 패키지 생성
- 핸들러 클래스를 `handler` 패키지로 이동
    - `OrderHandler`, `SideHandler`, `BoardHandler` 클래스를 `sunkyung.yumwaysubway.handler` 패키지로 옮긴다.
    - 다른 패키지에서 변수에 접근할 수 있도록 접근 제어를 `public` 으로 변경
- App.java 변경
    - 핸들러 클래스에 대해 import 문 추가
