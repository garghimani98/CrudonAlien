package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Entity
public class Alien {
	
	@Id
     private int aid;
	 private String aname;
	 private String tech;
		public String getTech() {
		return tech;
	    }
	   public void setTech(String tech) {
		this.tech = tech;
	    }
		public int getAid() {
			return aid;
		}
		public void setAid(int aid) {
			this.aid = aid;
		}
		public String getAname() {
			return aname;
		}
		public void setAname(String aname) {
			this.aname = aname;
		}
}
