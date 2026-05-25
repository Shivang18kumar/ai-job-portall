package com.shivang.jobportal.controller;

import com.shivang.jobportal.dto.ApplicationResponse;
import com.shivang.jobportal.entity.Application;
import com.shivang.jobportal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // 🔹 Candidate applies
    @PreAuthorize("hasRole('CANDIDATE')")
    @PostMapping("/apply/{jobId}")
    public Application apply(@PathVariable Long jobId) {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return applicationService.apply(jobId, email);
    }

    // 🔹 View applications (admin/recruiter later refine)
    @GetMapping
    public List<Application> getAll() {
        return applicationService.getAllApplications();
    }


    @PreAuthorize("hasRole('CANDIDATE')")
    @PostMapping("/apply/{jobId}/resume")
    public ApplicationResponse applyWithResume(
            @PathVariable Long jobId,
            @RequestParam("file") MultipartFile file) throws Exception {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return applicationService.applyWithResume(jobId, email, file);
    }
}
