package com.jobhunter.register.dao;

import com.jobhunter.register.domain.EmploymentCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmploymentDao extends JpaRepository<EmploymentCertificate, Long> {
}
