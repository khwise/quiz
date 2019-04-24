package com.quiz.core.persistences.repository;

import com.quiz.core.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @DataJpaTest 는 기본값이 InMemory DB 이다.
 * mysql 과 같은 production type 의 DB 를 사용할 시 다음과 같은 코드를 추가한다.
 * @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
 * TODO : DataSource 로딩
 **/
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void create_member() {

        Member newMember = new Member();
        newMember.setId("owner");
        newMember.setPassword("password");
        Member saveMember = memberRepository.save(newMember);

        assertThat(saveMember.getMemberNo(), is(notNullValue()));

    }
}