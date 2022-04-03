package com.javeros.musicroom.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javeros.musicroom.models.BranchOffice;
import com.javeros.musicroom.models.Room;
import com.javeros.musicroom.repository.IRoomRepository;
import com.javeros.musicroom.repository.ISucursalesRepository;

@RequestMapping("/api/branch-oficces")
@RestController
public class BranchOfficeResource {
	
	private final ISucursalesRepository branchOfficeRepository;
	private final IRoomRepository roomRepository;
	
	public BranchOfficeResource(ISucursalesRepository branchOfficeRepository, IRoomRepository roomRepository) {
		this.branchOfficeRepository = branchOfficeRepository;
		this.roomRepository = roomRepository;
	}

	@GetMapping
	public ResponseEntity<List<BranchOffice>> findAll(){
		List<BranchOffice> list = branchOfficeRepository.findByStatus(1);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}/rooms")
	public ResponseEntity<List<Room>> findByBranchOffice(@PathVariable("id") Long id){
		List<Room> list = roomRepository.findByBranchOfficeId(id);
		return ResponseEntity.ok(list);
	}
}
