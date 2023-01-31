package com.nextgenpos.nextgenpos.common;

import java.util.Date;

public class ReportDto {
    private Long idReport;
    private String reportName;
    private String reportFileType;
    private String[] fileContent;
    private Date date;

    public ReportDto(Long idReport, String reportName, String reportFileType, String[] fileContent, Date date) {
        this.idReport = idReport;
        this.reportName = reportName;
        this.reportFileType = reportFileType;
        this.fileContent = fileContent;
        this.date = date;
    }

    public Long getIdReport() {
        return idReport;
    }

    public String getReportName() {
        return reportName;
    }

    public String getReportFileType() {
        return reportFileType;
    }

    public String[] getFileContent() {
        return fileContent;
    }

    public Date getDate() {
        return date;
    }
}
