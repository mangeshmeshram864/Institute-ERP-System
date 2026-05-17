package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.dto.CounsellorDto;
import com.example.demo.entity.Counsellor;


public interface CounselorService {
	
	String addCounsellor(CounsellorDto dto);
	String deleteCounsellor( long id);
	String updateCounsellor(long id  ,  Counsellor update);
	Counsellor getCounsellor(long id);
	List<Counsellor> getCounsllors();
	
	

}
