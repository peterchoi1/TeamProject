-- trigger to throw error if instructor.years_experience is less than 1
DROP TRIGGER IF EXISTS trg_years_exp_ins;
DELIMITER $$
create trigger trg_years_exp_ins 
before insert on employee
for each row
begin
   declare msg varchar(128);
   if new.role_id < 1
    then
    if new.years_experience < 1 
     then
        set msg = concat('InsertYearsExpError: Trying to insert a negative or zero value in employee: ', cast(new.years_experience as char));
        signal sqlstate '45000' set message_text = msg;
     end if;
     elseif new.years_experience < 0
     then 
     set msg = concat('InsertYearsExpError: Trying to insert a negative value in employee: ', cast(new.years_experience as char));
        signal sqlstate '45000' set message_text = msg;
   end if;
end $$
DELIMITER ;


-- Insert trigger to throw error if the student.major_id being assigned does not meet the minimum requirements for the SAT score
DROP TRIGGER IF EXISTS trg_valid_major_ins;
DELIMITER $$
create trigger trg_valid_major_ins 
before insert on student
for each row
begin
   declare msg varchar(128);
    declare sat_check integer;
    select major.minimum_sat into sat_check from major where new.major_id = major.id;
   if (new.sat < sat_check) or (new.sat > 1600)
    then
       set msg = concat('InsertMajError: Trying to insert an invalid value in Student major_id field.');
       signal sqlstate '45000' set message_text = msg;
   end if;
end $$
DELIMITER ;

-- Update trigger to throw error if the student.major_id being assigned does not meet the minimum requirements for the GPA score
DROP TRIGGER IF EXISTS trg_valid_major_upd;
DELIMITER $$
create trigger trg_valid_major_upd 
before update on student
for each row
begin
   declare msg varchar(128);
    declare gpa_check integer;
    select major.req_gpa into gpa_check from major where new.major_id = major.id;
   if (new.gpa < gpa_check) or (new.gpa > 4.0)
    then
       set msg = concat('UpdateMajError: Trying to update an invalid value in student major_id field.');
       signal sqlstate '45000' set message_text = msg;
   end if;
end $$
DELIMITER ;

-- Insert trigger to throw error if the student sat score does not meet the minimum requirements
DROP TRIGGER IF EXISTS trg_valid_sat_ins;
DELIMITER $$
create trigger trg_valid_sat_ins 
before insert on student
for each row
begin
   declare msg varchar(128);
   if (new.sat < 400) or (new.sat > 1600)
    then
       set msg = concat('InsertSatError: Trying to insert an invalid value in Student Sat field.');
       signal sqlstate '45000' set message_text = msg;
   end if;
end $$
DELIMITER ;

-- Update trigger to throw error if the tenured field is not 0 or 1
DROP TRIGGER IF EXISTS trg_valid_tenure_upd;
DELIMITER $$
create trigger trg_valid_tenure_upd 
before update on instructor
for each row
begin
   declare msg varchar(128);
   if (new.tenured < 0) or (new.tenured > 1)
    then
       set msg = concat('UpdateTenuredError: Trying to update an invalid value into instructor table, tenured column.');
       signal sqlstate '45000' set message_text = msg;
   end if;
end $$
DELIMITER ;


-- Insert trigger to throw error if the role_ field is not 0 or 1
DROP TRIGGER IF EXISTS trg_valid_role_id;
DELIMITER $$
create trigger trg_valid_role_id 
before insert on employee
for each row
begin
   declare msg varchar(128);
   if (new.role_id < 0) or (new.role_id > 1)
    then
       set msg = concat('InsertTenuredError: Trying to insert an invalid value into Employee table, role_id column.');
       signal sqlstate '45000' set message_text = msg;
   end if;
end $$
DELIMITER ;














-- Insert trigger for instructure.tenured constraint of 0 or 1