# BabySittersClubEmployment

This is a project I did to simulate a normal work task. 

The Babysitters Club Employment Agency has decided to computerize their payroll. A babysitter earns a specific fee per hour until 9:00 PM (while the children are awake and active), a lower rate between 9:00 PM and midnight (after bedtimes and the babysitter can study), and a higher fee after midnight (when babysitting cuts into prime sleeping time).

They maintain two datafiles are one for the employees and one for their data   

Personnel data file 

employee no.
lastname, firstname
street address
city, state zipcode
hourly rate before 9:00 PM	hourly rate between 9:00 PM and midnight	hourly rate after midnight



Payroll data file
employee no.
number of days employed
starting time and ending time for each day


Write a program that reads the starting time and ending times (in hours and minutes) for a babysitter and computes the babysitter’s fee. Assume all times are between 6:00 PM and 6:00 AM.

Your output should consist of an alphabetical list (by last name) of each babysitter and their pay.

Be sure to use the structured programming techniques you have learned in prior classes. Namely, use methods  and maximize legibility by using proper indentation, spacing, and comments. Do not forget to provide program documentation.


The Data below is the data you should use to do the assignment 



Personnel file Data 

0001
McGill, Stacey
231 Maple Avenue
Stoneybrook, Connecticut 30122
5.50	4.00	6.00

0002
Spier, Maryann
401 Orange Lane 
Stoneybrook, Connecticut 30122
10.00	8.00	15.00

0003
Thomas, Kristy
222 Blossom Blvd.
Stoneybrook, Connecticut 30122
5.00	4.00	6.00

0004
Schafer, Dawn
131 Apple Gardens
Stoneybrook, Connecticut 30122
4.00	3.00	5.00

0005
Pike, Mallory
656 Brook Lane
Stoneybrook, Connecticut 30122
1.75	1.00	1.25

0006
Ramsey, Jessi
545 Greenleaf Street
Stoneybrook, Connecticut 30122
10.00	10.00	10.00

0007
Kishi, Claudia
303 Ginger Blvd.
Stoneybrook, Connecticut 30122
5.00	2.50	7.50


Payroll file data 

0001
2
8:00   10:00
9:00	11:30



0002
1
6:00	2:00

0003
2
8:00   10:00
9:00	11:30

0004
3
9:30	1:00
6:00	9:00
7:15	8:15

0005
2
7:00 	5:30
6:00	1:45

0006
3
9:30	1:00
7:00	9:00
1:15	3:15

0007
2
7:00 	3:30
9:00	1:45
