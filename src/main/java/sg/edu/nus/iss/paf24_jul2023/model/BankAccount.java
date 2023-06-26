package sg.edu.nus.iss.paf24_jul2023.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    private Integer id;

    private String fullName;

    private Boolean isBlocked;

    private Boolean isActive;

    private String account_type;

    private float balance;

}
