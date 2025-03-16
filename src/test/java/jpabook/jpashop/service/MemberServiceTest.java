package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

// 테스트가 컨테이너에서 실행되므로 @Autowired 같은 기능을 사용할 수 있다.
@RunWith(SpringJUnit4ClassRunner.class)
// 테스트 케이스를 실행할 때 사용하는 스프링 설정 정보
@ContextConfiguration(locations = "classpath:appConfig.xml")
// 서비스 계층에서 사용했을 때와 다르게 테스트가 끝나면 트랜잭션을 강제로 롤백한다.
// 따라서 데이터베이스에 데이터가 저장되지 않아 반복해서 테스트를 진행할 수 있다.
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void join() throws Exception {

        // Given
        Member member = new Member();
        member.setName("kim");

        // When
        Long saveId = memberService.join(member);

        // Then
        assertEquals(member, memberService.findOne(saveId));
    }


}
