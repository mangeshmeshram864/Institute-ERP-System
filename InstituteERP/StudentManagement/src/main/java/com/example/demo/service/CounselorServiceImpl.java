package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CounsellorDto;
import com.example.demo.entity.Counsellor;
import com.example.demo.exception.CounserllorException;
import com.example.demo.interfaces.CounselorService;
import com.example.demo.repository.CounsellorRepository;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.FollowUpRepository;
import com.example.demo.repository.InquiryRepository;

@Service
public class CounselorServiceImpl implements CounselorService {
	 @Autowired
	    private InquiryRepository inquiryRepo;

	    @Autowired
	    private CounsellorRepository counsellorRepo;

	    @Autowired
	    private FollowUpRepository followUpRepo;

	    @Autowired
	    private EnrollmentRepository enrollmentRepo;
   
    
    @Override
    public String addCounsellor(CounsellorDto dto) {

        Counsellor counsellor = new Counsellor();
        counsellor.setName(dto.getName());
        counsellor.setEmail(dto.getEmail());
        counsellor.setPhone(dto.getPhone());
        counsellor.setJoiningDate(dto.getJoiningDate());
        counsellor.setStatus(dto.getStatus());

        counsellorRepo.save(counsellor);

        return "Counsellor added successfully";
    }



	@Override
	public String updateCounsellor(long id , Counsellor update) {
		if(!counsellorRepo.existsById(id)) {
			throw new CounserllorException("This Counserllor are not available", HttpStatus.NOT_FOUND);
		}
		Counsellor exist = new Counsellor();
		exist.setName(update.getName());
		exist.setEmail(update.getEmail());
		exist.setJoiningDate(update.getJoiningDate());
		exist.setPhone(update.getPhone());
		exist.setStatus(update.getStatus());
		
		counsellorRepo.save(exist);
		
		return "cousellor are updated";
	}


	@Override
	public Counsellor getCounsellor(long id) {
		if(!counsellorRepo.existsById(id)) {
			throw new CounserllorException("This Counserllor are not available", HttpStatus.NOT_FOUND);
		}
		
		return counsellorRepo.findById(id).get();
	}


	@Override
	public List<Counsellor> getCounsllors() {
		
		return counsellorRepo.findAll();
	}



	@Override
	public String deleteCounsellor(long id) {
		if(!counsellorRepo.existsById(id)) {
			throw new CounserllorException("This Counserllor are not available", HttpStatus.NOT_FOUND);
		}
		counsellorRepo.deleteById(id);
		return "Counsellor are deleted ";
	}

   
}