package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;

    @Pattern(regexp = "[A-Za-z]*", message = "Customer Name should not contain space or special characters")
    private String custName;

    @NotNull
    private String custAddress;

    private double custAccBalance;

    @Range(min = 1000000000, max = 9999999999L, message = "Contact No must be 10 digit")
    @Column(unique = true)
    private long custContactNo;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    private Date custDOB;

    @Email(message = "Email ID must be valid")
    @Column(unique = true)
    private String custEmailId;
}
