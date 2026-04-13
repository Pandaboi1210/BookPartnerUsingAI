package com.sprint.BookPartnerApplication.mapper;

import com.sprint.BookPartnerApplication.dto.JobDTO;
import com.sprint.BookPartnerApplication.entity.Job;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {
    
    public JobDTO toDTO(Job job) {
        if (job == null) {
            return null;
        }
        return new JobDTO(
            job.getJobId(),
            job.getJobDesc(),
            job.getMinLvl(),
            job.getMaxLvl()
        );
    }
    
    public Job toEntity(JobDTO dto) {
        if (dto == null) {
            return null;
        }
        Job job = new Job();
        job.setJobId(dto.getJobId());
        job.setJobDesc(dto.getJobDesc());
        job.setMinLvl(dto.getMinLvl());
        job.setMaxLvl(dto.getMaxLvl());
        return job;
    }
}
