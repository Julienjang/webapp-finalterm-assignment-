package com.mvc.employee.model.service;

import com.mvc.employee.model.dao.MemberDAO;
import com.mvc.employee.model.dto.MemberDTO;

import java.sql.Connection;
import java.util.List;

import static com.mvc.common.jdbc.JDBCTemplate.*;

public class MemberService {

    private final MemberDAO memberDAO;

    public MemberService() {
        memberDAO = new MemberDAO();
    }

    public MemberDTO selectOneMemberById(int memberId) {

        /* Connection 생성 */
        Connection con = getConnection();

        /* Connection과 함께 정보를 전달하여 조회한다. */
        MemberDTO selectedMember = memberDAO.selectMemberById(con, memberId);

        /* connection 닫기 */
        close(con);

        /* 조회 결과를 반환한다. */
        return selectedMember;
    }

    /* 멤버 정보 전체 조회용 메소드 */
    public List<MemberDTO> selectAllMembers() {

        /* Connection 생성 */
        Connection con = getConnection();

        /* 비지니스 로직 */
        /* 1. dao 호출하여 조회 */
        List<MemberDTO> memberList = memberDAO.selectAllMembers(con);

        /* Connection 닫기 */
        close(con);

        /* 수행 결과 반환 */
        return memberList;
    }

    /* 신규 멤버 등록용 메소드 */
    public int insertMember(MemberDTO member) {

        Connection con = getConnection();

        int result = memberDAO.insertMember(con, member);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result;
    }

    public int updateMember(MemberDTO member) {

        Connection con = getConnection();

        int result = memberDAO.updateMember(con, member);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result;
    }

    public int deleteMember(int memberCode) {

        Connection con = getConnection();

        int result = memberDAO.deleteMember(con, memberCode);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result;
    }

}
