package com.shivang.jobportal.controller;

import com.shivang.jobportal.entity.Application;
import com.shivang.jobportal.service.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruiter")
@RequiredArgsConstructor
public class RecruiterController {

    private final RecruiterService recruiterService;

    @PreAuthorize("hasRole('RECRUITER')")
    @GetMapping("/applications/{jobId}")
    public List<Application> getApplicants(
            @PathVariable Long jobId
    ) {

        return recruiterService.getApplicants(jobId);
    }

    @PreAuthorize("hasRole('RECRUITER')")
    @PutMapping("/application/{id}/shortlist")
    public Application shortlistCandidate(
            @PathVariable Long id
    ) {

        return recruiterService.shortlistCandidate(id);
    }

    @PreAuthorize("hasRole('RECRUITER')")
    @PutMapping("/application/{id}/reject")
    public Application rejectCandidate(
            @PathVariable Long id
    ) {

        return recruiterService.rejectCandidate(id);
    }
}