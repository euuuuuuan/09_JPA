package com.ohgiraffers.section00;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach // 각 테스트 메서드가 실행되기 전에 실행되어야 하는 코드나 초기화 작업을 할때 사용
    void setUp() {
        calculator = new Calculator();
        System.out.println("BeforeEach : 테스트를 시작합니다.");
    }

    @AfterEach // 각 테스트 메서드가 실행된 후에 실행되어야 하는 후속 작업 및 정리 작업할때 사용
    void tearDown() {
        System.out.println("AfterEach : 테스트 끝!");
    }

    @DisplayName("덧셈 테스트") // 테스트 결과에 대한 이름을 지정할 수 있다.
    @Test
        // 테스트 메소드를 정의할때 사용하는 어노테이션, 테스트 메소드로 등록되고,
        // 코드 검증 및 테스트 결과확인을 하게 해준다.
    void testAddition() {
        // given // 사전 조건
        int a = 5;
        int b = 3;

        // when // 테스트 할 시점
        int result = calculator.add(a, b);

        // then // 테스트에서 기대하는 결과
        assertEquals(8, result);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void testSubtraction() {

        // given
        int a = 5;
        int b = 3;

        // when
        int result = calculator.subtract(a, b);

        // then
        assertEquals(2, result);

    }
}