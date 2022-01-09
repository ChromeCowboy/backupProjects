
-- catering company reimbursement 

drop table employee_login cascade;
create table employee_login(
	employee_login_id numeric,
	employee_login_name varchar primary key,
	employee_login_password varchar
);

drop table manager_login;
create table manager_login(
	manager_login_id numeric,
	manager_login_name varchar primary key,
	manager_login_password varchar	
);

drop table reimbursements cascade;
create table reimbursements(
	reimbursed_invoice_num serial primary key, -- serial makes the id climb automatically
	reimbursed_employee varchar,
	reimbursed_past_pending varchar,
    reimbursed_approval varchar,
	reimbursed_amount numeric,
	reimbursed_reason varchar
);

drop sequence reimbursement_sequence;
create sequence reimbursement_sequence start 275 increment 5;  -- sequence for invoice starts at 275

insert into employee_login values(1, 'Ben Employee', 'benemployee');
insert into employee_login values(2, 'Alli Employee', 'alliemployee');
insert into employee_login values(3, 'Sam Employee', 'samemployee');

insert into manager_login values(1, 'Jerry Admin', 'jerryadmin');

insert into reimbursements values(nextval('reimbursement_sequence'),'Ben Employee','pending','null', 4.69, 'Birthday candles for event.');
insert into reimbursements values(nextval('reimbursement_sequence'), 'Alli Employee', 'past', 'approved', 10.25, 'Work lunch meeting.');
insert into reimbursements values(nextval('reimbursement_sequence'), 'Sam Employee', 'past', 'not approved', 20.53, 'Tie for wedding event.');
insert into reimbursements values(nextval('reimbursement_sequence'), 'Ben Employee', 'past', 'approved', 3.71, 'Pens for dinner guests at event.');
insert into reimbursements values(nextval('reimbursement_sequence'), 'Ben Employee', 'past', 'approved', 5.24, 'Lighters for the tables at event');
insert into reimbursements values(nextval('reimbursement_sequence'), 'Alli Employee', 'pending', 'null', 13.54, 'Napkins for birthday event');
insert into reimbursements values(nextval('reimbursement_sequence'),'Ben Employee', 'past', 'not approved', 3.12, 'Bus ticket to work');
insert into reimbursements values(nextval('reimbursement_sequence'), 'Sam Employee', 'past', 'approved', 30.98, 'Two bottles of wine for guests');
insert into reimbursements values(nextval('reimbursement_sequence'), 'Alli Employee', 'past', 'not approved', 53.02, 'Phone bill');
insert into reimbursements values(nextval('reimbursement_sequence'), 'Ben Employee', 'pending', 'null', 14.09, 'Copies of menu at copiers');
insert into reimbursements values(nextval('reimbursement_sequence'), 'Alli Employee', 'past', 'approved', 17.08, 'Plastic cups for event');

select * from reimbursements where reimbursed_employee='Alli Employee';

select * from reimbursements where reimbursed_past_pending = 'pending';