SELECT e.name AS Employee
FROM
Employee e
JOIN
(SELECT id, salary FROM Employee) AS e1 ON e.managerId = e1.id
WHERE
e.salary > e1.salary;
