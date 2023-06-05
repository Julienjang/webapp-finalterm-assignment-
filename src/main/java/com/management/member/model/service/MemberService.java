package com.management.member.model.service;

import com.common.SearchCondition;
import com.management.member.model.dao.MemberDAO;
import com.mvc.employee.model.dto.MemberDTO;
import com.management.member.view.MemberPrint;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.common.Template.getSqlSession;

public class MemberService {

    private MemberDAO memberDAO;
    private MemberPrint memberPrint;

    public List<MemberDTO> selectAllMembers() {
        SqlSession sqlSession = getSqlSession();

        memberDAO = sqlSession.getMapper(MemberDAO.class);
        List<MemberDTO> memberList = memberDAO.selectAllMembers();
        sqlSession.close();

        return memberList;
    }

    public List<MemberDTO> selectMemberByCondition(SearchCondition searchCondition) {
        SqlSession sqlSession = getSqlSession();

        memberDAO = sqlSession.getMapper(MemberDAO.class);
        List<MemberDTO> memberList = memberDAO.selectMemberByCondition(String.valueOf(searchCondition));
        sqlSession.close();

        return memberList;
    }

    public boolean registerNewMember(MemberDTO member) {
        SqlSession sqlSession = getSqlSession();

        memberDAO = sqlSession.getMapper(MemberDAO.class);
        boolean result = memberDAO.insertMember(member);

        if (result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public boolean modifyMemberInfo(MemberDTO member) {
        SqlSession sqlSession = getSqlSession();

        memberDAO = sqlSession.getMapper(MemberDAO.class);
        boolean result = memberDAO.updateMemberInfo(member);

        if (result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public boolean deleteMember(String memberCode) {
        SqlSession sqlSession = getSqlSession();

        memberDAO = sqlSession.getMapper(MemberDAO.class);
        boolean result = memberDAO.deleteMember(Integer.parseInt(memberCode));

        if (result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

}
