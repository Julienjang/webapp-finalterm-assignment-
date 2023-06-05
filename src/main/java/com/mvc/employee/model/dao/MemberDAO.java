package com.mvc.employee.model.dao;

import com.mvc.common.config.ConfigLocation;
import com.mvc.employee.model.dto.MemberDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.mvc.common.jdbc.JDBCTemplate.close;

public class MemberDAO {

    private final Properties prop;

    public MemberDAO() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "member-mapper.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MemberDTO selectMemberById(Connection con, int memberId) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        MemberDTO selectedMember = null;

        String query = prop.getProperty("selectMemberById");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, memberId);

            rset = pstmt.executeQuery();

            if (rset.next()) {
                selectedMember = new MemberDTO();

                selectedMember.setMemberCode(rset.getInt("MEMBER_CODE"));
                selectedMember.setMemberName(rset.getString("MEMBER_NAME"));
                selectedMember.setLaunchDate(rset.getString("LAUNCH_DATE"));
                selectedMember.setDivisionCode(rset.getString("DIVISION_CODE"));
                selectedMember.setDetailInfo(rset.getString("DETAIL_INFO"));
                selectedMember.setStudentQuantity(rset.getString("STUDENT_QUANTITY"));
                selectedMember.setContact(rset.getString("CONTACT"));
                selectedMember.setTeamCode(rset.getString("TEAM_CODE"));
                selectedMember.setActiveStatus(rset.getString("ACTIVE_STATUS"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return selectedMember;
    }

    /* Select all members */
    public List<MemberDTO> selectAllMembers(Connection con) {

        Statement stmt = null;
        ResultSet rset = null;

        List<MemberDTO> memberList = null;

        String query = prop.getProperty("selectAllMembers");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            memberList = new ArrayList<>();

            while (rset.next()) {
                MemberDTO member = new MemberDTO();

                member.setMemberCode(rset.getInt("MEMBER_CODE"));
                member.setMemberName(rset.getString("MEMBER_NAME"));
                member.setLaunchDate(rset.getString("LAUNCH_DATE"));
                member.setDivisionCode(rset.getString("DIVISION_CODE"));
                member.setDetailInfo(rset.getString("DETAIL_INFO"));
                member.setStudentQuantity(rset.getString("STUDENT_QUANTITY"));
                member.setContact(rset.getString("CONTACT"));
                member.setTeamCode(rset.getString("TEAM_CODE"));
                member.setActiveStatus(rset.getString("ACTIVE_STATUS"));

                memberList.add(member);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(stmt);
        }

        return memberList;
    }

    /* Insert new member */
    public int insertMember(Connection con, MemberDTO member) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("insertMember");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, member.getMemberCode());
            pstmt.setString(2, member.getMemberName());
            pstmt.setString(3, member.getLaunchDate());
            pstmt.setString(4, member.getDivisionCode());
            pstmt.setString(5, member.getDetailInfo());
            pstmt.setString(6, member.getStudentQuantity());
            pstmt.setString(7, member.getContact());
            pstmt.setString(8, member.getTeamCode());
            pstmt.setString(9, member.getActiveStatus());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }


    // Update member details
    public int updateMember(Connection con, MemberDTO member) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("updateMember");

        try {
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, member.getMemberName());
            pstmt.setString(2, member.getLaunchDate());
            pstmt.setString(3, member.getDivisionCode());
            pstmt.setString(4, member.getDetailInfo());
            pstmt.setString(5, member.getStudentQuantity());
            pstmt.setString(6, member.getContact());
            pstmt.setString(7, member.getTeamCode());
            pstmt.setString(8, member.getActiveStatus());
            pstmt.setInt(9, member.getMemberCode());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }


    // Delete member by member code
    public int deleteMember(Connection con, int memberCode) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("deleteMember");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, memberCode);

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }

}