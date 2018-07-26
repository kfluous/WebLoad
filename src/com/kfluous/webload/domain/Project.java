package com.kfluous.webload.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Project {
    private int mId;
    private String mProjectname;
    private Date mDate;
    private String mRequest;
    private Byte mIsshown;
    private String mPath;

    @Id
    @Column(name = "id")
    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    @Basic
    @Column(name = "projectname")
    public String getProjectname() {
        return mProjectname;
    }

    public void setProjectname(String projectname) {
        mProjectname = projectname;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    @Basic
    @Column(name = "request")
    public String getRequest() {
        return mRequest;
    }

    public void setRequest(String request) {
        mRequest = request;
    }

    @Basic
    @Column(name = "isshown")
    public Byte getIsshown() {
        return mIsshown;
    }

    public void setIsshown(Byte isshown) {
        mIsshown = isshown;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return mId == project.mId &&
                Objects.equals(mProjectname, project.mProjectname) &&
                Objects.equals(mDate, project.mDate) &&
                Objects.equals(mRequest, project.mRequest) &&
                Objects.equals(mIsshown, project.mIsshown) &&
                Objects.equals(mPath, project.mPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mProjectname, mDate, mRequest, mIsshown, mPath);
    }
}
