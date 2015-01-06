package com.supplyplatform.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.supplyplatform.domain.Member;
import com.supplyplatform.repository.MemberRepository;

public class MemberRepositoryImpl extends HiberateDAO implements MemberRepository {

	@Override
	public boolean saveMember(Member member) {
		this.getSession().save(member);
		return member.getId() != null ? true : false;
	}

	@Override
	public Member getMember(Long id) {
		return (Member) this.getSession().load(Member.class, id);
	}
	
	@Override
	public boolean removeMember(Long id) {
		Member member = getMember(id);
		this.getSession().delete(member);
		return true;
	}

	@Override
	public List<Member> getMember(Member queryMember) {
		Criteria criteria = getSession().createCriteria(Member.class);
		if (queryMember.getId() != null) {
			Criterion idEq = Restrictions.eq("id", queryMember.getId());
			criteria.add(idEq);
		}
		if (queryMember.getName() != null) {
			Criterion nameEq = Restrictions.eq("name", queryMember.getName());
			criteria.add(nameEq);
		}
		if (queryMember.getUserName() != null) {
			Criterion userNameEq = Restrictions.eq("userName", queryMember.getUserName());
			criteria.add(userNameEq);
		}
		if (queryMember.getPwd() != null) {
			Criterion pwdEq = Restrictions.eq("pwd", queryMember.getPwd());
			criteria.add(pwdEq);
		}
		return criteria.list();
	}

	
}
