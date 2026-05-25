package com.shivang.jobportal.service;

import com.shivang.jobportal.dto.JobRequest;
import com.shivang.jobportal.entity.Job;
import com.shivang.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job createJob(JobRequest request, String recruiterEmail) {

        Job job = new Job();
        job.setTitle(request.title);
        job.setDescription(request.description);
        job.setCompany(request.company);
        job.setLocation(request.location);
        job.setPostedBy(recruiterEmail);

        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}