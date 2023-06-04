package com.management.member.model.dto;

import java.util.Objects;

public class MemberDTO {
    // 강사 코드
    private int memberCode;
    // 강사 이름
    private String memberName;
    // 런칭일
    private String launchDate;
    // 구분 코드
    private String divisionCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return memberCode == memberDTO.memberCode && memberName.equals(memberDTO.memberName) && launchDate.equals(memberDTO.launchDate) && divisionCode.equals(memberDTO.divisionCode) && detailInfo.equals(memberDTO.detailInfo) && studentQuantity.equals(memberDTO.studentQuantity) && contact.equals(memberDTO.contact) && teamCode.equals(memberDTO.teamCode) && activeStatus.equals(memberDTO.activeStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberCode, memberName, launchDate, divisionCode, detailInfo, studentQuantity, contact, teamCode, activeStatus);
    }

    // 상세 정보
    private String detailInfo;
    // 수강생 수
    private String studentQuantity;

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberName='" + memberName + '\'' +
                ", launchDate='" + launchDate + '\'' +
                ", divisionCode='" + divisionCode + '\'' +
                ", detailInfo='" + detailInfo + '\'' +
                ", studentQuantity='" + studentQuantity + '\'' +
                ", contact='" + contact + '\'' +
                ", teamCode='" + teamCode + '\'' +
                ", activeStatus='" + activeStatus + '\'' +
                '}';
    }

    // 연락처
    private String contact;
    // 소속 코드
    private String teamCode;
    // 활동 상태
    private String activeStatus;

    // 기본 생성자
    public MemberDTO() {}

    // 강사 코드에 대한 getter/setter
    public int getMemberCode() {
        return memberCode;
    }
    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    // 강사 이름에 대한 getter/setter
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    // 런칭일에 대한 getter/setter
    public String getLaunchDate() {
        return launchDate;
    }
    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    // 구분 코드에 대한 getter/setter
    public String getDivisionCode() {
        return divisionCode;
    }
    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    // 상세 정보에 대한 getter/setter
    public String getDetailInfo() {
        return detailInfo;
    }
    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    // 수강생 수에 대한 getter/setter
    public String getStudentQuantity() {
        return studentQuantity;
    }
    public void setStudentQuantity(String studentQuantity) {
        this.studentQuantity = studentQuantity;
    }

    // 연락처에 대한 getter/setter
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    // 소속 코드에 대한 getter/setter
    public String getTeamCode() {
        return teamCode;
    }
    public void setTeamCode(int teamCode) {
        this.teamCode = String.valueOf(teamCode);
    }

    // 활동 상태에 대한 getter/setter
    public String getActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }
}
