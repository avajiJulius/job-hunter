package com.jobhunter.job.web;

import com.jobhunter.job.dao.PersonCheckDao;
import com.jobhunter.job.domain.PersonRequest;
import com.jobhunter.job.domain.PersonResponse;
import com.jobhunter.job.exception.PersonCheckException;
import com.jobhunter.job.dao.PoolConnectionBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/check")
@Singleton
public class CheckPersonService {

    private static final Logger logger = LoggerFactory.getLogger(CheckPersonService.class);
    private PersonCheckDao dao;

    @PostConstruct
    public void init() {
        logger.info("SERVICE IS CREATED");
        dao = new PersonCheckDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {
        logger.info(request.toString());
        return dao.checkPerson(request);
    }

}
