# EventTrackerProject
### Overview
#### This project was to build the backend of a web app consisting of one to two tables for some sort of event or activity to keep track of using the Spring REST API to program basic CRUD functionality.

### Technologies Used
#### In this project, the new tools and technologies I used were Spring REST API to build the CRUD functionality for my app and Postman to test it.

### Lessons Learned
#### I ran into an issue while testing where I was getting a 500 internal error message due to having a null value in my "offer" boolean field. I attempted to change it to the wrapper class "Boolean", but the error persisted. The solution that worked was to assign offer to "false" in the JobApplication entity and go back to my inserts in MySQL Workbench and set their offers to "false".

### CRUD paths
#### @RequestMapping("api")

#### @GetMapping("apps")
#### public List<JobApplication> index

####	@PostMapping("apps")
####	public JobApplication create

####	@GetMapping("apps/{appId}")
####	public JobApplication retrieve

####	@PutMapping("apps/{appId}")
####	public JobApplication update

####	@DeleteMapping("apps/{appId}")
####	public void delete
