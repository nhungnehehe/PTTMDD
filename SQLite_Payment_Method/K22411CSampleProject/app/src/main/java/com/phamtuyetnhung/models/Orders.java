package com.phamtuyetnhung.models;

public class Orders {
     private int Id;
    private String Code;
    private String Name;
    private int EmployeeId;
    private int CustomerId;
    private String OrderDated;
    private String Description;
    private int Status;
    private String StatusDescription;

    public Orders() {
    }

    public Orders(int id, String code, String name, int employeeId, int customerId, String orderDated, String description, int status, String statusDescription) {
        Id = id;
        Code = code;
        Name = name;
        EmployeeId = employeeId;
        CustomerId = customerId;
        OrderDated = orderDated;
        Description = description;
        Status = status;
        StatusDescription = statusDescription;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getOrderDated() {
        return OrderDated;
    }

    public void setOrderDated(String orderDated) {
        OrderDated = orderDated;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getStatusDescription() {
        return StatusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        StatusDescription = statusDescription;
    }
}
