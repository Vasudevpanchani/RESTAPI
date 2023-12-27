package com.example.doctorandpatient.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.doctorandpatient.dto.ResponseDTO;
import com.example.doctorandpatient.model.Doctor;
import com.example.doctorandpatient.service.DoctorService;

import jakarta.persistence.criteria.Path;


@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	private static final String UPLOAD_DIR = "C:\\Users\\HP\\OneDrive\\Pictures\\Screenshots";
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/getDoctor")
	@ResponseBody
	public List<Doctor> getAllDetails(){
		return doctorService.getAllDetails();
	}
	
	@PostMapping("/addDoctor")
	@ResponseBody
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}
	
	@DeleteMapping("/deleteDoctor")
	@ResponseBody
	public Doctor deleteDoctor(@RequestParam("id") long id) {
		return doctorService.deleteDoctor(id);
	}
	
	@PutMapping("/updateDoctor")
	@ResponseBody
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		return doctorService.updateDoctor(doctor);
	}
	
	@PutMapping("/addDataById")
	@ResponseBody
	public Doctor addDoctorDataByIdandPatientId(@RequestParam("did") long doctorid,@RequestParam("pid") long patientid) {
		return doctorService.addDoctorDataByIdandPatientId(doctorid, patientid);
	}
	
	@PostMapping("/uploadFile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		try {
			File directory=new File(UPLOAD_DIR);
			
			if (!directory.exists()) {	
				directory.mkdirs();
			}
			
			String fileName = file.getOriginalFilename();
			java.nio.file.Path filePath=Paths.get(UPLOAD_DIR).resolve(fileName);
			
			Files.write(filePath, file.getBytes(), StandardOpenOption.CREATE);

			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/doctor/download/")
					.path(fileName).toUriString();

			return ResponseEntity.ok("File uploaded successfully. Download URL: " + fileDownloadUri);
		}catch (IOException ex) {
			return ResponseEntity.status(500).body("Could not upload the file: " + ex.getMessage());
		}
	}
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<Object> downloadFile(@PathVariable("fileName") String fileName) {
		try {

			java.nio.file.Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName).normalize();
			File file = filePath.toFile();

			if (file.exists()) {
				org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
				headers.setContentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM);
				headers.setContentDispositionFormData("attachment", fileName);

				return ResponseEntity.ok().headers(headers).contentLength(file.length())
						.body(new FileSystemResource(file));
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception ex) {
			return ResponseEntity.status(500).body("Failed to download the file: " + ex.getMessage());
		}
	}
	
	@GetMapping("/getDoctorById/{id}")
	@ResponseBody
	public ResponseDTO getDoctorFindById(@PathVariable("id") long id) {
		Doctor doctor=doctorService.DoctorFindById(id);
		return new ResponseDTO(200,"ok",doctor);
	}
}
