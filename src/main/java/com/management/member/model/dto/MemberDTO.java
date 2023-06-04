package com.management.member.model.dto;

import java.util.Objects;

public class MemberDTO {
    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(int teamCode) {
        this.teamCode = teamCode;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    private int memberCode;
    private String memberName;
    private String birthDate;
    private String divisionCode;
    private String detailInfo;
    private String contact;
    private int teamCode;
    private String activeStatus;


    // 생성자
    public MemberDTO() {
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberName='" + memberName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", divisionCode='" + divisionCode + '\'' +
                ", detailInfo='" + detailInfo + '\'' +
                ", contact='" + contact + '\'' +
                ", teamCode=" + teamCode +
                ", activeStatus='" + activeStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return memberCode == memberDTO.memberCode && teamCode == memberDTO.teamCode && Objects.equals(memberName, memberDTO.memberName) && Objects.equals(birthDate, memberDTO.birthDate) && Objects.equals(divisionCode, memberDTO.divisionCode) && Objects.equals(detailInfo, memberDTO.detailInfo) && Objects.equals(contact, memberDTO.contact) && Objects.equals(activeStatus, memberDTO.activeStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberCode, memberName, birthDate, divisionCode, detailInfo, contact, teamCode, activeStatus);
    }
}

// Getter/Setter 메소드

