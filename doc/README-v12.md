# 12 - 클래스 필드와 클래스 메서드의 한계

## 학습 목표

- 클래스 필드와 클래스 메서드의 한계를 이해한다.

## 실습 소스 및 결과

- src/main/java/sunkyung/yumwaysubway/handler/OrderHandler.java 추가
- src/main/java/sunkyung/yumwaysubway/App.java 변경

## 실습

### 작업1) 새 주문판을 추가하라.

- BoardHandler2.java
    - `/board2/add`, `/board2/list` 명령을 처리할 클래스를 추가한다.
- App.java
    - 새 명령을 처리하는 코드를 추가한다.

실행 결과:

```
명령> /board2/add
빵? 플랫 브레드
메인? 미트볼
치즈? 슈레드 
채소? 모두
소스? 바베큐

명령> /board2/add
빵? 허니오트
메인? 참치
치즈? 아메리칸
채소? 모두
소스? 머스타드

명령> /board/add
빵? 화이트
메인? 터키
치즈? 모짜렐라
채소? 올리브 많이
소스? 스윗칠리

명령> /board2/list
빵: 플랫 브레드
메인: 미트볼
치즈: 슈레드 
채소: 모두
소스: 바베큐

빵: 허니오트
메인: 참치
치즈: 아메리칸
채소: 모두
소스: 머스타드

명령> /board/list
빵: 화이트
메인: 터키
치즈: 모짜렐라
채소: 올리브 많이
소스: 스윗칠리
```
