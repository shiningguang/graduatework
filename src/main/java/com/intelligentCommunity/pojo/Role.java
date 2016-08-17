package com.intelligentCommunity.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String chinesename;
	private List<Permission> permissions;
	
	public final static int STATUS_ADMIN = 1;
	public final static int STATUS_US = 2;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChinesename() {
		return chinesename;
	}
	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="role_permission",joinColumns={
			@JoinColumn(name="rid")
	},inverseJoinColumns={
			@JoinColumn(name="pid")
	})
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	

}

