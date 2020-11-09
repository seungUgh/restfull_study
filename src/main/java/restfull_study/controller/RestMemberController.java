package restfull_study.controller;



import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restfull_study.dto.Member;
import restfull_study.exception.DuplicateMemberException;
import restfull_study.service.MemberService;

@RestController
@RequestMapping("/api")
public class RestMemberController {

	@Autowired
	private MemberService service;
	
	
	@GetMapping("/members")
	public ResponseEntity<Object> members(){
		System.out.println("members()");
		return ResponseEntity.ok(service.getLists());
		//리턴되는게잇으면 gson으로 변경해서 돌려주겟다~~~
	}
	
	//숫자만 가능하다!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	@GetMapping("/members/{id}")
	public ResponseEntity<Object> member(@PathVariable long id){
		System.out.println("members() id > ");
		Member member = service.getMember(id);
		if(member == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(member);
	}
	
	@PostMapping("/members/")
	public ResponseEntity<Object> newMember(@RequestBody Member member){
		System.out.println("newMember > "+ member);
		try {
			service.registerMember(member);
			
			URI uri = URI.create("/api/members/" + member.getId());
			return ResponseEntity.created(uri).body(member.getId());
		}catch(DuplicateMemberException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@PutMapping("/members/{id}")
	public ResponseEntity<Object> updateMember(@PathVariable long id, @RequestBody Member member){
		System.out.println("updateMember >" + member);
		return ResponseEntity.ok(service.modifyMember(member));
	}
	
	@DeleteMapping("/members/{id}")
	public ResponseEntity<Object> deleteMember(@PathVariable long id){
		System.out.println("deleteMember > " + id);
		return ResponseEntity.ok(service.removeMember(id));
	}

	//HTTP method - get(select) post(insert) put(update) patch(update), delete
}
