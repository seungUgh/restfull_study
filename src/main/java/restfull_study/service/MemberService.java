package restfull_study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import restfull_study.dto.Member;


@Service
public interface MemberService {
	List<Member> getLists();

	Member getMember(long id);

	int registerMember(Member member);

	int modifyMember(Member member);

	int removeMember(long id);
}
