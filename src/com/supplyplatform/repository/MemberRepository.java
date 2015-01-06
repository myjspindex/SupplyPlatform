package com.supplyplatform.repository;

import java.util.List;

import com.supplyplatform.domain.Member;

/**
 * ��Ա�ֿ�
 * @author bxy
 *
 */
public interface MemberRepository {
	
	
	/**
	 * �����Ա 
	 * @param member
	 */
	public boolean saveMember(Member member);
	
	
	/**
	 * ���һ����Ա
	 * @param id
	 * @return
	 */
	public Member getMember(Long id);
	
	
	/**
	 * ɾ��һ����Ա
	 * @param id
	 * @return
	 */
	public boolean removeMember(Long id);
	
	
	/**
	 * ����������ѯMember
	 * @param userName
	 * @param pwd
	 * @return
	 */
	public List<Member> getMember(Member queryMember);
	

}
