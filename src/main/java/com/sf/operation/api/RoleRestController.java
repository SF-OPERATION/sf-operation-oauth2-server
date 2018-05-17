package com.sf.operation.api;

public class RoleRestController {

}
/*package com.sf.operation.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.issueapi.model.Role;
import com.issueapi.service.RoleService;
//@Controller + @ResponseBody
@RestController
public class RoleRestController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("/roles")
	public Map<String,Object> getAllRoles(){
		List<Role> roles=roleService.getAllRoles();
		
		Map<String,Object> map=new HashMap<>();
		map.put("message", "Get All Role Successfully.");
		map.put("status", true);
		map.put("data",roles);
		System.out.println(roleService.getAllRoles());
		return map;
	}
	 customize response status with ResponseEntity
	 * 
	 * 
	@GetMapping("/roles/{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable Integer  id){
		Role role=roleService.findRoleById(id);
		if(role==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		System.out.println(roleService.findRoleById(id));
		return ResponseEntity.ok(role);
	}
	
	
	//{message: "" ,status: "",data:{}}
	@PostMapping("/roles")
	public Map<String, Object> createRole(@RequestBody Role role){
			boolean status=roleService.createRole(role);
			Map<String,Object> map=new HashMap<>();
			map.put("message", "Create Role Successfully.");
			map.put("status", status);
			
		 	System.out.println(role);
		 	return map;
	
	}
	
	@DeleteMapping("/roles/{id}")
	public ResponseEntity<?> removeRoleById(@PathVariable Integer  id){
		if(!roleService.removeRoleById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		System.out.println(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@PutMapping("/roles")
	public ResponseEntity<?> updateRoleById(@RequestBody Role role){
			Map<String,Object> map=new HashMap<>();
			map.put("message", "Updated Role Successfully.");
			if(roleService.updateRoleById(role)){
				return new ResponseEntity<>(map,HttpStatus.OK);
			}
		 	System.out.println(role.getRoleID());
		 	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

	@GetMapping("/roles")
	public List<Role> getAllRoles(){
		System.out.println(roleService.getAllRoles());
		return roles=roleService.getAllRoles();;
	}
	
	@PostMapping("/roles")
	public boolean createRole(@RequestBody Role role){
		 	System.out.println(role);
		 	return roleService.createRole(role);
	
	}
	
	@DeleteMapping("/roles/{id}")
	public boolean removeRoleById(@PathVariable Integer  id){
		System.out.println(id);	
		return roleService.removeRoleById(id);
	}
	
	@PutMapping("/roles")
	public boolean updateRoleById(@RequestBody Role role){
		 	System.out.println(role.getRoleID());
		 	return roleService.updateRoleById(role);
	
	}
}
	*/