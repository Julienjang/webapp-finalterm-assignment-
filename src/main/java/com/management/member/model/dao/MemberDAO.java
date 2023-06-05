package com.management.member.model.dao;

import com.mvc.employee.model.dto.MemberDTO;

import java.util.List;

public interface MemberDAO {
    List<MemberDTO> selectAllMembers();

    List<MemberDTO> selectMemberByCondition(String condition);

    boolean insertMember(MemberDTO member);

    boolean updateMemberInfo(MemberDTO member);

    boolean deleteMember(int memberCode);
}
