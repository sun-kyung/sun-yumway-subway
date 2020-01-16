# 24_1 - `Iterator` 디자인 패턴의 활용

## 학습 목표

- `Iterator` 디자인 패턴의 용도를 이해하고 활용할 수 있다.
- 자료구조와 상관없이 일관된 방법으로 데이터를 조회할 수 있다.
## 실습 소스 및 결과

- src/main/java/sunkyung/yumwaysubway/util/Iterator.java 추가
- src/main/java/sunkyung/yumwaysubway/util/ListIterator.java 추가
- src/main/java/sunkyung/yumwaysubway/util/List.java 변경
- src/main/java/sunkyung/yumwaysubway/util/AbstractList.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/LessonHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/MemberHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/handler/BoardHandler.java 변경
- src/main/java/sunkyung/yumwaysubway/util/StackIterator.java 추가
- src/main/java/sunkyung/yumwaysubway/util/Stack.java 변경
- src/main/java/sunkyung/yumwaysubway/util/QueueIterator.java 추가
- src/main/java/sunkyung/yumwaysubway/util/Queue.java 변경
- src/main/java/sunkyung/yumwaysubway/App.java 변경

## 실습

### 훈련1. Stack 이나 Queue, List 에서 값을 꺼내는 방법을 통일하라.

- Iterator.java 생성
    - 인터페이스로 값을 꺼내는 규칙을 정의한다.

### 훈련2. List에서 값을 꺼내는 Iterator 구현체를 정의하라.

- ListIterator.java 생성
    - List 객체에서 값을 꺼내는 일을 한다.
    - Iterator 사용법을 따른다.

### 훈련3. 모든 List 구현체(ArrayList, LinkedList)가 Iterator 객체를 리턴하도록 규칙을 추가하라.

- List.java 변경
    - iterator() 메서드 추가

### 훈련4. 모든 List 구현체가 Iterator 객체를 리턴하도록 iterator() 메서드를 구현하라.

- AbstractList.java 변경
    - List 인터페이스에 추가된 iterator() 규칙을 구현한다.
    - ArrayList나 LinkedList는 이 클래스를 상속 받기 때문에 이 클래스에서 iterator()를 구현하면 된다.

### 훈련5. List(예: ArrayList, LinkedList)에서 목록을 꺼내는 경우 Iterator를 활용하라.

- BoardHandler.java 변경
  - listBoard() 변경
- OrderHandler.java 변경
  - listOrder() 변경
- SideHandler.java 변경
  - listSide() 변경 

### 훈련6. Stack 객체에 들어 있는 값을 꺼내 줄 Iterator 구현체를 준비하고 리턴한다.

- StackIterator.java 생성
  - Iterator 인터페이스를 구현한다.
- Stack.java 변경
    - `Iterator` 구현체를 리턴하는 iterator() 를 정의한다.

### 훈련7. Queue 객체에 들어 있는 값을 꺼내 줄 Iterator 구현체를 준비하고 리턴한다.
    
- QueueIterator.java 생성
  - Iterator 인터페이스를 구현한다.
- Queue.java 변경
    - `Iterator` 구현체를 리턴하는 iterator() 를 정의한다.
    
### 훈련8. Stack과 Queue에서 값을 꺼낼 때 Iterator를 사용하도록 변경하라.

- App.java 변경
    - `history`, `history2` 명령을 처리할 때 Stack, Queue 객체에서 직접 값을 꺼내지 않고 Iterator 구현체를 통해서 꺼낸다.
    - printCommandHistory()와 printCommandHistory2()는 코드가 같기 때문에 하나로 합친다.
    
    
# 24_2 - `Iterator` 구현체와 스태틱 중첩 클래스(static nested class)

## 학습 목표

- 스태틱 중첩 클래스를 사용할 수 있다.
- 스태틱 중첩 클래스를 사용하여 인터페이스 구현체를 만들 수 있다.


## 실습 소스 및 결과

- src/main/java/sunkyung/yumwaysubway/util/ListIterator.java 삭제
- src/main/java/sunkyung/yumwaysubway/util/AbstractList.java 변경
- src/main/java/sunkyung/yumwaysubway/util/StackIterator.java 삭제
- src/main/java/sunkyung/yumwaysubway/util/Stack.java 변경
- src/main/java/sunkyung/yumwaysubway/util/QueueIterator.java 삭제
- src/main/java/sunkyung/yumwaysubway/util/Queue.java 변경

## 실습

