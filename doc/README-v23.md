# 23_1 - 일반화(generalization) 상속기법을 사용하여 ArrayList와 LinkedList의 공통점 분리하기

## 학습 목표

- 상속 기법 중 일반화 기법을 수행할 수 있다.
- 클래스의 공통점을 유지보수하기 쉽게 분리하기 위해 상속을 이용할 수 있다
- 다형적변수를 이용하여 다양한 서브타입 객체를 다룰 수 있다
- 의존성 주입(DI)기법을 이용하여 객체를 부품처럼 교체하기 쉽도록 만들 수 있다

### 주요 개념
- 일반화 (Generalization) : 
  - 서브 클래스의 공통분모를 추출하여 수퍼클래스로 정의하고 상속관계를 맺는 것
- 다형적변수 (Polymorphic Variables): 
  - Handler에서 사용할 목록관리객체를 수퍼클래스의 레퍼런스로 선언하는 것
    이를 통해 List의 서브객체로 교체하기 쉽도록 만드는 것
- 의존성 주입 (DI; Dependecy Injection) : 
  - Handler가 의존하는 객체를 내부에서 생성하지 않고 생성자를 통해 외부에서 주입받는 것
    이를 통해 의존객체 교체가 쉽도록 만드는 것


## 실습 소스 및 결과

- src/main/java/sunkyung/yumwaysubway/util/AbstractList.java 추가
- src/main/java/sunkyung/yumwaysubway/util/ArrayList.java 변경
- src/main/java/sunkyung/yumwaysubway/util/LinkedList.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/OrderHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/SideHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/BoardHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/App.java 변경

## 실습

### 훈련1. 데이터 목록을 다루는 ArrayList와 LinkedList의 공통점을 찾아 별도의 클래스로 분리하라

- AbstractList.java
    - ArrayList와 LinkedList의 공통 멤버(필드와 메서드)를 선언한다
    - 서브 클래스에서 반드시 재정의해야하는 메서드는 추상 메서드로 구현하지 않고 놓아둔다
- ArrayList.java
    - `AbstractList` 를 상속받는다
    - 상속받은 추상 메서드를 구현한다
- LinkedList.java
    - `AbstractList` 를 상속받는다
    - 상속받은 추상 메서드를 구현한다
- OrderHandler.java
    - ArrayList 또는 LinkedList를 직접 지정하는 대신에 추상클래스를 필드로 선언한다.
    - 생성자에서 구체적으로 구현한 서브클래스를 공급받도록 변경한다.
    - 따라서 특정 클래스(ArrayList, LinkedList)에 의존하는 코드를 제거한다.
- SideHandler.java
    - ArrayList 또는 LinkedList를 직접 지정하는 대신에 추상클래스를 필드로 선언한다.
    - 생성자에서 구체적으로 구현한 서브클래스를 공급받도록 변경한다.
    - 따라서 특정 클래스(ArrayList, LinkedList)에 의존하는 코드를 제거한다.
- BoardHandler.java
    - ArrayList 또는 LinkedList를 직접 지정하는 대신에 추상클래스를 필드로 선언한다.
    - 생성자에서 구체적으로 구현한 서브클래스를 공급받도록 변경한다.
    - 따라서 특정 클래스(ArrayList, LinkedList)에 의존하는 코드를 제거한다.
- App.java
    - XxxHandler가 사용할 의존 객체(AbstractList 객체)를 준비한다.
    - XxxHandler를 생성할 때 해당 의존객체를 넘겨준다
    
# 23_2 - generalization을 통해 추출한 수퍼클래스를 추상클래스로 정의하기

## 학습 목표

- 추상클래스를 정의할 수 있다
- 추상클래스 문법의 용도를 이해한다
- 추상 메서드를 정의할 수 있다
- 추상 메서드 문법의 용도를 이해한다

## 실습 소스 및 결과

- src/main/java/sunkyung/yumwaysubway/util/ArrayList.java 변경 변경(List.java의 이름변경)

## 실습

### 훈련1. List.java에 추상클래스와 추상메서드 문법을 적용하라

- AbstractList.java
    - List 클래스의 이름을 AbstractList로 변경한다
    - AbstractList 클래스를 추상 클래스로 선언한다
    - AbstractList의 메서드를 추상메서드로 정의한다
    
# 23_3 - 인터페이스를 활용하여 객체 사용 규칙 정의하기

## 학습 목표

- 인터페이스의 용도와 이점을 이해한다.
- 객체 간의 사용 규칙을 정의할 때 인터페이스를 활용할 수 있다.


## 실습 소스 및 결과

- src/main/java/sunkyung/yumwaysubway/util/List.java 추가
- src/main/java/sunkyung/yumwaysubway/util/AbstractList.java 변경
- src/main/java/sunkyung/yumwaysubway/util/LinkedList.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/OrderHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/SideHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/BoardHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/App.java 변경

## 실습

### 훈련1. 추상클래스에서 추상 메서드를 추출하여 인터페이스를 정의하라

- List.java
    - AbstractList추상클래스에 있는 추상메서드를 추출하여 따로 메서드사용규칙을 정의한다
- AbstractList.java
    - 추상 메서드를 List인터페이스로 옮긴다
    - List 규칙을 따른다
    