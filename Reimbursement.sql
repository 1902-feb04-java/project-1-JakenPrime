CREATE DATABASE reimbursement_portal;
CREATE SCHEMA reimbursements;

CREATE TABLE reimbursements.employees(
	id SERIAL NOT NULL,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	manager_id INTEGER NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	CONSTRAINT pk_employee_id PRIMARY KEY (id),
	CONSTRAINT u_employee_email_id UNIQUE(email, id),
	CONSTRAINT fk_emp_manager_id FOREIGN KEY (manager_id) REFERENCES managers.id,
	CONSTRAINT chk_min_emp_password CHECK(LENGTH(password >=8))
);
										  
CREATE TABLE reimbursements.managers(
	id SERIAL NOT NULL,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	CONSTRAINT pk_manager_id PRIMARY KEY (id),
	CONSTRAINT u_manager_email_id UNIQUE(email, id),
	CONSTRAINT chk_min_man_password CHECK(LENGTH(password >=8))
);

CREATE TABLE reimbursements.reimbursements(
	id SERIAL NOT NULL,
	employee_id INTEGER NOT NULL,
	manager_id INTEGER NOT NULL,
	amount NUMERIC(8,2) NOT NULL,
	receipt BYTEA NOT NULL,
	status_id INTEGER NOT NULL,
	CONSTRAINT pk_reimbursement_id PRIMARY KEY (id),
	CONSTRAINT fk_reimburse_manager_id FOREIGN KEY (manager_id) REFERENCES managers.id,
	CONSTRAINT fk_reimburse_employee_id FOREIGN KEY (employee_id) REFERENCES employees.id,
	CONSTRAINT fk_reimburse_status_id FOREIGN KEY (status_id) REFERENCES reimbursement_status.id,
);
						
CREATE TABLE reimbursement.reimbursement_status(
	id SERIAL NOT NULL,
	name VARCHAR(50) NOT NULL,
	CONSTRAINT pk_status_id PRIMARY KEY (id)
);