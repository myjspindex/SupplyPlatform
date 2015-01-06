package com.supplyplatform.repository;

import java.util.List;

import com.supplyplatform.domain.Member;

/**
 * 会员仓库
 * @author bxy
 *
 */
public interface MemberRepository {
	
	
	/**
	 * 保存会员 
	 * @param member
	 */
	public boolean saveMember(Member member);
	
	
	/**
	 * 获得一个会员
	 * @param id
	 * @return
	 */
	public Member getMember(Long id);
	
	
	/**
	 * 删除一个会员
	 * @param id
	 * @return
	 */
	public boolean removeMember(Long id);
	
	
	/**
	 * 根据条件查询Member
	 * @param userName
	 * @param pwd
	 * @return
	 */
	public List<Member> getMember(Member queryMember);
	

}
