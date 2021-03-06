package com.qa.imsproject.persistance.dao.classes;
/**
 * ProjectCustomer class with getters and setters to be used by the methods in the DAOs
 * @author Admin
 *
 */
public class ProjectCustomer {

		private Long id;
		private String name;
		
		public ProjectCustomer(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}


		public ProjectCustomer(String name) {
			super();
			this.name = name;
		}


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

		
}
