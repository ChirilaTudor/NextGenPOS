package com.nextgenpos.nextgenpos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Reports {
    private Long idReport;
    private String reportName;
    private String reportFileType;
    private byte[] fileContent;
    private Date date;




    @Id
    @GeneratedValue
    public Long getIdReport() {
        return idReport;
    }

    public void setIdReport(Long idReport) {
        this.idReport = idReport;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportFileType() {
        return reportFileType;
    }

    public void setReportFileType(String reportFileType) {
        this.reportFileType = reportFileType;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
