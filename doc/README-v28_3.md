# 28_3 - 파일 포맷으로 JSON 이용하기

## 학습 목표

- 외부 라이브러리를 가져와서 프로젝트에 적용할 수 있다
- JSON 포맷을 이해하고 이점을 이해한다
- Google JSON 라이브러리를 사용할 수 있다

## JSON 데이터 포맷 특징

- 문자열로 데이터를 표현한다
- {프로퍼티:값, ...} 방식으로 객체의 값을 저장한다
- 바이너리 방식에 비해 데이터가 커지는 문제가 있지만
  모든 프로그래밍 언어에서 다룰 수 있다는 장점이 있다
- 그래서 이기종 플랫폼(OS, 프로그래밍 언어 등) 간에 데이터를 교환할 때 많이 사용

## 실습 소스 및 결과
- build.gradle 변경
- src/main/java/sunkyung/yumwaysubway/App.java 변경
  
## 실습

### 훈련 1: Gradle 스크립트 파일(build.gradle)에 Google JSON라이브러리를 추가한다

- mvnrepository.com 에서 라이브러리 검색
  - json.org 사이트에서 자바 라이브러리 확인
  - 'gson' 키워드로 검색
- build.gradle 을 편집한다
  - 의존 라이브러리 블록(dependencis {})에 gson정보를 추가한다
- 이클립스 설정 파일을 갱신한다
  - 'gradle eclipse'를 실행
  - 이클립스에서 해당 프로젝트를 'refresh'한다
  - 'Referenced Libraries'노드에서 gson 라이브러리 파일이 추가된 것을 확인한다
  
### 훈련 2 : 게시물 데이터를 저장하고 읽을 때 JSON형식을 사용한다

- App.java
  -saveBoardData()를 변경한다
  -loadBoardData()를 변경한다
  
### 훈련 3 : 샌드위치 데이터를 저장하고 읽을 때 JSON형식을 사용한다

- App.java
  -saveOrderData()를 변경한다
  -loadOrderData()를 변경한다
  
### 훈련 4 : 사이드 데이터를 저장하고 읽을 때 JSON형식을 사용한다

- App.java
  -saveSideData()를 변경한다
  -loadSideData()를 변경한다

### 훈련 5 : Arrays 의 메서드를 활용하여 배열을 List 객체로 만든다

- App.java
  - 해당 부분의 코드를 변경한다







