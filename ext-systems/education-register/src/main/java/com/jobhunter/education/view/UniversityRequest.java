package com.jobhunter.education.view;

import java.io.Serializable;
import java.time.LocalDate;

public class UniversityRequest implements Serializable {
    private String uniStudentFirstName;
    private String uniStudentLastName;
    private LocalDate uniStudentBirthDay;

    private String universityCertificateNumber;
    private LocalDate universityIssueDate;


}
