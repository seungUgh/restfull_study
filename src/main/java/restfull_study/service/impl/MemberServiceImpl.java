package restfull_study.service.impl;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restfull_study.dto.Member;
import restfull_study.mapper.MemberMapper;
import restfull_study.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	protected static final Log log = LogFactory.getLog(MemberServiceImpl.class);
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public List<Member> getLists() {
		List<Member>list = mapper.selectMemberByAll();
		log.debug("service - getLists() > " + list.size());
		return list;
	}

	@Override
	public Member getMember(long id) {
		log.debug("service = getMember() id > " + id );
		return mapper.selectMemberById(id);
	}

	@Override
	public int registerMember(Member member) {
		log.debug("service - registerMember() > " + member);
		return mapper.insertMember(member);
	}

	@Override
	public int modifyMember(Member member) {
		log.debug("service - modifyMember() > " + member);
		return mapper.updateMember(member);
	}

	@Override
	public int removeMember(long id) {
		log.debug("service - removeMember() > " + id);
		return mapper.deleteMember(id);
	}

}
