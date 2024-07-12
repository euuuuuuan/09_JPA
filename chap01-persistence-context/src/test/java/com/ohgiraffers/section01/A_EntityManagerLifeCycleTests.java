package com.ohgiraffers.section01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class A_EntityManagerLifeCycleTests {
    /*
     * 엔티티 매니저 팩토리(EntityManagerFactory)란?
     * 엔티티 매니저를 생성할 수 있는 기능을 제공하는 팩토리 클래스이다.
     * application 스코프와 동일하게 싱글톤으로 생성해서 관리하는 것이 효율적이다.
     * 따라서 데이터베이스를 사용하는 애플리케이션 당 한 개의 EntityManagerFactory를 생성한다.
     * */
    /*
     * 엔티티 매니저(EntityManager)란?
     * 엔티티 매니저는 엔티티를 저장하는 메모리 상의 데이터베이스를 관리하는 인스턴스이다.
     * 엔티티를 저장하고, 수정, 삭제, 조회하는 등의 엔티티와 관련된 모든 일을 한다.
     * 엔티티 매니저는 thread-safe하지 않기 때문에 동시성 문제가 발생할 수 있다.
     * 따라서 스레드 간 공유를 하지 않고, web의 경우 일반적으로 request scope와 일치시킨다.
     *
     * 영속성 컨텍스트(PersistenceContext)란?
     * 엔티티 매니저를 통해 엔티티를 저장하거나 조회하면 엔티티 매니저는 영속성 컨텍스트에 엔티티를 보관하고 관리한다.
     * 영속성 컨텍스트는 엔티티를 key-value 방식으로 저장하는 저장소이다.
     * 영속성 컨텍스트는 엔티티 매니저를 생성할 때 하나 만들어진다.
     * 그리고 엔티티 매니저를 통해서 영속성 컨텍스트에 접근할 수 있고, 또 관리할 수 있다.
     * */

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    @BeforeAll  // 테스트 클래스 전체가 시작되기 전 한번만 실행되는 메소드 정의
    public static void initFactory() {
        entityManagerFactory =
                Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll  // 테스트 클래스 전체가 진행된 후 한번만 실행되는 메소드 정의
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManage() {
        entityManager.close();
    }

    @DisplayName("엔티티 매니저 팩토리와 엔티티 매니저 생명주기 확인1")
    @Test
    public void lifeCylce1() {
        System.out.println("entityManagerFactory.hashCode() = " + entityManagerFactory.hashCode());
        System.out.println("entityManager.hashCode() = " + entityManager.hashCode());
    }

    @DisplayName("엔티티 매니저 팩토리와 엔티티 매니저 생명주기 확인1")
    @Test
    public void lifeCylce2() {
        System.out.println("entityManagerFactory.hashCode() = " + entityManagerFactory.hashCode());
        System.out.println("entityManager.hashCode() = " + entityManager.hashCode());
    }
}