### 훈련1. ListIterator 클래스를 AbstractList 클래스의 중첩클래스로 만들라.

- AbstractList.java
  - ListIterator 클래스를 스태틱 중첩 클래스로 정의한다.
- ListIterator.java
  - 삭제한다.

### 훈련2. QueueIterator 클래스를 Queue 클래스의 중첩클래스로 만들라.

- Queue.java
  - QueueIterator 클래스를 스태틱 중첩 클래스로 정의한다.
- QueueIterator.java 
  - 삭제한다.

### 훈련3. StackIterator 클래스를 Stack 클래스의 중첩클래스로 만들라.

- Stack.java
  - StackIterator 클래스를 스태틱 중첩 클래스로 정의한다.
- StackIterator.java 
  - 삭제한다.

  
# 24_3 - `Iterator` 구현체와 논스태틱 중첩 클래스(non-static nested class; inner class)

## 학습 목표

- 논스태틱 중첩 클래스를 사용할 수 있다.
- 스태틱 중첩 클래스와 논스태틱 중첩 클래스 사이의 차이점을 이해한
- 논스태틱 중첩 클래스를 사용하여 인터페이스 구현체를 만들 수 있다.


## 실습 소스 및 결과

- src/main/java/sunkyung/yumwaysubways/util/AbstractList.java 변경
- src/main/java/sunkyung/yumwaysubway/util/Stack.java 변경
- src/main/java/sunkyung/yumwaysubway/util/Queue.java 변경

## 실습

### 훈련1. ListIterator 중첩 클래스를 논스태틱 중첩클래스로 만들라.

- AbstractList.java
  - ListIterator 클래스를 논스태틱 중첩 클래스로 변경한다.
  - iterator() 메서드를 변경한다.

### 훈련2. QueueIterator 중첩 클래스를 논스태틱 중첩클래스로 만들라.

- Queue.java
  - QueueIterator 클래스를 논스태틱 중첩 클래스로 변경한다.
  - iterator() 메서드를 변경한다.

### 훈련3. StackIterator 중첩 클래스를 논스태틱 중첩클래스로 만들라.

- Stack.java
  - StackIterator 클래스를 논스태틱 중첩 클래스로 변경한다.
  - iterator() 메서드를 변경한다.
  
  
# 24_4 - `Iterator` 구현체와 로컬클래스 (local class)

## 학습 목표

- 로컬 클래스를 사용할 수 있다.
- 스태틱 중첩 클래스와 논스태틱 중첩 클래스 사이의 차이점을 이해한
- 논스태틱 중첩 클래스를 사용하여 인터페이스 구현체를 만들 수 있다.


## 실습 소스 및 결과

- src/main/java/sunkyung/yumwaysubways/util/AbstractList.java 변경
- src/main/java/sunkyung/yumwaysubway/util/Stack.java 변경
- src/main/java/sunkyung/yumwaysubway/util/Queue.java 변경

## 실습

### 훈련1. ListIterator 중첩 클래스를 로컬클래스로 만들라.

- AbstractList.java
  - iterator() 메서드를 변경한다.

### 훈련2. QueueIterator 중첩 클래스를 로컬클래스로 만들라.

- Queue.java
  - iterator() 메서드를 변경한다.

### 훈련3. StackIterator 중첩 클래스를 로컬클래스로 만들라.

- Stack.java
  - iterator() 메서드를 변경한다.
  
  
# 24_5 - `Iterator` 구현체와 익명 클래스 (anonymous class)

## 학습 목표

- 익명 클래스를 사용할 수 있다.
- 스태틱 중첩 클래스와 논스태틱 중첩 클래스 사이의 차이점을 이해한
- 논스태틱 중첩 클래스를 사용하여 인터페이스 구현체를 만들 수 있다.


## 실습 소스 및 결과

- src/main/java/sunkyung/yumwaysubways/util/AbstractList.java 변경
- src/main/java/sunkyung/yumwaysubway/util/Stack.java 변경
- src/main/java/sunkyung/yumwaysubway/util/Queue.java 변경

## 실습

### 훈련1. ListIterator 중첩 클래스를 익명클래스로 만들라.

- AbstractList.java
  - iterator() 메서드를 변경한다.

### 훈련2. QueueIterator 중첩 클래스를 익명클래스로 만들라.

- Queue.java
  - iterator() 메서드를 변경한다.

### 훈련3. StackIterator 중첩 클래스를 익명클래스로 만들라.

- Stack.java
  - iterator() 메서드를 변경한다.
  