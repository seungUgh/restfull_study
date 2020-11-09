package restfull_study.mapper;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ControllerConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberMapperTest {

	protected static final Log log = LogFactory.getLog(MemberMapperTest.class);
	private static Member member;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Autowired
	private MemberMapper mapper;

	@Test
	public void test01SelectMemberByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Member> list = mapper.selectMemberByAll();
		Assert.assertNotNull(list);
//		list.stream().forEach(System.out::println);
		list.forEach(member -> log.debug(member.toString()));
	}

	@Test
	public void test02SelectMemberById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		long member = 2;
		Member res = mapper.selectMemberById(member);
		Assert.assertNotNull(res);
		log.debug(res.toString());
	}

	@Test
	public void test03InsertMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		member = new Member("test121@test.co.kr", "1111", "test300", null);
		int res = mapper.insertMember(member);
		Assert.assertEquals(1, res);

		log.debug(member.toString());

	}

	@Test
	public void test04UpdateMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member upMember = mapper.selectMemberById(member.getId());
		upMember.setName("수정");
		upMember.setPassword("2222");
		int res = mapper.updateMember(upMember);
		Assert.assertEquals(1, res);
		
		log.debug(upMember.toString());
	}

	@Test
	public void test05DeleteMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int res = mapper.deleteMember(member.getId());
		Assert.assertEquals(1, res);
		
	}

}
