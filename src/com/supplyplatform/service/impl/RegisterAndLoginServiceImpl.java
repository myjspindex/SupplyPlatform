package com.supplyplatform.service.impl;

import java.util.List;

import com.supplyplatform.domain.Mall;
import com.supplyplatform.domain.Member;
import com.supplyplatform.domain.SuperMarket;
import com.supplyplatform.repository.MemberRepository;
import com.supplyplatform.service.RegisterAndLoginService;

public class RegisterAndLoginServiceImpl extends BaseService implements RegisterAndLoginService {
	
	private MemberRepository memberRepository;
	
	
	@Override
	public Mall mallLogin(Mall mall) {
		List<Member> list = memberRepository.getMember(mall);
		return list.size() > 0 ? (Mall) list.get(0) : null;
	}
	
	
	@Override
	public int mallRegister(Mall mall) {
		Mall query = new Mall();
		query.setUserName(mall.getUserName());
		List<Member> list = memberRepository.getMember(mall);
		if (list.size() != 0) {
			//这种情况 证明用户名已经注册 
			return 2;
		}
		return memberRepository.saveMember(mall) ? 0 : 1;
	}
	

	@Override
	public SuperMarket supermarketLogin(SuperMarket superMarket) {
		List<Member> list = memberRepository.getMember(superMarket);
		return list.size() > 0 ? (SuperMarket) list.get(0) : null;
	}


	@Override
	public int supermarketRegister(SuperMarket superMarket) {
		SuperMarket query = new SuperMarket();
		query.setUserName(superMarket.getUserName());
		List<Member> list = memberRepository.getMember(query);
		if (list.size() != 0) {
			//这种情况 证明用户名已经注册 
			return 2;
		}
		return memberRepository.saveMember(superMarket) ? 0 : 1;
	}

	
	public void setMemberRepository(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
}
