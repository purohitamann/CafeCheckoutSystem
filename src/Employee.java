public class Employee {
    private String employeeFristName=" ";
    private String employeeLastName=" ";
    private String employeeFullName= this.employeeFristName+ " "+ this.employeeLastName;
    private String employeeAlias;
    
    
    private String employeeCell;
    private String employeeEmail;
    private String employeeType;
    private String employeePayRate;
    private String employeeAddress;

    private String employeePosition;

    private String employeeWorkedHours;
    private String employeeAcessTier;

    public Employee(String name){
      this.employeeFristName = name;
    }

    public Employee(){
        this.setAlias();
    }
    
    public Employee(String employeeFristName, String employeeLastName) {
        this.employeeFristName = employeeFristName;
        this.employeeLastName = employeeLastName;
        this.setAlias();
    }
    
    public String getEmployeeFristName() {
        return employeeFristName;
    }
    public void setEmployeeFristName(String employeeFristName) {
        this.employeeFristName = employeeFristName;
    }
    public String getEmployeeLastName() {
        return employeeLastName;
    }
    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }
    public String getEmployeeFullName() {
        return employeeFullName;
    }
    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }
    public String getEmployeeAlias() {
        return this.employeeAlias;
    }
    
    public String getEmployeeCell() {
        return employeeCell;
    }
    public void setEmployeeCell(String employeeCell) {
        this.employeeCell = employeeCell;
    }
    public String getEmployeeEmail() {
        return employeeEmail;
    }
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
    public String getEmployeeType() {
        return employeeType;
    }
    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
    public String getEmployeePayRate() {
        return employeePayRate;
    }
    public void setEmployeePayRate(String employeePayRate) {
        this.employeePayRate = employeePayRate;
    }
    public String getEmployeeAddress() {
        return employeeAddress;
    }
    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
    public String getEmployeePosition() {
        return employeePosition;
    }
    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }
    public String getEmployeeWorkedHours() {
        return employeeWorkedHours;
    }
    public void setEmployeeWorkedHours(String employeeWorkedHours) {
        this.employeeWorkedHours = employeeWorkedHours;
    }
    public String getEmployeeAcessTier() {
        return employeeAcessTier;
    }
    public void setEmployeeAcessTier(String employeeAcessTier) {
        this.employeeAcessTier = employeeAcessTier;
    }

    
   
    public void setAlias(){
        if(this.employeeFristName != null || this.employeeLastName!= null){
        this.employeeAlias= this.employeeFristName+" "+ this.employeeLastName.charAt(0)+".";}
    }

    public boolean isCheck() {
        return false;
    }
}
