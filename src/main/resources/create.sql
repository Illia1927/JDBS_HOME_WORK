1 step:
CREATE TABLE developers(
developer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
name VARCHAR(30) NOT NULL ,
age INT NOT NULL
);

2 step:
CREATE TABLE companies(
compnies_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
name VARCHAR(100) NOT NULL
);

3 step:
CREATE TABLE customers(
  costomers_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(50) NOT NULL
);

4 step:
CREATE TABLE projects(
  projects_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  date DATE NOT NULL,
  company_id  INT NOT NULL,
  customer_id INT NOT NULL,
  FOREIGN KEY (company_id) REFERENCES companies(company_id) ,
  FOREIGN KEY (customer_id) REFERENCES customers(costomer_id)
);

5 step:
CREATE TABLE skills(
skill_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
type ENUM ('JAVA', 'CPP', 'C_SHARP','JS') NOT NULL ,
level ENUM ('JUNIOR', 'MIDDLE', 'SENIOR') NOT NULL ,
developer_id INT NOT NULL ,
FOREIGN KEY (developer_id) REFERENCES developers(developer_id)
);

6 step:
CREATE TABLE developers_projects(
developer_id INT NOT NULL ,
projects_id INT NOT NULL ,
FOREIGN KEY (developer_id) REFERENCES developers (developer_id),
FOREIGN KEY (projects_id) REFERENCES projects (projects_id)
);

number 2:
1 step:
ALTER TABLE developers
ADD salary DOUBLE;

2 step:
SELECT projects.name AS name,
sum(developers.salary) AS sumSalary
FROM projects
INNER JOIN developers_projects
ON projects.projects_id = developers_projects.projects_id
INNER JOIN  developers
ON developers_projects.developer_id = developers.developer_id
GROUP BY projects.projects_id
ORDER BY sumSalary DESC
LIMIT 1;

3 step:
SELECT sum(salary)
FROM developers
INNER JOIN skills
ON developers.developer_id = skills.developer_id
WHERE skills.type = "JAVA";

4 step:
ALTER TABLE projects
ADD cost DOUBLE;

5 step:
SELECT name,  cost
FROM projects
ORDER BY cost
LIMIT 1;

6 step:
SELECT avg(developers.salary) AS avgSalary
FROM projects
INNER JOIN developers_projects
ON projects.projects_id = developers_projects.projects_id
INNER JOIN developers
ON developers_projects.developer_id = developers.developer_id
WHERE projects.cost = ( SELECT min(cost)FROM projects);