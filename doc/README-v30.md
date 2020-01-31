# 30 - 직렬화와 역직렬화를 이용하여 객체를 통째로 읽고 쓰기

## 학습목표

- 객체를 직렬화 하여 출력하고 역직렬화 하여 읽어들일 수 있다
- `java.io.Serializable` 인터페이스와 `serialVersionUID` 스태틱 변수의 용도를 ㅣㅇ해한다 
  
## 실습 소스 및 결과

- src/main/java/sunkyung/yumwaysubway/App.java 변경
- src/main/java/sunkyung/yumwaysubway/Board.java 변경
- src/main/java/sunkyung/yumwaysubway/Order.java 변경
- src/main/java/sunkyung/yumwaysubway/Side.java 변경

##실습

### 훈련 1: 객체 단위로 읽고 출력하라.

- Order.java
    - `java.io.Serializable` 인터페이스를 구현한다.
    - `serialVersionUID` 스태틱 변수의 값을 설정한다.
- Side.java
    - `java.io.Serializable` 인터페이스를 구현한다.
    - `serialVersionUID` 스태틱 변수의 값을 설정한다.
- Board.java
    - `java.io.Serializable` 인터페이스를 구현한다.
    - `serialVersionUID` 스태틱 변수의 값을 설정한다.
- App.java (App.java.01)
    - 파일에서 데이터를 읽을 때 ObjectInputStream을 사용한다.
    - 파일에서 데이터를 쓸 때 ObjectOutputStream을 사용한다.

#### 실행 결과

`App`의 실행 결과는 이전 버전과 같다.

### 과제 2: ArrayList/LinkedList 객체를 통째로 읽고 출력하라.

- App.java
    - `java.io.Serializable` 구현체라면 직렬화/역직렬화가 가능하다.
    - 따라서 ArrayList, LinkedList 객체를 통째로 읽고 쓸 수 있다.

#### 실행 결과

`App`의 실행 결과는 이전 버전과 같다.
