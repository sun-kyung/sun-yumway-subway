# 06 - 배열과 흐름 제어문 활용하기

## 학습 목표

- 배열을 활용하여 여러 개의 데이터를 저장할 수 있다.
- 조건문과 반복문을 활용하여 프로그램의 실행 흐름을 제어할 수 있다.

## 실습 소스 및 결과

- src/main/java/com/bitcamp/myproject/App.java 유지
- src/main/java/com/bitcamp/myproject/App2.java 변경
- src/main/java/com/bitcamp/myproject/App3.java 변경
- src/main/java/com/bitcamp/myproject/App4.java 변경

## 실습

### 작업1) 여러 개의 샌드위치 주문명을 받아 출력하라

App.java 실행 결과

목록으로 출력할 항목은 `빵, 메인, 치즈, 채소, 소스`이다.

```
빵? 플랫
메인? 참치
치즈? 아메리칸
채소? 모두
소스? 허니머스타드

계속 입력하시겠습니까?(Y/n) y

빵? 허니오트
메인? 치킨베이컨 랜치
치즈? 슈레드
채소? 토마토 빼고
소스? 바베큐

계속 입력하시겠습니까?(Y/n) y

빵? 화이트
메인? 스테이크
치즈? 모짜렐라
채소? 할라피뇨 빼고
소스? 스위트어니언

계속 입력하시겠습니까?(Y/n) n

빵: 플랫
메인: 참치
치즈: 아메리칸
채소: 모두
소스: 허니머스타드

빵: 허니오트
메인: 치킨베이컨 랜치
치즈: 슈레드
채소: 토마토 빼고
소스: 바베큐

빵: 화이트
메인: 스테이크
치즈: 모짜렐라
채소: 할라피뇨 빼고
소스: 스위트어니언
```

### 작업2) 여러 개의 사이드 정보를 입력 받아 출력하라.

App2.java 실행 결과

목록으로 출력할 항목은 `쿠키, 음료, 사이드`이다.

```
쿠키? 더블초코칩
음료? 콜라
사이드? 수프

계속 입력하시겠습니까?(Y/n) y

쿠키? 화이트 마카다미아
음료? 아메리카노
사이드? 웨지감자

계속 입력하시겠습니까?(Y/n) y

쿠키? 초코칩
음료? 미닛메이드
사이드? 없음

계속 입력하시겠습니까?(Y/n) n

더블초코칩, 콜라, 수프
화이트 마카다미아, 아메리카노, 웨지감자
초코칩, 미닛메이드, 없음
```

### 작업3) 여러 개의 리뷰 게시글을 입력 받아 출력하라.

App3.java 실행 결과

목록으로 출력할 항목은 `번호,내용,작성일,조회수`이다.

```
제목? 서브웨이
내용? 맛있다

계속 입력하시겠습니까?(Y/n) y

제목? 오늘부터 할인
내용? 스파이시 이탈리안

계속 입력하시겠습니까?(Y/n) y

제목? 치즈는
내용? 뭐가 제일 맛있나요

계속 입력하시겠습니까?(Y/n) n

서브웨이
맛있다
2019-01-01
0

오늘부터 할인
스파이시 이탈리안
2019-01-01
0

치즈는
뭐가 제일 맛있나요
2019-01-01
0
```