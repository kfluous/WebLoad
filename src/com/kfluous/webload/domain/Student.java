package com.kfluous.webload.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Student {
    private Long mSid;
    private String mName;
    private String mPassword;
    private byte mAdmin;

    @Id
    @Column(name = "sid")
    public long getSid() {
        return mSid;
    }

    public void setSid(long sid) {
        mSid = sid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    @Basic
    @Column(name = "admin")
    public byte getAdmin() {
        return mAdmin;
    }

    public void setAdmin(byte admin) {
        mAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return mSid == student.mSid &&
                mAdmin == student.mAdmin &&
                Objects.equals(mName, student.mName) &&
                Objects.equals(mPassword, student.mPassword);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mSid, mName, mPassword, mAdmin);
    }
}
