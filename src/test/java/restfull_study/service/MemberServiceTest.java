package restfull_study.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import restfull_study.config.ControllerConfig;
import restfull_study.dto.Member;
import restfull_study.service.impl.MemberServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ControllerConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberServiceTest {
	protected static final Log log = LogFactory.getLog(MemberServiceImpl.class);
	private static Member member;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Autowired
	private MemberService service;
	
	@Test
	public void test01GetLists() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Member> list = service.getLists();
		Assert.assertNotNull(list);
		list.forEach(member -> log.debug(member.toString()));
		
	}

	@Test
	public void test04GetMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	
		Member findMember = service.getMember(member.getId());
		Assert.assertNotNull(findMember);
		log.debug(findMember.toString());
	}

	@Test
	public void test03RegisterMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		member = new Member("test700@test.co.kr", "1111", "test700", null);
		int res = service.registerMember(member);
		Assert.assertEquals(1, res);
		
		log.debug("member > " + member.toString());
	
	}

	@Test
	public void test05ModifyMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		member.setName("수정");
		member.setPassword("2222");
		
		int res = service.modifyMember(member);
		Assert.assertEquals(1, res);
		
		log.debug(member.toString());
	}

	@Test
	public void test06RemoveMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	
		int res = service.removeMember(member.getId());
		Assert.assertEquals(1, res);
	}

}
