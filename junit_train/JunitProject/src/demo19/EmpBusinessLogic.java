package demo19;

public class EmpBusinessLogic {
	// Calculate the yearly salary of employee
	public double calculateYearlySalary(EmployeeDetails employeeDetails) {
		double yearlySalary = 0;
		if(employeeDetails.getAge()<30){
			yearlySalary = employeeDetails.getMonthlySalary() * 12;
		}else{
			yearlySalary = employeeDetails.getMonthlySalary() * 13;
		}		
		return yearlySalary;
	}
	
	// Calculate the  salary of employee
		public double calculateMonthSalary(EmployeeDetails employeeDetails) {
			int salary = 0,days=0,year=0;
			
			int month=2;
			//¼ÆËãÒµÎñÂß¼­
			if(month==2){
				if(isLeapYear(year))
				     days=29;
				else
					days=28;
			}					
		
			return salary;
		}
 
		private  boolean isLeapYear(int theYear) {
			if (theYear % 400 == 0)
				return true;
			
			if (theYear % 100 == 0)
				return false;
			
			if (theYear % 4 == 0)
				return true;
			
			return false;
		}
		
	// Calculate the appraisal amount of employee
	public double calculateAppraisal(EmployeeDetails employeeDetails) {
		double appraisal = 0;
		if(employeeDetails.getAge()<30){
			if (employeeDetails.getMonthlySalary() < 10000) {
				appraisal = 500;
			} else {
				appraisal = 1000;
			}
		}else{
			if (employeeDetails.getMonthlySalary() < 10000) {
				appraisal = 2500;
			} else {
				appraisal = 5000;
			}
		}		
		return appraisal;
	}
}
